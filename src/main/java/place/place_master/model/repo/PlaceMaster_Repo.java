package place.place_master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import place.place_master.model.master.PlaceMaster;

@Repository("placeMasterRepo")
public interface PlaceMaster_Repo extends CrudRepository<PlaceMaster, Long> 
{
	@Query(value = "SELECT * FROM PLACE_MASTER a WHERE a.place_category_seq_no in :ids order by place_seq_no", nativeQuery = true)
	ArrayList<PlaceMaster> getSelectPlaces(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM PLACE_MASTER WHERE a.place_type_seq_no in :ids", nativeQuery = true)
	void delSelectPlaces(@Param("ids") ArrayList<Long> ids);
}