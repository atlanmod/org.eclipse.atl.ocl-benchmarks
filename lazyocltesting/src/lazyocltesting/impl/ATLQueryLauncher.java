package lazyocltesting.impl;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;

import lazyocltesting.QueryLauncher;


public class ATLQueryLauncher implements QueryLauncher{

	public ILauncher transformationLauncher;
	public ModelFactory modelFactory;
	public IInjector injector;
	public IReferenceModel SourceMetamodel;
	public IReferenceModel TargetMetamodel;
	
	public final static String PARAM_METAMODEL = "./metamodels/Parameters.ecore";
	public final static String PARAM_METAMODEL_NAME = "Parameters";
	public final static String PARAM_MODEL = "./models/parameters.xmi";
	
	public final static String TRANSFORMATION_DIR = "./transformations/";
	
	Map<String, Object> options = new HashMap<String, Object>();
	
	static ParameterManager pm;
	static Resource inResource;
	static String transformationName;
	
	List<Object> modules = new ArrayList<Object>();

	public static void main(String[] args) throws IOException {

		ATLQueryLauncher l = new ATLQueryLauncher();
		Object query = l.initialize("TestQueryNormal", "./transformations/");
		
		TimingData td = new TimingData();
		l.run(query);
		td.finish();
		System.out.println(td.getFinished());
		
		EObject parameter = pm.getParameterObject("TakeIn");
		pm.setParameterValue(parameter, 40);
		
		td = new TimingData();
		l.run(query);
		td.finish();
		System.out.println(td.getFinished());
	}

	public void load(String sourceMetaModelPath) {
		
		transformationLauncher = new EMFVMLauncher();
		modelFactory = new EMFModelFactory();
		injector = new EMFInjector();

		/*
		 * Load Metamodels
		 */
		try {
			SourceMetamodel = modelFactory.newReferenceModel();
			injector.inject(SourceMetamodel, sourceMetaModelPath);
		} catch (ATLCoreException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Object initialize(String queryName, String transformationDirectiory) {
		
		load(PARAM_METAMODEL);
		
		IModel sourceModel =  null;
		
		try {
			sourceModel = modelFactory.newModel(SourceMetamodel);
			injector.inject(sourceModel, PARAM_MODEL);
			inResource = ((EMFModel)sourceModel).getResource();
		} catch (ATLCoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		transformationLauncher.initialize(new HashMap<String, Object>());
		transformationLauncher.addInModel(sourceModel, "IN", PARAM_METAMODEL_NAME);
			
		
		String inputMetamodelNsURI = Util.lazyMetamodelRegistration(PARAM_METAMODEL);
		pm = new ParameterManager(inputMetamodelNsURI, inResource);
		transformationName = transformationDirectiory + queryName + ".asm";
		
		return transformationLauncher;
	}

	@Override
	public Object run(Object query) {
		try {
			return ((ILauncher)query).launch(ILauncher.RUN_MODE, 
					new NullProgressMonitor(), options, new FileInputStream(transformationName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
				//new FileInputStream(transformationName));
	}

	@Override
	public ParameterManager getParameterManager() {
		return pm;
	}
}
