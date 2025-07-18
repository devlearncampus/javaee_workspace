package mall.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mall.model.product.ColorService;

@Controller
public class ColorController {
	
	@Autowired
	private ColorService colorService;
	
	@GetMapping("/admin/color/list")
	@ResponseBody 	//response.setContentType("application/json")
	public List selectAll() {
		//3단계: 일 시키기 
		List colorList = colorService.selectAll();
		
		//4단계: jsp로 가져갈 것이 없으므로 저장하는 것이 아니라, 데이터 출력 
		return colorList;
	}
	
}






