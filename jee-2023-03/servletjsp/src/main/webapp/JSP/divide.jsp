<%@ page 
    language="java" 
    errorPage="/JSP/error.jsp"
    contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>divide.jsp</title>
</head>

<body>
    <h1>/JSP/divide.jsp</h1>
    <hr>

    <%
        int n = 4/0;    //예외 발생
    %>
</body>

</html>