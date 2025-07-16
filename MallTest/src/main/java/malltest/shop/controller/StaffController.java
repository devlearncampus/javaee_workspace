package malltest.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import malltest.shop.domain.Bio;
import malltest.shop.domain.Staff;
import malltest.shop.model.staff.StaffService;

@Controller
public class StaffController {
	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	private StaffService staffService;
	
	@RequestMapping("/staff/registform")
	public String registForm() {		
		logger.debug("등록폼 실행");
		return "staff/regist";
	}

	@RequestMapping("/staff/regist")
	public String regist(Bio bio) {
		Staff staff=bio.getStaff();
		
		logger.debug("name"+staff.getName());
		logger.debug("sal"+staff.getSal());
		logger.debug("email"+staff.getEmail());
		logger.debug("blood"+bio.getBlood());
		logger.debug("height"+bio.getHeight());
		logger.debug("weight"+bio.getWeight());
		
		try {
			staffService.regist(bio);
			logger.debug("등록성공");
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("등록실패");
		}		
		return "";
	}
}
