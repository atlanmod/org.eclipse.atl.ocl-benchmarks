package lazyocltesting.impl;

import lazyocltesting.QueryLauncher;
import lazyocltesting.QueryLauncherFactory;

public class ATLQueryLauncherFactory implements QueryLauncherFactory {

	@Override
	public QueryLauncher createLauncher() {
		return new ATLQueryLauncher();
	}

}
