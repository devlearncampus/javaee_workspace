<%@page import="com.sinse.boardapp.model.News"%>
<%@page import="com.sinse.boardapp.repository.NewsDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	NewsDAO newsDAO = new NewsDAO();
%>
<%
	//내장 객체 
	String news_id=request.getParameter("news_id");
	out.print("넘겨받은 파라미터는 "+news_id);
	News news=newsDAO.select(Integer.parseInt(news_id));
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
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
<%@ include file="/inc/head_link.jsp" %>
<script type="text/javascript">
	$(()=>{		
		$("#content").summernote({
			height:250
		});	//서머노트 연동 
		$("#content").summernote("code", "<%=news.getContent()%>");
		
		//버튼에 이벤트 연결 
		$("input[type='button']").click(()=>{
			$("form").attr({
				action:"/news/regist",
				
				//머리에 데이터를 실어 나르게 됨, 따라서 편지봉투에 나르는 겪, 문제1)노출 문제2)내용짤린다
				//body인 post로 보내자
				method:"POST",  
			});
			$("form").submit(); //전송
		});
		
	});
</script>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
  <form>
    <label for="fname">Title</label>
    <input type="text" id="fname" name="title" value="<%=news.getTitle()%>">

    <label for="lname">Writer</label>
    <input type="text" id="lname" name="writer" value="<%=news.getWriter() %>">

    <label for="subject">Content</label>
    <textarea id="content" name="content" placeholder="내용입력" style="height:200px"></textarea>

    <input type="button" value="Submit">
  </form>
  
  	<div id="comment_header">
  		<input type="text" style="width:73%">
  		<input type="text" style="width:20%">
  		<input type="button" value="등록">
  	</div>
  	
  	<div id="comment_content">
  		<table>
  			<tr>
  				<th>댓글 제목</th>
  				<th>작성자</th>
  				<th>등록일</th>
  			</tr>
  			
  			<tr>
  				<th>ddddddd</th>
  				<th>ddd</th>
  				<th>dddd</th>
  			</tr>
  			
  		</table>
  	</div>
</div>

</body>
</html>








