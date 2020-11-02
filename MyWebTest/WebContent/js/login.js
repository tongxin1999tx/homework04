var xmlHttp;
var flag = 0;

function createXmlHttp() {
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    } else {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function ajaxCheckLogin() {
    var userName = document.getElementById("userName").value;
    var password = document.getElementById("password").value;
    var Verifycode = document.getElementById("Verifycode").value;
    var autoLogin = document.getElementById("autoLogin").value;
    createXmlHttp();
    xmlHttp.open("post", "ajaxLoginCheck", true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttp.send("userName=" + userName + "&password=" + password + "&Verifycode=" + Verifycode + "&autoLogin=" + autoLogin);
    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            var response = xmlHttp.responseText;
            var json = JSON.parse(response);
            if (json.code == 0) {
                window.location.href = "main.jsp";
            } else {
                document.getElementById("checkError").innerText = json.info;
            }
        }
    }
}


var flag = 0;
function onChang1(obj) {
    var obValue = obj.value;
    if (obValue.length == 0 ||obValue == "") {
        document.getElementById("usName").innerHTML = "<font name='usName' style='font-size:12px;color:red'>请输入用户名！</font>";
        flag = 0;
    } else {
        document.getElementById("usName").innerHTML = "<font name='usName' style='font-size:12px;color:green'>可以使用！</font>";
        flag++;
    }
}
function onChang2(obj) {
    var obValue = obj.value;
    if (obValue.length == 0||obValue == "") {
        document.getElementById("paword").innerHTML = "<font name='paword' style='font-size:12px;color:red'>请输入密码！</font>";
        flag = 0;
    } else {
        document.getElementById("paword").innerHTML = "<font name='paword' style='font-size:12px;color:green'>可以使用！</font>";
        flag++;
    }
}
function onChang3(obj) {
    var obValue = obj.value;
    if (obValue.length == 0||obValue == "") {
        document.getElementById("vco").innerHTML = "<font name='vco' style='font-size:12px;color:red'>请输入验证码！</font>";
        flag = 0;
    }else {
        document.getElementById("vco").innerHTML = "<font name='vco' style='font-size:12px;color:green'>可以使用！</font>";
        flag++;
    }
}
function checkError(){
	document.getElementById("checkError").innerHTML = "<font name='checkError' style='font-size:12px;color:red'>${json.info}</font>";
}