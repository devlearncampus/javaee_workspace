package mall.domain;

import lombok.Data;

@Data
public class ProductImg {
	private int product_img_id;
	private String filename; //어떤 이미지명을..
	private Product product; //어떤 상품이..
}
