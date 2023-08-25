package party.party_master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import party.party_master.model.master.PartyMaster;

@Repository("partyRepo")
public interface PartyMasterRepo extends JpaRepository<PartyMaster, Long> 
{

	@Query(value = "SELECT * FROM Party_Master a WHERE a.party_SEQ_NO in :ids order by party_SEQ_NO", nativeQuery = true)
	ArrayList<PartyMaster> getSelectParties(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM Party_Master a WHERE a.party_SEQ_NO in :ids", nativeQuery = true)
	void delSelectParties(@Param("ids") ArrayList<Long> ids);

}
