package lazyocltesting.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

import lazyocltesting.QueryLauncher;
import lazyocltesting.QueryLauncherFactory;

public class TestExample {

	public static void main(String[] args) {
		TestExample te = new TestExample();

		te.TestQuery(new EMFTVMQueryLauncherFactory(), "TestCollect", "./transformations/");

		System.out.println("Now we test with normal ATL");
		
		te.TestQuery(new ATLQueryLauncherFactory(), "TestCollectN", "./transformations/");

	}

	public void TestQuery(QueryLauncherFactory f, String queryName, String transfDir) {
		QueryLauncher ql = f.createLauncher();
		Object query = ql.initialize(queryName, transfDir);
		ParameterManager pm = ql.getParameterManager();
		EObject parameter = pm.getParameterObject("TakeIn");
		;

		for (int i = 4; i <= 256; i += 4) {
			pm.setParameterValue(parameter, i);

			TimingData td = new TimingData();
			ql.run(query);
			td.finish();
			System.out.println(i+ ":"+ td.getFinished());
		}

	}

}
