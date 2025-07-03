package com.sinse.boardapp.exception;

public class CommentException extends RuntimeException{
	
	public CommentException(String msg) {
		super(msg); //생성자는 물려받지 못하므로, 부모의 생성자를 호출한다..
	}
	public CommentException(String msg, Throwable e) {
		super(msg, e);
	}
	public CommentException(Throwable e) {
		super(e);
	}
	
}
