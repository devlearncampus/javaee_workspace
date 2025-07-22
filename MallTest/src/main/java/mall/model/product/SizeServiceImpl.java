package mall.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeServiceImpl implements SizeService{
	@Autowired
	private SizeDAO sizeDAO;
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return sizeDAO.selectAll();
	}
	
}
