package com.sinse.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 컨트롤러들의 최상위 객체 정의, 
public interface Controller {
	
	//모든 하위 컨트롤러들이 업무수행할때 호출메서드 정의
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	//모든 하위 컨트롤러들이, 어떤 페이지를 검색해야 할지를 DispatcherServlet에게 알려주기 위한 메서드 정의 
	public String getViewPage();
}









