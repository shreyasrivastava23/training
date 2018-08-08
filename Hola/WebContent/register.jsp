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
	<form action="Users.hola">
		<h1>Register Form</h1>
		<table style="width: 50%">
			
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="male" checked>Male
					<input type="radio" name="gender" value="female" checked>Female</td/>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" ></td>
			</tr>
			<tr>
				<td>City</td>
				<td><select name="city">
						<%
							String[] cities = { "Mumbai", "Pune", "Banagalore", "Noida", "Kanpur" };
							for (String ct : cities) {
						%>
						<option value="<%=ct%>"><%=ct%></option>
						<%}%>
				</select></td>
			</tr>
			<tr>
				<td>Movie</td>
				<td><input type="text" name="movie" required></td>
			</tr>
			<tr>
				<td>Age</td>

				<td><select name="age">
						<%
							for (int a = 18; a <= 60; a++) {
						%>
						<option value="<%=a%>"><%=a%></option>
						<%}%>
					</select></td>
			</tr>
			<tr>
				<td>Photo</td>
				<td><input type="file" name="photo" ></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="Register"></th>
			</tr>
		</table>
	</form>
	<%@ include file="footer.html"%>
</body>
</html>