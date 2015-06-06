package it.fago.ebp;

/**
 * 
 * @author Stefano Fago
 *
 */
public class Callers {

	private static class Entrypoint extends SecurityManager {
		
		public Class<?>[] callers() {
			final Class<?>[] classes = getClassContext();
			final int len = classes.length - 2;
			Class<?>[] result = new Class<?>[classes.length - 2];
			System.arraycopy(classes, 2, result, 0, len);
			return result;
		}
		
		public Class<?>[] callersFrom(int numOfLevelToSkip) {
			final Class<?>[] classes = getClassContext();
			final int len = classes.length - numOfLevelToSkip;
			Class<?>[] result = new Class<?>[len];
			System.arraycopy(classes, numOfLevelToSkip, result, 0, len);
			return result;
		}
	};

	public static Entrypoint internal = new Entrypoint();

	public static final Class<?>[] obtain() {
		return internal.callers();
	}

	public static final Class<?>[] obtainSkipping(int numOfLevelToSkip) {
		return internal.callersFrom(numOfLevelToSkip);
	}
	
	public static final void destroy() {
		internal = null;
	}

}// END
