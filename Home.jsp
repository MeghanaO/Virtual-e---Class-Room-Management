<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="central">
		<table align="center">
			<tr>
				<td>
					<form name="frmStudent" action="../Controller" method="post">
						<table border=0 bgcolor="peru"
							style="border-radius: 15px; -moz-border-radius: 15px; -webkit-border-radius: 15px;">
							<tr>
								<td><h1>Student Login</h1></td>
							</tr>
							<tr>
								<td>User Id:</td>
								<td><input type="text" name="userid" value=""
									onblur="usernameValidation()"></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type="password" name="password" value=""
									onblur="passwordValidation()"></td>
							</tr>
							<tr>
								<td><input type="hidden" name="action" value="loginStudent"></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="Login">&nbsp;&nbsp;&nbsp;<a
									align="left" href="StudentRegister.jsp" target="right">Register</a></td>
							</tr>
						</table>
					</form>
				</td>
				<td>
					<form name="frmFaculty" action="../Controller" method="post">
						<table border="0" bgcolor="Hotpink"
							style="border-radius: 15px; -moz-border-radius: 15px; -webkit-border-radius: 15px;">
							<tr>
								<td><h1>Faculty Login</h1></td>
							</tr>
							<tr>
								<td>User Id:</td>
								<td><input type="text" name="userid" value=""
									onblur="usernameValidation()"></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type="password" name="password" value=""
									onblur="passwordValidation()"></td>
							</tr>
							<tr>
								<td><input type="hidden" name="action" value="loginFaculty"></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="Login">&nbsp;&nbsp;&nbsp;
									<a align="left" href="FacultyRegister.jsp" target="right">Register</a></td>
							</tr>
						</table>
					</form>
				</td>
				<td>
					<form name="frmAdmin" action="../Controller" method="post">
						<table border=0 bgcolor="CadetBlue"
							style="border-radius: 15px; -moz-border-radius: 15px; -webkit-border-radius: 15px;">
							<tr>
								<td><h1>Admin Login</h1></td>
							</tr>
							<tr>
							<td>User Id:</td>
								<td><input type="text" name="userid" value="" onblur="usernameValidation()"></td>
								</tr>
							<tr>
								<td>Password:</td>
								<td><input type="password" name="password" value=""
									onblur="passwordValidation()"></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="Login"></td>
								<tr>
								<td><input type="hidden" name="action" value="loginAdmin"></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>