package it.fago.ebp;


import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author Stefano Fago
 *
 */
public class CachingExceptions {
	//
	private static ConcurrentHashMap<String, Throwable> cache;

	public static final void init() {
		cache = new ConcurrentHashMap<String, Throwable>(71, 0.75f, 35);
	}

	public static final void cacheElement(String id, Throwable element) {
		if (element instanceof RuntimeStacklessException) {
			cache.putIfAbsent(((RuntimeStacklessException) element).getId(),
					element);
			return;
		}
		if (element instanceof StacklessException) {
			cache.putIfAbsent(((StacklessException) element).getId(), element);
			return;
		}
		cache.putIfAbsent(id, element);
	}

	public static final Throwable removeElement(String id) {
		return cache.remove(id);
	}

	public static final boolean alreadyUsedId(String id) {
		return cache.get(id) != null;
	}

	public static final Set<String> idSet() {
		return cache.keySet();
	}

	public static final void flushAll() {
		cache.clear();
	}

	public static final void destroy() {
		cache.clear();
		cache = null;
	}

}// END
