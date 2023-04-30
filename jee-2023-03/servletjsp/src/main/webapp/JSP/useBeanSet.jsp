<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:useBean id="myBean" class="org.zerock.myapp.domain.LoginBean" scope="session" />
<jsp:setProperty name="myBean" property="userid" value="Yoseph" />
<jsp:setProperty name="myBean" property="passwd" value="1234" />

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>useBeanSet.jsp</title>
</head>

<body>
    <h1>/JSP/useBeanSet.jsp</h1>
    <hr>

    <h1>useBean 사용실습</h1>

    <ol>
        <li>userid: <%= myBean.getUserid() %></li>
        <li>passwd: <%= myBean.getPasswd() %></li>
    </ol>
</body>

</html>