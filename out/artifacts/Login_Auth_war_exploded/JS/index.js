
function fnLogin()
{
    var uname=document.getElementById("input_user")
    var password=document.getElementById("input_password")
    if(uname.value.length==0)
    {
        document.getElementById("tip").style.display="block"
    }else if(uname.value=="tom"&&password.value==123){
        window.location="http://mail.swpu.edu.cn/";
    }
}
function getCookie(cname){
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) { return c.substring(name.length,c.length); }
    }
    return "";
}
function checkCookie(){
    var user=getCookie("username");
    var uname=document.getElementById("input_user");
    var pwd=getCookie("pwd");
    var upwd=document.getElementById("input_password");


    if (user!=""){
        var uname=document.getElementById("input_user");
        uname.value=user;
        upwd=pwd;
    }
}
window.onload=function()//用window的onload事件，窗体加载完毕的时候
{

    checkCookie();
}