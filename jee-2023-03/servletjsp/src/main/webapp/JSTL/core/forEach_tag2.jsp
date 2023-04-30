<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>/JSTL/core/forEach2.jsp</h3>
<hr>

<%--
    <c:forEach /> 태그의 두 번째 용법: classical for문 생성 기능

    문법: 
        <c:forEach [var="현재값을저장할변수명을 문자열로지정"] 
                    begin="시작값을 문자열로지정" 
                    end="종료값을 문자열로지정" 
                    [step="증감치을 문자열로지정"]>
            ${var속성명(***var 속성명은 바로 EL변수명을 만들어냄***)}
        </c:forEach>
--%>

<c:forEach var="cnt" begin="1" end="10" step="1">
    ${cnt}<br>
</c:forEach>

