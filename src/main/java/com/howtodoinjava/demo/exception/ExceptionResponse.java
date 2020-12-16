package com.howtodoinjava.demo.exception;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.howtodoinjava.demo.config.EmployeeConstant;


public class ExceptionResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = EmployeeConstant.FULL_DATE_TIME2)
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String errorMessage;
	private String requestedURI;
	private String exceptionName;
	private String exceptionDesc;
	private boolean exceptionFound;
	private List<String> exceptionList = new ArrayList<>();
	private String severityFlag;
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setRequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRequestedURI() {
		return requestedURI;
	}

	public void callerURL(final String requestedURI) {
		this.requestedURI = requestedURI;
	}

	public String getExceptionName() {
		return exceptionName;
	}

	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}

	public boolean isExceptionFound() {
		return exceptionFound;
	}

	public void setExceptionFound(boolean exceptionFound) {
		this.exceptionFound = exceptionFound;
	}

	public List<String> getExceptionList() {
		return exceptionList;
	}

	public void setExceptionList(List<String> exceptionList) {
		this.exceptionList = exceptionList;
	}

	public String getExceptionDesc() {
		return exceptionDesc;
	}

	public void setExceptionDesc(String exceptionDesc) {
		this.exceptionDesc = exceptionDesc;
	}

	public String getSeverityFlag() {
		return severityFlag;
	}

	public void setSeverityFlag(String severityFlag) {
		this.severityFlag = severityFlag;
	}
	
	
}
