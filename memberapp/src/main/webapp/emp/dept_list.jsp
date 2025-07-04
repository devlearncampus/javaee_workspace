<%@page import="com.sinse.memberapp.model.Dept"%>
<%@page import="java.util.List"%>
<%@page import="com.sinse.memberapp.repository.DeptDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	DeptDAO deptDAO = new DeptDAO();	
	List<Dept> list=deptDAO.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%">
		<tr>
			<th>deptno</th>
			<th>dname</th>
			<th>loc</th>
			<th>근무자수</th>
		</tr>	
		
		<%for(Dept dept : list){%>
		<tr>
			<td>deptno</td>
			<td>dname</td>
			<td>loc</td>
			<td>근무자수</td>
		</tr>	
		<%} %>
	</table>
</body>
</html>






