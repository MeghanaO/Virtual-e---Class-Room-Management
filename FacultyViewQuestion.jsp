<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tcs.bean.Faculty, com.tcs.bean.QuestionAndAnswer"%>
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

	<%ArrayList<QuestionAndAnswer> qalist= (ArrayList<QuestionAndAnswer>)session.getAttribute("List");%>
	<%ArrayList<QuestionAndAnswer> qalist1= (ArrayList<QuestionAndAnswer>)session.getAttribute("List1");%>
	<% if(qalist.size()>0){ %>
	<table>
	<tr>
	<td>ClassRoomID</td>
	<td>QuestionID</td>
	<td>StudentID</td>
	<td>Question</td>
	<td>Status</td>
	<td>FacultyID</td>
	<td>Answer</td>
	</tr>
	
	<% for(QuestionAndAnswer qanda : qalist){ %>
	<tr>
	<td><%= qanda.getClassRoomId() %>
	<td><%= qanda.getQuestionId() %>
	<td><%= qanda.getStudentId() %>
	<td><%= qanda.getQuestion() %>
	<td><%= qanda.getStatus() %>
	<td><%= qanda.getFacultyId()%>
	<td><%= qanda.getAnswer() %>
	</tr>
	<% }%>
	<% }%>
	</table>
	<% if(qalist1.size()>0){ %>
	<table>
	<tr>
	<td>ClassRoomID</td>
	<td>QuestionID</td>
	<td>StudentID</td>
	<td>Question</td>
	<td>Status</td>
	<td>FacultyID</td>
	<td>Answer</td>
	</tr>
	
	<% for(QuestionAndAnswer qanda : qalist1){ %>
	<tr>
	<td><%= qanda.getClassRoomId() %>
	<td><%= qanda.getQuestionId() %>
	<td><%= qanda.getStudentId() %>
	<td><%= qanda.getQuestion() %>
	<td><%= qanda.getStatus() %>
	<td><%= qanda.getFacultyId()%>
	<td><%= qanda.getAnswer() %>
	</tr>
	<% }%>
	<% }%>
	</table>
	<div id="footer"
		style="background-color: Lemonchiffon; clear: both; text-align: center;">
		<p>VirtualClassRoomManagementSystem.com © All rights reserved.
			2014 TCS-ILP OMR,Chennai-524001,TAMILNADU,INDIA. Ph:(+91) 9003522350</p>
	</div>
</body>
</html>