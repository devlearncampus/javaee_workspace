package com.sinse.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinse.mvcapp.color.model.BloodManager;

//혈액형에 대한 판단 요청을 처리하는 컨트롤러 정의 
public class BloodController{
	BloodManager bloodManager=new BloodManager();
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1) 요청을 받는다.		
		String blood=request.getParameter("blood");
		
		//2) 분석 (생략, 왜? 어차피 이 컨트롤러는 혈액형에 대한 처리이므로,,) 
		//3) 일 시킨다 
		String result=bloodManager.getAdvice(blood);
		//4) 뷰로 가져갈 것이 있다면 저장 
		HttpSession session = request.getSession();
		session.setAttribute("msg", result);
		//5) 알맞는 뷰 보여주기 
		response.sendRedirect("/blood/result.jsp");
		
	}
}





