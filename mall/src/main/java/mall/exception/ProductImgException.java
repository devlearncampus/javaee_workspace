package mall.exception;

public class ProductImgException extends RuntimeException{
	
	public ProductImgException(String msg) {
		super(msg); //생성자는 물려받지 못하므로, 부모의 생성자를 호출한다..
	}
	public ProductImgException(String msg, Throwable e) {
		super(msg, e);
	}
	public ProductImgException(Throwable e) {
		super(e);
	}
	
}
