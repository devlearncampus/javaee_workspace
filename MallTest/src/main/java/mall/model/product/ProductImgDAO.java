package mall.model.product;

import java.util.List;

import mall.domain.ProductImg;

public interface ProductImgDAO {
	public List<ProductImg> selectByProductId(int product_id);
	public void insert(ProductImg productImg);
	
}
