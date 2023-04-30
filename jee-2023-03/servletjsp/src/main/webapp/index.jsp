<%--<%@page import="java.io.IOException %> --%>
<% 
	System.out.println(">>>>>>>>>>> /JSP/index.jsp <<<<<<<<<<"); 
	
	boolean isTrue = false;
	if(!isTrue) {
		throw new java.io.IOException("TEST");
	} //if
%>

<html>
<body>
<h2>Hello World!</h2>
<h2>대한민국</h2>
</body>
</html>

