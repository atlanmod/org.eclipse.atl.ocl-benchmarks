package lazyocltesting.tests;

import org.eclipse.emf.ecore.EObject;

import lazyocltesting.impl.ATLQueryLauncherFactory;
import lazyocltesting.impl.EMFTVMQueryLauncherFactory;
import lazyocltesting.impl.ParameterManager;
import lazyocltesting.plotter.XYPlotterConfiguration;

public class TestSets extends TestCollection {
	
	private static String savePath = "graphs/set/small/";
	private static String emftvmTPath = "./transformations/set/emftvm/";
	private static String standardTPath = "./transformations/set/standard/";
	final XYPlotterConfiguration conf = new XYPlotterConfiguration(false, false, false, 200, 300);
	
	ParameterManager pm = null;
	EObject expensiveParameter = null;

	public static void main(String[] args) {
		TestSets te = new TestSets();
		te.run();
	}
	
	@Override
	public void run() {
		TestTrace EMFTVMTrace;
		TestTrace normalTrace;
		
//		//Test Collect
//		//TOCHECK collect yields a bag... how we test collect properly then?
//		System.out.println("TESTING Collect**");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestCollect", emftvmTPath, 5);		
//		System.out.println("Now we test with normal ATL");		
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestCollectN", standardTPath, 5);
//		
//		plot(conf, "Collect", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		
//		System.out.println("TESTING Select");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestSelect", emftvmTPath, 100);		
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestSelectN", standardTPath, 100);
//		
//		plot(conf, "Select", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING Includes");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIncludes", emftvmTPath, 200);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIncludesN", standardTPath, 200);
//		
//		plot(conf, "Includes", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		
//		System.out.println("TESTING Excludes");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestExcludes", emftvmTPath, 200);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestExcludesN", standardTPath, 200);
//		
//		plot(conf, "Excludes", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//
//		
//		
//		System.out.println("TESTING IncludesAll");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIncludesAll", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIncludesAllN", standardTPath, 300);
//		
//		plot(conf, "IncludesAll", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING ExcludesAll");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestExcludesAll", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestExcludesAllN", standardTPath, 300);		
//
//		plot(conf, "ExcludesAll", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING Including");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIncluding", emftvmTPath, 500);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIncludingN", standardTPath, 500);
//		
//		plot(conf, "Including", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();	
//		
//		System.out.println("TESTING Excluding");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestExcluding", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestExcludingN", standardTPath, 100);
//		
//		plot(conf, "Excluding", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING Count");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestCount", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestCountN", standardTPath, 100);
//		
//		plot(conf, "Count", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		
//		System.out.println("TESTING Sum");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestSum", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestSumN", standardTPath, 100);
//		
//		plot(conf, "Sum", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		
////		TOCHECK Seems that the select 'eats' the weight of the expensive() operation
//		System.out.println("TESTING Union");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestUnion", emftvmTPath, 500);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestUnionN", standardTPath, 500);
//		
//		plot(conf, "Union", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING Size");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestSize", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestSizeN", standardTPath, 100);
//		
//		plot(conf, "Size", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING IsEmpty");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIsEmpty", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIsEmptyN", standardTPath, 100);
//		
//		plot(conf, "IsEmpty", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		
//		System.out.println("TESTING forALL");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestForAll", emftvmTPath, 500);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestForAllN", standardTPath, 500);
//		
//		plot(conf, "forALL", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//				
//		System.out.println("TESTING Flatten");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestFlatten", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestFlattenN", standardTPath, 100);
//		
//		plot(conf, "Flatten", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		
//		System.out.println("TESTING Reject");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestReject", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestRejectN", standardTPath, 100);
//		
//		plot(conf, "Reject", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING Exists");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestExists", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestExistsN", standardTPath, 300);
//		
//		plot(conf, "Exists", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING Any");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestAny", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestAnyN", standardTPath, 300);
//		
//		plot(conf, "Any", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING One");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestOne", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestOneN", standardTPath, 300);
//		
//		plot(conf, "One", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING isUnique");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIsUnique", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIsUniqueN", standardTPath, 100);
//		
//		plot(conf, "isUnique", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING sortedBy");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestSortedBy", emftvmTPath, 10);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestSortedByN", standardTPath, 10);
//		
//		plot(conf, "sortedBy", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING Iterate");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIterate", emftvmTPath, 700);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIterateN", standardTPath, 700);
//		
//		plot(conf, "Iterate", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING EQ");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestEQ", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestEQN", standardTPath, 100);
//		
//		plot(conf, "EQ", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING NotEQ");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestNeq", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestNeqN", standardTPath, 100);
//		
//		plot(conf, "NEQ", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING Intersection");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIntersection", emftvmTPath, 400);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIntersectionN", standardTPath, 400);
//		
//		plot(conf, "Intersection", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING Minus");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestMinus", emftvmTPath, 10);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestMinusN", standardTPath, 10);
//		
//		plot(conf, "Minus", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING SymmetricDifference");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestSymmetricDif", emftvmTPath, 600);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestSymmetricDifN", standardTPath, 600);
//		
//		plot(conf, "SymmetricDif", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
	}
}
