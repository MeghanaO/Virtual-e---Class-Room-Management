<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="header" style="background-color: Lemonchiffon;">
		<table align="center">
			<tr>
				<td><img src="../1.png" alt="Virtual Learning" height="75"
					width="75"></td>
				<td><h1>Virtual Class Room Management System</h1></td>
			</tr>
		</table>
	</div>
	</div>

<div id="menu"
		style="background-color: #FFD700; height: 525px; width: 125px; float: left;">

		<a href="FacultyProfile.jsp"> Faculty Profile </a><br> <a
			href="FacultyStudyProfile.jsp"> Study Profile </a><br> <a
			href="FacultyQ.jsp"> Post Question </a><br>

	</div>


	<form name="frmEditFacultyForm" action="../Controller" method="post">
		<center>
			<h3>Edit Faculty Details</h3>
		</center>
		<div class="central">
			<table align="center" bgcolor="pink"
				style="border-radius: 15px; -moz-border-radius: 15px; -webkit-border-radius: 15px;"
				width="400" height="400">
				<tr>
					<td>User Name</td>
					<td><input type="text"
						style="background-color: Burlywood; font-color: black"
						name="username" value="" onblur="validateUserName()"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input style="background-color: Burlywood" type="text"
						name="password" value="" onblur="validatePassWord()"></td>
				</tr>
				<tr>
					<td>Class Room Id</td>
					<td><input type="text"
						style="background-color: Burlywood; font_color: black"
						name="classid" value="" onblur="validateClassRoomId()"></td>
				</tr>
				<tr>
					<td>Contact Number</td>
					<td><input type="text"
						style="background-color: Burlywood; font_color: black"
						name="phonenumber" value="" onblur="validatePhoneno()"></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><input type="text"
						style="background-color: Burlywood; font-color: black"
						name="email" value="" onblur="validateEmailId()"></td>
				</tr>
			</table>
		</div>
		<br>
		<div align="center">
			<input type="hidden"
				name="action" value="EditFaculty">
			<input type="submit" value="Submit"
				style="background-color: Cornsilk">  &nbsp;
			&nbsp; &nbsp; &nbsp; &nbsp; <input type="reset" value="reset"
				style="background-color: Cornsilk"> 
		</div>
	</form>
	<div id="footer"
		style="background-color: Lemonchiffon; clear: both; text-align: center;">
		<p>VirtualClassRoomManagementSystem.com © All rights reserved.
			2014 TCS-ILP OMR,Chennai-524001,TAMILNADU,INDIA. Ph:(+91) 9003522350</p>
	</div>
</body>
</html>