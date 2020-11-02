window.onload = function(){
 var oForm = document.getElementById('myForm');
 var oUser = document.getElementById('userName');
 var oPswd = document.getElementById('password');
 var oRemember = document.getElementById('remember');
 
 //复选框未勾选则清除cookie
 oRemember.onchange = function() {
 if (!this.checked) {
  delCookie('userName');
  delCookie('password');
 }
 };
 
 //复选框是勾选保存cookie
 oForm.onsubmit = function() {
 if (remember.checked) {
  setCookie('userName', oUser.value, 7); //保存帐号到cookie，有效期7天
  setCookie('password', oPswd.value, 7); //保存密码到cookie，有效期7天
 }
 };
};

//设置cookie
function setCookie(name, value, day) {
 var date = new Date();
 date.setDate(date.getDate() + day);
 document.cookie = name + '=' + value + ';expires=' + date;
};

//获取cookie
function getCookie(name) {
 var reg = RegExp(name + '=([^;]+)');
 var arr = document.cookie.match(reg);
 if (arr) {
 return arr[1];
 } else {
 return '';
 }
};

