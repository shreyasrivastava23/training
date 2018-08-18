<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body bgcolor=#ADD8E6 text=black>
	<form action="register.do">
		<table width="400" allign="center">
			<tr>
				<th colspan="2">Registration Form</th>
			</tr>
			<tr>
				<td><b>userId</B><br></td>
			</tr>
			<tr>
				<td><input type="text" name ="userId" placeholder="Enter your user id"
					> <br> <br></td>
			</tr>

			<tr>
				<td><b>EmailId :</B><br></td>
			</tr>
			<tr>
				<td><input type="email" name="email" placeholder="someone@xyz.in"
					pattern="[A-Za-z0-9@.]{10,40}"><br> <br></td>
			</tr>

			<tr>
				<td><b>Password :</B> <br></td>
			</tr>
			<tr>
				<td><input type="password" name="password" 
					placeholder="8 to 20 characters minimum"><br> <br></td>
			</tr>

			

		



			<span><tr>
					<td colspan="2"><input type="submit" value="Submit"></span>
			
				</tr>
		</table>
	</form>

</body>
</html>