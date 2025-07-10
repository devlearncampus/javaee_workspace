package mvcproject.web.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
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
	
	Properties props; //key-value 쌍으로 이루어진 데이터를 이해할 수 있는 객체
	
	//요청이 들어오기 전에 처리할 준비를 해야하기 때문에
	public void init(ServletConfig config) throws ServletException {
		//ServletContext 란?Context라 문맥, 맥락,즉 이 서블릿이 실행되고 환경을 말하므로, 우리의 웹애플리케이션을 말함
		ServletContext context=config.getServletContext();
		String realPath=context.getRealPath(config.getInitParameter("contextConfigLocation"));
		
		logger.debug(realPath);
		
		try(FileInputStream fis = new FileInputStream(realPath)){
			props = new Properties();
			props.load(fis);//스트림 대입 
		}catch(Exception e) {
			e.printStackTrace();	
		}
		
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
		
		//클라이언트의 요청 URI 를 이용하여 , 매핑파일을 검색하고 value 를 반환
		String uri=request.getRequestURI();
		String className=props.getProperty(uri);
		logger.debug("요청 uri 는 "+uri);
		logger.debug("동작할 클래스는 "+className);
	
		//텍스트에 불과한 className 을 실제 클래스로 로드 
		try {
			Class clazz=Class.forName(className); //static 영역 해당 클래스 Load
			Controller controller=(Controller)clazz.newInstance(); //new 연산말고도 , 메서드로도 인스턴스를 생성할 수 있다.
			
			controller.execute(request, response); //하위 컨트롤러 동작!!!
			//하위 컨트롤러가 3,4단계를 완료한 시점이므로, 하위 컨틀로러가 반환한 키워드로 다시 매핑
			//파일을 검색하자!!!
			String viewName=controller.getViewName();
			
			//검색한 결과 실제 보여질 페이지를 반환
			String viewPage=props.getProperty(viewName);
			
			//포워딩은? 클라이언트에게 응답 정보로 재접속을 강요하는 것이 아니라, 즉 응답을 보류한상태로 
			//현재의 요청의 흐름을 서버의 또 다른 서블릿 or jsp에게 전달하는 방법 
			RequestDispatcher dis=request.getRequestDispatcher(viewPage);
			dis.forward(request, response);//이 시점에 포워딩이 발생!!!
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
}












