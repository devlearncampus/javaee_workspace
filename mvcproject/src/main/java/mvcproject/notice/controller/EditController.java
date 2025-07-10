package mvcproject.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcproject.notice.domain.Notice;
import mvcproject.notice.repository.NoticeDAO;
import mvcproject.web.servlet.Controller;

public class EditController implements Controller{
	NoticeDAO noticeDAO=new NoticeDAO();
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String notice_id=request.getParameter("notice_id");
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		
		Notice notice = new Notice();
		notice.setNotice_id(Integer.parseInt(notice_id));		
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);		
		
		//3단계: 일 시키기 
		noticeDAO.update(notice);
		PrintWriter out = response.getWriter();
		out.print("EditController에서 심은 id "+notice_id);
		
		//4단계: content.jsp 가 기다리고 잇는 형태인 notice
		request.setAttribute("notice", notice);
		
		//detail.do?notice_id=6;
	}

	public boolean isForward() {
		return true;
		//return false;  //redirect가 맞지만, 매핑 파일 자체가 변수가 올수 없으므로, 포워딩으로 처리함 
	}

	public String getViewName() {
		return "/notice/edit/view";
	}
	
	
}
