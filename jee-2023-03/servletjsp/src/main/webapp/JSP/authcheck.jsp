<%-- 인증되어 있는 웹브라우저의 요청인지 확인(이 로직은 공통로직임)--%>

<%
    String auth = (String) session.getAttribute("__AUTH__");
    if(auth != null) { //이미 로그인에 성공한 웹브라우저임.
        ;;
    } else {           //인증이 안 된 상태 => 로그인 창으로 redirection 시켜야 함.
        response.sendRedirect("/loginForm.html");
        
        return; //포워딩, 리다이렉션을 해도 끝나지 않고 밑으로 끝까지 모든 코드를 수행하기 때문에 끝내야 함.
    } //if
%>