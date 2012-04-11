package org.eclipse.epsilon.standalone.service.transform;

import org.eclipse.core.resources.IResourceRuleFactory;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.epsilon.standalone.service.jobs.EglTransformOperationJob;
import org.eclipse.epsilon.standalone.service.jobs.EtlTransformOperationJob;

public class TransformService implements ITransformService {

	public void startup() {
		System.out.println("**** TRANSFORM SERVICE STARTED *****");
	}

	@Override
	public void doEtlTransform(EtlTransformParameters parameters) {
		EtlTransformOperationJob job = EtlTransformOperationJob
				.createJob(parameters);
		executeJob(job);
	}

	@Override
	public void doEglTransform(EglTransformParameters parameters) {
		EglTransformOperationJob job = EglTransformOperationJob
				.createJob(parameters);
		executeJob(job);
	}

	private void executeJob(WorkspaceJob job) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResourceRuleFactory ruleFactory = workspace.getRuleFactory();
		ISchedulingRule rule = ruleFactory.modifyRule(workspace.getRoot());
		job.setUser(true);
		job.setPriority(Job.INTERACTIVE);
		job.setRule(rule);
		job.schedule();
		System.out.println(job.getName() + " done.");
	}

}
