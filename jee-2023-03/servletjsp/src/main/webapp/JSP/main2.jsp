<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page autoFlush="true" %>
<%@page import="javax.servlet.RequestDispatcher" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>main2.jsp</title>
</head>

<body>    
    <h1>/JSP/main2.jsp</h1>
    <hr>

    <!-- 동적인 삽입 -->
    <jsp:include page="/JSP/header1.jsp" flush="true" />
    <jsp:include page="/JSP/header2.jsp" flush="true" />
    <jsp:include page="/JSP/header3.jsp" flush="true">
        <jsp:param name="nickName" value="Yoseph" />
    </jsp:include>

    <%--
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/footer.jsp");
        dispatcher.include(request, response);
    --%>
</body>

</html>