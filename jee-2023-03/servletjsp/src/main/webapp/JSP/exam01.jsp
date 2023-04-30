<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="myBean" class="org.zerock.myapp.domain.LoginBean" />

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>exam01.jsp</title>
</head>

<body>    
    <h1>/JSP/exam01.jsp</h1>
    <hr>

    <h1>JSTL Core 라이브러리 실습#1</h1>
    <hr>

    <%-- set 태그의 목적: 공유영역에 속성 바인딩/재바인딩 수행
    syntax: <c:set 
                var="변수명(공유속성명)" 
                value="공유속성값" 
                scope="{page|request|session|application}" />
    자바코드로 변환: pageContext.setAttribute("변수명", "속성값");
    var 속성: 바인딩 되는 속성의 이름 지정
    value 속성: 바인딩되는 속성의 값
    중요: 이 태그의 var 속성의 값이 EL 변수명이 된다! --%>
    <c:set var="__PAGE__"           value="VALUE_1" scope="page" />
    <c:set var="__REQUEST__"        value="VALUE_2" scope="request" />
    <c:set var="__SESSION__"        value="VALUE_3" scope="session" />
    <c:set var="__APPLICATION__"    value="VALUE_4" scope="application" />

    <!-- out 태그의 value 속성의 값: (1) 문자열 or (2) EL 표기법 -->
    1. <c:out value="Hello World" /><br>
    2. <c:out value="${__PAGE__}" /><br>
    3. ${__PAGE__}<br>

    <!-- <h1>JSTL Core 라이브러리 실습#2</h1>
    <hr> -->
    
    <!-- 4개의 공유영역에 한군데 -->
</body>

</html>