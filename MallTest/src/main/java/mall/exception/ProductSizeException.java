package mall.exception;

public class ProductSizeException extends RuntimeException{
	
	public ProductSizeException(String msg) {
		super(msg); //생성자는 물려받지 못하므로, 부모의 생성자를 호출한다..
	}
	public ProductSizeException(String msg, Throwable e) {
		super(msg, e);
	}
	public ProductSizeException(Throwable e) {
		super(e);
	}
	
}
