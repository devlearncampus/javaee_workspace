package malltest.shop.model.staff;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import malltest.shop.domain.Staff;
import malltest.shop.exception.StaffException;

@Repository
public class MybatisStaffDAO implements StaffDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insert(Staff staff) throws StaffException{
		int result = sqlSessionTemplate.insert("Staff.insert", staff);
		if(result <1) {
			throw new StaffException("등록실패");
		}
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Staff select(int staff_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Staff staff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int staff_id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
