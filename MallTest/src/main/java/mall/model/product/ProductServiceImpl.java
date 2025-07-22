package mall.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mall.domain.Color;
import mall.domain.Product;
import mall.domain.ProductColor;
import mall.domain.ProductImg;
import mall.domain.ProductSize;
import mall.domain.Size;
import mall.exception.ProductColorException;
import mall.exception.ProductException;
import mall.exception.ProductImgException;
import mall.exception.ProductSizeException;
import mall.exception.UploadException;
import mall.util.FileManager;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ProductSizeDAO productSizeDAO;
	
	@Autowired
	private ProductColorDAO productColorDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private ProductImgDAO productImgDAO;
	
	@Transactional
	public void regist(Product product, String path) throws ProductException, ProductColorException,  ProductSizeException, UploadException, ProductImgException{
		
		//1) 상품 등록
		productDAO.insert(product);
		
		//2) 상품에 소속된 색상 등록 
		for(ProductColor productColor : product.getColorList()) {			
			productColor.setProduct(product);			
			productColorDAO.insert(productColor);
		}
		
		//3) 상품에 소속된 사이즈 등록 
		for(ProductSize productSize : product.getSizeList()) {			
			productSize.setProduct(product);			
			productSizeDAO.insert(productSize);
		}
		
		//4) 이미지 등록 
		fileManager.save(product, path);
		
		//5) 이미지명 등록
		List<ProductImg> productImgList = product.getImgList();
		
		for(ProductImg productImg : productImgList) {
			productImg.setProduct(product);
			productImgDAO.insert(productImg);
		}
		
	}

	@Override
	public List selectAll() {
		return productDAO.selectAll();
	}

	@Override
	public Product select(int product_id) {
		return productDAO.select(product_id);
	}

	@Override
	public void edit(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Product product, String path) { 
		fileManager.remove(product, path);
	}
	
}
