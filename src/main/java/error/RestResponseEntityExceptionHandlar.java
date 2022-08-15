package error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lti.springboot.tutorial.entity.ErrorMessage;

//@ControllerAdvice is a specialization of the @Component annotation which allows to handle exceptions across the whole application in one global handling component. 
//@ControllerAdvice class to handle the exceptions globally
//@ResponseStatus marks a method or exception class with the status code and reason message that should be returned.

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandlar extends ResponseEntityExceptionHandler{

	//The @ExceptionHandler is an annotation used to handle the specific exceptions and sending the custom responses to the client. Define a class that extends the RuntimeException class.
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception, WebRequest request) {
		ErrorMessage  message = new ErrorMessage(HttpStatus.NOT_FOUND,
				exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
}
