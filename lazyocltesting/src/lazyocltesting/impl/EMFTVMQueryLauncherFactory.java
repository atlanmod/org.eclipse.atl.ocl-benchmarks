package lazyocltesting.impl;

import lazyocltesting.QueryLauncher;
import lazyocltesting.QueryLauncherFactory;

public class EMFTVMQueryLauncherFactory implements QueryLauncherFactory {

	@Override
	public QueryLauncher createLauncher() {
		return new EMFTVMQueryLauncher();
	}

}
