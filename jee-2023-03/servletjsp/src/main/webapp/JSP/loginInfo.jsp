<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- 인증체크하는 공통 JSP 정적 삽입 --%>
<%@include file="/JSP/authcheck.jsp" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>loginInfo.jsp</title>
</head>
<body>
    <h1>/JSP/loginInfo.jsp</h1>
    <hr>

    <%-- String auth = (String) session.getAttribute("__AUTH__"); --%>

	<%
   		out.println(request);
	%>

    <h1>인증정보: <%= auth %></h1>
    <p><a href="/JSP/logout.jsp">로그아웃</a></p>
</body>
</html>