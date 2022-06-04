package com.cos.photogramstart.handler.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAdvice {
	
	@Around("execution(* com.cos.photogramstart.web.api.*Controller.*(..)")
	public Object apiAdvice() {
		return null;
	}
	
	@Around("execution(* com.cos.photogramstart.web.*Controller.*(..)")
	public Object advice() {
		
		return null;
	}
	
}
