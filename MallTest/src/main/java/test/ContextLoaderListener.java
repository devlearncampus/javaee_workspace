package test;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

//Tomcat이 가동될때, 감지 처리 
public class ContextLoaderListener implements ServletContextListener{

	//Tomcat과 같은 웹컨테이가 가동될때 동작하는 메서드
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("서버 가동 되었어요");
		//애플리케이션 수준의 객체의 ServletConext에 나의 이름을 저장
		ServletContext context=sce.getServletContext();
		context.setAttribute("tel", "010-8888-9999");

	}

	//Tomcat과 같은 웹컨테이가 중단될때 동작하는 메서드
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("서버 중단 되었어요");
		
	}

	
}
