package myframework.web.handler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import myframework.web.servlet.Controller;

public class SimpleUrlHandlerMapping implements HandlerMapping{
	Logger logger=LoggerFactory.getLogger(getClass());
	
	JsonObject root; //DispatcherServlet 이 생성한 json 매핑 파일을 해석(파싱)한 결과 객체 
	
	//하위 컨트롤러 들을 key-value의 쌍으로 보관해놓자 
	//그래야 요청이 들어올때, 해당 요청에 동작할 하위 컨트롤러를 DispatcherServlet에게 반환할 것이기 때문
	//Map<url,하위컨트롤러>
	Map<String, Controller> controllerMap=new HashMap<>();
	
	public void setRoot(JsonObject root) {
		this.root=root;
		logger.debug("DispatcherServlet으로부터 넘겨받은 root"+root);
	}

	@Override
	public void initialize() {
		//root를 이용하여, json 의 controllerMappings 검색
		JsonObject controllerMappings =root.getAsJsonObject("controllerMappings");
		logger.debug("controllerMappings 의 결과 "+controllerMappings);
		
		//반복문으로 객체의 모든 키값에 매핑된 클래스명을 대상으로 인스턴스화 작업을 시도하고, 
		//controllerMap 에 수집해 놓기
		Set set=controllerMappings.keySet();
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()) { //요소가 존재하는 동안...
			String uri=it.next();
			logger.debug("요소는 "+uri);
			String controllerName=controllerMappings.get(uri).getAsString();
			logger.debug("컨트롤러명은 "+controllerName);
			
			try {
				Controller controller=(Controller)Class.forName(controllerName).newInstance();
				controllerMap.put(uri, controller);
				
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		logger.debug("갯수는 "+controllerMap.size());
	}

	@Override
	public Controller getController(String uri) {
		return controllerMap.get(uri);
	}
	
	
}





