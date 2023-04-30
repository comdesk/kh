<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>/JSTL/core/choose_when_otherwise.jsp</h3>
<hr>

<%-- core 라이브러리 태그 중, 아래의 3개를 이용해서,
자바의 switch문과 비슷한 제어문을 생성할 수 있다.
(1) <c:choose/>     => switch 키워드
(2) <c:when/>       => case 키워드
(3) <c:otherwise/>  => default 키워드   
--%>

<!-- 아래의 조건식에는 일반적으로 EL표현식이 들어간다.
왜? 조건식에는 의례, 비교연산자가 필요하기 때문.
이 비교연산자를 EL표현식에서는 그대로 사용가능하기 때문. -->

<c:choose>
    <c:when test="${param.color == 1}">
        <p>1. color는 ${param.color} 입니다.</p>
    </c:when>
    <c:when test="${param.color == 2}">
        <p>2. color는 ${param.color} 입니다.</p>
    </c:when>
    <c:when test="${param.color == 3}">
        <p>3. color는 ${param.color} 입니다.</p>
    </c:when>
    <c:otherwise>
        <p>4. color는 ${param.color} 입니다.</p>
    </c:otherwise>
</c:choose>