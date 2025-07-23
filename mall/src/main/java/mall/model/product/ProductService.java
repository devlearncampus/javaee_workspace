package mall.model.product;

import mall.domain.Product;

public interface ProductService {
	public void regist(Product product, String savePath); //insert sql + 파일업로드 , 트랜잭션 까지 진행 
	
	//상품 등록과정에서 트랜잭션으로 처리할 수 없는 파일 삭제 처리
	public void remove(Product product, String savePath);
}
