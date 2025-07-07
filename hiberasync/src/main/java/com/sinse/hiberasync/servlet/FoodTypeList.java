package com.sinse.hiberasync.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.sinse.hiberasync.repository.FoodTypeDAO;

//음식 유형 목록 요청을 받는 서블릿
public class FoodTypeList extends HttpServlet{
	FoodTypeDAO foodTypeDAO;
	Logger logger=LoggerFactory.getLogger(getClass());
	
	public FoodTypeList() {
		foodTypeDAO = new FoodTypeDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DAO를 이용하여 목록 가져오기
		List list=foodTypeDAO.selectAll();
		
		
		//Tomcat이 개발자가 모아놓은 문자열을 이용하여, 응답 컨텐츠를 보내기 전에 , 
		//개발자는 원하는 문자열을 out.print() 로 넣어두어야 한다.. 
		//클라이언트가 원하는 컨텐츠가 html 문서가 아니라, html문서에 들어갈 일부 데이터인경우 
		//개발자는 순수 데이터를 구성해야 한다..
		PrintWriter out=response.getWriter();
		response.setContentType("application/json;charset=utf-8");
	
		//클라이언트에게 json 형식의 데이터를 전송할때, 문자열로 변환해야 하지만, 처리할 
		//문자열이 너무 복잡하여 효율성이 떨어짐... java객체와 json 문자열과의 변환을 자동으로 처리
		//해주는 구글이 제공하는 강력한 라이브러리가 있음 Gson
		Gson gson=new Gson();
		String result=gson.toJson(list);  // java.util.List를 json 문자열로 변환, 문자열이기 때문에 전송이 가능..
		
		logger.debug("문자열로 변환 후 데이터 "+result);
		out.print(result);//저장해 놓으면, Tomcat이 응답컨텐츠로 만들어서 보낸다..
		
		
	}
}














