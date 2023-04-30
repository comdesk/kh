<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--@page import="org.zerock.myapp.domain.LoginBean, java.util.List, java.util.ArrayList" --%>
<%@page import="org.zerock.myapp.domain.LoginBean" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>



<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>set.jsp</title>
</head>

<body>    
    <h1>/JSP/set.jsp</h1>
    <hr>

    <h1>List 실습</h1>

    <%
        LoginBean oneBean = new LoginBean();
        oneBean.setUserid("aaa");
        oneBean.setPasswd("1234");

        LoginBean twoBean = new LoginBean();
        twoBean.setUserid("bbb");
        twoBean.setPasswd("2222");

        //리스트 객체를 만들고, 2개의 자바빈즈 객체를 요소로 추가
        List<LoginBean> list = new ArrayList<>();
        list.add(oneBean);
        list.add(twoBean);

        //Request Scope에 리스트 객체를 속성으로 바인딩
        request.setAttribute("__MODEL__", list);
    %>

    <jsp:forward page="/JSP/get.jsp" />
</body>

</html>