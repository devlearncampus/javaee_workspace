package com.sinse.hiberasync.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//맛집 정보 수정 요청을 처리하는 서블릿 
public class StoreEdit extends HttpServlet{
	
	Logger logger=LoggerFactory.getLogger(getClass());
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String store_id=request.getParameter("store_id");
		String store_name=request.getParameter("store_name");
		String tel=request.getParameter("tel");
		String food_type_id=request.getParameter("food_type_id");
		
		logger.debug("store_id"+store_id);
		logger.debug("store_name"+store_name);
		logger.debug("tel"+tel);
		logger.debug("food_type_id"+food_type_id);
	}
}








