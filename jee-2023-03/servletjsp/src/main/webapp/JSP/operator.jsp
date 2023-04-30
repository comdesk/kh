<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page errorPage="/JSP/error.jsp" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>operator.jsp</title>
</head>

<body>    
    <h1>/JSP/operator.jsp</h1>
    <hr>

    <h1>EL 연산자 실습</h1>

    <hr>
    <h2>1. EL의 사칙연산자 연습</h2>
    <h2>\${3+5} = ${3 + 5}</h2>
    <h2>\${3-5} = ${3 - 5}</h2>
    <h2>\${3*5} = ${3 * 5}</h2>
    <h2>\${13/5} = ${13 / 5}</h2>
    <h2>\${13%5} = ${13 % 5}</h2>

    <hr>
    <h2>2. EL의 비교연산자 연습</h2>
    <h2>\${3==5} = ${3 == 5}</h2>
    <h2>\${3>5} = ${3 > 5}</h2>
    <h2>\${3>=5} = ${3 >= 5}</h2>
    <h2>\${3<5} = ${3 < 5}</h2>
    <h2>\${3<=5} = ${3 <= 5}</h2>
    <h2>\${3!=5} = ${3 != 5}</h2>

    <hr>
    <h2>3. EL의 다양한 연산자로 복잡한 조건식 연습</h2>
    <h2>\${3!=5&&4==4} = ${3!=5&&4==4}</h2>
    <h2>\${3!=5||4!=4} = ${3!=5||4!=4}</h2>
    <h2>\${!(3==5)} = ${!(3==5)}</h2>

</body>

</html>