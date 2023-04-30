<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>declare.jsp</title>
</head>

<body>
    <h1>/JSP/declare.jsp</h1>
    <hr>
</body>

</html>

<%! 
//변환된 클래스 소스파일에 필드 선언
String initMesg = "jspInit 메소드";
String delMesg = "jspDestroy 메소드";

//변환될 클래스 소스 파일에 메소드 선언
//JSP LifeCycle(서블릿과 비슷하게) 메소드
public void jspInit() {     //When New state, called back.
    System.out.println(">>>>> " + initMesg + " <<<<<");
} //jspInit

public void jspDestroy() {     //When Destroy state, called back.
    System.out.println(">>>>> " + delMesg + " <<<<<");
} //jspDestroy
%>