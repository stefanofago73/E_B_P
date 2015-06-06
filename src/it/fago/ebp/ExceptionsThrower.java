package it.fago.ebp;

/**
 * 
 * @author Stefano Fago
 * 
 */
public final class ExceptionsThrower {

	private ExceptionsThrower() {
	}

	public static RuntimeException throwAsUnchecked(final Exception ex) {
		ExceptionsThrower.<RuntimeException> throwsUnchecked(ex);
		throw new AssertionError(
				"Unreachable Code executed: something went wrong...");
	}

	private final static <T extends Exception> void throwsUnchecked(
			Exception toThrow) throws T {
		@SuppressWarnings("unchecked")
		T result = (T) toThrow;
		throw result;
	}

}// END
