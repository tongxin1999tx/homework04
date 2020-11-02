<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="css/main.css" />
        <script src="js/main.js"></script>
        <title>欢迎登录主页</title>
    </head>

    <body>
        <div id="div_name">
         <p style="color:#000fff">当前登录：${currentUser.getChrName()}
         <a href="login.html">
         	<%  
           Cookie   killMyCookie   =   new   Cookie( "password" , null);  
           killMyCookie.setMaxAge( 0 );  
           killMyCookie.setPath( "/" );  
           response.addCookie(killMyCookie);
			%>[安全退出]</a>
         </p>
        </div>
        <br><br><hr/><br>
         <div id="div_link">
             <span>
                <a href="#">首页&nbsp;</a>
            </span>
             <span>
                <a href="GetdownloadListController">下载&nbsp;</a>
             </span>
            <span>
                <a href="#">工具&nbsp;</a>
            </span>
              <span>
                <a href="#">论坛&nbsp;</a>
            </span>
             <span>
                <a href="#">关于&nbsp;</a>
            </span>
        </div>

    </body>

    </html>