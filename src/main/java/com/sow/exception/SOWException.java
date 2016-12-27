package com.sow.exception;

public class SOWException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1539458485198408270L;

	private String errorCode;
	private String errorDesc;
	
	public SOWException(String message) {
        super(message);
    }

	public SOWException(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }
	
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorDesc
	 */
	public String getErrorDesc() {
		return errorDesc;
	}

	/**
	 * @param errorDesc the errorDesc to set
	 */
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
	
}
