<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 이미 공유된 공유 속성을 삭제(unbinding)할 때 사용 -->

<%--문법: <c:remove var="문자열로 삭제할 공유속성명 지정" 
            [scope="{page|request|session|application}"]></c:remove> --%>

<c:remove var="__MODEL__" scope="session" />
<c:remove var="__SESSION__" scope="session" />