/**
 * tinyImgUpload
 * @param ele [string] [生成组件的元素的选择器]
 * 调用方法
 * tinyImgUpload('div')
 */
document.documentElement.style.fontSize = document.documentElement.clientWidth*0.1+'px';
var uploadFiles = tinyImgUpload('#upload');
function tinyImgUpload(ele) {
    // 判断容器元素合理性并且添加基础元素
    var eleList = document.querySelectorAll(ele);
    if(eleList.length == 0){
        console.log('绑定的元素不存在');
        return;
    }else if(eleList.length>1){
        console.log('请绑定唯一元素');
        return;
    }else {
        /*eleList[0].innerHTML ='<div id="img-container" >'+
            '<div id="img-up-add" class="img-up-add  img-item" style=""> <span class="img-add-icon">选择图片</span> </div>'+
            '<input type="file" name="pricePicFile" id="img-file-input">'+
            '</div>';*/
        var ele = eleList[0].querySelector('#img-container');
        ele.files = [];   // 当前上传的文件数组
    }

    // 为添加按钮绑定点击事件，设置选择图片的功能
    var addBtn = document.querySelector('.img-up-add');
    addBtn.addEventListener('click',function () {
        document.querySelector('#img-file-input').value = null;
        document.querySelector('#img-file-input').click();
        return false;
    },false);

    // 预览图片
    //处理input选择的图片
    function handleFileSelect(evt) {
        var files = evt.target.files;
        for(var i=0, f; f=files[i];i++){
            // 过滤掉非图片类型文件
            if(!f.type.match('image.*')){
                continue;
            }
            // 过滤掉重复上传的图片
            var tip = false;
            for(var j=0; j<(ele.files).length; j++){
                if((ele.files)[j].name == f.name){
                    tip = true;
                    break;
                }
            }
            if(!tip){
                // 图片文件绑定到容器元素上
                ele.files.push(f);
                var reader = new FileReader();
                reader.onload = (function (theFile) {
                    return function (e) {
                        var oDiv = document.createElement('div');
                        oDiv.className = 'img-thumb img-item';
                        // 向图片容器里添加元素
                        oDiv.innerHTML = '<img class="thumb-icon" src="'+e.target.result+'" />'+
                            '<a href="javscript:;" class="img-remove" id="delImg" title="删除">x</a>'
                        ele.insertBefore(oDiv, addBtn);
                        addBtn.setAttribute("style","display:none");
                    };
                })(f);
                reader.readAsDataURL(f);
            }
        }
    }

    document.querySelector('#img-file-input').addEventListener('change', handleFileSelect, false);

    // 删除图片
    function removeImg(evt) {
        if(evt.target.className.match(/img-remove/)){
            // 获取删除的节点的索引
            function getIndex(ele){
                if(ele && ele.nodeType && ele.nodeType == 1) {
                    var oParent = ele.parentNode;
                    var oChilds = oParent.children;
                    for(var i = 0; i < oChilds.length; i++){
                        if(oChilds[i] == ele)
                            return i;
                    }
                }else {
                    return -1;
                }
            }
            // 根据索引删除指定的文件对象
            var index = getIndex(evt.target.parentNode);
            ele.removeChild(evt.target.parentNode);
            if(index < 0){
                return;
            }else {
                ele.files.splice(index, 1);
                addBtn.setAttribute("style","display:block");
            }
        }
    }
    ele.addEventListener('click', removeImg, false);
    return ele.files;
}