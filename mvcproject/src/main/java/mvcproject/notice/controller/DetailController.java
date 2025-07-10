package mvcproject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcproject.notice.domain.Notice;
import mvcproject.notice.repository.NoticeDAO;
import mvcproject.web.servlet.Controller;

//상세보기 요청을 처리하는 컨트롤러...
public class DetailController implements Controller{

	NoticeDAO noticeDAO=new NoticeDAO();
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3단계: 일 시키기 
		Notice notice=noticeDAO.select(Integer.parseInt(request.getParameter("notice_id")));
		
		//4단계: 결과 저장 
		request.setAttribute("notice", notice);
	}

	@Override
	public String getViewName() {
		return "/notice/detail/view";
	}
	
}
