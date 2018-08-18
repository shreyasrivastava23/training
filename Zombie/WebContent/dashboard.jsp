<%-- <%@page import="entity.User"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile Window</title>
</head>

<body bgcolor=#ADD8E6 text=black>
<jsp:include page="banner.jsp"/>

<%-- <% User user= (User) session.getAttribute("User"); %> --%>

<h1>My Dashboard</h1>
User Id: ${User.userId}<br>
Email:${User.email}<br>
Feed Count:${User.totalFeeds }
<a href ="query.jsp">Ask Question</a>


<%--  <table align="center">
<tr><th colspan="2"> Your Profile Details </th></tr>
<tr><td> userId </td></tr><tr><td><%=user.getUserId() %></td></tr>
<tr><td> email </td></tr><tr><td><%=user.getEmail() %></td></tr>
</table> --%>

</body>
</html>