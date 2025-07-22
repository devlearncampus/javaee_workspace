package mall.model.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mall.domain.ProductImg;
import mall.exception.ProductImgException;

@Repository
public class MybatisProductImgDAO implements ProductImgDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<ProductImg> selectByProductId(int product_id) {
		return sqlSessionTemplate.selectList("ProductImg.selectByProductId", product_id);
	}
	
	@Override
	public void insert(ProductImg productImg) throws ProductImgException{
		int result = sqlSessionTemplate.insert("ProductImg.insert", productImg);

		if(result <1) {
			throw new ProductImgException("상품 이미지 등록 실패");
		}
	}

	
}
