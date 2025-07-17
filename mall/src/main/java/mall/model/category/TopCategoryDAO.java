package mall.model.category;

import java.util.List;

import mall.domain.TopCategory;

public interface TopCategoryDAO {
	public List selectAll();
	public TopCategory select(int topcategory_id);
}
