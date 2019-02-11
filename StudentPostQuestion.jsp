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
<form name="Compose" action="../Controller" method="post">
<textarea name="post" rows="5" cols="100"></textarea>
<input type="hidden" name="action" value="StudentPostQuestion">
<input type="submit" name="submit" value="Submit" onClick=return validatePostQuestion('Compose'); return false;>

</form>
</center>
</body>
</html>