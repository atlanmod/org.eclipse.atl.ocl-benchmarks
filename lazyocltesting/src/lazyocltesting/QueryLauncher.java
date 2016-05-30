package lazyocltesting;

import lazyocltesting.impl.ParameterManager;

public interface QueryLauncher {
	
	public abstract Object initialize(String queryName, String transformationDirectory);
	public abstract Object run(Object query);
	public abstract ParameterManager getParameterManager();
}