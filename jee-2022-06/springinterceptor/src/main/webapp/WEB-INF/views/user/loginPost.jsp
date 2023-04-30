<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <%@include file="/WEB-INF/views/common/favicon.jsp" %>
</head>
<body>
    <c:redirect url="/board/list" />
    <!-- <%response.sendRedirect("/board/list"); %> -->
</body>
</html>