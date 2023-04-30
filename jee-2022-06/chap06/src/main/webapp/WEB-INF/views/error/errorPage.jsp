<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" 
	isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error.jsp</title>
</head>
<body>
	<h1><%= request.getRequestURI() %></h1>
	<hr>

	<h2>시스템에 잠시 문제가 발생하였습니다.</h2>
	<h3>잠시 후에 다시 시도하여 주십시오.</h3>

	<p><%= exception %></p>
	<p>${__EXCEPTION__}</p>
</body>
</html>