package com.sinse.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinse.mvcapp.color.model.BloodManager;
import com.sinse.mvcapp.color.model.ColorManager;

//모든~~~종류의 요청을 다 받을수 있는 서블릿..get, post
public class DispatcherServlet extends HttpServlet{
	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 매 요청마다 1:1 대응되는 매핑을 피하기 위해 하나의 진입점으로 몰았으나, 
		 * 진입점이 되는 클래스가 매 요청마다 1:1 대응되는 if조건문이 작성되고 있음
		 * */
		if(request.getRequestURI().equals("/blood.do")) {//클라이언트의 요청이 혈액형이면..
			//혈액형을 전문적으로 처리하는 컨트롤러에게 업무 분담!!!
			//요청에 대한 처리를 1:1 대응하는 객체로 처리하는 개발 패턴을 가리켜 Command Pattern 
			BloodController controller = new BloodController();
			controller.execute(request, response);
		}else if(request.getRequestURI().equals("/color.do")) {
			ColorController controller = new ColorController();
			controller.execute(request, response);
		}
		
	}
}





