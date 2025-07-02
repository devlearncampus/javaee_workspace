<%@page import="com.sinse.boardapp.model.Notice"%>
<%@page import="com.sinse.boardapp.repository.NoticeDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%! NoticeDAO noticeDAO=new NoticeDAO(); %>
<%
	//요청 객체로부터 파라미터 뽑아내기
	//이 스크립틀릿 영역은 이 jsp가 서블릿으로 변경되어질때, service() 메서드 영역이므로, 이미 service()메서드
	//의 매개변수 요청 객체와 응답객체를 넘겨받은 상태..
	//service(HttpServletRequest request, HttpServletResponse response)
	String notice_id=request.getParameter("notice_id");
	
	//String sql="select * from notice where notice_id="+notice_id;
	//out.print(sql);	
	Notice notice=noticeDAO.select(Integer.parseInt(notice_id));
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
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.js"></script>
<script type="text/javascript">
	$(()=>{		
		$("#content").summernote({
			height:250,
		});	//서머노트 연동 
		$("#content").summernote('code', "<%=notice.getContent()%>");
		
		//버튼에 이벤트 연결 
		//0번째-수정
		$("#bt_edit").click(()=>{
			
		});
		
		//1번째-삭제
		$("#bt_del").click(()=>{
			if(confirm("삭제하시겠어요?")){
				//Get방식 요청(링크)
				location.href="/notice/del?notice_id=<%=notice_id%>";
			}
		});
		
		//2번째-목록
		$("#bt_list").click(()=>{
			
		});
		
	});
</script>
</head>
<body>
<h3>Contact Form</h3>

<div class="container">
  <form>
    <label for="fname">Title</label>
    <input type="text" id="fname" name="title" value="<%=notice.getTitle()%>">

    <label for="lname">Writer</label>
    <input type="text" id="lname" name="writer" value="<%=notice.getWriter()%>">

    <label for="subject">Content</label>
    <textarea id="content" name="content" placeholder="내용입력" style="height:200px"></textarea>

    <input type="button" value="수정" id="bt_edit">
    <input type="button" value="삭제" id="bt_del">
    <input type="button" value="목록" id="bt_list">
    
  </form>
</div>

</body>
</html>
