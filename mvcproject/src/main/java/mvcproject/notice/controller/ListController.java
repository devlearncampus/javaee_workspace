package mvcproject.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcproject.notice.repository.NoticeDAO;
import mvcproject.web.servlet.Controller;

//ver 2.5 
public class ListController implements Controller{
	NoticeDAO noticeDAO=new NoticeDAO();
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3단계 : 일시키기
		List noticeList=noticeDAO.selectAll();
		
		//4단계 : 결과 저장
		request.setAttribute("noticeList", noticeList);
	}
	@Override
	public boolean isForward() {
		return true;
	}
	public String getViewName() {
		return "/notice/list/view";
	}

}
