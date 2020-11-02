var flag = 0;

function onChang1(obj) {
    var obValue = obj.value;
    if (obValue.length > 8 || obValue.length < 3) {
        document.getElementById("usName").innerHTML = "<font name='usName' style='font-size:12px;color:red'>长度要求3-8位!</font>";
        flag = 0;
    } else {
        document.getElementById("usName").innerHTML = "<font name='usName' style='font-size:12px;color:green'>可以使用</font>";
        flag++;
    }
}

function onChang2(obj) {
    var obValue = obj.value;
    if (obValue.length > 8 || obValue.length < 6) {
        document.getElementById("usPass").innerHTML = "<font name='usPass' style='font-size:12px;color:red'>长度要求6-8位!</font>";
        flag = 0;

    } else {
        document.getElementById("usPass").innerHTML = "<font name='usPass' style='font-size:12px;color:green'>可以使用</font>";
        flag++;
    }
}

function onChang3(obj) {
    var obValue = obj.value;
    var pass = document.getElementById("userpass").value;
    if (obValue != pass) {
        document.getElementById("usPass1").innerHTML = "<font name='usPass1' style='font-size:12px;color:red'>请再次确认密码!</font>";
        flag = 0;

    } else {

        document.getElementById("usPass1").innerHTML = "<font name='usPass1' style='font-size:12px;color:green'>通过</font>";
        flag++;
    }
}

function res() {
    document.getElementById("username").value = "";
    document.getElementById("userpass").value = "";
    document.getElementById("userpass1").value = "";

}

function sub() {
    var name = document.getElementById("username").value;
    var pass = document.getElementById("userpass").value;
    var pass1 = document.getElementById("userpass1").value;
    if (name != null && pass != null && pass1 != null && pass.equals("pass1")) {
        if (flag == 3) {
            document.register.submit();
        } else {
            alert("请认真填写注册信息");
            document.getElementById("username").value = "";
            document.getElementById("userpass").value = "";
            document.getElementById("userpass1").value = "";
            document.getElementById("usName").innerHTML = "";
            document.getElementById("usPass").innerHTML = "";
            document.getElementById("usPass1").innerHTML = "";
        }
    }
}