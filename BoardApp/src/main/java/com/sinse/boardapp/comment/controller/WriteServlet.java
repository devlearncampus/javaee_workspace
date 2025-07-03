package com.sinse.boardapp.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터를 받자!!!
		request.setCharacterEncoding("utf-8");
		String msg=request.getParameter("msg");
		String user=request.getParameter("user");
		
		System.out.println(msg);
		System.out.println(user);
	}
}	









