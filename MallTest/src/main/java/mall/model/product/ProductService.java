package mall.model.product;

import java.util.List;

import mall.domain.Product;

public interface ProductService {
	public void regist(Product product, String path);
	public List selectAll();
	public Product select(int product_id);
	public void edit(Product product);
	public void remove(Product product, String path);
}
