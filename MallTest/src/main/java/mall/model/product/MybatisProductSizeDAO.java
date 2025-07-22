package mall.model.product;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mall.domain.ProductSize;
import mall.exception.ProductSizeException;

@Repository
public class MybatisProductSizeDAO implements ProductSizeDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void insert(ProductSize ProductSize) throws ProductSizeException{
		int result = sqlSessionTemplate.insert("ProductSize.insert", ProductSize);
		
		if(result <1) {
			throw new ProductSizeException("상품 사이즈 등록실패");
		}
	}
	
}
