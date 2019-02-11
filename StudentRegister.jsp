<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h3>Student Register Form</h3>
</center>
<form name='frmStudentRegister' action="../Controller" method="post"><br>
<div class="central">
<table align="center" bgcolor="pink" style="border-radius: 15px;-moz-border-radius: 15px;-webkit-border-radius: 15px;" width="400" height="400">
<tr><td>User Name</td><td><input type="text" style="background-color:Burlywood;font-color:black" name="username" value="" onblur="validateStudentUserName()"></td></tr>
<tr><td>Password</td><td><input style="background-color:Burlywood" type="text" name="password" value="" onblur="validateStudentPassWord()"></td></tr>
<tr><td>Class Room Id</td><td><input type="text" style="background-color:Burlywood;font_color:black" name="classid" value="" onblur="validateStudentClassRoomId()"></td></tr>
<tr><td>Faculty Id</td><td><input type="text" style="background-color:Burlywood;font_color:black" name="facultyid" value="" onblur="validateStudentFacultyId()"></td></tr>
<tr><td>Contact Number</td><td><input type="text" style="background-color:Burlywood;font_color:black" name="contactnumber" value="" onblur="validateStudentPhoneno()"></td></tr>
<tr><td>Email Id</td><td><input type="text" style="background-color:Burlywood;font-color:black" name="email" value="" onblur="validateStudentEmailId()"></td></tr>
<tr><td><input type="hidden" name="action" value="addStudent"></td></tr>
</table>
</div><br>
<div align="center">
<input type="submit" value="Submit" style="background-color:Cornsilk">
&nbsp; 
&nbsp; 
&nbsp; 
&nbsp; 
&nbsp; <input type="reset" value="reset" style="background-color:Cornsilk">
</div><br><br>
<div class="footer">
<table align="center">
<tr><td>Go to</td><td><a href="Login.jsp">Login Page</a></td></tr>
</table>
</div>
</form>
</body>
</html>