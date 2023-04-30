<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>/JSTL/core/catch_tag.jsp</h3>
<hr>

<!-- 자바언어의 예외처리 구문인 try-catch 구문과 비슷한 역할을 수행 -->

<%--
    문법: <c:catch var="예외발생시, 발생한예외를저장하는변수명">
            예외가 발생가능한 코드블록
          </c:catch>
--%>

<c:catch var="exception">
    예외발생전<br>
    <%= 10 / 0 %><br>
    예외발생후<br>
</c:catch>

<c:out value="${exception}" />
<p></p>
<c:out value="${exception.getMessage()}" />