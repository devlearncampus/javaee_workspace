package myframework.shop.staff.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import myframework.staff.model.domain.Bio;
import myframework.staff.model.domain.Staff;
import myframework.staff.model.service.StaffService;
import myframework.web.servlet.Controller;

//사원 등록 요청을 처리하는 하위 컨트롤러 (3, 4단계)
public class RegistController implements Controller{
	Logger logger=LoggerFactory.getLogger(getClass());
		
	StaffService staffService=new StaffService();
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 
		String name=request.getParameter("name");
		String sal=request.getParameter("sal");
		String email=request.getParameter("email");
		String blood=request.getParameter("blood");
		String height=request.getParameter("height");
		String weight=request.getParameter("weight");
		
		Staff staff = new Staff();
		staff.setName(name);
		staff.setSal(Integer.parseInt(sal));
		staff.setEmail(email);
		
		Bio bio = new Bio();
		bio.setBlood(blood);
		bio.setHeight(Integer.parseInt(height));
		bio.setWeight(Integer.parseInt(weight));
		bio.setStaff(staff);
		
		// 서비스에게 부탁하기 
		staffService.regist(bio);		
	}

	public String getViewName() {
		return "/shop/staff/regist/view";
	}
	public boolean isForward() {
		return false;
	}
	
	
}
