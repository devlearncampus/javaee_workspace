package mall.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class NoticeController {
	
	//목록요청 처리  , 특정 uri 에 매핑되는 대상을 컨트롤러 클래스로 처리하는 것이 아니라 
	//메서드로 처리하기 위함...
	@RequestMapping("/notice/list")
	public ModelAndView selectAll() {
		//3단계: db에서 가져오기 
		//4단계: 결과 저장 
		//request.setAttribute("list", "목록list");
		//ModelAndView 객체는 Model과 View를 합쳐놓은 객체임 
		//Model 객체에 정보를 담으면 request.setAttribute() 와 동일한 효과 
		//View 에는 DispatcherServlet에게 전달할 페이지파일명이 아닌 이름을 전달하는 용도 
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("notice/list");
		
		log.debug("목록 요청 받음");
		return mav;
	}
	
	//상세보기 요청 처리 
	//글 등록 요청 처리 
	//글 수정 요청 처리 
	//글 삭제 요청 처리 
}






