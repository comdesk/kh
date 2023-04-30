<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>currentTime</title>
</head>
<body>
    <h1>/JSP/currentTime.jsp</h1>
    <hr>

    <%
        Date now = new Date();
        System.out.println("now: " + now);
    %>

    <h2>Now: <%= now %></h2>
</body>
</html>