package malltest.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	Logger logger=LoggerFactory.getLogger(getClass());

	@RequestMapping("/loginform")
	public String loginForm() {
		
		return "admin/login";
	}
	
	@RequestMapping("/admin/main")
	public String getMain() {
		
		logger.debug("메인 요청 받음 ");
		
		return "admin/index";
	}
	
}


