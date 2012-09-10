/**
 * Generated with Acceleo
 */
package ewe.parts;

/**
 * 
 * 
 */
public class EweViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * Project view descriptor
	 * 
	 */
	public static class Project {
		public static class Properties {
	
			
			public static String name = "ewe::Project::properties::name";
			
			
			public static String defaultTarget = "ewe::Project::properties::defaultTarget";
			
	
		}
	
	}

	/**
	 * Task view descriptor
	 * 
	 */
	public static class Task {
		public static class Properties {
	
			
			public static String name = "ewe::Task::properties::name";
			
			
			public static String attributes = "ewe::Task::properties::attributes";
			
			
			public static String taskElements = "ewe::Task::properties::taskElements";
			
	
		}
	
	}

	/**
	 * LoadModelTask view descriptor
	 * 
	 */
	public static class LoadModelTask {
		public static class Properties {
	
			
			public static String name = "ewe::LoadModelTask::properties::name";
			
			
			public static String parameters = "ewe::LoadModelTask::properties::parameters";
			
			
			public static String type = "ewe::LoadModelTask::properties::type";
			
	
		}
	
	}

	/**
	 * StoreModelTask view descriptor
	 * 
	 */
	public static class StoreModelTask {
		public static class Properties {
	
			
			public static String name = "ewe::StoreModelTask::properties::name";
			
			
			public static String model = "ewe::StoreModelTask::properties::model";
			
			
			public static String target = "ewe::StoreModelTask::properties::target";
			
	
		}
	
	}

	/**
	 * ParameterNestedElement view descriptor
	 * 
	 */
	public static class ParameterNestedElement {
		public static class Properties {
	
			
			public static String name = "ewe::ParameterNestedElement::properties::name";
			
			
			public static String value = "ewe::ParameterNestedElement::properties::value";
			
	
		}
	
	}

	/**
	 * VariableNestedElement view descriptor
	 * 
	 */
	public static class VariableNestedElement {
		public static class Properties {
	
			
			public static String ref = "ewe::VariableNestedElement::properties::ref";
			
			
			public static String as = "ewe::VariableNestedElement::properties::as";
			
			
			public static String optional = "ewe::VariableNestedElement::properties::optional";
			
	
		}
	
	}

	/**
	 * ExportsNestedElement view descriptor
	 * 
	 */
	public static class ExportsNestedElement {
		public static class Properties {
	
			
			public static String ref = "ewe::ExportsNestedElement::properties::ref";
			
			
			public static String as = "ewe::ExportsNestedElement::properties::as";
			
			
			public static String optional = "ewe::ExportsNestedElement::properties::optional";
			
	
		}
	
	}

	/**
	 * UsesNestedElement view descriptor
	 * 
	 */
	public static class UsesNestedElement {
		public static class Properties {
	
			
			public static String ref = "ewe::UsesNestedElement::properties::ref";
			
			
			public static String as = "ewe::UsesNestedElement::properties::as";
			
			
			public static String optional = "ewe::UsesNestedElement::properties::optional";
			
	
		}
	
	}

	/**
	 * ModelNestedElement view descriptor
	 * 
	 */
	public static class ModelNestedElement {
		public static class Properties {
	
			
			public static String ref = "ewe::ModelNestedElement::properties::ref";
			
			
			public static String as = "ewe::ModelNestedElement::properties::as";
			
	
		}
	
	}

	/**
	 * RollbackTransactionTask view descriptor
	 * 
	 */
	public static class RollbackTransactionTask {
		public static class Properties {
	
			
			public static String name = "ewe::RollbackTransactionTask::properties::name";
			
	
		}
	
	}

	/**
	 * DisposeModelTask view descriptor
	 * 
	 */
	public static class DisposeModelTask {
		public static class Properties {
	
			
			public static String name = "ewe::DisposeModelTask::properties::name";
			
			
			public static String model = "ewe::DisposeModelTask::properties::model";
			
	
		}
	
	}

	/**
	 * StartTransactionTask view descriptor
	 * 
	 */
	public static class StartTransactionTask {
		public static class Properties {
	
			
			public static String name = "ewe::StartTransactionTask::properties::name";
			
			
			public static String models = "ewe::StartTransactionTask::properties::models";
			
	
		}
	
	}

	/**
	 * EolTask view descriptor
	 * 
	 */
	public static class EolTask {
		public static class Properties {
	
			
			public static String src = "ewe::EolTask::properties::src";
			
			
			public static String exports = "ewe::EolTask::properties::exports";
			
			
			public static String uses = "ewe::EolTask::properties::uses";
			
			
			public static String models = "ewe::EolTask::properties::models";
			
	
		}
	
	}

	/**
	 * EmlTask view descriptor
	 * 
	 */
	public static class EmlTask {
		public static class Properties {
	
			
			public static String src = "ewe::EmlTask::properties::src";
			
			
			public static String exports = "ewe::EmlTask::properties::exports";
			
			
			public static String uses = "ewe::EmlTask::properties::uses";
			
			
			public static String models = "ewe::EmlTask::properties::models";
			
			
			public static String useMatchTrace = "ewe::EmlTask::properties::useMatchTrace";
			
			
			public static String exportTransformationTrace = "ewe::EmlTask::properties::exportTransformationTrace";
			
			
			public static String exportMergeTrace = "ewe::EmlTask::properties::exportMergeTrace";
			
	
		}
	
	}

	/**
	 * EglTask view descriptor
	 * 
	 */
	public static class EglTask {
		public static class Properties {
	
			
			public static String src = "ewe::EglTask::properties::src";
			
			
			public static String exports = "ewe::EglTask::properties::exports";
			
			
			public static String uses = "ewe::EglTask::properties::uses";
			
			
			public static String models = "ewe::EglTask::properties::models";
			
			
			public static String target = "ewe::EglTask::properties::target";
			
	
		}
	
	}

	/**
	 * EtlTask view descriptor
	 * 
	 */
	public static class EtlTask {
		public static class Properties {
	
			
			public static String src = "ewe::EtlTask::properties::src";
			
			
			public static String exports = "ewe::EtlTask::properties::exports";
			
			
			public static String uses = "ewe::EtlTask::properties::uses";
			
			
			public static String models = "ewe::EtlTask::properties::models";
			
			
			public static String exportTransformationTrace = "ewe::EtlTask::properties::exportTransformationTrace";
			
	
		}
	
	}

	/**
	 * EvlTask view descriptor
	 * 
	 */
	public static class EvlTask {
		public static class Properties {
	
			
			public static String src = "ewe::EvlTask::properties::src";
			
			
			public static String exports = "ewe::EvlTask::properties::exports";
			
			
			public static String uses = "ewe::EvlTask::properties::uses";
			
			
			public static String models = "ewe::EvlTask::properties::models";
			
			
			public static String failOnErrors = "ewe::EvlTask::properties::failOnErrors";
			
			
			public static String failOnWarnings = "ewe::EvlTask::properties::failOnWarnings";
			
			
			public static String exportAsModel = "ewe::EvlTask::properties::exportAsModel";
			
			
			public static String exportConstraintTrace = "ewe::EvlTask::properties::exportConstraintTrace";
			
	
		}
	
	}

	/**
	 * CommitTransactionTask view descriptor
	 * 
	 */
	public static class CommitTransactionTask {
		public static class Properties {
	
			
			public static String name = "ewe::CommitTransactionTask::properties::name";
			
	
		}
	
	}

	/**
	 * Target view descriptor
	 * 
	 */
	public static class Target {
		public static class Properties {
	
			
			public static String name = "ewe::Target::properties::name";
			
			
			public static String description = "ewe::Target::properties::description";
			
	
		}
	
	}

	/**
	 * LoadEMFModelTask view descriptor
	 * 
	 */
	public static class LoadEMFModelTask {
		public static class Properties {
	
			
			public static String name = "ewe::LoadEMFModelTask::properties::name";
			
			
			public static String type = "ewe::LoadEMFModelTask::properties::type";
			
			
			public static String modelFile = "ewe::LoadEMFModelTask::properties::modelFile";
			
			
			public static String metamodelFile = "ewe::LoadEMFModelTask::properties::metamodelFile";
			
			
			public static String isMetamodelFileBased = "ewe::LoadEMFModelTask::properties::isMetamodelFileBased";
			
			
			public static String readOnLoad = "ewe::LoadEMFModelTask::properties::readOnLoad";
			
			
			public static String metamodelUri = "ewe::LoadEMFModelTask::properties::metamodelUri";
			
			
			public static String storeOnDisposal = "ewe::LoadEMFModelTask::properties::storeOnDisposal";
			
	
		}
	
	}

	/**
	 * Attribute view descriptor
	 * 
	 */
	public static class Attribute {
		public static class Properties {
	
			
			public static String name = "ewe::Attribute::properties::name";
			
			
			public static String value = "ewe::Attribute::properties::value";
			
	
		}
	
	}

	/**
	 * NestedElement view descriptor
	 * 
	 */
	public static class NestedElement {
		public static class Properties {
	
			
			public static String name = "ewe::NestedElement::properties::name";
			
			
			public static String attributes = "ewe::NestedElement::properties::attributes";
			
			
			public static String taskElements = "ewe::NestedElement::properties::taskElements";
			
	
		}
	
	}

	/**
	 * FlockTask view descriptor
	 * 
	 */
	public static class FlockTask {
		public static class Properties {
	
			
			public static String src = "ewe::FlockTask::properties::src";
			
			
			public static String exports = "ewe::FlockTask::properties::exports";
			
			
			public static String uses = "ewe::FlockTask::properties::uses";
			
			
			public static String models = "ewe::FlockTask::properties::models";
			
			
			public static String originalModel = "ewe::FlockTask::properties::originalModel";
			
			
			public static String migratedModel = "ewe::FlockTask::properties::migratedModel";
			
	
		}
	
	}

	/**
	 * EUnitTask view descriptor
	 * 
	 */
	public static class EUnitTask {
		public static class Properties {
	
			
			public static String src = "ewe::EUnitTask::properties::src";
			
			
			public static String exports = "ewe::EUnitTask::properties::exports";
			
			
			public static String uses = "ewe::EUnitTask::properties::uses";
			
			
			public static String models = "ewe::EUnitTask::properties::models";
			
			
			public static String failOnErrors = "ewe::EUnitTask::properties::failOnErrors";
			
			
			public static String report = "ewe::EUnitTask::properties::report";
			
			
			public static String toDir = "ewe::EUnitTask::properties::toDir";
			
			
			public static String package_ = "ewe::EUnitTask::properties::package";
			
	
		}
	
	}

	/**
	 * EclTask view descriptor
	 * 
	 */
	public static class EclTask {
		public static class Properties {
	
			
			public static String src = "ewe::EclTask::properties::src";
			
			
			public static String exports = "ewe::EclTask::properties::exports";
			
			
			public static String uses = "ewe::EclTask::properties::uses";
			
			
			public static String models = "ewe::EclTask::properties::models";
			
			
			public static String useMatchTrace = "ewe::EclTask::properties::useMatchTrace";
			
			
			public static String exportMatchTrace = "ewe::EclTask::properties::exportMatchTrace";
			
	
		}
	
	}

	/**
	 * DisposeModelsTask view descriptor
	 * 
	 */
	public static class DisposeModelsTask {
		public static class Properties {
	
			
			public static String name = "ewe::DisposeModelsTask::properties::name";
			
	
		}
	
	}

}
