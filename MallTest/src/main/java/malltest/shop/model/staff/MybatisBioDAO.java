package malltest.shop.model.staff;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import malltest.shop.domain.Bio;
import malltest.shop.exception.BioException;

@Repository
public class MybatisBioDAO implements BioDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insert(Bio bio) throws BioException{		
		int result = sqlSessionTemplate.insert("Bio.insert",bio);
		
		if(result <1) {
			throw new BioException("등록 실패");
		}		
	}
	
}
