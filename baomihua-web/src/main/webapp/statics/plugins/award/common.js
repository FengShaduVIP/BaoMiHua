
/*让文字和标签的大小随着屏幕的尺寸做变话 等比缩放*/
(function (doc, win) {
    var docEl = doc.documentElement,
        resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
        recalc = function () {
            var clientWidth = docEl.clientWidth;
            if (!clientWidth) return;
            docEl.style.fontSize = 100 * (clientWidth / 750) + 'px';
        };

    if (!doc.addEventListener) return;
    win.addEventListener(resizeEvt, recalc, false);
    doc.addEventListener('DOMContentLoaded', recalc, false);
    Marquee();
})(document, window);
var indexNum = 0;
var luck={
    index:0,	//当前转动到哪个位置，起点位置
    count:8,	//总共有多少个位置
    timer:0,	//setTimeout的ID，用clearTimeout清除
    speed:20,	//初始转动速度
    times:0,	//转动次数
    cycle:50,	//转动基本次数：即至少需要转动多少次再进入抽奖环节
    prize:-1,	//中奖位置
    init:function(id){
        if ($("#"+id).find(".luck-unit").length>0) {
            $luck = $("#"+id);
            $units = $luck.find(".luck-unit");
            this.obj = $luck;
            this.count = $units.length;
        };
    },
    roll:function(){
        var index = this.index;
        var count = this.count;
        var luck = this.obj;
        $(luck).find(".luck-unit-"+index).removeClass("active");
        index += 1;
        if (index>count-1) {
            index = 0;
        };
        $(luck).find(".luck-unit-"+index).addClass("active");
        this.index=index;
        return false;
    },
    stop:function(index){
        this.prize=index;
        return false;
    }
};

function roll(){
    luck.times += 1;
    luck.roll();
    if (luck.times > luck.cycle+10 && luck.prize==luck.index) {
        var time = clearTimeout(luck.timer);
        luck.prize=-1;
        luck.times=0;
        click=false;
        if(time==undefined)
            showModal()
    }else{
        if (luck.times<luck.cycle) {
            luck.speed -= 10;
        }else if(luck.times==luck.cycle) {
            var index = Math.random()*(luck.count)|0;
            if(vm.priceNum==null||vm.priceNum==undefined||vm.priceNum==-1){
                if(index>4){
                    index = 7;
                }else {
                    index = 5;
                }
                luck.prize = index;
                vm.priceNum = index;
            }else{
                luck.prize = vm.priceNum;
            }
        }else{
            if (luck.times > luck.cycle+10 && ((luck.prize==0 && luck.index==7) || luck.prize==luck.index+1)) {
                luck.speed += 110;
            }else{
                luck.speed += 20;
            }
        }
        if (luck.speed<40) {
            luck.speed=40;
        }
        luck.timer = setTimeout(roll,luck.speed);
    }
    return false;
}

var click=false;

window.onload=function(){

    luck.init('luck');
    $("#btn").click(function(){
        //按下弹起效果
        $("#btn").addClass("cjBtnDom");
        setTimeout(function(){
            $("#btn").removeClass("cjBtnDom");
        },200);

        /**
         * 检验手机号代码
         */
        var phoneNum = vm.phoneNum;
        if(!checkPhone(vm.phoneNum)){
            layer.open({
                content: '请填写正确手机号！'
                ,style: 'background-color:#E84A54; color:#fff; border:none;font-size:40px;'
                ,time: 1.5
            });
            return;
        }
        $.get("../webpublic/checkAwardTimes?phoneNum="+phoneNum, function(r){
            r =  JSON.parse(r);
            doAction(r);
        });
    });
};

function showModal(){
    layer.open({
        type: 1,
        title: false,
        closeBtn: false,
        shadeClose: false,
        shade: false,
        maxmin: false, //开启最大化最小化按钮
        content: $("#info").html()
    });
}

function closeWindow() {
    layer.closeAll();
}


function doAction(r){
    luck.speed = 100;
    roll(); //转圈过程不响应click事件，会将click置为false
    click = true; //一次抽奖完成后，设置click为true，可继续抽奖
    return false;
   /* if(!r.data){
        layer.open({
            content: '该手机号目前无法参与抽奖。'
            ,style: 'background-color:#E84A54; color:#fff; border:none;font-size:40px;'
            ,time: 1.5
        });
    }else{
        vm.priceNum = r.priceNum*1-1;
        if(click) { //click控制一次抽奖过程中不能重复点击抽奖按钮，后面的点击不响应
            return false;
        } else {

        }
    }*/
}

var checkPhone = function(a)
{
    var patrn = /^((?:13|14|15|16|17|18|19)\d{9}|0(?:10|2\d|[3-9]\d{2})[1-9]\d{6,7})$/;
    if (!patrn.exec(a)) return false;
    return true;
};

//播报

function Marquee(){
    var demo = document.getElementById("demo");
    var demo1 = document.getElementById("demo1");
    var demo2 = document.getElementById("demo2");
    demo2.innerHTML=demo1.innerHTML;
    if(demo.scrollLeft-demo1.offsetWidth>=0){
        demo.scrollLeft=0;
    }else{
        demo.scrollLeft++;
    }
    setTimeout(Marquee,10);
}




