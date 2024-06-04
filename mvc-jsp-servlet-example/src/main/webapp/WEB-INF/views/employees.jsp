<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="net.javaguides.mvc.model.Employee" %>
<%@ page import ="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% List<Employee> employees = (List<Employee>)request.getAttribute("employees"); %>
</body>

<table border="1" style="width: 50%" height="50%">
	<thead>
	 <tr>
	 	<th>ID</th>
	 	<th>First Name</th>
	 	<th>Last Name</th>
	 </tr>
	</thead>
	<tbody>
	<!--  for (Todo todo: todos) { -->
	<% for (Employee employee: employees) { %>
	<tr>
		<td><%=employee.getId() %></td>
		<td><%=employee.getFirstName() %></td>
		<td><%=employee.getLastName() %></td>
	</tr>
	<%} %>
	</tbody> 	
</table>
</html>