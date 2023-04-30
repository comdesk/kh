<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>/JSP/out.jsp</h1>
    <hr>

    <%
        String name = "홍길동";

        out.println(String.format("<p>out 출력: %s</p>", name));
    %>

    <p>expression 출력: <% out.print(name); %></p>
</body>
</html>