package mall.exception;

public class ProductColorException extends RuntimeException{
	
	public ProductColorException(String msg) {
		super(msg); //생성자는 물려받지 못하므로, 부모의 생성자를 호출한다..
	}
	public ProductColorException(String msg, Throwable e) {
		super(msg, e);
	}
	public ProductColorException(Throwable e) {
		super(e);
	}
	
}
