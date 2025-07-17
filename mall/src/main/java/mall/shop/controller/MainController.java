package mall.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mall.model.category.TopCategoryService;

@Controller
public class MainController {
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public ModelAndView getMain() {
		//3단계: 일시키기 
		List topList=topCategoryService.selectAll();
		
		ModelAndView mav = new ModelAndView("shop/index");
		
		//4단계: 결과 저장  
		mav.addObject("topList", topList);
		
		return mav;
	}
}








