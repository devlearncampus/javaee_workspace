package myframwork.staff.model.repository;

import org.apache.ibatis.session.SqlSession;

import myframework.exception.BioException;
import myframework.mybatis.MybatisConfig;
import myframework.staff.model.domain.Bio;

public class BioDAO {

	MybatisConfig config=MybatisConfig.getInstance();
	
	public void insert(SqlSession sqlSession, Bio bio) throws BioException{

		int result = sqlSession.insert("Bio.insert", bio);
		if(result <1) {
			throw new BioException("Staff의 신체정보 등록 실패");
		}

	}
	
}






