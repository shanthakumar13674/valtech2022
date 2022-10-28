<%@page import="com.valtech.dao.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>http://localhost:8080/valtechWeb/empCtlr?empId=3</h2>
<% Employee e = (Employee)request.getAttribute("e"); %>
<table>
<tr>
 	<td>Id</td><td><%= e.getId() %></td>
 </tr>
 <tr>
	<td>Name</td><td><%= e.getName() %></td>
	</tr>
 <tr>
	<td>Age</td><td><%= e.getAge() %></td>
</tr>
 <tr>
	<td>Gender</td><td><%= e.getGender() %></td>
</tr>
 <tr>
	<td>Salary</td><td><%= e.getSalary() %></td>
</tr>
<%-- <tr>
	<td><a href=<%=prev%>>Previous</a></td>
	<td><a href=<%=next%>>Next</a></td>
</tr> --%>
</table>
</body>
</html>

