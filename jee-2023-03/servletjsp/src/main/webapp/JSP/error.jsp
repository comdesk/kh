<%@ page 
    language="java" 
    isErrorPage="true"
    contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>

<% exception.printStackTrace(); %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>error.jsp</title>
</head>

<body>
    <h1>/JSP/error.jsp</h1>
    <hr>

    <h2>시스템에 잠시 문제가 발생하였사오니, <br>잠시 후에 다시 시도하여 주십시오.</h2>

    <!-- <h2> -->
        <%--= exception --%>
    <!-- </h2> -->
    <!-- <ol> -->
        <%--
            StackTraceElement[] stackTrace = exception.getStackTrace();
            for(StackTraceElement e : stackTrace) {
        --%>
        
            <!-- <li> -->
                <!-- at  -->
                <%--= e --%>
            <!-- </li>  -->
        <%--
            } //enhanced for
        --%>
    <!-- </ol> -->
</body>

</html>