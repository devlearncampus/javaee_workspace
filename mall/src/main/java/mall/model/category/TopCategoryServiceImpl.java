package mall.model.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mall.domain.TopCategory;

@Service
public class TopCategoryServiceImpl implements TopCategoryService{
	//DAO를 느슨하게 보유
	@Autowired
	private TopCategoryDAO topCategoryDAO;
	
	
	@Override
	public List selectAll() {
		return topCategoryDAO.selectAll();
	}

	@Override
	public TopCategory select(int topcategory_id) {

		return null;
	}

}
