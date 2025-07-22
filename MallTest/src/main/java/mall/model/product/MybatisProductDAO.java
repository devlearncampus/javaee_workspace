package mall.model.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mall.domain.Product;
import mall.exception.ProductException;

@Repository
public class MybatisProductDAO implements ProductDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(Product product) throws ProductException{
		int result = sqlSessionTemplate.insert("Product.insert", product);
		if(result<1) {
			throw new ProductException("등록 실패");
		}
	}

	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Product.selectAll");
	}

	@Override
	public Product select(int product_id) {	
		return sqlSessionTemplate.selectOne("Product.select", product_id);
	}

	@Override
	public void update(Product product) throws ProductException{
		int result = sqlSessionTemplate.update("Product.update", product);
		if(result <1) {
			throw new ProductException("수정 실패");
		}
	}

	@Override
	public void delete(int product_id) throws ProductException{
		int result = sqlSessionTemplate.delete("Product.delete", product_id);
		if(result <1) {
			throw new ProductException("삭제 실패");
		}
		
	}
	
	
	
}
