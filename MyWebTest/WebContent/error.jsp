<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>登录失败</title>           
            <link rel="stylesheet" href="css/error.css" />
            <script src="js/error.js"></script>
        </head>
        <body style="overflow: auto;" onload="calc()">
        <div id="errorDIV">
        	<div id="errorHint">
        	<span>
          		<img src="images/error.jpg">  	
        	</span>
       	
        		<p id="errorInfo">${info}</p>
            	<br>
            	<div>页面将在<span id='second'>10</span>秒后自动跳转......
            	<a href="login.html">立即跳转</a>
            	</div>
            </div>
        </div>
        </body>

        </html>