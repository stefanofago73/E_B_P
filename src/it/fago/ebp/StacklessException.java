package it.fago.ebp;

/**
 * 
 * @author Stefano Fago
 * 
 */
public class StacklessException extends Exception {

	//
	private static final long serialVersionUID = 2675247953392230575L;
	//
	private String id;

	/**
	 * 
	 * @param message
	 */
	public StacklessException(String message) {
		super(message, null);
	}

	/**
	 * 
	 * @param message
	 * @param className
	 * @param methodName
	 * @param lineNumber
	 */
	public StacklessException(String message, String className,
			String methodName, int lineNumber) {
		super(message, null);
		setStackTrace(new StackTraceElement[] { new StackTraceElement(
				className, methodName, "", lineNumber) });
	}

	/**
	 * 
	 * @param message
	 * @param className
	 * @param methodName
	 * @param fileName
	 * @param lineNumber
	 */
	public StacklessException(String message, String className,
			String methodName, String fileName, int lineNumber) {
		super(message, null);
		setStackTrace(new StackTraceElement[] { new StackTraceElement(
				className, methodName, fileName, lineNumber) });
	}

	/**
	 * 
	 * @param message
	 * @param traces
	 */
	public StacklessException(String message, StackTraceElement[] traces) {
		super(message, null);
		setStackTrace(traces);
	}

	@Override
	public Throwable fillInStackTrace() {
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

}// END