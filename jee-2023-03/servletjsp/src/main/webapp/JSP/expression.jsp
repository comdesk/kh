<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>expression</title>
</head>
<body>
    <h1>/JSP/expression.jsp</h1>
    <hr>

    <h2>이름목록</h2>

    <%
        String name = "Yoseph";
        int age = 23;
        double weight = 58.3;
    %>

    <ul>
        <li><%= name %></li>
        <li><%= age %></li>
        <li><%= weight %></li>
    </ul>
</body>
</html>