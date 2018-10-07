function basePath() {   
	//获取当前网址，如： http://localhost:8080/ems/Pages/Basic/Person.jsp   
	var curWwwPath = window.document.location.href;
	//获取主机地址之后的目录，如： /ems/Pages/Basic/Person.jsp   
	var pathName = window.document.location.pathname;   
	var pos = curWwwPath.indexOf(pathName);   
	// 获取主机地址，如： http://localhost:8080   
	var localhostPath = curWwwPath.substring(0, pos);   
	// 获取带"/"的项目名，如：/ems   
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);   
	// 获取项目的basePath   http://localhost:8080/ems/   
	var basePath = localhostPath + projectName + "/";   
	return localhostPath;
};

//生成
var awardlog = Vue.extend({
    props:['item'],
    template:[
        '<li>{{item.time}}&nbsp;&nbsp;&nbsp; {{item.phoneNum}}会员，获得{{item.priceName}}</li>'
    ].join('')
});

Vue.component('awardlog',awardlog);

var vm = new Vue({
	el:'#rrapp',
	data:{
		awardList:[],//奖品列表
        awardLoglist:[],//获奖记录
		phoneNum:null,
		isCanDo:false,
		priceNum:null,
		priceListData:[
			{name:"iPhone8 plus",index:1,price:"一等奖"},
            {name:"美图V6手机",index:2,price:"二等奖"},
            {name:"AJ黑金正版鞋",index:3,price:"三等奖"},
            {name:"加强版refa",index:4,price:"四等奖"},
            {name:"888现金红包",index:5,price:"五等奖"},
            {name:"coco香水",index:6,price:"六等奖"},
            {name:"520现金红包",index:7,price:"七等奖"},
            {name:"MAC口红",index:8,price:"八等奖"}
		]
	},
	methods: {
		//获取奖品列表
		getAwardList:function (event) {
            $.get("../webpublic/awardlist", function(r){
            	r = JSON.parse(r);
                vm.wardList = r.list;
            });
        },
        getAwardLoglist:function (event) {
            $.get("../webpublic/awardLoglist", function(r){
                r = JSON.parse(r);
                vm.awardLoglist = r.list;
            });
        }
	},
    created:function () {
        this.getAwardList();
        this.getAwardLoglist();
    }
});
