package com.servlet.exception;

public class NotFoundIDException extends Exception {

	public NotFoundIDException() {
		super("일치하는 아이디가 없습니다.");
	}
	
}
