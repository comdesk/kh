<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <h1>/JSP/count.jsp</h1>
    <hr>

    <%! private int count; %>

    <%
        application.setAttribute("__VISITED_COUNT__", ++count);
    %>

    <h2>현재 방문자수: <%= count %></h2>
</body>

</html>