package mall.model.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mall.domain.Product;
import mall.exception.ProductException;

@Service  //서비스는 모델 영역의 객체이기는 하나, 직접 일하지 않고 주로 전담 객체들에게 일을 할당
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;
	
	//@Transactional
	public void regist(Product product) throws ProductException{
		productDAO.insert(product);
	}
	
}
