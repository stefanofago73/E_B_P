package it.fago.ebp;

public interface SwapPolicy {

	public boolean apply(final Throwable source, final Throwable target);
	
}//END
