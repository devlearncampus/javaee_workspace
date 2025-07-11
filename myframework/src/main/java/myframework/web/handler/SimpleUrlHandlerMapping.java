package myframework.web.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import myframework.web.servlet.Controller;

public class SimpleUrlHandlerMapping implements HandlerMapping{
	Logger logger=LoggerFactory.getLogger(getClass());
	
	JsonObject root; //DispatcherServlet 이 생성한 json 매핑 파일을 해석(파싱)한 결과 객체 
	
	public void setRoot(JsonObject root) {
		this.root=root;
		logger.debug("DispatcherServlet으로부터 넘겨받은 root"+root);
	}

	@Override
	public void initialize() {
		
	}

	@Override
	public Controller getController(String uri) {
		return null;
	}
	
	
}
