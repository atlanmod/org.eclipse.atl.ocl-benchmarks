package lazyocltesting.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

public class ParameterManager {
	
	private String inputMetamodelNsURI;
	private Resource inResource;

	public ParameterManager(String inputMetamodelNsURI, Resource inResource) {
		super();
		this.inputMetamodelNsURI = inputMetamodelNsURI;
		this.inResource = inResource;
	}

	public EObject getParameterObject(String name){
		
		EObject root = inResource.getContents().get(0);
		EList<EObject> parameters = root.eContents();
		
		EPackage inputPackage = (EPackage) root.eClass().eContainer();
		
		//EPackage inputPackage = EPackage.Registry.INSTANCE.getEPackage(inputMetamodelNsURI);
		EClass parameterClass = (EClass) inputPackage.getEClassifier("Parameter");
		
		EStructuralFeature feature = parameterClass.getEStructuralFeature("name");
		for(EObject p : parameters){
			if ( ((String)p.eGet(feature)).equals(name))
				return p;
		}
		return null;
	}
	
	//Ideally, we should create a parameter Object class to avoid code repetition
	public Object getParameterValue(EObject p){
		EPackage inputPackage = EPackage.Registry.INSTANCE.getEPackage(inputMetamodelNsURI);
		EClass parameterClass = (EClass) inputPackage.getEClassifier("Parameter");
		EStructuralFeature feature = parameterClass.getEStructuralFeature("value");
		return p.eGet(feature);
	}
	
	public void setParameterValue(EObject p, Object value){
		//EPackage inputPackage = EPackage.Registry.INSTANCE.getEPackage(inputMetamodelNsURI);
		
		EPackage inputPackage = (EPackage) p.eClass().eContainer();
		EClass parameterClass = (EClass) inputPackage.getEClassifier("Parameter");
		EStructuralFeature feature = parameterClass.getEStructuralFeature("value");
		p.eSet(feature, value);
	}

	public Resource getInResource() {
		return inResource;
	}

	public void setInResource(Resource inResource) {
		this.inResource = inResource;
	}

}
