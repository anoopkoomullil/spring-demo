package com.howtodoinjava.demo.exception;

import com.howtodoinjava.demo.model.MWErrors;

public class EmployeeServiceException extends Exception {

	private static final long serialVersionUID = -470180507998010368L;

	private String error;
	private String errorDescription;
	private int status;
	private ExceptionResponse exceptionResponse;
	private String exceptionDesc;
	private MWErrors mwErrors;

	public MWErrors getMwErrors() {
		return mwErrors;
	}

	public void setMwErrors(MWErrors mwErrors) {
		this.mwErrors = mwErrors;
	}

	public EmployeeServiceException() {
		super();
	}

	public EmployeeServiceException(final String message) {
		super(message);
	}
	
	public EmployeeServiceException(ExceptionResponse exceptionResponse) {
		this.exceptionResponse = exceptionResponse;
	}
	
	public EmployeeServiceException(String error,String errorDescription,int status) {
		this.error = error;
		this.errorDescription = errorDescription;
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ExceptionResponse getExceptionResponse() {
		return exceptionResponse;
	}

	public void setExceptionResponse(ExceptionResponse exceptionResponse) {
		this.exceptionResponse = exceptionResponse;
	}

	public String getExceptionDesc() {
		return exceptionDesc;
	}

	public void setExceptionDesc(String exceptionDesc) {
		this.exceptionDesc = exceptionDesc;
	}
	
}

