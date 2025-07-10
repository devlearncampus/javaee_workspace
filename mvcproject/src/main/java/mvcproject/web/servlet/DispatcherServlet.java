package mvcproject.web.servlet;

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

//아주 큰규모의 웹애플리케이션에서 모든 요청을 이 서블릿이 받는다.
public class DispatcherServlet extends HttpServlet{
	Logger logger=LoggerFactory.getLogger(getClass());
	
	FileInputStream fis;

	//요청이 들어오기 전에 처리할 준비를 해야하기 때문에
	public void init(ServletConfig config) throws ServletException {
		//ServletContext 란?Context라 문맥, 맥락,즉 이 서블릿이 실행되고 환경을 말하므로, 우리의 웹애플리케이션을 말함
		ServletContext context=config.getServletContext();
		String realPath=context.getRealPath(config.getInitParameter("contextConfigLocation"));
		
		logger.debug(realPath);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	//Get 이던 Post이던 모두 이 메서드에서 요청 처리 ( 메서드의 공통화 )
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("메서드 호출");
		
	}
	
}


