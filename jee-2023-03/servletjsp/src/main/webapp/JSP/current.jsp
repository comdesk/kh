<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>current.jsp</title>
</head>

<body>    
    <h1>/JSP/current.jsp</h1>
    <hr>

    <!-- 포워드 하기 전에, 이미 출력 버퍼가 flush 되어 버리면,
    포워드 실패 및 오류 발생 - 왜? target JSP가 출력 버퍼를 clear할 기회가 없기 때문 -->
    <%-- for(int i = 0; i <= 500; i++) { --%>
        <!-- <h4>/JSP/current.jsp</h4> -->        
    <%-- } //for --%>

    <jsp:forward page="/JSP/forward.jsp">
        <jsp:param name="nickName" value="한글" />
    </jsp:forward>

</body>

</html>