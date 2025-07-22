package mall.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import mall.domain.Product;
import mall.model.category.TopCategoryService;
import mall.model.product.ProductService;

@Slf4j
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//서비스 에게 일시킴 (느슨하게 보유, 즉 결합도를 낮추어서 보유,따라서 인터페이스로 보유)
	@Autowired
	private TopCategoryService topCategoryService;
	
	// localhost:8888/admin/admin/product/registform
	@RequestMapping(value="/admin/product/registform")
	public String registform() {
		//상품 등록페이지를 보게되는 초기에, 상위 카테고리가채워져 있어야 함
		return "secure/product/regist";
	}
	
	//상품 등록 요청을 처리 
	@PostMapping("/admin/product/regist")
	@ResponseBody
	public String regist(Product product, MultipartFile[] photo, HttpServletRequest request) {
		//MultipartFile 변수와 html 이름이 동일하면 매핑됨 
		log.debug("업로드 한 파일의 수는 "+photo.length);
		
		//모델 객체는 table을 반영한 객체이므로, 컨트롤러 영역에서 바로 파라미터를 받는 용도도 사용해서는 안됨
		//왜? 데이터베이스 컬럼명이 노출되기 때문에, 
		//해결책은? 클라이언트의 파라미터를 받는 용도의 객체를 별도로 둔다(DTO=Data Transfer Object)
		//DTO에서 Model 객체로 옮겨야 함..
		
		productService.regist(product);
		
		//log.debug("product = "+product);
		//log.debug("photo = "+photo);
		//ServletContext context=request.getServletContext(); //jsp applicatio 내장 객체 
		//String realPath = context.getRealPath("/data");
		//log.debug("realPath is "+realPath);
		
		//4단계: DML은 저장할게 없다
		return "ok";
	}
}















