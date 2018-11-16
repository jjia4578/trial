<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyLogin</title>
</head>
<body>
	<sf:form action = "mylogin" method = "Post" modelAttribute = "blank_user_login">
		Username: <sf:input path = "username" type = "text" />
		Password: <sf:input path = "password" type = "text" />
		<input type = "submit" value = "login"/>
	</sf:form>
	
</body>
</html>