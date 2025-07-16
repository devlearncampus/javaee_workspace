package malltest.shop.model.staff;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import malltest.shop.domain.Staff;
import malltest.shop.exception.StaffException;

@Slf4j
@Repository
public class HibernateStaffDAO implements StaffDAO{
	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void insert(Staff staff) throws StaffException{
		try {
			getSession().saveOrUpdate(staff);
		} catch (Exception e) {			
			log.error("등록실패", e.getMessage(), e);
			throw new StaffException("등록실패", e);
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
