package com.sinse.boardapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinse.boardapp.exception.NoticeException;
import com.sinse.boardapp.model.Notice;
import com.sinse.boardapp.repository.NoticeDAO;

//클라이언트가 전송한 글쓰기 폼의 파라미터들을 받아, db에 insert 시키는 서블릿
public class RegistServlet extends HttpServlet{
	//클라이언트인 브라우저가 전송한 변수=파라미티 값을 받아서, db에 넣기!!!
	// 이 요청은 유저게 보게될 디자인과 관련없으므로, 이 요청을 처리할 기술을 Servlet으로 선택함
	NoticeDAO noticeDAO;
	
	public RegistServlet() {
		noticeDAO = new NoticeDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//파라미터에 대한 인코딩 지정
		
		//jsp  <% @ page contentType="text/html;charset=utf-8"%>
		response.setContentType("text/html;charset=utf-8");
		//response.setCharacterEncoding("utf-8"); //응답시 컨텐츠에 문자 인코딩 지정 
		PrintWriter out=response.getWriter();
		
		//요청 객체에 들어있는 파라미터 꺼내기
		String title=request.getParameter("title"); // html에 지정한 name
		String writer=request.getParameter("writer"); 
		String content=request.getParameter("content");
		
		System.out.println(title);
		System.out.println(writer);
		System.out.println(content);	
		
		//파라미터들을 모델 객체에 넣자 
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		
		try {
			noticeDAO.insert(notice); //등록...
			out.print("<script>");
			out.print("alert('등록성공');");
			out.print("location.href='/notice/list.jsp';");//목록 페이지를 재요청
			out.print("</script>");
			
		} catch (NoticeException e) {
			//클라이언트가 받게될 응답 정보에 스크립트 문자열을채워넣기 
			//Tomcat과 같은 웹컨테이너가, 이 메서드의 닫는 괄호를 만나면, 그 시점부터 나선다..
			//응답 객체인 Response에 들어있는 출력스트림에 누적되어 잇는 문자열을 이용하여, HTML컨텐츠 생성
			//하기 때문에...
			out.print("<script>");
			out.print("alert('"+ e.getMessage() +"');");
			out.print("</script>");
			e.printStackTrace();
		}
	}
}
















