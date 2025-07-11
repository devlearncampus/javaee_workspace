package myframework.web.handler;

import com.google.gson.JsonObject;

import myframework.web.servlet.Controller;

//모든 핸들러 매핑 객체들의 최상위 객체를 정의하며, 구현을 강제하자 
public interface HandlerMapping {
	
	//DispatcherServlet이 보유한 Root JsonObject가 있어야 json 설정파일을 해석가능하므로. 넘겨받자
	//얘도, admin-serlvet.json 을 해석해야 하므로...
	public void setRoot(JsonObject root); 
	
	//각 핸들러 매핑하고 하고싶은 초기화 작업에 사용할 메서드 
	public void initialize();

	//DispatcherServlet에게 전달한 컨트롤러 반환 ..
	public Controller getController(String uri);
	
}






