<%@ page contentType="text/html; charset=UTF-8"%>
<%
	int totalRecord=26;	
	int pageSize=10; //페이지당 보여질 레코드 수
	int totalPage=(int)Math.ceil((float)totalRecord/pageSize) ; //총 페이지 수 
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
}

th, td {
	text-align: left;
	padding: 16px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
</head>
<body>

	<h2>Zebra Striped Table</h2>
	<p>For zebra-striped tables, use the nth-child() selector and add a
		background-color to all even (or odd) table rows:</p>

	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Points</th>
		</tr>
		<%for(int i=1;i<=pageSize;i++){ %>
		<tr>
			<td>Jill</td>
			<td>Smith</td>
			<td>50</td>
		</tr>
		<%}%>
		<tr>
			<td colspan="3">
				<%for(int i=1;i<=totalPage;i++){%>
				[ <%=i%> ]
				<%} %>
			</td>
		</tr>
	</table>

</body>
</html>





