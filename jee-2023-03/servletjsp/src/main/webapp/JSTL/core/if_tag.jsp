<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>/JSTL/core/if_tag.jsp</h3>
<hr>

<!-- 자바의 단순 if문을 생성하는 태그이다.
단, 자바의 if-else 같은 거짓일 때의 조건은 처리하지 못한다.
(주의)단순 if문만 생성가능하다. -->

<%-- 문법: 
            <c:if test="조건식">
                조건식이 참일 경우 실행(출력)할 문장
            </c:if>            
--%>

<!-- 예: http://localhost:8080/JSTL/core/if_tag.jsp?color=1 (테스트 조건: 색상값을 전달) -->

<c:if test="${param.color == 1}">
    <p>1. color는 ${param.color} 입니다.</p>
</c:if>

<c:if test="${param.color == 2}">
    <p>2. color는 ${param.color} 입니다.</p>
</c:if>

<c:if test="${param.color == 3}">
    <p>3. color는 ${param.color} 입니다.</p>
</c:if>