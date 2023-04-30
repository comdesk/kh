<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="/JSP/error.jsp" %>

<jsp:useBean id="myBean" class="org.zerock.myapp.domain.LoginBean" scope="page" />
<jsp:setProperty name="myBean" property="*" />

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>useBeanAll.jsp</title>
</head>

<body>
    <h1>/JSP/useBeanAll.jsp</h1>
    <hr>

    <h1>useBeanAll 사용실습</h1>

    <ol>
        <li>userid: <jsp:getProperty name="myBean" property="userid" /></li>
        <li>passwd: <jsp:getProperty name="myBean" property="passwd" /></li>
    </ol>
</body>

</html>