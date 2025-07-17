<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
	에러 발생 
	<%
	Exception e=(Exception)request.getAttribute("e"); 
	out.print(e.getMessage());
	%>
	
</body>
</html>