package place.place_class.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import place.place_class.model.master.PlaceClassMaster;

@Repository("placeClassMasterRepo")
public interface PlaceClassMaster_Repo extends CrudRepository<PlaceClassMaster, Long> 
{
	@Query(value = "SELECT * FROM PLACE_CLASS_MASTER a WHERE a.place_class_seq_no in :ids order by place_class_seq_no", nativeQuery = true)
	ArrayList<PlaceClassMaster> getSelectPlaceClasses(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM PLACE_CLASS_MASTER a WHERE a.place_class_seq_no in :ids", nativeQuery = true)
	void delSelectPlaceClasses(@Param("ids") ArrayList<Long> ids);
}
