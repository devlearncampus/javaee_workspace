package mall.model.product;

import mall.domain.Product;

public interface ProductService {
	public void regist(Product product, String savePath); //insert sql + 파일업로드 , 트랜잭션 까지 진행 
}
