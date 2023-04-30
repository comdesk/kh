<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Built-in Object</title>
</head>
<body>
    <h1>/JSP/config.jsp</h1>
    <hr>

    <h2>config 내장객체를 이용한 초기화 파라미터 값 얻기</h2>
    <%
        String name = config.getInitParameter("name");
        String age = config.getInitParameter("age");
    %>

    <p>1. name: <%= name %></p>
    <p>2. age: <%= age %></p>
</body>
</html>