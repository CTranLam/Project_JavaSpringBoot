package com.javaweb.controlleradvice;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.customexception.FieldRequiredException;
import com.javaweb.customexception.ValidNumException;
import com.javaweb.model.ErrorResponseDTO;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex, WebRequest request) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setError(ex.getMessage());
        ArrayList<String> details = new ArrayList<>();
        details.add("So nguyen lam sao chia duoc cho 0");
        errorResponseDTO.setDetail(details);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(FieldRequiredException.class)
	public ResponseEntity<Object> handleFieldRequiredException(FieldRequiredException ex, WebRequest request) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setError(ex.getMessage());
        ArrayList<String> details = new ArrayList<>();
        details.add("check lai name hoac numberofbasement di boi vi bi null");
        errorResponseDTO.setDetail(details);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_GATEWAY);
    }
	
	@ExceptionHandler(ValidNumException.class)
	public ResponseEntity<Object> handleValidNumException(ValidNumException ex, WebRequest request){
		ErrorResponseDTO error = new ErrorResponseDTO();
		error.setError(ex.getMessage());
		ArrayList<String> details = new ArrayList<String>();
		details.add("Num vua nhap khong hop le !");
		details.add("Vui long nhap lai");
		error.setDetail(details);
		return new ResponseEntity<Object>(error, HttpStatus.BAD_GATEWAY);
	}
}