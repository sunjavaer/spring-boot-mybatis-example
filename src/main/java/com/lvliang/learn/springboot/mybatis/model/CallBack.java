package com.lvliang.learn.springboot.mybatis.model;

public class CallBack {
	
	private String isOK;
	
	private String message;

	public String getIsOK() {
		return isOK;
	}

	public void setIsOK(String isOK) { 
		this.isOK = isOK;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CallBack [isOK=" + isOK + ", message=" + message + "]";
	}
}
