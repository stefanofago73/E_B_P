package it.fago.ebp;

public class StackSwapper {

	/**
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	public static boolean swap(final Throwable source, final Throwable target) {
		if (source != null && target != null) {
			target.setStackTrace(source.getStackTrace());
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param source
	 * @param target
	 * @param policy
	 * @return
	 */
	public static boolean swap(final Throwable source, final Throwable target,
			SwapPolicy policy) {
		return (source != null && target != null) ? policy
				.apply(source, target) : false;
	}

}// END
