package mall.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
	private int product_id;
	private String product_name;
	private String brand;
	private int price;
	private int discount;
	private String introduce;
	private String detail;
	
	//하나의 상품은 여러 색상을 보유할 수 있다  1:多 관계 (mybatis 에서 collection 수집)
	private List<ProductColor> colorList;
	
	//하나의 상품은 여러 사이즈를 보유할 수 있다. 1:多 관계 (mybatis 에서 collection 수집)
	private List<ProductSize> sizeList;
	
	//하나의 상품은 여러 이미지를 보유할 수 있다 1:多 관계 (mybatis 에서 collection 수집)
	private List<ProductImg> imgList;
	
	private MultipartFile[] photo;
	
	private SubCategory subcategory; //1:1 관계 (myatis 에서 association 으로 매핑)
}





