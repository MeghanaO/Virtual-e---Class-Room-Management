<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tcs.bean.Faculty"%>
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

		<a href="FacultyProfile.jsp"> Faculty Profile </a><br> <a
			href="FacultyStudyProfile.jsp"> Study Profile </a><br> <a
			href="FacultyQ.jsp"> Post Question </a><br>

	</div>



<%Faculty faculty1 = (Faculty)(session.getAttribute("faculty5")); %>
<table>
<tr>
<td>Name</td>
<td><%=faculty1.getUserName()%></td>
</tr>
<tr>
<td>Password</td>
<td><%=faculty1.getPassword()%></td>
</tr>
<tr>
<td>FacultyId</td>
<td><%=faculty1.getFacultyId()%></td>
</tr>
<tr>
<td>ClassRoomId</td>
<td><%=faculty1.getClassRoomId()%></td>
</tr>
<tr>
<td>EmailId</td>
<td><%=faculty1.getEmailId()%></td>
</tr>
<tr>
<td>PhoneNo</td>
<td><%=faculty1.getPhoneNo()%></td> 
</tr> 
</table>
	<div id="footer"style="background-color: Lemonchiffon; clear: both; text-align: center;">
		<p>VirtualClassRoomManagementSystem.com © All rights reserved.
			2014 TCS-ILP OMR,Chennai-524001,TAMILNADU,INDIA. Ph:(+91) 9003522350</p>
	</div>
</body>
</html>