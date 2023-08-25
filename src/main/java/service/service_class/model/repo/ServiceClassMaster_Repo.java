package service.service_class.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import service_class.model.master.ServiceClassMaster;

@Repository("serviceClassMasterRepo")
public interface ServiceClassMaster_Repo extends JpaRepository<ServiceClassMaster, Long> 
{
	@Query(value = "SELECT * FROM SERVICE_CLASS_MASTER a WHERE a.service_class_seq_no in :ids order by service_class_seq_no", nativeQuery = true)
	ArrayList<ServiceClassMaster> getSelectServiceClasses(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM SERVICE_CLASS_MASTER a WHERE a.service_class_seq_no in :ids", nativeQuery = true)
	void delSelectServiceClasses(@Param("ids") ArrayList<Long> ids);
}
