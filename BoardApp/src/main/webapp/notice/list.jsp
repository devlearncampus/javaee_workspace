<%@page import="com.sinse.boardapp.model.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.sinse.boardapp.repository.NoticeDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	//list.jsp가 톰켓에 의해, 서블릿으로 작성될때 멤버 영역 (선언부)
	NoticeDAO noticeDAO;
	int id =;
%>
<%
	//요청을 받는 service() 메서드 영역
	noticeDAO=new NoticeDAO();
	List<Notice> list=noticeDAO.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(()=>{
		$("button").click(()=>{
			location.href="/notice/write.jsp";
		});
	});
</script>
</head>
<body>

<h2>Zebra Striped Table</h2>
<p>For zebra-striped tables, use the nth-child() selector and add a background-color to all even (or odd) table rows:</p>

<table>
  <tr>
    <th>No</th>
    <th>제목</th>
    <th>작성자</th>
    <th>등록일</th>
    <th>조회</th>
  </tr>
  
  <%for(int i=0;i<list.size();i++){ %>
  <% Notice notice=list.get(i);%>
  <tr>
    <td>Jill</td>
    <td><a href="/notice/content.jsp?notice_id=<%=id = notice.getNotice_id()%>"><%=notice.getTitle() %></a></td>
    <td><%=notice.getWriter() %></td>
    <td><%=notice.getRegdate() %></td>
    <td><%=notice.getHit() %></td>
  </tr>
	<%} %>
	<tr>
		<td colspan="5"><button>글등록</button></td>		
	</tr>
</table>

</body>
</html>
