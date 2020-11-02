<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>注册界面</title>
        <script language="javascript" src="js/register.js"></script>
    </head>

    <body>
        <form method="post" action="RegisterServlet" name="register">
            <table style="height:100%;width:100%">
                <tr align="center" valign="middle">
                    <td>
                        <table width="392" height="200" border=0 align="center">
                            <tbody>
                                <tr valign="middle" align="center">
                                    <td colspan="3" height="40" valign="middle" align="center">
                                        <font face="黑体" size="5px" color="#196ed1" style="padding-left:20px;">用户注册 </font>
                                    </td>
                                </tr>
                                <tr>
                                    <td>用户名：</td>
                                    <td><input type="text" name="username" id="username" value="" onChange="onChang1(this)">
                                        <td id="usName"></td>
                                </tr>

                                <tr>
                                    <td>密码：</td>
                                    <td><input type="password" name="userpass" id="userpass" value="" onChange="onChang2(this)">
                                        <td id="usPass"></td>
                                </tr>
                                <tr>
                                    <td>确认密码：</td>
                                    <td><input type="password" name="userpass1" id="userpass1" value="" onChange="onChang3(this)">
                                        <td id="usPass1"></td>
                                </tr>
                                <tr>
                                    <td>邮箱：</td>
                                    <td><input type="text" name="mail" id="mail" value="" onChange="onChang4(this)">
                                        <td id="usPass1"></td>
                                </tr>
                                <tr>
                                    <td>省份：</td>
                                    <td>
                                    <select >
                                    	<option value=""></option>

                                    </select>
                                        <td id="usPass1"></td>
                                </tr>
                                <tr>
                                    <td>城市：</td>
                                    <td>
                                    <select >
                                    	<option value=""></option>

                                    </select>
                                        <td id="usPass1"></td>
                                </tr>
                                <tr>
                                    <td><input type="submit" value="提交" onClick="sub()">
                                        <td><input type="button" value="重置" onClick="res()">
                                </tr>
                            </tbody>
                        </table>
                </tr>
            </table>
        </form>
    </body>

    </html>