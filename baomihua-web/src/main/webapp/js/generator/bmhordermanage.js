$(function () {
    $("#jqGrid").jqGrid({
        url: '../bmhordermanage/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true,hidden:true },
			{ label: '快递商家', name: 'orderTyp', index: 'order_typ', width: 80 },
			{ label: '快递单号', name: 'orderNum', index: 'order_num', width: 80 }, 			
			{ label: '客户姓名', name: 'vipName', index: 'vip_name', width: 80 }, 			
			{ label: '手机号', name: 'phoneNum', index: 'phone_num', width: 80 },
            { label: '可抽奖次数', name: 'awardTimes', index: 'award_times', width: 80 },
            { label: '中奖号码', name: 'priceNum', index: 'price_num', width: 80 },
            { label: '客户省份', name: 'province', index: 'province', width: 80 },
			{ label: '客户城市', name: 'city', index: 'city', width: 80 },
			{ label: '创建人', name: 'createUser', index: 'create_user', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 ,formatter:function(value){
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
		bmhOrderManage: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.bmhOrderManage = {};
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
			var url = vm.bmhOrderManage.id == null ? "../bmhordermanage/save" : "../bmhordermanage/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.bmhOrderManage),
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
				    url: "../bmhordermanage/delete",
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
			$.get("../bmhordermanage/info/"+id, function(r){
                vm.bmhOrderManage = r.bmhOrderManage;
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