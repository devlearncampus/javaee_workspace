package mall.model.category;

import java.util.List;

import mall.domain.TopCategory;

//컨트롤러가 느슨하게, 서비스를 보유하게 하려면(DI) 인터페이스로 정의
public interface TopCategoryService {
	
	public List selectAll();
	public TopCategory select(int topcategory_id);
	
}
