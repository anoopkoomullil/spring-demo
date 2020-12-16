package com.howtodoinjava.demo.exception;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.howtodoinjava.demo.config.EmployeeConstant;







@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler{
	
	

	/*@ExceptionHandler(IfssControllerException.class)
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	public @ResponseBody ExceptionResponse handleResourceNotFound(final IfssControllerException exception,
			final HttpServletRequest request) {

		ExceptionResponse error = exception.getExceptionResponse();
		error.setTimestamp(LocalDateTime.now());
        error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		error.callerURL(request.getRequestURI());
		error.setExceptionName(AuditMappingConstant.IFSS_CONTROLLER_EXCEPTION);
		return error;
	}*/
	
	@ExceptionHandler(EmployeeServiceException.class)
    public ResponseEntity<ExceptionResponse> customHandleNotFound(EmployeeServiceException exception, HttpServletRequest request) {
		
		ExceptionResponse error = exception.getExceptionResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setExceptionName(EmployeeConstant.TELEX_SERVICE_EXCEPTION);
        error.setStatus(HttpStatus.NOT_FOUND.value());
		error.callerURL(request.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
	
	/*@ExceptionHandler(IfssDaoException.class)
    public ResponseEntity<ExceptionResponse> daoHandleNotFound(IfssDaoException exception, HttpServletRequest request) {

		ExceptionResponse error = exception.getExceptionResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setExceptionName(AuditMappingConstant.IFSS_DAO_EXCEPTION);
        error.setStatus(HttpStatus.NOT_FOUND.value());
		error.callerURL(request.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }*/
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException(final Exception exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setTimestamp(LocalDateTime.now());
        error.setError(exception.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		error.setExceptionDesc(exception.getCause()+exception.getMessage()+ExceptionUtils.getStackTrace(exception));
		error.setExceptionName(EmployeeConstant.TELEX_EXCEPTION);
		return error;
	}
	
	 // @Validate For Validating Path Variables and Request Parameters
    @ExceptionHandler(ConstraintViolationException.class)
    public void constraintViolationException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
