package mall.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import mall.domain.Color;
import mall.domain.Product;
import mall.domain.ProductColor;
import mall.domain.ProductSize;
import mall.domain.Size;
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
	public String regist(Product product, int[] color, int[] size,   HttpServletRequest request) {
		//MultipartFile 변수와 html 이름이 동일하면 매핑됨 
		MultipartFile[] photo=product.getPhoto();
		log.debug("업로드 한 파일의 수는 "+photo.length);
		
		try {
			for(int i=0;i<photo.length;i++) {
				//확장자 구하기 (원본 업로드 이미지 정보 추츨)
				log.debug("원본 파일명은 "+photo[i].getOriginalFilename());
				String  ori=photo[i].getOriginalFilename();
				
				String ext =ori.substring(ori.lastIndexOf(".")+1, ori.length());
				
				//개발자가 원하는 파일명 생성하기 
				try {
					Thread.sleep(10); //연산 속도가 너무 빠르면, 파일명이 중복될 수 있으므로..일부러 지연.. 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				long time=System.currentTimeMillis(); //23758297829
				String filename=time+"."+ext;
				
				//realPath를 사용하려면, 앱의 전반적인 전역적 정보를 가진 객체인 ServletContext가 필요함 
				ServletContext context=request.getServletContext();
				String savePath=context.getRealPath("/data");
				
				File file = new File(savePath+File.separator+filename);
				log.debug("업로드된 이미지가 생성된 경로는 "+savePath);
				
				photo[i].transferTo(file); //메모리상의 파일 정보가, 실제 디스크상으로 존재하게 되는 시점!!
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//Product 객체의 멤버변수로 직접 html 과 매핑이 될 수 없는 경우엔, 우회하면 된다.. 
		//우회란? 파라미터를 별도로 받아서,  다시 Product 에 넣어준다
		
		//사용자가 선택한 색상이 3개라면, ProductColor의 인스턴스도 3개를 생성!!
		//스프링의 자동 매핑이 불가하므로, 개발자가 직접 생성 
		List<ProductColor> colorList=new ArrayList();
		List<ProductSize> sizeList = new ArrayList();
		
		for(int c : color) {
			Color cc= new Color();
			cc.setColor_id(c);
			
			ProductColor productColor  =new ProductColor();
			//유저가 선택한 색상 대입 
			productColor.setColor(cc);
			colorList.add(productColor);
		}
		
		for(int s : size) {
			Size ss = new Size();
			ss.setSize_id(s);
			
			ProductSize productSize = new ProductSize();
			productSize.setSize(ss);	
			sizeList.add(productSize);
		}
		
		//매핑완료 후, Product 에 대입 
		product.setColorList(colorList);
		product.setSizeList(sizeList);
		
		
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















