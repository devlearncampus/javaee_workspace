package malltest.shop.model.staff;

import java.util.List;

import malltest.shop.domain.Bio;
import malltest.shop.domain.Staff;

public interface StaffService {
	public void regist(Bio bio);
	public List selectAll();
	public Staff select(int staff_id);
	public void update(Bio bio);
	public void delete(int staff_id);
}
