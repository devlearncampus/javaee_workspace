package mall.exception;

public class UploadException extends RuntimeException{
	
	public UploadException(String msg) {
		super(msg); //생성자는 물려받지 못하므로, 부모의 생성자를 호출한다..
	}
	public UploadException(String msg, Throwable e) {
		super(msg, e);
	}
	public UploadException(Throwable e) {
		super(e);
	}
	
}
