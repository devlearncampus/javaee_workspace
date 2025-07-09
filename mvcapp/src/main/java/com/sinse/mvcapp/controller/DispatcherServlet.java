package com.sinse.mvcapp.controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//모든~~~종류의 요청을 다 받을수 있는 서블릿..get, post
public class DispatcherServlet extends HttpServlet{
	Logger logger=LoggerFactory.getLogger(getClass());
	
	
	//이 서블릿의 인스턴스가 생성될때, 초기화가 진행되고, 이 초기화 진행 시점에 
	//설정파일로 부터 , 해당 요청에 어떤 하위 컨트롤러가 작동해야 하는지 분석하여, 
	//요청을 전달하기 위해
	FileInputStream fis;
	
	public void init(ServletConfig config) throws ServletException {
		ServletContext context=config.getServletContext(); //현재 서블릿이 실행되고 문맥상의 애플리케이션..
		//WEB-INF:외부 웹브라우저에서의 접근이 불가능한 보안 디렉토리이지만, 자바코드내부에서는 얼마든지 접근가능
		String realPath=context.getRealPath(config.getInitParameter("contextConfigLocation"));
		
		logger.debug(realPath);
		
		//fis = new FileInputStream("C:\\lecture_workspace\\backend\\javaee_workspace\\mvcapp\\src\\main\\webapp\\WEB-INF\\servlet-mapping.data");
	}
	
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
		Controller controller=null;
		if(request.getRequestURI().equals("/blood.do")) {//클라이언트의 요청이 혈액형이면..
			//혈액형을 전문적으로 처리하는 컨트롤러에게 업무 분담!!!
			//요청에 대한 처리를 1:1 대응하는 객체로 처리하는 개발 패턴을 가리켜 Command Pattern 
			controller = new BloodController();			
		}else if(request.getRequestURI().equals("/color.do")) {
			controller = new ColorController();
		}
		controller.execute(request, response);
		
	}
	
	@Override
	public void destroy() {
		if(fis !=null) {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}











