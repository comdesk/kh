<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- 인증체크하는 공통 JSP 정적 삽입 --%>
<%@include file="/JSP/authcheck.jsp" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>응답문서</title>
</head>

<body>
    <h1>/JSP/main.jsp</h1>
    <hr>

    <h1>Lorem ipsum dolor sit amet consectetur adipisicing.</h1>

    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus, cupiditate commodi optio facere praesentium nemo?</p>
	
	<%
   		out.println(request);
	%>
	
	<a href="/JSP/loginInfo.jsp">정보보기</a>

    <%-- 응답 소스로 전송되지 않아야 할 주석은 JSP의 주석을 사용:
         정적인 삽입(소스 그대로 넣는다) --%>
    <%@include file="/JSP/copyright.jsp" %>
</body>

</html>