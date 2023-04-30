<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>/JSTL/core/redirect_tag.jsp</h3>
<hr>

<!-- Servlet/JSP에서 배웠던, 리다이렉션 기법을 태그로 구현한 것 -->

<%--
    문법:
        <c:redirect url="TargetURL을 문자열로지정" [context="ContextPath을문자열로지정"] />
--%>

<c:redirect url="/JSP/main.jsp" />
<%-- <c:redirect url="/JSP/main.jsp" context="/myweb" /> --%>