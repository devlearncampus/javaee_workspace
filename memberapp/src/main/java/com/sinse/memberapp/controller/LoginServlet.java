package com.sinse.memberapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//post로 전송되어 오는 로그인 정보를 받아, 회원테이블과 일치여부에 따라
//로그인 성공 및 실패..
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 
		String id=request.getParameter("");
		String pwd=request.getParameter("");
	}
}










