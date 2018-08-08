<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=wheat text=maroon>
<jsp:include page="banner.jsp"></jsp:include>

<% if(request.getParameter("invalid")!=null) {%>
<font size="3" color="Red">Invalid Email id/Password</font>
<%} %>
<form action="Users.hola">
<table width="300" align="center">
<tr><th colspan="2">login screen</th></tr>
<tr><td>EmailId</td><td><input type="text" name="email" required></td></tr>
<tr><td>Password</td><td><input name="password" type="password" required></td></tr>
<tr><th colspan="2"><input type="submit" value="login"></th></tr>
<tr><td colspan="2"><a href="forget.jsp">Forget Password! Change it</a></td></tr>
<tr><td colspan="2"><a href="register.jsp">New User! Register Now</a></td></tr>

</table>
</form>
<%@ include file="footer.html" %>

</body>
</html>