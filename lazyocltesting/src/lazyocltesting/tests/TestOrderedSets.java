package lazyocltesting.tests;

import org.eclipse.emf.ecore.EObject;

import lazyocltesting.impl.ATLQueryLauncherFactory;
import lazyocltesting.impl.EMFTVMQueryLauncherFactory;
import lazyocltesting.impl.ParameterManager;
import lazyocltesting.plotter.XYPlotterConfiguration;

public class TestOrderedSets extends TestCollection{
	
	private static String savePath = "graphs/orderedset/small/";
	private static String emftvmTPath = "./transformations/orderedset/emftvm/";
	private static String standardTPath = "./transformations/orderedset/standard/";
	final XYPlotterConfiguration conf = new XYPlotterConfiguration(false, false, false, 200, 300);
	
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
//		plot(conf, "Collect", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING Select");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestSelect", emftvmTPath, 10);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestSelectN", standardTPath, 10);
//		
//		plot(conf, "Select", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING Includes");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIncludes", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIncludesN", standardTPath, 100);
//		
//		plot(conf, "Includes", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		
//		System.out.println("TESTING Excludes");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestExcludes", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestExcludesN", standardTPath, 100 );
//		
//		plot(conf, "Excludes", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING IncludesAll");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIncludesAll", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIncludesAllN", standardTPath, 100);
//		
//		plot(conf, "IncludesAll", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING ExcludesAll");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestExcludesAll", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestExcludesAllN", standardTPath, 100);
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
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestExcluding", emftvmTPath, 500);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestExcludingN", standardTPath, 500);
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
//		plot(conf, "Sum", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
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
//		plot(conf, "forALL", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING At");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestAt", emftvmTPath, 500);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestAtN", standardTPath, 500);
//		
//		plot(conf, "At", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING IndexOf");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIndexOf", emftvmTPath, 500);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIndexOfN", standardTPath, 500);
//		
//		plot(conf, "IndexOf", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING First");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestFirst", emftvmTPath, 500);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestFirstN", standardTPath, 500);
//		
//		plot(conf, "First", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING Last");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestLast", emftvmTPath, 500);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestLastN", standardTPath, 500);
//		
//		plot(conf, "Last", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING Suborderedset");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestSubOrderedSet", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestSubOrderedSetN", standardTPath, 300);
//		
//		plot(conf, "Suborderedset", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING InsertAt");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestInsertAt", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestInsertAtN", standardTPath, 100);
//		
//		plot(conf, "InsertAt", EMFTVMTrace, normalTrace, true, savePath);
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
//		System.out.println("TESTING Prepend");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestPrepend", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestPrependN", standardTPath, 300);
//		plot(conf, "Prepend", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING Append");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestAppend", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestAppendN", standardTPath, 300);
//		
//		plot(conf, "Append", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING Reject");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestReject", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestRejectN", standardTPath, 300);
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
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestIsUnique", emftvmTPath, 300);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestIsUniqueN", standardTPath, 300);
//		
//		plot(conf, "isUnique", EMFTVMTrace, normalTrace, true, savePath);
//		breakLine();
//		
//		System.out.println("TESTING sortedBy");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestSortedBy", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestSortedByN", standardTPath, 100);
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
//		System.out.println("TESTING NEQ");
//		EMFTVMTrace = TestQuery(new EMFTVMQueryLauncherFactory(), "TestNeq", emftvmTPath, 100);
//		System.out.println("Now we test with normal ATL");
//		normalTrace = TestQuery(new ATLQueryLauncherFactory(), "TestNeqN", standardTPath, 100);
//		
//		plot(conf, "NEQ", EMFTVMTrace, normalTrace, true, savePath);
//		
		
	}

}
