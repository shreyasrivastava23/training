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
<h1>Share your Response</h1><hr size="1" color="crimson">
<form action ="comment.do">
<table border="1" bordercolor="crimson">
<tr><th colspan="2"> ${Question.query}</th></tr>
<tr><td colspan="2">
<textarea name="response" rows="5" cols="30"></textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="Respond"></td></tr>
<c:forEach items="${ Question.comments }" var="cmnt">
<tr><td>${ cmnt.user.userId }</td>
<td>${ cmnt.response}</td></tr>

</c:forEach>
</table>
</form>
</body>
</html>