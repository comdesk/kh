<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
<%@include file="/WEB-INF/views/common/favicon.jsp" %>
</head>
<body>
	<h1><%= request.getRequestURI() %></h1>
    <!-- <h1>${request.getRequestURI}</h1> -->
    <hr>

    <button type="button" id="logoutBtn">Logout</button>

    <script>
        var logoutBtn = document.querySelector("#logoutBtn");
        logoutBtn.addEventListener("click", function () {
            location = "/user/logout";  //GET, /user/logout
        }); //onclick
    </script>
</body>
</html>
