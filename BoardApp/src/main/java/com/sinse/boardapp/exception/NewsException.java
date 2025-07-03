package com.sinse.boardapp.exception;

public class NewsException extends RuntimeException{
	
	public NewsException(String msg) {
		super(msg); //생성자는 물려받지 못하므로, 부모의 생성자를 호출한다..
	}
	public NewsException(String msg, Throwable e) {
		super(msg, e);
	}
	public NewsException(Throwable e) {
		super(e);
	}
	
}
