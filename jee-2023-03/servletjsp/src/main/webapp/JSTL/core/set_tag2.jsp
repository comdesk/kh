<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- set 태그의 두 번째 용법 -->
<%-- 문법: <c:set target="${EL변수로 Bean객체 지정}" property="Bean속성명" value="속성값" /> --%>

<jsp:useBean id="loginBean" class="org.zerock.myapp.domain.LoginBean" scope="request"/>

<c:set target="${loginBean}" property="userid" value="Yoseph" />
<c:set target="${loginBean}" property="passwd" value="1234" />

<hr>

userid: <jsp:getProperty name="loginBean" property="userid" /><br>
passwd: <jsp:getProperty name="loginBean" property="passwd" />
