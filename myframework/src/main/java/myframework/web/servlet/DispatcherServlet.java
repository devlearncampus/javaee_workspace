package myframework.web.servlet;

import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

//웹애플리케이션의 모든 요청을 1차적으로 처리하는 전면 컨트롤러 
public class DispatcherServlet extends HttpServlet{
	Logger logger=LoggerFactory.getLogger(getClass());
	
	/*
	 * 이 서블릿이 초기화될때, 매핑 파일에 등록된 컨트롤러들만 인스턴스를 생성하여 모아야 하는데, 
	 * 이 서블릿이 직접 하지 않고, 개발자가 등록한 핸들러 매핑에게 맡김 
	 * 또한 추후 요청을 처리할때도, 어떤 하위 컨트롤러가 동작해야 하는지도 , 핸들어 매핑이 알아서 분석하여 
	 * 이 서블릿에게 반환한다..왜?? 어제까지는 요청이 들어올때마다 하위 컨트롤러의 인스턴스를 생성하는 방식이기
	 * 메모리 낭비.. 
	 * */
	public void init(ServletConfig config) throws ServletException {
		//초기화 파라미터 읽기 ( 설정파일의 위치 얻기)  
		String contextConfigLocation=config.getInitParameter("contextConfigLocation");
		
		//현재 애플리케이션의 정보 얻기 
		ServletContext context=config.getServletContext();
		String realPath = context.getRealPath(contextConfigLocation);
		
		try(FileReader reader=new FileReader(realPath)){
			JsonObject root=JsonParser.parseReader(reader).getAsJsonObject();
			logger.debug("root ="+root);
			
		}catch(Exception e) {
			
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
}












