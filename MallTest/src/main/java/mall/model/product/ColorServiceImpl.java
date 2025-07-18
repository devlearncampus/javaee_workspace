package mall.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorServiceImpl implements ColorService{
	@Autowired
	private ColorDAO colorDAO;
	
	public List selectAll() {
		return colorDAO.selectAll();
	}
	
}



