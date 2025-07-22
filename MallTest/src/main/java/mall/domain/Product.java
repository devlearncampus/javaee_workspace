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
	private MultipartFile[] photo;	
	private List<ProductColor> colorList;
	private List<ProductSize> sizeList;
	private List<ProductImg> imgList;
	private SubCategory subcategory;
}