package malltest.shop.model.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import malltest.shop.domain.Bio;
import malltest.shop.domain.Staff;
import malltest.shop.exception.BioException;
import malltest.shop.exception.StaffException;

@Service
public class StaffServiceImpl implements StaffService{
	
	@Qualifier("hibernateStaffDAO")
	@Autowired
	private StaffDAO staffDAO;

	@Autowired
	private BioDAO bioDAO;
	
	
	@Transactional
	public void regist(Bio bio) throws StaffException, BioException{				
		staffDAO.insert(bio.getStaff());
		//bio.setStaff(bio.getStaff());
		//bioDAO.insert(bio);
		
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
	public void update(Bio bio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int staff_id) {
		// TODO Auto-generated method stub
		
	}
	
}
