package malltest.shop.exception;

public class StaffException extends RuntimeException{

	public StaffException(String msg) {
		super(msg);
	}
	public StaffException(String msg, Throwable e) {
		super(msg, e);
	}
	public StaffException(Throwable e) {
		super(e);
	}
	
	
}
