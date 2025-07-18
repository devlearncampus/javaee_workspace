package mall.model.category;

import java.util.List;

public interface SubCategoryService {
	public List selectAll();
	public List selectByTopCategoryId(int topcategory_id);		
}
