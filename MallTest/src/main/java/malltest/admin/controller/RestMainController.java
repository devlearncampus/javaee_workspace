package malltest.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import malltest.admin.util.Message;

@Slf4j
@RestController
public class RestMainController {
	
	@RequestMapping(value="/admin/login", method=RequestMethod.POST)
	public Message login() {
		
		log.debug("login controller 동작함 ");
		
		Message message = new Message();
		message.setStatus("success");
		message.setMessage("로그인 성공");
		return message;
	}
}
