<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<form:form action="login" modelAttribute="signInDTO" acceptCharset="UTF-8">
		<label path="userName">User Name</label>
		<form:input path="userName" />
		<form:errors path="userName" cssClass="error"></form:errors>
		<label path="password">Password</label>
		<form:input path="password" />
		<form:errors path="password" cssClass="error"></form:errors>
		<input type="submit" value="Sign In">
	</form:form>
</body>
</html>