<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>login.jsp</title>

    <%@include file="/WEB-INF/views/common/favicon.jsp" %>
</head>
<body>
	<h1><%= request.getRequestURI() %></h1>
    <!-- <h1>${request.getRequestURI}</h1> -->
    <hr>

    <form action="/user/loginPost" method="post" style="width: 300px">
        <fieldset style="border: 5px outset gold;">
            <legend>LoginForm</legend>

            <div><input type="text" name="userid" placeholder="User ID"></div>
            <div><input type="password" name="userpw" placeholder="User Password"></div>
            <div>Remember-me <input type="checkbox" name="rememberMe"></div>

            <p></p>

            <div><button type="submit">Sign-in</button></div>
        </fieldset>
    </form>
</body>
</html>
