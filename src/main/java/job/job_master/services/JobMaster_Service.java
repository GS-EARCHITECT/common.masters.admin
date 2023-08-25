package job.job_master.services;

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
import job.job_master.model.dto.JobMaster_DTO;
import job.job_master.model.master.JobMaster;
import job.job_master.model.repo.JobMaster_Repo;

@Service("jobMasterServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobMaster_Service implements I_JobMaster_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(JobMasterService.class);

	@Autowired
	private JobMaster_Repo jobMasterRepo;

	@Override
	public JobMaster_DTO newJobMaster(JobMaster_DTO jcmDTO) 
	{
		if(!jobMasterRepo.existsById(jcmDTO.getMasterJobSeqNo()))
		{
		jcmDTO = this.getJobMaster_DTO(jobMasterRepo.save(this.setMasterJobMaster(jcmDTO)));
		}
		return jcmDTO;
	}

	@Override
	public void updJobMaster(JobMaster_DTO jcmDTO) 
	{
		JobMaster JobMaster = null;

		if (jobMasterRepo.existsById(jcmDTO.getMasterJobSeqNo())) 
		{
			JobMaster = this.setMasterJobMaster(jcmDTO);
			JobMaster.setMasterJobSeqNo(jcmDTO.getMasterJobSeqNo());
			jobMasterRepo.save(JobMaster);
		}
	}

	
	@Override
	public ArrayList<JobMaster_DTO> getAllJobMasters() 
	{
		ArrayList<JobMaster> jobList = (ArrayList<JobMaster>) jobMasterRepo.findAll();
		ArrayList<JobMaster_DTO> jobDTOs = new ArrayList<JobMaster_DTO>();
		jobDTOs = jobList != null ? this.getJobMaster_DTOs(jobList) : null;
		return jobDTOs;
	}

	@Override
	public ArrayList<JobMaster_DTO> getSelectJobMasters(ArrayList<Long> jcmSeqNos) 
{
		ArrayList<JobMaster> jobList = (ArrayList<JobMaster>) jobMasterRepo.findAllById(jcmSeqNos);
		ArrayList<JobMaster_DTO> jcmDTOs = new ArrayList<JobMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobMaster_DTOs(jobList) : null;
		return jcmDTOs;
	}

	@Override
	public void delAllJobMasters() 
	{
		jobMasterRepo.deleteAll();
	}

	@Override
	public void delSelectJobMasters(ArrayList<Long> jcmSeqNos) 
	{
		jobMasterRepo.deleteAllById(jcmSeqNos); 
	}

	private ArrayList<JobMaster_DTO> getJobMaster_DTOs(ArrayList<JobMaster> JobMasters) 
	{
		JobMaster_DTO jobDTO = null;
		ArrayList<JobMaster_DTO> jobDTOs = new ArrayList<JobMaster_DTO>();

		for (int i = 0; i < JobMasters.size(); i++) {
			jobDTO = getJobMaster_DTO(JobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private JobMaster_DTO getJobMaster_DTO(JobMaster jobMaster) 
	{
		JobMaster_DTO jobMasterDTO = new JobMaster_DTO();
		jobMasterDTO = new JobMaster_DTO();		
		jobMasterDTO.setMasterJobSeqNo(jobMaster.getMasterJobSeqNo());
		jobMasterDTO.setDescription(jobMaster.getDescription());
		jobMasterDTO.setJob(jobMaster.getJob());
		jobMasterDTO.setSpecificationSeqNo(jobMaster.getSpecificationSeqNo());		
		return jobMasterDTO;
	}

	private JobMaster setMasterJobMaster(JobMaster_DTO cDTO) 
	{
		JobMaster jobMaster = new JobMaster();
		jobMaster.setDescription(cDTO.getDescription());
		jobMaster.setJob(cDTO.getJob());
		jobMaster.setSpecificationSeqNo(cDTO.getSpecificationSeqNo());
		return jobMaster;
	}
}