function basePath() {   
	//获取当前网址，如： http://localhost:8080/ems/Pages/Basic/Person.jsp   
	var curWwwPath = window.document.location.href;
	//获取主机地址之后的目录，如： /ems/Pages/Basic/Person.jsp   
	var pathName = window.document.location.pathname;   
	var pos = curWwwPath.indexOf(pathName);   
	// 获取主机地址，如： http://localhost:8080   
	var localhostPath = curWwwPath.substring(0, pos);   
	// 获取带"/"的项目名，如：/ems   
	//var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);   
	// 获取项目的basePath   http://localhost:8080/ems/   
	//var basePath = localhostPath + projectName + "/";   
	return localhostPath+"/";
};

$(function () {
    $('.fancybox').fancybox({
        openEffect: 'none',
        closeEffect: 'none'
    });
    $("#jqGrid").jqGrid({
        url: '../bmhprize/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true,hidden:true },
			{ label: '名称', name: 'name', index: 'name', width: 80 },
			{ label: '图片', name: 'picUrl', index: 'pic_url', width: 80,formatter:function(urlPic){
                urlPic = basePath()+urlPic;
				return '<a class="fancybox" href="'+urlPic+'">'+
					'<img class="price-pic" alt="image" src="'+urlPic+'"/>'+
				   '</a>';
				}
			},
			{ label: '位置', name: 'sort', index: 'sort', width: 80 },
			{ label: '创建人', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80,formatter:function(value){
					return T.dateFormat(value,1);
            	}
			}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		bmhPrize: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
            vm.bmhPrize = {};
			vm.showList = false;
			vm.title = "新增";
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.bmhPrize.id == null ? "../bmhprize/save" : "../bmhprize/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.bmhPrize),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../bmhprize/delete",
				    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get("../bmhprize/info/"+id, function(r){
                vm.bmhPrize = r.bmhPrize;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});

function doSavePrice() {
    var formData = new FormData($( "#priceForm" )[0]);
    $.ajax({
        url: '../bmhprize/save' ,
        type: 'POST',
        data: formData,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function (returndata) {
            alert('操作成功', function(index){
                vm.reload();
                document.getElementById("delImg").click();
                document.getElementById("priceForm").reset();
            });
        },
        error: function (returndata) {
            alert('操作失败', function(index){
                vm.reload();
            });
        }
    });
}