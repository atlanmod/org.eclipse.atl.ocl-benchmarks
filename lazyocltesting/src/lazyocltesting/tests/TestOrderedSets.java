package lazyocltesting.tests;

import org.eclipse.emf.ecore.EObject;

import lazyocltesting.impl.ATLQueryLauncherFactory;
import lazyocltesting.impl.EMFTVMQueryLauncherFactory;
import lazyocltesting.impl.ParameterManager;
import lazyocltesting.plotter.XYPlotterConfiguration;

public class TestOrderedSets extends TestCollection{
	
	private static String savePathS = "graphs/orderedset/small/";
	private static String savePathB = "graphs/orderedset/";
	
	private static String emftvmTPath = "./transformations/orderedset/emftvm/";
	private static String standardTPath = "./transformations/orderedset/standard/";
	final XYPlotterConfiguration confS = new XYPlotterConfiguration(false, false, false, 200, 300);
	final XYPlotterConfiguration confB = new XYPlotterConfiguration(true, true, true, 800, 1000);
	
	ParameterManager pm = null;
	EObject expensiveParameter = null;

	public static void main(String[] args) {
		TestOrderedSets te = new TestOrderedSets();
		te.run();
	}

	@Override
	public void run() {
		TestTrace EMFTVMTrace;
		TestTrace normalTrace;
		
		//TOCHECK seems that standard ATL is not strict with collection types
//		System.out.println("TESTING Collect");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestCollect", emftvmTPath, 10);
//		System.out.println("Now we test with normal ATL");		
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestCollectN", standardTPath, 10);
//		
//		plot(confS, "Collect", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Collect", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING Select");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestSelect", emftvmTPath, 10);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestSelectN", standardTPath, 10);
//		
//		plot(confS, "Select", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Select", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING Includes");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIncludes", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIncludesN", standardTPath, 100);
//		
//		plot(confS, "Includes", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Includes", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		
//		System.out.println("TESTING Excludes");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestExcludes", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestExcludesN", standardTPath, 100 );
//		
//		plot(confS, "Excludes", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Excludes", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING IncludesAll");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIncludesAll", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIncludesAllN", standardTPath, 100);
//		
//		plot(confS, "IncludesAll", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "IncludesAll", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING ExcludesAll");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestExcludesAll", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestExcludesAllN", standardTPath, 100);
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
//		plot(confB, "including", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING Excluding");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestExcluding", emftvmTPath, 500);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestExcludingN", standardTPath, 500);
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
		//TOCHECK Not implemented in Standard ATL
//		System.out.println("TESTING Max");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestMax", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestMaxN", standardTPath, 100);
//		
//		plot(conf, "Count", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
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
		//TOCHECK Reverse not implemented in normal ATL
//		System.out.println("TESTING Reverse");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestReverse", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestReverseN", standardTPath, 100);
//		
//		plot(conf, "Reverse", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
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
//		System.out.println("TESTING At");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestAt", emftvmTPath, 500);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestAtN", standardTPath, 500);
//		
//		plot(confS, "At", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "At", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING IndexOf");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIndexOf", emftvmTPath, 500);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIndexOfN", standardTPath, 500);
//		
//		plot(confS, "IndexOf", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "IndexOf", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING First");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestFirst", emftvmTPath, 500);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestFirstN", standardTPath, 500);
//		
//		plot(confS, "First", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "First", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING Last");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestLast", emftvmTPath, 500);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestLastN", standardTPath, 500);
//		
//		plot(confS, "Last", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Last", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING Suborderedset");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestSubOrderedSet", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestSubOrderedSetN", standardTPath, 300);
//		
//		plot(confS, "Suborderedset", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Suborderedset", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING InsertAt");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestInsertAt", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestInsertAtN", standardTPath, 100);
//		
//		plot(confS, "InsertAt", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "InsertAt", EMFTVMTrace, normalTrace, true, savePathB);
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
//		System.out.println("TESTING Prepend");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestPrepend", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestPrependN", standardTPath, 300);
//		plot(confS, "Prepend", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Prepend", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING Append");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestAppend", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestAppendN", standardTPath, 300);
//		
//		plot(confS, "Append", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "Append", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING Reject");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestReject", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestRejectN", standardTPath, 300);
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
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIsUnique", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIsUniqueN", standardTPath, 300);
//		
//		plot(confS, "isUnique", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "isUnique", EMFTVMTrace, normalTrace, true, savePathB);
//		breakLine();
//		
//		System.out.println("TESTING sortedBy");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestSortedBy", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestSortedByN", standardTPath, 100);
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
//		System.out.println("TESTING NEQ");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestNeq", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestNeqN", standardTPath, 100);
//		
//		plot(confS, "NEQ", EMFTVMTrace, normalTrace, true, savePathS);
//		plot(confB, "NEQ", EMFTVMTrace, normalTrace, true, savePathB);
		
		
	}

}
