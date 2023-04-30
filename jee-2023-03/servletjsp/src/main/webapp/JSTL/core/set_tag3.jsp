<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- set 태그의 세 번째 용법 -->
<!-- 첫 번째 용법인 공유 속성을 생성하는 두 번째 방법 -->
<%-- 문법: <c:set var="공유속성명" value="공유속성값" [scope="{page|request|session|application}"] /> --%>

<%--<c:set var="__MODEL__" value="<%= new org.zerock.myapp.domain.LoginBean() %>" scope="session"></c:set>--%>
<c:set var="__MODEL__" value="<%= new java.util.ArrayList<String>(10) %>" scope="session"></c:set>

<p>__MODEL__: ${__MODEL__}</p>

<c:set var="add1" value="${10+5}" scope="request" />
<c:set var="add2" value="${10 > 5}" scope="request" />