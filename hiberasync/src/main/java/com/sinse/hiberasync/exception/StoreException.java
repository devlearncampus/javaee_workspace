package com.sinse.hiberasync.exception;

public class StoreException extends RuntimeException{

	public StoreException(String msg) {
		super(msg);
	}
	public StoreException(String msg,Throwable e) {
		super(msg,e);
	}
	public StoreException(Throwable e) {
		super(e);
	}
	
}
