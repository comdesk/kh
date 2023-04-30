<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>get.jsp</title>
</head>

<body>    
    <h1>/JSP/get.jsp</h1>
    <hr>

    <h1>List 실습</h1>


    <p>자동공유영역탐색: ${__MODEL__}</p>
    
    <p>1. 1st. LoginBean: ${__MODEL__[0].userid}, ${__MODEL__[0].passwd}</p>
    <p>2. 2nd. LoginBean: ${__MODEL__[1].userid}, ${__MODEL__[1].passwd}</p>
</body>

</html>