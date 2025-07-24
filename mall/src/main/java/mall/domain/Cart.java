package mall.domain;

import lombok.Data;

@Data
public class Cart {
	private int cart_id;
	private Product product;
	private int ea; 
	private int member_id; //내일 할 예정 
	private String selectedColor; //선택한 색상 
	private String selectedSize; //선택한 사이즈 
	
}







