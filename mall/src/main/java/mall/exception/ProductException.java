package mall.exception;

public class ProductException extends RuntimeException{
	
	public ProductException(String msg) {
		super(msg); //생성자는 물려받지 못하므로, 부모의 생성자를 호출한다..
	}
	public ProductException(String msg, Throwable e) {
		super(msg, e);
	}
	public ProductException(Throwable e) {
		super(e);
	}
	
}
