function $(id){
    return document.getElementById(id)
}

function preRegist() {
    // BOM
    // document.forms[0].uname;
    // DOM
    // var unameText = document.getElementById("unameText");
    var unameText = $("unameText");
    //用户名应为6~16位数组和字母组成
    var unameReg=/[0-9a-zA-Z]{6,16}/;
    var uname=unameText.value;
    var unameSpan = $("unameSpan");
    if (!unameReg.test(uname)){
        unameSpan.style.visibility="visible";
        return false;
    }else{
        unameSpan.style.visibility="hidden";
    }

    // 密码的长度至少为8位
    var pwdText = $("pwdText");
    var pwd = pwdText.value;
    var pwdReg=/[\w]{8,}/
    var pwdSpan = $("pwdSpan");
    if (!pwdReg.test(pwd)){
        pwdSpan.style.visibility="visible";
        return false;
    }else{
        pwdSpan.style.visibility="hidden";
    }

    // 密码两次输入不一致
    if (pwd!=$("pwdText2").value){
        $("pwdSpan2").style.visibility="visible";
        return false;
    }else{
        $("pwdSpan2").style.visibility="hidden";
    }

    //请输入正确的邮箱格式
    var email = $("emailText").value ;
    var emailSpan = $("emailSpan");
    var emailReg = /^[a-zA-Z0-9_\.-]+@([a-zA-Z0-9-]+[\.]{1})+[a-zA-Z]+$/;
    if(!emailReg.test(email)){
        emailSpan.style.visibility="visible";
        return false ;
    }else{
        emailSpan.style.visibility="hidden";
    }

    return true ;
}
var xmlHttpRequest

function createXMLHttpRequest() {
    if (window.XMLHttpRequest){
        //符合DOM2标准的浏览器 ，xmlHttpRequest的创建方式
        xmlHttpRequest= new XMLHttpRequest();
    }else if (window.ActiveXObject){//IE浏览器
        try {
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }catch (e) {
            xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
        }

    }
}

function ckUname(uname) {
    //如果想要发送异步请求，我们需要一个关键对象 XMLHttpRequest
    createXMLHttpRequest();
    xmlHttpRequest.open("GET","user.do?operate=ckUname&uname="+uname,true);
    //设置回调函数
    xmlHttpRequest.onreadystatechange=ckUnameCB;
    //发送请求
    xmlHttpRequest.send();
}
function ckUnameCB() {
    if (xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
        //xmlHttpRequest.responseText 表示 服务器端响应给我的文本内容
        // alert(xmlHttpRequest.responseText);
        var responseText = xmlHttpRequest.responseText;
        if (responseText=="{'uname':'1'" +
            "}"){
            alert("用户名已经被注册！")
        }else{
            alert("用户名可以注册！")
            alert()
        }
        // responseText.split(":")
    }

}