package com.sinse.boardapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트가 전송한 글쓰기 폼의 파라미터들을 받아, db에 insert 시키는 서블릿
public class RegistServlet extends HttpServlet{
	//클라이언트인 브라우저가 전송한 변수=파라미티 값을 받아서, db에 넣기!!!
	// 이 요청은 유저게 보게될 디자인과 관련없으므로, 이 요청을 처리할 기술을 Servlet으로 선택함

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//파라미터에 대한 인코딩 지정
		
		
		//요청 객체에 들어있는 파라미터 꺼내기
		String title=request.getParameter("title"); // html에 지정한 name
		String writer=request.getParameter("writer"); 
		String content=request.getParameter("content");
		
		System.out.println(title);
		System.out.println(writer);
		System.out.println(content);		
	}
}






