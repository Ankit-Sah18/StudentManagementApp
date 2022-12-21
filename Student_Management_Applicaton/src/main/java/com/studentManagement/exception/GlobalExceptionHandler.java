package com.studentManagement.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(StudentException.class)
	   public ResponseEntity<MyErrorDetails> studentExceptionHandler(StudentException e,WebRequest wr){
		   
		            MyErrorDetails error= new MyErrorDetails();
		            error.setMessage(e.getMessage());
		            error.setDetails(wr.getDescription(false));
		            error.setTimeStamp(LocalDateTime.now());
		            
		            return new ResponseEntity<MyErrorDetails>(error, HttpStatus.NOT_FOUND);
	   }
	   
	@ExceptionHandler(CourseException.class)
	   public ResponseEntity<MyErrorDetails> courseExceptionHandler(CourseException e,WebRequest wr){
		   
           MyErrorDetails error= new MyErrorDetails();
           error.setMessage(e.getMessage());
           error.setDetails(wr.getDescription(false));
           error.setTimeStamp(LocalDateTime.now());
           
           return new ResponseEntity<MyErrorDetails>(error, HttpStatus.NOT_FOUND);
 }
	
	@ExceptionHandler(AdminException.class)
      public ResponseEntity<MyErrorDetails> adminExceptionHandler(AdminException e,WebRequest wr){
		   
           MyErrorDetails error= new MyErrorDetails();
           error.setMessage(e.getMessage());
           error.setDetails(wr.getDescription(false));
           error.setTimeStamp(LocalDateTime.now());
           
           return new ResponseEntity<MyErrorDetails>(error, HttpStatus.NOT_FOUND);
     }
      
	
      public ResponseEntity<MyErrorDetails> loginExceptionHandler(LoginException e,WebRequest wr){
		   
          MyErrorDetails error= new MyErrorDetails();
          error.setMessage(e.getMessage());
          error.setDetails(wr.getDescription(false));
          error.setTimeStamp(LocalDateTime.now());
          
          return new ResponseEntity<MyErrorDetails>(error, HttpStatus.NOT_FOUND);
  }
      
      @ExceptionHandler(Exception.class)
      public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception e,WebRequest wr){
		   
          MyErrorDetails error= new MyErrorDetails();
          error.setMessage(e.getMessage());
          error.setDetails(wr.getDescription(false));
          error.setTimeStamp(LocalDateTime.now());
          
          return new ResponseEntity<MyErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
