package resource.resource_class.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import resource.resource_class.model.master.ResourceClassMaster;

@Repository("resourceClassMasterRepo")
public interface ResourceClassMasterRepo extends CrudRepository<ResourceClassMaster, Long> 
{
	@Query(value = "SELECT * FROM RESOURCE_CLASS_MASTER a WHERE a.resource_class_seq_no in :ids order by resource_class_seq_no", nativeQuery = true)
	ArrayList<ResourceClassMaster> getSelectResourceClasses(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM RESOURCE_CLASS_MASTER a WHERE a.resource_class_seq_no in :ids", nativeQuery = true)
	void delSelectResourceClasses(@Param("ids") ArrayList<Long> ids);
}
