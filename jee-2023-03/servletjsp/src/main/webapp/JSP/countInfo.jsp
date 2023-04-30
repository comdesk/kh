<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <h1>/JSP/countInfo.jsp</h1>
    <hr>

    <h2>방문자수 조회하기 화면</h2>

    <%
        int count = (Integer) application.getAttribute("__VISITED_COUNT__");
    %>

    <h3>현재 방문자수: <%= count %></h3>
</body>

</html>