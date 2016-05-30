package lazyocltesting.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

import lazyocltesting.QueryLauncher;

public class EMFTVMQueryLauncher implements QueryLauncher{
	
	public final static String PARAM_METAMODEL = "./metamodels/Parameters.ecore";
	public final static String PARAM_METAMODEL_NAME = "Parameters";
	public final static String PARAM_MODEL = "./models/parameters.xmi";
	
	public final static String TRANSFORMATION_DIR = "./transformations/";
	
	private static String inputMetamodelNsURI;
	static Resource inResource;
	static ParameterManager pm;

	//Main transformation launch method
	public ExecEnv getExecEnv(String inMetamodelPath, String inModelPath, String transformationDir, String transformationModule){

		/* 
		 * Creates the execution environment where the transformation is going to be executed,
		 * you could use an execution pool if you want to run multiple transformations in parallel,
		 * but for the purpose of the example let's keep it simple.
		 */
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		ResourceSet rs = new ResourceSetImpl();

		/*
		 * Load meta-models in the resource set we just created, the idea here is to make the meta-models
		 * available in the context of the execution environment, the ResourceSet is later passed to the
		 * ModuleResolver that is the actual class that will run the transformation.
		 * Notice that we use the nsUris to locate the metamodels in the package registry, we initialize them 
		 * from Ecore files that we registered lazily as shown below in e.g. registerInputMetamodel(...) 
		 */
		registerInputMetamodel(PARAM_METAMODEL);
		Metamodel inMetamodel = EmftvmFactory.eINSTANCE.createMetamodel();
		inMetamodel.setResource(rs.getResource(URI.createURI(inputMetamodelNsURI), true));
		env.registerMetaModel(PARAM_METAMODEL_NAME, inMetamodel);

		/*
		 * Create and register resource factories to read/parse .xmi and .emftvm files,
		 * we need an .xmi parser because our in/output models are .xmi and our transformations are
		 * compiled using the ATL-EMFTV compiler that generates .emftvm files
		 */
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emftvm", new EMFTVMResourceFactoryImpl());

		// Load models
		Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(rs.getResource(URI.createURI(inModelPath, true), true));
		env.registerInputModel("IN", inModel);
		inResource = inModel.getResource(); 

		/*
		 *  Load and run the transformation module
		 *  Point at the directory your transformations are stored, the ModuleResolver will 
		 *  look for the .emftvm file corresponding to the module you want to load and run
		 */
		ModuleResolver mr = new DefaultModuleResolver(transformationDir, rs);
		TimingData td = new TimingData();
		env.loadModule(mr, transformationModule);
		td.finishLoading();
		return env;
	}
	
	public ExecEnv getQuery(String transformationModule, String transformationDirectory){
		return getExecEnv(PARAM_METAMODEL, PARAM_MODEL, transformationDirectory, transformationModule);
		
	}
	
	public void registerInputMetamodel(String inputMetamodelPath){	
		inputMetamodelNsURI = Util.lazyMetamodelRegistration(inputMetamodelPath);
	}

	/*
	 *  A test main method. Not to be used.
	 * 
	 */	
	public static void main(String ... args){
		
		EMFTVMQueryLauncher l = new EMFTVMQueryLauncher();
		Object query = l.initialize("TestQuery", "./transformations/");
		
		EObject parameter = pm.getParameterObject("TakeIn");
		pm.setParameterValue(parameter, 10);
		
		TimingData td = new TimingData();
		l.run(query);
		td.finish();
		System.out.println(td.getFinished());
	
		pm.setParameterValue(parameter, 20);
		
		td = new TimingData();
		l.run(query);
		td.finish();
		System.out.println(td.getFinished());
		
	}

	@Override
	public Object initialize(String queryName, String transformationDirectory) {
		ExecEnv query = getQuery(queryName, transformationDirectory);
		pm = new ParameterManager(inputMetamodelNsURI, inResource);
		return query;
	}

	@Override
	public Object run(Object query) {
		TimingData td = new TimingData();
		return ((ExecEnv)query).run(td);
	}

	@Override
	public ParameterManager getParameterManager() {
		return pm;
	}


}
