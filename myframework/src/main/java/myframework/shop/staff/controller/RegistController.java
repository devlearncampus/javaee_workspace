package myframework.shop.staff.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import myframework.staff.model.domain.Bio;
import myframework.staff.model.domain.Staff;
import myframework.web.servlet.Controller;
import myframwork.staff.model.repository.BioDAO;
import myframwork.staff.model.repository.StaffDAO;

//사원 등록 요청을 처리하는 하위 컨트롤러 (3, 4단계)
public class RegistController implements Controller{
	Logger logger=LoggerFactory.getLogger(getClass());
	
	StaffDAO staffDAO=new StaffDAO();
	BioDAO bioDAO=new BioDAO();
	
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

		
		logger.debug("사원 등록 전의 staff"+staff.getStaff_id());
		 
		staffDAO.insert(staff);//일 시키기
		
		logger.debug("사원 등록 후의 staff는 "+staff.getStaff_id());
	}

	public String getViewName() {
		return null;
	}
	public boolean isForward() {
		return false;
	}
	
	
}
