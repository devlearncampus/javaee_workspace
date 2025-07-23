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
	
	public void insert(Product product) throws ProductException{
		int result = sqlSessionTemplate.insert("Product.insert", product);
		if(result <1) {
			throw new ProductException("등록실패"); //실패되었음을 다른 계층에서도 알아야 하므로.잡으면 안됨
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
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		
	}

}



