//Handling exceptions and errors in APIs and sending the proper response to the client is good for enterprise applications.
package error;

public class DepartmentNotFoundException extends Exception{
	public DepartmentNotFoundException() {
		// TODO Auto-generated constructor stub
		super();
	}

	public DepartmentNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	
	public DepartmentNotFoundException(String message, Throwable cause) {
		// TODO Auto-generated constructor stub
		super(message,cause);
	}
	
	public DepartmentNotFoundException(Throwable cause) {
		// TODO Auto-generated constructor stub
		super(cause);
	}
	
	 protected DepartmentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	        super(message, cause, enableSuppression, writableStackTrace);
	    }

}
