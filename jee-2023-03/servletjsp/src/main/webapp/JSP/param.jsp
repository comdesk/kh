<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>param.jsp</title>
</head>

<body>    
    <h1>/JSP/param.jsp</h1>
    <hr>

    <ul>
        <li>userid: ${param.userid}</li>
        <li>passwd: ${param.passwd}</li>
    </ul>
</body>

</html>