function gspan(cobj){       //获取表单后的span 标签 显示提示信息
	
    if (cobj.nextSibling.nodeName != 'SPAN'){

        gspan(cobj.nextSibling);

    } else {

        return cobj.nextSibling;
    }
}

 

//检查表单 obj【表单对象】， info【提示信息】 fun【处理函数】  click 【是否需要单击， 提交时候需要触发】

function check(obj, info, fun, click){
	console.log(obj);
    var sp = gspan(obj);

    obj.onfocus = function(){

        sp.innerHTML = info;

        sp.style.color = "black";

    }

    obj.onblur = function(){

        if (fun(this.value)){

            sp.innerHTML = "输入正确！";

            sp.style.color = "green";

        } else {

            sp.innerHTML = info;
            sp.style.color = "red";
        }
    }

    if (click == 'click'){

        obj.onblur();

    }

}

onload = regs;//页面载入完执行

function regs(click){

    var stat = true;        //返回状态， 提交数据时用到
    
    isbn = document.getElementById('isbn');

    title = document.getElementById('title');

    publisher = document.getElementById('publisher');

    publish_date = document.getElementById('publish_date');

    price = document.getElementById('price');
    
    check(isbn, "ISBN由10位或13位纯数字组成", function(val){

        var re = /^[0-9]{10}([0-9]{3})?$/;
        console.log(val);
        if (re.test(val)){
            return true;
        }
        else{
            stat = false;
            return false;
        }

    }, click);

    check(title, "题目由1~20个汉字、英文字母或数字组成", function(val){

        var re = /^([\u4E00-\u9FFF]|[0-9]|[a-z]|[A-Z]){1,20}$/;
       
        if (re.test(val)){
            return true;
        }
        else{
            stat = false;
            return false;
        }

    }, click);

    check(publisher, "出版社由1~20个汉字、英文字母或数字组成", function(val){

        var re = /^([\u4E00-\u9FFF]|[0-9]|[a-z]|[A-Z]){1,20}$/;
        console.log(val);
        if (re.test(val)){
            return true;
        }
        else{
            stat = false;
            return false;
        }

    }, click);

    check(publish_date, "出版日期为8位数字，格式示例：19950101", function(val){

        var re = /^[0-9]{8}$/;
        console.log(val);
        if (re.test(val)){
            return true;
        }
        else{
            stat = false;
            return false;
        }

    }, click);

 

    check(price, "价格为1~8位整数，单位：（元）", function(val){
        var re= /^[0-9]{1,8}$/;

        if (re.test(val)){

            return true;

        } else {

            stat = false;

            return false;
            
        }

    }, click);
    
    
    return stat;

}