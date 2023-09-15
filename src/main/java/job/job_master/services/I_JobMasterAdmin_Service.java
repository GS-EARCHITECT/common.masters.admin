package job.job_master.services;

import java.util.ArrayList;

import job.job_master.model.dto.JobMaster_DTO;

public interface I_JobMasterAdmin_Service 
{
	public JobMaster_DTO newJobMaster(JobMaster_DTO jcmDTO);
	public void updJobMaster(JobMaster_DTO jcmDTO);
	public ArrayList<JobMaster_DTO> getSelectJobMasters(ArrayList<Long> ids);
	public ArrayList<JobMaster_DTO> getAllJobMasters();
	public void delAllJobMasters();	
	public void delSelectJobMasters(ArrayList<Long> ids);
}