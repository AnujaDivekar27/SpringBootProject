package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.ExceptionResponse;

@ControllerAdvice //globally apply for all controller
public class ExceptionHandlingController {

	@ExceptionHandler
	public @ResponseBody ExceptionResponse handlingResponse(AccountNotFound accountNotFound, HttpServletRequest request)
	{
	  ExceptionResponse exceptionResponse=new ExceptionResponse();	
	  exceptionResponse.setUri(request.getRequestURI());
	  exceptionResponse.setErrormsg(accountNotFound.getMessage());
	  
	  return exceptionResponse;
		
	}
}
