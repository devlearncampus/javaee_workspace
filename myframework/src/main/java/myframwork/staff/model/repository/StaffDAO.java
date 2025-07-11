package myframwork.staff.model.repository;

import org.apache.ibatis.session.SqlSession;

import myframework.exception.StaffException;
import myframework.mybatis.MybatisConfig;
import myframework.staff.model.domain.Staff;

public class StaffDAO {

	MybatisConfig config=MybatisConfig.getInstance();
	
	//등록 
	public void insert(SqlSession sqlSession, Staff staff) throws StaffException{
		int result = sqlSession.insert("Staff.insert", staff);
		if(result <1) {
			throw new StaffException("Staff 등록실패");
		}
	}
	
}







