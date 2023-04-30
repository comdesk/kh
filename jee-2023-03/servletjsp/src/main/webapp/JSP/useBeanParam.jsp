<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- 기본 scope에 바인딩되어 있는 자바빈즈 객체를, 
Request 메시지의 전송파라미터 수집용으로 사용 -->
<jsp:useBean id="myBean" class="org.zerock.myapp.domain.LoginBean" scope="session"/>
<jsp:setProperty name="myBean" property="userid" param="myUserid" />
<jsp:setProperty name="myBean" property="passwd" param="myPasswd" />

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>useBeanParam.jsp</title>
</head>

<body>
    <h1>/JSP/useBeanParam.jsp</h1>
    <hr>

    <h1>param 속성을 통한 전송파라미터 자동 수집 실습</h1>

    <ol>
        <li>userid: <%= myBean.getUserid() %></li>
        <li>passwd: <%= myBean.getPasswd() %></li>
    </ol>
</body>

</html>