<%@page import="com.valtech.dao.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% List<Employee> emps = (List<Employee>) request.getAttribute("emps"); %>
<table>
<thead>
	<tr>
		<td>Id</td>
		<td>Name</td>
		<td>Age</td>
		<td>Gender</td>
		<td>Salary</td>
		<td>Operations</td>
	</tr>
</thead>
<tbody>
	<%for(Employee e : emps)  {%>
	<tr>
		<td><%=e.getId() %></td>
		<td><%=e.getName() %></td>
		<td><%=e.getAge() %></td>
		<td><%= e.getGender() %></td>
		<td><%=e.getSalary() %></td>
		<td>
			<a href="empCtlr?empId=<%= e.getId()%>"><button>View Details</button></a>
			<a href="empCtlr?submit=delete&empId=<%= e.getId()%>"><button>Delete</button></a>
		</td>
	</tr>
	<%} %>
</tbody>
</table>
<form action="empCtlr" method="post">
<input type="submit" name="submit" value="New Employee"/>
</form>
</body>
</html>







