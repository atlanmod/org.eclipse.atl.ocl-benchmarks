package lazyocltesting.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.nebula.visualization.xygraph.figures.Trace;

import lazyocltesting.QueryLauncher;
import lazyocltesting.QueryLauncherFactory;
import lazyocltesting.impl.ATLQueryLauncherFactory;
import lazyocltesting.impl.EMFTVMQueryLauncherFactory;
import lazyocltesting.impl.ParameterManager;
import lazyocltesting.plotter.XYPlotter;
import lazyocltesting.plotter.XYPlotterConfiguration;

public class TestAllInstances {
	
	private static TestTrace EMFTVMTrace;
	private static TestTrace normalTrace;
	
	private static String savePath = "graphs/";
	
	ParameterManager pm = null;
	EObject expensiveParameter = null;

	public static void main(String[] args) {
		TestAllInstances te = new TestAllInstances();

		//Test allInstances
		System.out.println("TESTING AllInstances");
		EMFTVMTrace = te.TestQuery(new EMFTVMQueryLauncherFactory(), "TestAllInstances", "./transformations/", 10);		
		System.out.println("Now we test with normal ATL");		
		normalTrace = te.TestQuery(new ATLQueryLauncherFactory(), "TestAllInstancesN", "./transformations/", 10);
		
		plot("AllInstances", EMFTVMTrace, "EMFTVM", normalTrace, "normal", true);
		breakLine();
		

	}

	public TestTrace TestQuery(QueryLauncherFactory f, String queryName, String transfDir, Integer expensiveValue) {
		QueryLauncher ql = f.createLauncher();
		Object query = ql.initialize(queryName, transfDir);
		pm = ql.getParameterManager();
		EObject parameter = pm.getParameterObject("TakeIn");
		
		EObject parameterExpensive = pm.getParameterObject("Expensive");
		pm.setParameterValue(parameterExpensive, expensiveValue);
		
		List<Double> x = new ArrayList<Double>();
		List<Double> y = new ArrayList<Double>();
		for (int i = 4; i <= 400; i += 4) {
			pm.setParameterValue(parameter, i);
			TimingData td = new TimingData();
			ql.run(query);
			td.finish();
			x.add((double) i);
			y.add((double) td.getFinished());
			System.out.println(i+ ":"+ td.getFinished());
		}
		
		TestTrace tt = new TestTrace(
				x.stream().mapToDouble(Double::doubleValue).toArray(), 
				y.stream().mapToDouble(Double::doubleValue).toArray());
		
		return tt;
	}
	
	public static void plot(String title, TestTrace tt1, String label1, TestTrace tt2, String label2, Boolean save){
		XYPlotterConfiguration conf = new XYPlotterConfiguration(false, false, false, 200, 300);
		XYPlotter tn = new XYPlotter(conf, title, savePath);
		
		Trace trace = tn.createTrace(
				tn.getXyGraph(), 
				label1, 
				tt1.getXtrace().length, 
				tt1.getXtrace(), 
				tt1.getYtrace());
							
		Trace trace2 = tn.createTrace(
				tn.getXyGraph(), 
				label2, 
				tt2.getXtrace().length, 
				tt2.getXtrace(), 
				tt2.getYtrace());
		
		tn.showPlot(trace, trace2, save);
	}
	
	public static void breakLine(){
		System.out.println("Press ENTER to continue to the next test");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
