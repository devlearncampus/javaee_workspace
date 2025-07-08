package com.sinse.hiberasync.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.sinse.hiberasync.exception.StoreException;
import com.sinse.hiberasync.repository.StoreDAO;
import com.sinse.hiberasync.util.Message;

public class StoreDelete extends HttpServlet{
	Logger logger=LoggerFactory.getLogger(getClass());
	StoreDAO storeDAO = new StoreDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String store_id=request.getParameter("store_id");
		
		logger.debug("store_id="+store_id);
		
		Message message = new Message();
		Gson gson = new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		
		try {
			storeDAO.delete(Integer.parseInt(store_id));
			response.setStatus(HttpServletResponse.SC_NO_CONTENT); //204 
		}catch (StoreException e) {
			e.printStackTrace();
			message.setResult("fail");
			message.setMsg(e.getMessage());
			String jsonResult=gson.toJson(message)	; //객체를 json문자열로 변환
			out.print(jsonResult);//전송 발생?
		}
		
	}
}











