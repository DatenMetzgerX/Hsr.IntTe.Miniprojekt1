package ch.hsr.intTe;

import java.util.concurrent.ExecutionException;

import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class ServiceLocator {
	
	private static ServiceLocator instance = new ServiceLocator();
	private final LoadingCache<Class<?>, Object> services = CacheBuilder.newBuilder().build(new InstanceCreator());
	
	public static ServiceLocator getInstance() {
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T locate(Class<T> clazz) {
		try {
			return (T) services.get(clazz);
		} catch (ExecutionException e) {
			throw Throwables.propagate(e);
		}
	}

	private static class InstanceCreator extends CacheLoader<Class<?>, Object> {

		@Override
		public Object load(Class<?> arg0) throws Exception {
			return arg0.newInstance();
		}
		
	}
}
