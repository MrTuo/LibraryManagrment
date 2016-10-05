function gspan(cobj){       //获取表单后的span 标签 显示提示信息
    console.log(cobj.nextSibling);
    if (cobj.nextSibling.nodeName != 'span'){

        gspan(cobj.nextSibling);

    } else {

        return cobj.nextSibling;

    }

}

 

//检查表单 obj【表单对象】， info【提示信息】 fun【处理函数】  click 【是否需要单击， 提交时候需要触发】

function check(obj, info, fun, click){

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

    name = document.getElementsByName('name')[0];

    age = document.getElementsByName('age')[0];

    country = document.getElementsByName('country')[0];

    check(name, "用户名由1~20个汉字、英文字母或数字组成", function(val){

        var re = /^[\u4E00-\u9FFF]{1,20}$/;
        if (re.test(val)){
            return true;
        }
        else{
            stat = false;
            return false;
        }

    }, click);

 

    check(age, "年龄为1~3位整数", function(val){
        var re= /^[0-9]{1,3}$/

        if (re.test(val)){

            return true;

        } else {

            stat = false;

            return false;

        }

    }, click);

 

     

    check(country, "国籍由1~20个汉字或英文字母组成", function(val){

        if (val.match(/^\S+$/) && val.length >=6 && val.length <=20 && val == password.value){

            return true;

        } else {

            stat = false;

            return false;

        }

    }, click);

}