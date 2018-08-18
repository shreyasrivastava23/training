
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=#ADD8E6 text=black>
<jsp:include page="banner.jsp"/>
<table align="center" width="50%" border="1" cellspacing="5">
		<tr bgcolor="wheat">
			<th>Time</th><th>Query</th><th>comments</th>
		</tr>
		<c:forEach items="${ Feeds }" var="feed">
		<tr>
			<td>${ feed.feedTime }</td>
			<td><a href="question.do?id=${feed.feedId}">${ feed.query }</a></td>
			<td>${ feed.totalComments }</td>		
		</tr>
		</c:forEach>
	</table>
</body>
</html>