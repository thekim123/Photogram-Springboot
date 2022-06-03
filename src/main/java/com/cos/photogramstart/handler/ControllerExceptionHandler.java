package com.cos.photogramstart.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomApiException;
import com.cos.photogramstart.handler.ex.CustomException;
import com.cos.photogramstart.handler.ex.CustomValidationApiException;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;
import com.cos.photogramstart.web.dto.CMRespDto;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(CustomValidationException.class)
	public String validationException(CustomValidationException e) {
		if (e.getErrorMap()!=null) {
			return Script.back(e.getErrorMap().toString());
		} else {
			return Script.back(e.getMessage());
		}
	}
	
	@ExceptionHandler(CustomException.class)
	public String Exception(CustomException e) {
			return Script.back(e.getMessage());
	}

	@ExceptionHandler(CustomValidationApiException.class)
	public ResponseEntity<?> validationApiException(CustomValidationApiException e) {
		
		return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CustomApiException.class)
	public ResponseEntity<?> ApiException(CustomApiException e) {
		
		return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), null), HttpStatus.BAD_REQUEST);
	}

}
