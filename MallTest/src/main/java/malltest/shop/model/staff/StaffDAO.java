package malltest.shop.model.staff;

import java.util.List;

import malltest.shop.domain.Staff;

public interface StaffDAO {

	public void insert(Staff staff);
	public List selectAll();
	public Staff select(int staff_id);
	public void update(Staff staff);
	public void delete(int staff_id);
}
