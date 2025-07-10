package mvcproject.blood.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mvcproject.blood.model.BloodManager;
import mvcproject.web.servlet.Controller;

public class BloodController implements Controller{
	Logger logger=LoggerFactory.getLogger(getClass());
	BloodManager bloodManager=new BloodManager();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("하위 컨트롤러 호출 성공");
		
		String blood = request.getParameter("blood");
		String result = bloodManager.getAdvice(blood); //3단계) 일시키기
		
		//4단계: 결과 저장 ( 이 클래스에서 결과를 보여주는 것이 아니므로, 결과 저장)
		//session 에 담으면 데이터는 사용할 수 있지만, .do로 새롭게 들어오지 않을 경우 과거의 데이터를
		//즉 갱신되지 않은 데이터를 보게됨. 
		request.setAttribute("msg", result);
		
	}

	
	public String getViewName() {
		return "/blood/view";
	}
	
	
}
