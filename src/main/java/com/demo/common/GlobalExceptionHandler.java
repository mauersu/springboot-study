package com.demo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	@ResponseBody
	public WebResponse illegalArgumentExceptionHandler(IllegalArgumentException e) {
		logger.error(e.getMessage(), e);
		return WebResponse.failed(ErrorCodeEnum.PARAM_ERROR, e.getMessage());
	}

	@ExceptionHandler(value = BindException.class)
	@ResponseBody
	public WebResponse bindExceptionHandler(BindException e) {
		logger.error(e.getMessage(), e);
		String message = StringUtils.collectionToCommaDelimitedString(
				e.getBindingResult().getFieldErrors()
						.stream()
						.map(FieldError::getDefaultMessage)
						.collect(Collectors.toList()));
		return WebResponse.failed(ErrorCodeEnum.PARAM_ERROR, message);
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public WebResponse exceptionHandler(Exception e) {
		logger.error(e.getMessage(), e);
		if (e instanceof ConstraintViolationException) {
	      ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
	      String message = StringUtils.collectionToCommaDelimitedString(
	          constraintViolationException.getConstraintViolations()
	              .stream()
	              .map(ConstraintViolation::getMessage)
	              .collect(Collectors.toList()));
	      return WebResponse.failed(ErrorCodeEnum.PARAM_ERROR, message);
	    }
		if (e instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
			String message = StringUtils.collectionToCommaDelimitedString(
					methodArgumentNotValidException.getBindingResult().getFieldErrors()
			              .stream()
			              .map(FieldError::getDefaultMessage)
			              .collect(Collectors.toList()));
			      return WebResponse.failed(ErrorCodeEnum.PARAM_ERROR, message);
		}
		return WebResponse.failed(ErrorCodeEnum.UNKNOW);
	}
}