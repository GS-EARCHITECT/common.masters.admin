package job.job_master.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import job.job_master.model.master.JobMaster;

@Repository("jobMasterRepo")
public interface JobMaster_Repo extends JpaRepository<JobMaster, Long> 
{}