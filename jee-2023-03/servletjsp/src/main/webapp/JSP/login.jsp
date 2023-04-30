<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>login.jsp</title>
    </head>

    <body>
        <h1>/JSP/login.jsp</h1>
        <hr>

        <h1>인증 정보를 세션 공유 영역에 저장</h1>

        <%
            String userid = request.getParameter("userid");
            String passwd = request.getParameter("passwd");
        %>

        <%
        if(userid == null || "". equals(userid)) {
            response.sendRedirect("/loginForm.html");
        } else {    //로그인에 성공했다 라고 가정하고...(비밀번호 db 비교 못하니까)
            //Session Shared Scope에 인증정보 바인딩
            session.setAttribute("__AUTH__", userid);
	
        	//인증에 성공했기 때문에, main 화면으로 이동시킴
        	//단, 이때 반드시 Redirection 기법으로 이동시켜야 함.
            response.sendRedirect("/JSP/main.jsp");     //로그인 성공한 사용자만이 올 수 있는 곳
        } //if-else
        %>
    </body>

    </html>