<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//서블릿과는 달리 jsp 이므로, session을 얻어올때 내장객체로 접근
		//session은 java.util.Map을 계승하였으므로, key-value 쌍으로 데이터를 관리.. 
		//따라서 session넣을수잇는 데이터의 종류 한계가 없는 객체이다
		String img=(String)session.getAttribute("img");
		out.print(img);
	%>
	<img style="width:300px;height:300px" src="/data/<%=img%>">
</body>
</html>





