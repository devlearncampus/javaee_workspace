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
import com.sinse.hiberasync.model.Store;
import com.sinse.hiberasync.repository.StoreDAO;
import com.sinse.hiberasync.util.Message;

//상점의 상세보기 요청을 처리하는 서블릿 
public class StoreDetail extends HttpServlet{
	
	Logger logger=LoggerFactory.getLogger(getClass());
	StoreDAO storeDAO = new StoreDAO();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String store_id=request.getParameter("store_id");
		
		response.setContentType("application/json");
		
		logger.debug("store_id"+store_id);
		Gson gson=new Gson();
		PrintWriter out = response.getWriter();
		Message message = new Message();
		
		try {
			Store store = storeDAO.select(Integer.parseInt(store_id));
			out.print(gson.toJson(store));//문자열 로 변환하여 전송하기 위함
		} catch (StoreException e) {
			e.printStackTrace();
			message.setResult("fail");
			message.setMsg(e.getMessage());
			out.print( gson.toJson(message));
		}
		
	}
}










