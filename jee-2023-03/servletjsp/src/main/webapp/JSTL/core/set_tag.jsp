<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.zerock.myapp.domain.LoginBean" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>/JSTL/core/set_tag.jsp</h3>
<hr>

<!-- set 태그는, 공유속성의 바인딩/재바인딩 수행 -->
<!-- 이전 자바코드: session.setAttribute("속성명", 속성값); -->
<%--문법#1: <c:set var="공유속성명" value="공유속성값" 
        [scope="{page|request|session|application}"] />
        scope은 생략 가능 -> 디폴트는 page --%>

<!-- 주의: JSTL tag는 JSP 주석으로 막아야 수행이 되지 않는다. -->
<!-- 주의2: 태그의 var 속성의 값이 곧 EL표현식의 EL변수가 된다(***) -->
<%-- <c:set var="msg" value="PAGE" scope="page" /> --%>
<%-- <c:set var="msg" value="REQUEST" scope="request" /> --%>
<%-- <c:set var="msg" value="SESSION" scope="session" /> --%>
<%--<c:set var="msg" value="APPLICATION" scope="application" />--%>

<!-- 문자열 말고, 다른 참조타입의 객체를 공유속성값으로 바인딩시켜보자! -->
<%--<c:set var="__MODEL__" value="${100}" scope="application" />--%>
<%--<c:set var="__MODEL__" value="${3.14159}" scope="session" />--%>

<!-- 공유속성값 출력 -->
<!-- EL표현식에 EL 변수(즉, 공유속성명)을 넣으면, 
     작은 공유 영역 > 큰 영역으로 자동으로 지정된 이름의 공유속성을 찾음. -->
<!-- <p>msg: ${msg}</p> -->

<!-- <p>__MODEL__: ${__MODEL__}</p> -->

<%-- LoginBean bean = new LoginBean(); //XX --%>
<%-- List<String> obj = new ArrayList<>(); //XX --%>

<%
    request.setAttribute("__MODEL__", new LoginBean());
%>
<c:set var="__SESSION__" value="${__MODEL__}" scope="session" />
<p>__SESSION__: ${__SESSION__}</p>