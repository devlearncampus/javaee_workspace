package mall.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	//서비스 에게 일시킴 (느슨하게 보유, 즉 결합도를 낮추어서 보유,따라서 인터페이스로 보유)
	@Autowired
	private TopCategoryService topCategoryService;
	
	@Autowired
	private ProductService productService;
	
	// localhost:8888/admin/admin/product/registform
	@RequestMapping(value="/admin/product/registform")
	public String registform() {
		//상품 등록페이지를 보게되는 초기에, 상위 카테고리가채워져 있어야 함
		return "secure/product/regist";
	}
	
	//상품 등록 요청을 처리 
	@PostMapping("/admin/product/regist")
	public String regist(@ModelAttribute Product product, int[] color,  int[] size, HttpServletRequest request) {
		log.debug("product = "+product);
		log.debug("color = "+color);
		log.debug("size = "+size);
		
		List<ProductColor> colorList = new ArrayList();
		List<ProductSize> sizeList = new ArrayList();
		
		for(int c : color) {
			Color cc = new Color();
			cc.setColor_id(c);
			
			ProductColor productColor = new ProductColor();
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
		
		product.setColorList(colorList);
		product.setSizeList(sizeList);
				
		ServletContext context=request.getServletContext(); //jsp applicatio 내장 객체 
		String realPath = context.getRealPath("/data");
		//log.debug("realPath is "+realPath);
		
		try {
			productService.regist(product, realPath);
		} catch (Exception e) {
			productService.remove(product, realPath);
			e.printStackTrace();
		}
		
		//4단계: DML은 저장할게 없다
		return "redirect:/admin/admin/product/list";
	}
	
	@GetMapping("/admin/product/list")
	public String getList(Model model) {
		List productList = productService.selectAll();
		model.addAttribute("productList", productList);
		return "secure/product/list";
	}
	
	@GetMapping("/admin/product/detail")
	public String getDetail(Model model , int product_id) {
		
		Product product = productService.select(product_id);
		
		log.debug("상세보기에서 product is "+product);
		model.addAttribute("product", product);
		
		return "secure/product/detail";
	}
	
}















