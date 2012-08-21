/*
 * 
 */
package ewe.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import ewe.EwePackage;
import ewe.diagram.edit.parts.CommitTransactionTaskNameEditPart;
import ewe.diagram.edit.parts.DisposeModelTaskNameEditPart;
import ewe.diagram.edit.parts.EUnitTaskSrcEditPart;
import ewe.diagram.edit.parts.EclTaskSrcEditPart;
import ewe.diagram.edit.parts.EglTaskSrcEditPart;
import ewe.diagram.edit.parts.EmlTaskSrcEditPart;
import ewe.diagram.edit.parts.EolTaskSrcEditPart;
import ewe.diagram.edit.parts.EtlTaskSrcEditPart;
import ewe.diagram.edit.parts.EvlTaskSrcEditPart;
import ewe.diagram.edit.parts.FlockTaskSrcEditPart;
import ewe.diagram.edit.parts.LoadEMFModelTaskNameEditPart;
import ewe.diagram.edit.parts.LoadModelTaskNameEditPart;
import ewe.diagram.edit.parts.LoadXMLModelTaskNameEditPart;
import ewe.diagram.edit.parts.NestedElementNameEditPart;
import ewe.diagram.edit.parts.PropertyNameEditPart;
import ewe.diagram.edit.parts.RollbackTransactionTaskNameEditPart;
import ewe.diagram.edit.parts.StartTransactionTaskNameEditPart;
import ewe.diagram.edit.parts.StoreModelTaskNameEditPart;
import ewe.diagram.edit.parts.TargetNameEditPart;
import ewe.diagram.edit.parts.TaskNameEditPart;
import ewe.diagram.parsers.MessageFormatParser;
import ewe.diagram.part.EweVisualIDRegistry;

/**
 * @generated
 */
public class EweParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser targetName_5020Parser;

	/**
	 * @generated
	 */
	private IParser getTargetName_5020Parser() {
		if (targetName_5020Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTarget_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			targetName_5020Parser = parser;
		}
		return targetName_5020Parser;
	}

	/**
	 * @generated
	 */
	private IParser eolTaskSrc_5001Parser;

	/**
	 * @generated
	 */
	private IParser getEolTaskSrc_5001Parser() {
		if (eolTaskSrc_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getExecutableModelTask_Src() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eolTaskSrc_5001Parser = parser;
		}
		return eolTaskSrc_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser emlTaskSrc_5002Parser;

	/**
	 * @generated
	 */
	private IParser getEmlTaskSrc_5002Parser() {
		if (emlTaskSrc_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getExecutableModelTask_Src() };
			MessageFormatParser parser = new MessageFormatParser(features);
			emlTaskSrc_5002Parser = parser;
		}
		return emlTaskSrc_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser eglTaskSrc_5003Parser;

	/**
	 * @generated
	 */
	private IParser getEglTaskSrc_5003Parser() {
		if (eglTaskSrc_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getExecutableModelTask_Src() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eglTaskSrc_5003Parser = parser;
		}
		return eglTaskSrc_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser etlTaskSrc_5004Parser;

	/**
	 * @generated
	 */
	private IParser getEtlTaskSrc_5004Parser() {
		if (etlTaskSrc_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getExecutableModelTask_Src() };
			MessageFormatParser parser = new MessageFormatParser(features);
			etlTaskSrc_5004Parser = parser;
		}
		return etlTaskSrc_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser evlTaskSrc_5005Parser;

	/**
	 * @generated
	 */
	private IParser getEvlTaskSrc_5005Parser() {
		if (evlTaskSrc_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getExecutableModelTask_Src() };
			MessageFormatParser parser = new MessageFormatParser(features);
			evlTaskSrc_5005Parser = parser;
		}
		return evlTaskSrc_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser loadEMFModelTaskName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getLoadEMFModelTaskName_5006Parser() {
		if (loadEMFModelTaskName_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			loadEMFModelTaskName_5006Parser = parser;
		}
		return loadEMFModelTaskName_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser loadXMLModelTaskName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getLoadXMLModelTaskName_5007Parser() {
		if (loadXMLModelTaskName_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			loadXMLModelTaskName_5007Parser = parser;
		}
		return loadXMLModelTaskName_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser flockTaskSrc_5008Parser;

	/**
	 * @generated
	 */
	private IParser getFlockTaskSrc_5008Parser() {
		if (flockTaskSrc_5008Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getExecutableModelTask_Src() };
			MessageFormatParser parser = new MessageFormatParser(features);
			flockTaskSrc_5008Parser = parser;
		}
		return flockTaskSrc_5008Parser;
	}

	/**
	 * @generated
	 */
	private IParser eUnitTaskSrc_5009Parser;

	/**
	 * @generated
	 */
	private IParser getEUnitTaskSrc_5009Parser() {
		if (eUnitTaskSrc_5009Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getExecutableModelTask_Src() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eUnitTaskSrc_5009Parser = parser;
		}
		return eUnitTaskSrc_5009Parser;
	}

	/**
	 * @generated
	 */
	private IParser eclTaskSrc_5010Parser;

	/**
	 * @generated
	 */
	private IParser getEclTaskSrc_5010Parser() {
		if (eclTaskSrc_5010Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getExecutableModelTask_Src() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eclTaskSrc_5010Parser = parser;
		}
		return eclTaskSrc_5010Parser;
	}

	/**
	 * @generated
	 */
	private IParser loadModelTaskName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getLoadModelTaskName_5011Parser() {
		if (loadModelTaskName_5011Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			loadModelTaskName_5011Parser = parser;
		}
		return loadModelTaskName_5011Parser;
	}

	/**
	 * @generated
	 */
	private IParser storeModelTaskName_5012Parser;

	/**
	 * @generated
	 */
	private IParser getStoreModelTaskName_5012Parser() {
		if (storeModelTaskName_5012Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			storeModelTaskName_5012Parser = parser;
		}
		return storeModelTaskName_5012Parser;
	}

	/**
	 * @generated
	 */
	private IParser rollbackTransactionTaskName_5013Parser;

	/**
	 * @generated
	 */
	private IParser getRollbackTransactionTaskName_5013Parser() {
		if (rollbackTransactionTaskName_5013Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			rollbackTransactionTaskName_5013Parser = parser;
		}
		return rollbackTransactionTaskName_5013Parser;
	}

	/**
	 * @generated
	 */
	private IParser disposeModelTaskName_5014Parser;

	/**
	 * @generated
	 */
	private IParser getDisposeModelTaskName_5014Parser() {
		if (disposeModelTaskName_5014Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			disposeModelTaskName_5014Parser = parser;
		}
		return disposeModelTaskName_5014Parser;
	}

	/**
	 * @generated
	 */
	private IParser startTransactionTaskName_5015Parser;

	/**
	 * @generated
	 */
	private IParser getStartTransactionTaskName_5015Parser() {
		if (startTransactionTaskName_5015Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			startTransactionTaskName_5015Parser = parser;
		}
		return startTransactionTaskName_5015Parser;
	}

	/**
	 * @generated
	 */
	private IParser commitTransactionTaskName_5016Parser;

	/**
	 * @generated
	 */
	private IParser getCommitTransactionTaskName_5016Parser() {
		if (commitTransactionTaskName_5016Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			commitTransactionTaskName_5016Parser = parser;
		}
		return commitTransactionTaskName_5016Parser;
	}

	/**
	 * @generated
	 */
	private IParser propertyName_5017Parser;

	/**
	 * @generated
	 */
	private IParser getPropertyName_5017Parser() {
		if (propertyName_5017Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			propertyName_5017Parser = parser;
		}
		return propertyName_5017Parser;
	}

	/**
	 * @generated
	 */
	private IParser nestedElementName_5018Parser;

	/**
	 * @generated
	 */
	private IParser getNestedElementName_5018Parser() {
		if (nestedElementName_5018Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			nestedElementName_5018Parser = parser;
		}
		return nestedElementName_5018Parser;
	}

	/**
	 * @generated
	 */
	private IParser taskName_5019Parser;

	/**
	 * @generated
	 */
	private IParser getTaskName_5019Parser() {
		if (taskName_5019Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			taskName_5019Parser = parser;
		}
		return taskName_5019Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case TargetNameEditPart.VISUAL_ID:
			return getTargetName_5020Parser();
		case EolTaskSrcEditPart.VISUAL_ID:
			return getEolTaskSrc_5001Parser();
		case EmlTaskSrcEditPart.VISUAL_ID:
			return getEmlTaskSrc_5002Parser();
		case EglTaskSrcEditPart.VISUAL_ID:
			return getEglTaskSrc_5003Parser();
		case EtlTaskSrcEditPart.VISUAL_ID:
			return getEtlTaskSrc_5004Parser();
		case EvlTaskSrcEditPart.VISUAL_ID:
			return getEvlTaskSrc_5005Parser();
		case LoadEMFModelTaskNameEditPart.VISUAL_ID:
			return getLoadEMFModelTaskName_5006Parser();
		case LoadXMLModelTaskNameEditPart.VISUAL_ID:
			return getLoadXMLModelTaskName_5007Parser();
		case FlockTaskSrcEditPart.VISUAL_ID:
			return getFlockTaskSrc_5008Parser();
		case EUnitTaskSrcEditPart.VISUAL_ID:
			return getEUnitTaskSrc_5009Parser();
		case EclTaskSrcEditPart.VISUAL_ID:
			return getEclTaskSrc_5010Parser();
		case LoadModelTaskNameEditPart.VISUAL_ID:
			return getLoadModelTaskName_5011Parser();
		case StoreModelTaskNameEditPart.VISUAL_ID:
			return getStoreModelTaskName_5012Parser();
		case RollbackTransactionTaskNameEditPart.VISUAL_ID:
			return getRollbackTransactionTaskName_5013Parser();
		case DisposeModelTaskNameEditPart.VISUAL_ID:
			return getDisposeModelTaskName_5014Parser();
		case StartTransactionTaskNameEditPart.VISUAL_ID:
			return getStartTransactionTaskName_5015Parser();
		case CommitTransactionTaskNameEditPart.VISUAL_ID:
			return getCommitTransactionTaskName_5016Parser();
		case PropertyNameEditPart.VISUAL_ID:
			return getPropertyName_5017Parser();
		case NestedElementNameEditPart.VISUAL_ID:
			return getNestedElementName_5018Parser();
		case TaskNameEditPart.VISUAL_ID:
			return getTaskName_5019Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(EweVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(EweVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (EweElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
