<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="facultyanswer" action="../Controller" method="post">
<label><h3>Enter Question Id to enter Answer The Question</h3></label>
<label>Question Id:</label><input type="text" name="questionid">
<textarea name="answer" rows="5" cols="100"></textarea>
<input type="hidden" name="action" value="FacultyAnswer">
<input type="submit" name="submit" value="submit">
</form>
</body>
</html>