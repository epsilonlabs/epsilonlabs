package org.eclipse.epsilon.standalone.service.transform;

import org.eclipse.core.resources.IResourceRuleFactory;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.epsilon.standalone.service.jobs.EtlTransformOperationJob;

public class TransformService implements ITransformService {

	private EtlTransformOperationJob job;

	public void startup() {
		System.out.println("**** TRANSFORM SERVICE STARTED *****");
	}

	@Override
	public void doEtlTransform(EtlTransformParameters etlTransformparameters) {

		job = EtlTransformOperationJob.createJob(etlTransformparameters);
		executeJob();
		System.out.println("Transform done");
	}

	private void executeJob() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResourceRuleFactory ruleFactory = workspace.getRuleFactory();
		ISchedulingRule rule = ruleFactory.modifyRule(workspace.getRoot());
		job.setUser(true);
		job.setPriority(Job.INTERACTIVE);
		job.setRule(rule);
		job.schedule();
	}

}
