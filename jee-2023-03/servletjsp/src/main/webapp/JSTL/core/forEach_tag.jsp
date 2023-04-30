<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>/JSTL/core/forEach.jsp</h3>
<hr>

<!-- 배열, 각종 컬렉션 등과 같은 Complex Type의 순회하여,
순차처리하는 데에 사용 => 간단히 하면, 자바의 enhanced for 문 생성 -->

<%-- 문법:   
        <c:forEach [var="요소를받을변수명을 문자열로 지정(이 문자열이 곧 EL표현식의 EL변수명이 됨)"] 
                   items="배열같은 Complex타입 객체(주로 EL표현식 -> 공유속성에 올려놔야 함.)(또는, JSP Experssion tag)" Expression tag 안 되는 거 맞다는데 나는 왜 되지..?
                   [varStatus="반복상태정보를저장하고있는변수명을 문자열로지정(이 문자열이 곧 EL표현식의 EL변수명이 됨)"]>
            body
        </c:forEach> 
--%>

<!-- JSTL 태그에서 var속성(=EL변수를 생성하는 속성)의 이름은 EL표현식의 EL변수명(==공유속성명이지만, 공유속성명이 아닌경우도 있음.)이 된다.(*********)
(공유속성명이 아님에도 불구하고 EL변수명으로 활용이 된다.) -->
<%-- 예: <c:forEach var="movie" items="${movieList}">
            ${movie}<br>
         </c:forEach> --%>

<%
    String[] movieList = {"title_1","title_2","title_3"}; //OK
    //java.util.List<String> movieList = java.util.Arrays.asList("title_1", "title_2", "title_3");  //OK
    //java.util.Map<String, String> movieList = new java.util.HashMap<>();    
    //movieList.put("movie_1", "title_1");
    //movieList.put("movie_2", "title_2");
    //movieList.put("movie_3", "title_3");

    //아래와 같이, 특정 공유영역에 공유속성을 만들어놔야 이 공유속성이름이 EL 표현식의
    //EL변수(=공유속성이름)로 사용 가능
    pageContext.setAttribute("movieList", movieList);   //Page Scope에 배열 바인딩
%>

<!-- 자바 코드로 한다면, 아래와 같음 -->
<%-- <% for( String movie : movieList ) { %>
    <%= movie &>
<%} //enhanced for%> --%>

<%--<c:forEach var="movie" items="<%= movieList %>"> --%>
<%--<c:forEach var="movie" items="${movieList}"> 
        ${movie}<br>
    </c:forEach>    
--%>

<c:forEach var="movie" items="${movieList}" varStatus="status">
    [${status.count}]. ${movie}, 
    (index: ${status.index}, isFirst?: ${status.first}, isLast?: ${status.last})<br>
</c:forEach>

<hr>

<c:forEach var="movie" items="${movieList}" varStatus="status">
    ${movie} <c:if test="${ not status.last }">,</c:if>
</c:forEach>


