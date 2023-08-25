package job.job_class_master.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import job.job_class_master.model.dto.JobClassMaster_DTO;
import job.job_class_master.model.master.JobClassMaster;
import job.job_class_master.model.repo.JobClassMaster_Repo;

@Service("jobClassMasterServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobClassMaster_Service implements I_JobClassMaster_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(JobClassMasterService.class);

	@Autowired
	private JobClassMaster_Repo jobClassMasterRepo;

	@Override
	public JobClassMaster_DTO newJobClass(JobClassMaster_DTO jcmDTO) 
	{
		JobClassMaster JobClassMaster = jobClassMasterRepo.save(this.setJobClassMaster(jcmDTO));
		jcmDTO = getJobClassMaster_DTO(JobClassMaster);
		return jcmDTO;
	}

	@Override
	public ArrayList<JobClassMaster_DTO> getAllJobClasses() 
	{
		ArrayList<JobClassMaster> jobList = (ArrayList<JobClassMaster>) jobClassMasterRepo.findAll();
		ArrayList<JobClassMaster_DTO> jobDTOs = new ArrayList<JobClassMaster_DTO>();
		jobDTOs = jobList != null ? this.getJobClassMaster_DTOs(jobList) : null;
		return jobDTOs;
	}

	@Override
	public ArrayList<JobClassMaster_DTO> getSelectJobClasses(ArrayList<Long> jcmSeqNos) 
{
		ArrayList<JobClassMaster> jobList = (ArrayList<JobClassMaster>) jobClassMasterRepo.getSelectJobClasses(jcmSeqNos);
		ArrayList<JobClassMaster_DTO> jcmDTOs = new ArrayList<JobClassMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobClassMaster_DTOs(jobList) : null;
		return jcmDTOs;
	}

	@Override
	public void updJobClass(JobClassMaster_DTO jcmDTO) 
	{
		JobClassMaster_DTO jobClassMasterDTO2 = null;
		JobClassMaster jobClassMaster2 = null;

		if (jobClassMasterRepo.existsById(jcmDTO.getJobClassSeqNo())) 
		{
			jobClassMaster2 = this.setJobClassMaster(jcmDTO);
			jobClassMasterRepo.save(jobClassMaster2);
		}
	}

	@Override
	public void delAllJobClasses() 
	{
		jobClassMasterRepo.deleteAll();
	}

	@Override
	public void delSelectJobClasses(ArrayList<Long> jcmSeqNos) 
	{
		jobClassMasterRepo.deleteSelectJobClasses(jcmSeqNos);
	}

	private ArrayList<JobClassMaster_DTO> getJobClassMaster_DTOs(ArrayList<JobClassMaster> jobMasters) {
		JobClassMaster_DTO jobDTO = null;
		ArrayList<JobClassMaster_DTO> jobDTOs = new ArrayList<JobClassMaster_DTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getJobClassMaster_DTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private JobClassMaster_DTO getJobClassMaster_DTO(JobClassMaster jobClassMaster2) {
		JobClassMaster_DTO jobClassMasterDTO = new JobClassMaster_DTO();
		jobClassMasterDTO = new JobClassMaster_DTO();
		jobClassMasterDTO.setJobClassSeqNo(jobClassMaster2.getJobClassSeqNo());
		jobClassMasterDTO.setJobClass(jobClassMaster2.getJobClass());
		jobClassMasterDTO.setRemark(jobClassMaster2.getRemark());
		jobClassMasterDTO.setStatus(jobClassMaster2.getStatus());
		return jobClassMasterDTO;
	}

	private JobClassMaster setJobClassMaster(JobClassMaster_DTO cDTO) {
		JobClassMaster jobClassMaster2 = new JobClassMaster();
		jobClassMaster2.setJobClass(cDTO.getJobClass());
		jobClassMaster2.setRemark(cDTO.getRemark());
		jobClassMaster2.setStatus(cDTO.getStatus());
		return jobClassMaster2;
	}
}