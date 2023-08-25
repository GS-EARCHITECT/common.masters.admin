package job.job_class_master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import job.job_class_master.model.master.JobClassMaster;

@Repository("jobClassMasterRepo")
public interface JobClassMaster_Repo extends JpaRepository<JobClassMaster, Long> 
{

	@Modifying
	@Query(value = "delete from JOB_CLASS_MASTER  where JOB_CLASS_SEQ_NO in :ids", nativeQuery = true)
	void deleteSelectJobClasses(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * from  JOB_CLASS_MASTER where JOB_CLASS_SEQ_NO in :ids ORDER BY JOB_CLASS_SEQ_NO", nativeQuery = true)
	ArrayList<JobClassMaster> getSelectJobClasses(@Param("jobClassMasterSeqNos") ArrayList<Long> ids);

	
}