package mall.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeServiceImpl implements SizeService{
	@Autowired
	private SizeDAO sizeDAO;
	
	public List selectAll() {
		return sizeDAO.seletAll();
	}
}
