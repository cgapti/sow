package com.sow.exception;

public class CustomException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1539458485198408270L;

	private boolean errorStatus;
	private String errorDesc;
	
		
	public boolean isErrorStatus() {
		return errorStatus;
	}
	public void setErrorStatus(boolean errorStatus) {
		this.errorStatus = errorStatus;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
	
	
}
