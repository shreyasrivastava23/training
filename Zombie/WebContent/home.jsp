<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body bgcolor=#ADD8E6 text=black>
<jsp:include page="banner.jsp"/>
	<h2>Login Page</h2>
	<%-- <% if(request.getParameter("invalid")!= null) { %>
	<font size="3" color = "red">Invalid Email ID / Password</font>
	<% } %> --%>
	<form action="login.do" >
	<font color="red">${Prompt}</font>
		<b>User id</B></br><input  name="userId"
			placeholder="enter user id"></span> <br> <br> <B>
			
			
			Password :</B> <br> <input type="password" name="password" "
			placeholder="8 characters minimum"> <br> <br>
			<span><input
			type="submit" value="Submit" > </span>
			<br><a href="forget.jsp">forgot password</a>
			<br><a href="register.jsp">register</a>
			</form>


	
</body>
</html>