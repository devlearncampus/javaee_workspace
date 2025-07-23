package mall.model.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisSubCategoryDAO implements SubCategoryDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; //순수mybatis에서 SqlSession 과 동일
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectByTopCategoryId(int topcategory_id) {
		return sqlSessionTemplate.selectList("SubCategory.selectByTopCategoryId", topcategory_id);
	}
	
}






