<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="empCtlr" method="post">
<table>
	<tr>
		<td>Name</td>
		<td><input name="name" type="text"/></td>
	</tr>
	<tr>
		<td>Age</td>
		<td><input name="age" type="text"/></td>
	</tr>
	<tr>
		<td>Gender</td>
		<td><input name="gender" type="text"/></td>
	</tr>
	<tr>
		<td>Salary</td>
		<td><input name="salary" type="text"/></td>
	</tr>
	<tr>
		<td><input type="submit" name="submit" value="Save"/></td>
		<td><input type="submit" name="submit" value="Cancel"/></td>
	</tr>
</table>
</form>
</body>
</html>




