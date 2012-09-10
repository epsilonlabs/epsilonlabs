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
import ewe.diagram.edit.parts.DisposeModelsTaskNameEditPart;
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
import ewe.diagram.edit.parts.NestedElementNameEditPart;
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
	private IParser targetName_5019Parser;

	/**
	 * @generated
	 */
	private IParser getTargetName_5019Parser() {
		if (targetName_5019Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTarget_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			targetName_5019Parser = parser;
		}
		return targetName_5019Parser;
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
	private IParser flockTaskSrc_5007Parser;

	/**
	 * @generated
	 */
	private IParser getFlockTaskSrc_5007Parser() {
		if (flockTaskSrc_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getExecutableModelTask_Src() };
			MessageFormatParser parser = new MessageFormatParser(features);
			flockTaskSrc_5007Parser = parser;
		}
		return flockTaskSrc_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser eUnitTaskSrc_5008Parser;

	/**
	 * @generated
	 */
	private IParser getEUnitTaskSrc_5008Parser() {
		if (eUnitTaskSrc_5008Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getExecutableModelTask_Src() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eUnitTaskSrc_5008Parser = parser;
		}
		return eUnitTaskSrc_5008Parser;
	}

	/**
	 * @generated
	 */
	private IParser eclTaskSrc_5009Parser;

	/**
	 * @generated
	 */
	private IParser getEclTaskSrc_5009Parser() {
		if (eclTaskSrc_5009Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getExecutableModelTask_Src() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eclTaskSrc_5009Parser = parser;
		}
		return eclTaskSrc_5009Parser;
	}

	/**
	 * @generated
	 */
	private IParser loadModelTaskName_5010Parser;

	/**
	 * @generated
	 */
	private IParser getLoadModelTaskName_5010Parser() {
		if (loadModelTaskName_5010Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			loadModelTaskName_5010Parser = parser;
		}
		return loadModelTaskName_5010Parser;
	}

	/**
	 * @generated
	 */
	private IParser storeModelTaskName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getStoreModelTaskName_5011Parser() {
		if (storeModelTaskName_5011Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			storeModelTaskName_5011Parser = parser;
		}
		return storeModelTaskName_5011Parser;
	}

	/**
	 * @generated
	 */
	private IParser rollbackTransactionTaskName_5012Parser;

	/**
	 * @generated
	 */
	private IParser getRollbackTransactionTaskName_5012Parser() {
		if (rollbackTransactionTaskName_5012Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			rollbackTransactionTaskName_5012Parser = parser;
		}
		return rollbackTransactionTaskName_5012Parser;
	}

	/**
	 * @generated
	 */
	private IParser disposeModelTaskName_5013Parser;

	/**
	 * @generated
	 */
	private IParser getDisposeModelTaskName_5013Parser() {
		if (disposeModelTaskName_5013Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			disposeModelTaskName_5013Parser = parser;
		}
		return disposeModelTaskName_5013Parser;
	}

	/**
	 * @generated
	 */
	private IParser startTransactionTaskName_5014Parser;

	/**
	 * @generated
	 */
	private IParser getStartTransactionTaskName_5014Parser() {
		if (startTransactionTaskName_5014Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			startTransactionTaskName_5014Parser = parser;
		}
		return startTransactionTaskName_5014Parser;
	}

	/**
	 * @generated
	 */
	private IParser commitTransactionTaskName_5015Parser;

	/**
	 * @generated
	 */
	private IParser getCommitTransactionTaskName_5015Parser() {
		if (commitTransactionTaskName_5015Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			commitTransactionTaskName_5015Parser = parser;
		}
		return commitTransactionTaskName_5015Parser;
	}

	/**
	 * @generated
	 */
	private IParser disposeModelsTaskName_5016Parser;

	/**
	 * @generated
	 */
	private IParser getDisposeModelsTaskName_5016Parser() {
		if (disposeModelsTaskName_5016Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			disposeModelsTaskName_5016Parser = parser;
		}
		return disposeModelsTaskName_5016Parser;
	}

	/**
	 * @generated
	 */
	private IParser nestedElementName_5017Parser;

	/**
	 * @generated
	 */
	private IParser getNestedElementName_5017Parser() {
		if (nestedElementName_5017Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			nestedElementName_5017Parser = parser;
		}
		return nestedElementName_5017Parser;
	}

	/**
	 * @generated
	 */
	private IParser taskName_5018Parser;

	/**
	 * @generated
	 */
	private IParser getTaskName_5018Parser() {
		if (taskName_5018Parser == null) {
			EAttribute[] features = new EAttribute[] { EwePackage.eINSTANCE
					.getTask_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			taskName_5018Parser = parser;
		}
		return taskName_5018Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case TargetNameEditPart.VISUAL_ID:
			return getTargetName_5019Parser();
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
		case FlockTaskSrcEditPart.VISUAL_ID:
			return getFlockTaskSrc_5007Parser();
		case EUnitTaskSrcEditPart.VISUAL_ID:
			return getEUnitTaskSrc_5008Parser();
		case EclTaskSrcEditPart.VISUAL_ID:
			return getEclTaskSrc_5009Parser();
		case LoadModelTaskNameEditPart.VISUAL_ID:
			return getLoadModelTaskName_5010Parser();
		case StoreModelTaskNameEditPart.VISUAL_ID:
			return getStoreModelTaskName_5011Parser();
		case RollbackTransactionTaskNameEditPart.VISUAL_ID:
			return getRollbackTransactionTaskName_5012Parser();
		case DisposeModelTaskNameEditPart.VISUAL_ID:
			return getDisposeModelTaskName_5013Parser();
		case StartTransactionTaskNameEditPart.VISUAL_ID:
			return getStartTransactionTaskName_5014Parser();
		case CommitTransactionTaskNameEditPart.VISUAL_ID:
			return getCommitTransactionTaskName_5015Parser();
		case DisposeModelsTaskNameEditPart.VISUAL_ID:
			return getDisposeModelsTaskName_5016Parser();
		case NestedElementNameEditPart.VISUAL_ID:
			return getNestedElementName_5017Parser();
		case TaskNameEditPart.VISUAL_ID:
			return getTaskName_5018Parser();
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
