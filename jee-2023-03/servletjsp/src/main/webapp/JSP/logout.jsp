<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 인증체크하는 공통 JSP 정적 삽입 --%>
<%@include file="/JSP/authcheck.jsp" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>logout.jsp</title>
</head>
<body>
    <h1>/JSP/logout.jsp</h1>
    <hr>
    
    <%
   		out.println(request);
	%>

    <%
        //세션 파괴
        session.invalidate();

        //다시 로그인 창으로 밀어버림.
        response.sendRedirect("/loginForm.html");
    %>
</body>
</html>