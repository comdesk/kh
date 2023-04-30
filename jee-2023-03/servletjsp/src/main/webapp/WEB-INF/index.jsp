<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>index.jsp</title>
</head>
<body>
    <h1>/WEB-INF/index.jsp</h1>
    <hr>

    <!-- Request Scope에 공유된 MODEL 데이터 추출 -->
    <h2>Model: <%= request.getAttribute("__MODEL__") %></h2>
</body>
</html>