package com.howtodoinjava.demo.model;

import java.sql.Timestamp;

public class MWErrors {

	private String errId;
	private String serviceProvider;
	private String esbUuid;
	private String reqUuid;
	private String reqAppid;
	private String processName;
	private String categoryCode;
	private String categoryDescription;
	private String errorCode;
	private String errorDescription;
	private String severityCode;
	private String sourceSystem;
	private String targetSystem;
	private Timestamp errorDateTime;
	private String errorReport;
	private String providerErrors;
	private String activityName;
	private String errorStackTrace;
	
	
	public String getErrId() {
		return errId;
	}
	public void setErrId(String errId) {
		this.errId = errId;
	}
	public String getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public String getEsbUuid() {
		return esbUuid;
	}
	public void setEsbUuid(String esbUuid) {
		this.esbUuid = esbUuid;
	}
	public String getReqUuid() {
		return reqUuid;
	}
	public void setReqUuid(String reqUuid) {
		this.reqUuid = reqUuid;
	}
	public String getReqAppid() {
		return reqAppid;
	}
	public void setReqAppid(String reqAppid) {
		this.reqAppid = reqAppid;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getSeverityCode() {
		return severityCode;
	}
	public void setSeverityCode(String severityCode) {
		this.severityCode = severityCode;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public String getTargetSystem() {
		return targetSystem;
	}
	public void setTargetSystem(String targetSystem) {
		this.targetSystem = targetSystem;
	}
	public Timestamp getErrorDateTime() {
		return errorDateTime;
	}
	public void setErrorDateTime(Timestamp errorDateTime) {
		this.errorDateTime = errorDateTime;
	}
	public String getErrorReport() {
		return errorReport;
	}
	public void setErrorReport(String errorReport) {
		this.errorReport = errorReport;
	}
	public String getProviderErrors() {
		return providerErrors;
	}
	public void setProviderErrors(String providerErrors) {
		this.providerErrors = providerErrors;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
	
	public String getErrorStackTrace() {
		return errorStackTrace;
	}
	public void setErrorStackTrace(String errorStackTrace) {
		this.errorStackTrace = errorStackTrace;
	}
	@Override
	public String toString() {
		return "MWErrors [errId=" + errId + ", serviceProvider=" + serviceProvider + ", esbUuid=" + esbUuid
				+ ", reqUuid=" + reqUuid + ", reqAppid=" + reqAppid + ", processName=" + processName + ", categoryCode="
				+ categoryCode + ", categoryDescription=" + categoryDescription + ", errorCode=" + errorCode
				+ ", errorDescription=" + errorDescription + ", severityCode=" + severityCode + ", sourceSystem="
				+ sourceSystem + ", targetSystem=" + targetSystem + ", errorDateTime=" + errorDateTime
				+ ", errorReport=" + errorReport + ", providerErrors=" + providerErrors + ", activityName="
				+ activityName + ", errorStackTrace=" + errorStackTrace + "]";
	}

	
	
	
}
