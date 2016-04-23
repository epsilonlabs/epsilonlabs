package uk.ac.york.mondo.integration.server.ifcexport.servlet.config;

import java.util.HashMap;
import java.util.Set;

import uk.ac.york.mondo.integration.api.IFCExportJob;
import uk.ac.york.mondo.integration.api.IFCExportStatus;

public class IFCExportManager {

	private static IFCExportManager instance = new IFCExportManager();
	
	private IFCExportManager(){}
	
	public static IFCExportManager getInstance()
	{
		if(instance == null)
		{
			instance = new IFCExportManager();
			return instance;
		}
		return instance;
	}
	protected JobIDGenerator jobIDGen = new JobIDGenerator();
	protected HashMap<IFCExportJob, IFCExportRequest> request_map = new HashMap<>();
	protected HashMap<IFCExportJob, IFCExportJobExecutor> executor_map = new HashMap<>();
	
	public IFCExportJob postRequest(IFCExportRequest request)
	{
		if (request_map.values().contains(request)) {
			for(IFCExportJob job: request_map.keySet())
			{
				if(request_map.get(job).equals(request))
				{
					return job;
				}
			}
			return null;
		}
		else {
			String jobID = jobIDGen.nextSessionId();
			IFCExportJob job = new IFCExportJob(jobID, IFCExportStatus.SCHEDULED, "added to queue");
			IFCExportJobExecutor exe_thread = new IFCExportJobExecutor(job, request);
			exe_thread.addJobChangeListener(new IFCExportJobChangeListener(job));
			request_map.put(job, request);
			exe_thread.schedule();
			executor_map.put(job, exe_thread);
			return job;
		}
	}
	
	public Set<IFCExportJob> getJobs()
	{
		return request_map.keySet();
	}
	
	public IFCExportJob getJob(String jobID)
	{
		for(IFCExportJob job: request_map.keySet())
		{
			if(job.getJobID().equals(jobID))
			{
				return job;
			}
		}
		return null;
	}
	
	public IFCExportJob getJobStatus(String jobID)
	{
		IFCExportJob job = getJob(jobID);
		if(job != null)
		{
			return job;
		}
		return null;
	}
	
	public boolean killJob(String jobID)
	{
		IFCExportJob job = getJob(jobID);
		if(job == null)
		{
			return false;
		}
		else
		{
			IFCExportJobExecutor executor = executor_map.get(job);
			if(executor != null)
			{
				executor.cancel();
				job.setStatus(IFCExportStatus.CANCELLED);
				return true;
			}
			else {
				return false;
			}
		}
	}

}
