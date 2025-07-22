package mall.model.category;

import java.util.List;

import mall.domain.SubCategory;

public interface SubCategoryDAO {
	public List selectByTopCategoryId(int topcategory_id);	
	public List selectAll();
	public SubCategory select(int subcategory_id);
}
