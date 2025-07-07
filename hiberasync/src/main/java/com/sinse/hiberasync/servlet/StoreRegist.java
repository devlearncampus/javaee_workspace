package com.sinse.hiberasync.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinse.hiberasync.exception.StoreException;
import com.sinse.hiberasync.model.FoodType;
import com.sinse.hiberasync.model.Store;
import com.sinse.hiberasync.repository.StoreDAO;

//맛집 등록 요청을 처리하는 서블릿 
public class StoreRegist extends HttpServlet{
	Logger logger=LoggerFactory.getLogger(getClass());
	StoreDAO storeDAO=new StoreDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//필터가 제대로 동작했다면, 한글처리를 따로 하지 않아도 인코딩 처리가 되어 있어야 함 
		String food_type_id=request.getParameter("food_type_id");
		String store_name=request.getParameter("store_name");
		String tel=request.getParameter("tel");
		
		logger.debug("food_type_id="+food_type_id);
		logger.debug("store="+store_name);
		logger.debug("tel="+tel);
		
		FoodType foodType = new FoodType();
		foodType.setFood_type_id(Integer.parseInt(food_type_id));
		
		Store store = new Store();
		store.setStore_name(store_name);
		store.setTel(tel);
		store.setFoodType(foodType); //부모 객체 주입!!!
		
		
		//응답 정보를 html 이 아닌 json으로 생성하여 보내자!
		
		 
		try {
			storeDAO.insert(store);//등록
		} catch (StoreException e) {
			e.printStackTrace();
			
		}
	}
}





