package metamodel.connectivity.plainxml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.xml.sax.SAXException;

public class PlainXMLMetamodelDriverUtil {

	protected XML2Ecore xml2EcoreParser = new XML2Ecore();
	protected EcoreFactory factory = xml2EcoreParser.factory;
	protected EcorePackage ecorePackage = EcorePackage.eINSTANCE;

	public EcoreFactory getFactory() {
		return factory;
	}
	
	public EcorePackage getEcorePackage() {
		return ecorePackage;
	}
	
	public EPackage loadModel(String modelString)
	{
		try {
			xml2EcoreParser.parseXMLFromFile(modelString);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xml2EcoreParser.getePackage();
	}
	
	public String removeTag(String fullName)
	{
		if (isXMLSyntax(fullName)) {
			return fullName.substring(2, fullName.length());
		}
		else {
			return fullName;
		}
	}
	
	public boolean isXMLSyntax(String fullName)
	{
		if (fullName.startsWith("a_") || fullName.startsWith("b_") ||
				fullName.startsWith("i_") || fullName.startsWith("f_") || 
				fullName.startsWith("d_") || fullName.startsWith("s_") ||
				fullName.startsWith("t_") || fullName.startsWith("c_") ||
				fullName.startsWith("e_") || fullName.startsWith("x_")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public EDataType getEDataTypeByName(String s)
	{
		if (s.startsWith("b_")) {
			return EcorePackage.eINSTANCE.getEBoolean();
		}
		else if (s.startsWith("f_")) {
			return EcorePackage.eINSTANCE.getEFloat();
		}
		else if (s.startsWith("d_")) {
			return EcorePackage.eINSTANCE.getEDouble();
		}
		else if (s.startsWith("i_")) {
			return EcorePackage.eINSTANCE.getEInt();
		}
		else if (s.startsWith("s_") || s.startsWith("a_")) {
			return EcorePackage.eINSTANCE.getEString();
		}
		return null;
	}
	
	public EAnnotation createAnnotationForWarning(String s)
	{
		EAnnotation annot = xml2EcoreParser.factory.createEAnnotation();
		annot.getDetails().put("warning", s);
		return annot;
	}
	
	public EAnnotation createAnnotationForError(String s)
	{
		EAnnotation annot = xml2EcoreParser.factory.createEAnnotation();
		annot.getDetails().put("error", s);
		return annot;
	}

}
