<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>/JSTL/core/out_tag.jsp</h3>
<hr>

<!-- 지정된 값을 원하는 위치에 출력하는 용도의 태그
EL표현식 또는 Experssion Tag 하고도 겹치는 기능 -->

<%--
    문법: <c:out value="출력할값(EL표현식, JSP Expression Tag, 문자열)" [default="기본값"] />
          //value 속성의 값이 없을 경우, default 속성의 값을 출력시킴
--%>

1. 단순 문자열 출력: <c:out value="STRING" /><br>
2. EL표현식의값을출력: <c:out value="${obj}" default="공유속성obj가 없습니다." /><br>
3. JSP expression tag 값 출력: <c:out value='<%= "Yoseph" %>' />

