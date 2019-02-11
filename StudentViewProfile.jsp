<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tcs.bean.Student"%>
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

	<div id="menu"
		style="background-color: #FFD700; height: 525px; width: 125px; float: left;">

		<a href="StudentProfile.jsp"> Student Profile </a><br> <a
			href="StudentStudyProfile.jsp"> Study Profile </a><br> <a
			href="StudentQ.jsp"> Post Question </a><br>

	</div>
	
	<%Student student1 = (Student)(session.getAttribute("student6")); %>
<table>
<tr>
<td>Name</td>
<td><%=student1.getUserName()%></td>
</tr>
<tr>
<td>Password</td>
<td><%=student1.getPassword()%></td>
</tr>
<tr>
<td>FacultyId</td>
<td><%=student1.getFacultyId()%></td>
</tr>
<tr>
<td>ClassRoomId</td>
<td><%=student1.getClassRoomId()%></td>
</tr>
<tr>
<td>EmailId</td>
<td><%=student1.getEmailId()%></td>
</tr>
<tr>
<td>PhoneNo</td>
<td><%=student1.getPhoneNo()%></td> 
</tr> 
</table>
	<div id="footer"style="background-color: Lemonchiffon; clear: both; text-align: center;">
		<p>VirtualClassRoomManagementSystem.com © All rights reserved.
			2014 TCS-ILP OMR,Chennai-524001,TAMILNADU,INDIA. Ph:(+91) 9003522350</p>
	</div>
</body>
</html>