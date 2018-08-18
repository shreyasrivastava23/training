<%@page import="entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hr>
<h1 align="center">zombie - Community of Experts</h1>
<% User user=(User) session.getAttribute("User");
if(user != null){
%>
<span>Hello<%= user.getUserId() %> </span>
<span><a href ="dashboard.jsp">Home</a> |<a href ="feeds.do">Feeds</a> |<a href = "logout.do">Logout</a> </span>
<% } else { %>
<span>Hello Visitor</span>
<% }%>

<hr size ="3" color="midnightblue">
</body>
</html>