<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>资源下载</title>
    <link rel="stylesheet" type="text/css" href="css/download.css">
    <title>Document</title>
</head>
<body>
    <h1>资源下载</h1>
    <div class="container">
        <c:forEach items="${downloadList}" var="download">
            <ul>
                <li>
                    <p class="name">${download.name}</p>
                    <div class="pic">
                        <img class="img" src="${download.image}" />
                        <p class="txt">
                            <span class="dis">${download.description}</span>
                            <span class="tit">
                                <i class="space">时间：${download.time}</i>
                                <i class="space">大小：${download.sizeStr}</i>
                                <i>星级：</i>
                                <i class="stars">
                                    <span style="width: ${download.star/5*100}%"></span>
                                </i>
                            </span>
                        </p>
                    </div>
                    <a class="dl" href="DownloadController?id=${download.id}" title="点击下载">立即下载</a>
                </li>
            </ul>
        </c:forEach>
        <p class="back"><a href="main.jsp">返回首页</a></p>
    </div>
</body>
</html>