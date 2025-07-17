package mall.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public ModelAndView getMain() {
		ModelAndView mav = new ModelAndView("shop/index");
		//mav.setViewName("");
		return mav;
	}
}








