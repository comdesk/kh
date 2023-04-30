<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Built-in Object</title>
</head>
<body>
    <h1>/JSP/response.jsp</h1>
    <hr>

    <%
        //response.sendRedirect("/JSP/responseRedirect.jsp");
        request.getRequestDispatcher("/JSP/responseRedirect.jsp").forward(request, response);
    %>
</body>
</html>