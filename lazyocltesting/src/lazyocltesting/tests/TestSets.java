package lazyocltesting.tests;

import org.eclipse.emf.ecore.EObject;

import lazyocltesting.impl.ATLQueryLauncherFactory;
import lazyocltesting.impl.EMFTVMQueryLauncherFactory;
import lazyocltesting.impl.ParameterManager;
import lazyocltesting.plotter.XYPlotterConfiguration;

public class TestSets extends TestCollection {
	
	private static String savePathS = "graphs/set/small/";
	private static String savePathB = "graphs/set/";
	
	private static String emftvmTPath = "./transformations/set/emftvm/";
	private static String standardTPath = "./transformations/set/standard/";
	final XYPlotterConfiguration confS = new XYPlotterConfiguration(false, false, false, 200, 300);
	final XYPlotterConfiguration confB = new XYPlotterConfiguration(true, true, true, 800, 1000);
	
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
//		plot(confS, "Collect", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Collect", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		
//		System.out.println("TESTING Select");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestSelect", emftvmTPath, 100);		
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestSelectN", standardTPath, 100);
//		
//		plot(confS, "Select", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Select", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING Includes");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIncludes", emftvmTPath, 200);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIncludesN", standardTPath, 200);
//		
//		plot(confS, "Includes", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Includes", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		
//		System.out.println("TESTING Excludes");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestExcludes", emftvmTPath, 200);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestExcludesN", standardTPath, 200);
//		
//		plot(confS, "Excludes", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Excludes", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//
//		
//		
//		System.out.println("TESTING IncludesAll");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIncludesAll", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIncludesAllN", standardTPath, 300);
//		
//		plot(confS, "IncludesAll", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "IncludesAll", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING ExcludesAll");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestExcludesAll", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestExcludesAllN", standardTPath, 300);		
//
//		plot(confS, "ExcludesAll", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "ExcludesAll", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING Including");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIncluding", emftvmTPath, 500);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIncludingN", standardTPath, 500);
//		
//		plot(confS, "Including", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Including", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();	
//		
//		System.out.println("TESTING Excluding");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestExcluding", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestExcludingN", standardTPath, 100);
//		
//		plot(confS, "Excluding", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Excluding", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING Count");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestCount", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestCountN", standardTPath, 100);
//		
//		plot(confS, "Count", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Count", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		
//		System.out.println("TESTING Sum");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestSum", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestSumN", standardTPath, 100);
//		
//		plot(confS, "Sum", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Sum", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		
////		TOCHECK Seems that the select 'eats' the weight of the expensive() operation
//		System.out.println("TESTING Union");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestUnion", emftvmTPath, 500);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestUnionN", standardTPath, 500);
//		
//		plot(confS, "Union", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Union", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING Size");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestSize", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestSizeN", standardTPath, 100);
//		
//		plot(confS, "Size", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Size", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING IsEmpty");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIsEmpty", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIsEmptyN", standardTPath, 100);
//		
//		plot(confS, "IsEmpty", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "IsEmpty", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		
//		System.out.println("TESTING forALL");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestForAll", emftvmTPath, 500);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestForAllN", standardTPath, 500);
//		
//		plot(confS, "forALL", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "forALL", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//				
//		System.out.println("TESTING Flatten");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestFlatten", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestFlattenN", standardTPath, 100);
//		
//		plot(confS, "Flatten", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Flatten", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		
//		System.out.println("TESTING Reject");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestReject", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestRejectN", standardTPath, 100);
//		
//		plot(confS, "Reject", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Reject", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING Exists");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestExists", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestExistsN", standardTPath, 300);
//		
//		plot(confS, "Exists", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Exists", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING Any");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestAny", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestAnyN", standardTPath, 300);
//		
//		plot(confS, "Any", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Any", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING One");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestOne", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestOneN", standardTPath, 300);
//		
//		plot(confS, "One", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "One", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING isUnique");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIsUnique", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIsUniqueN", standardTPath, 100);
//		
//		plot(confS, "isUnique", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "isUnique", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING sortedBy");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestSortedBy", emftvmTPath, 10);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestSortedByN", standardTPath, 10);
//		
//		plot(confS, "sortedBy", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "sortedBy", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING Iterate");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIterate", emftvmTPath, 700);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIterateN", standardTPath, 700);
//		
//		plot(confS, "Iterate", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Iterate", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING EQ");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestEQ", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestEQN", standardTPath, 100);
//		
//		plot(confS, "EQ", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "EQ", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING NotEQ");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestNeq", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestNeqN", standardTPath, 100);
//		
//		plot(confS, "NEQ", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "NEQ", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING Intersection");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIntersection", emftvmTPath, 400);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIntersectionN", standardTPath, 400);
//		
//		plot(confS, "Intersection", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Intersection", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING Minus");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestMinus", emftvmTPath, 10);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestMinusN", standardTPath, 10);
//		
//		plot(confS, "Minus", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Minus", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING SymmetricDifference");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestSymmetricDif", emftvmTPath, 600);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestSymmetricDifN", standardTPath, 600);
//		
//		plot(confS, "SymmetricDif", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "SymmetricDif", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
	}
}
