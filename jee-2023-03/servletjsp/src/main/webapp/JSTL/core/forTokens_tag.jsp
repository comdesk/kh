<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>/JSTL/core/forTokens_tag.jsp</h3>
<hr>

<!-- 이 태그는 자바의 java.util.StringTokenizer 클래스를 이용한,
문자열 파싱작업을 태그로 할 수 있도록 만든 것입니다. -->

<%--
    문법:
    <c:forTokens var="문자열token을하나씩저장할EL변수명" items="파싱대상문자열" delims="구분자문자열">
        body
    </c:forTokens>
--%>

<c:forTokens var="city" items="서울.인천,부산,오산.대구,대전" delims=".,">
    ${city}<br>
</c:forTokens>