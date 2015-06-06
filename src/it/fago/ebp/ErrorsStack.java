package it.fago.ebp;


import java.util.ArrayList;


/**
 * 
 * @author Stefano Fago
 *
 */
public class ErrorsStack {
	//
	private final ErrorsStack next;
	//
	private final ErrorElement elem;

	private ErrorsStack(final ErrorsStack next, final ErrorElement elem) {
		this.next = next;
		this.elem = elem;
	}

	public static ErrorsStack create() {
		return new ErrorsStack(null, null);
	}

	public ErrorsStack addError(String message, StackTraceElement trace) {
		return new ErrorsStack(this, new ErrorElement(message, trace));
	}

	
	public Exception toException(String message) {
		ArrayList<StackTraceElement> traces = new ArrayList<StackTraceElement>();
		ErrorsStack me = this;
		while (me != null) {
			traces.add(me.elem.trace);
			me = me.next;
		}
		return new StacklessException(message,
				traces.toArray(new StackTraceElement[traces.size()]));
	}

	public RuntimeException toRuntimeException(String message) {
		ArrayList<StackTraceElement> traces = new ArrayList<StackTraceElement>();
		ErrorsStack me = this;
		while (me != null) {
			traces.add(me.elem.trace);
			me = me.next;
		}
		return new RuntimeStacklessException(message,
				traces.toArray(new StackTraceElement[traces.size()]));
	}

	// =========================================
	//
	//
	//
	// =========================================

	private static class ErrorElement {
		public final String message;
		public final StackTraceElement trace;

		public ErrorElement(final String message, final StackTraceElement elem) {
			this.message = message;
			this.trace = elem;
		}
	}

}// END
