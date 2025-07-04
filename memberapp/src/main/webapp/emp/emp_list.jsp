<%@page import="com.sinse.memberapp.model.Emp"%>
<%@page import="com.sinse.memberapp.model.Dept"%>
<%@page import="com.sinse.memberapp.repository.EmpDAO"%>
<%@page import="java.util.List"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	EmpDAO empDAO = new EmpDAO();	
	List<Emp> list=empDAO.selectAll();
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
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>mgr</th>
			<th>hiredate</th>
			<th>sal</th>
			<th>comm</th>
			<th>deptno</th>
			<th>dname</th>
			<th>loc</th>
		</tr>	
		
		<%for(Emp emp : list){%>
		<%
			Dept dept=emp.getDept();
		%>
		<tr>
			<td><%=emp.getEmpno() %></td>
			<td><%=emp.getEname() %></td>
			<td><%=emp.getJob()%></td>
			<td><%=emp.getMgr()%></td>
			<td><%=emp.getHiredate()%></td>
			<td><%=emp.getSal()%></td>
			<td><%=emp.getComm()%></td>
			<td><%=dept.getDeptno()%></td>
			<td><%=dept.getDname()%></td>
			<td><%=dept.getLoc()%></td>
		</tr>	
		<%} %>
	</table>
</body>
</html>






