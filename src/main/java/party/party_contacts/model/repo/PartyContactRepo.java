package party.party_contacts.model.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import party.party_contacts.model.master.PartyContact;
import party.party_contacts.model.master.PartyContactPK;

@Repository("partyContactRepo")
public interface PartyContactRepo extends JpaRepository<PartyContact, PartyContactPK> 
{

	@Query(value = "SELECT * FROM Party_Contacts a WHERE ((a.CUSTOMER_SEQ_NO in :ids) and (a.ON_DTTM BETWEEN :frDtTm  and :toDtTm)) order by a.CUSTOMER_SEQ_NO", nativeQuery = true)
	ArrayList<PartyContact> getSelectPartyContactsBetweenTimes(@Param("ids") ArrayList<Long> ids, @Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
	
	@Query(value = "SELECT * FROM Party_Contacts a WHERE a.CUSTOMER_SEQ_NO in :ids order by CUSTOMER_SEQ_NO", nativeQuery = true)
	ArrayList<PartyContact> getSelectPartyContacts(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM Party_Contacts a WHERE MOBILE_NO in :mbs order by CUSTOMER_SEQ_NO", nativeQuery = true)
	ArrayList<PartyContact> getSelectPartiesByMobiles(@Param("mbs") ArrayList<Long> mbs);

	@Query(value = "SELECT * FROM Party_Contacts a WHERE upper(trim(a.email_id)) = upper(trim(:eid)) order by CUSTOMER_SEQ_NO", nativeQuery = true)
	ArrayList<PartyContact> getSelectPartiesByEmail(@Param("eid") String eid);
	
	@Query(value = "SELECT * FROM Party_Contacts a WHERE a.landline in :lls order by CUSTOMER_SEQ_NO", nativeQuery = true)
	ArrayList<PartyContact> getSelectPartiesByLandlines(@Param("lls") ArrayList<Long> lls);
	
	@Query(value = "DELETE FROM Party_Contacts a WHERE ((a.CUSTOMER_SEQ_NO in :ids) and (a.ON_DTTM BETWEEN :frDtTm  and :toDtTm)) order by a.CUSTOMER_SEQ_NO", nativeQuery = true)
	void delSelectPartyContactsBetweenTimes(@Param("ids") ArrayList<Long> ids, @Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
	
	@Query(value = "DELETE FROM Party_Contacts a WHERE a.CUSTOMER_SEQ_NO in :ids order by CUSTOMER_SEQ_NO", nativeQuery = true)
	void delSelectPartyContacts(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM Party_Contacts a WHERE MOBILE_NO in :mbs order by CUSTOMER_SEQ_NO", nativeQuery = true)
	void delSelectPartiesByMobiles(@Param("mbs") ArrayList<Long> mbs);

	@Query(value = "DELETE FROM Party_Contacts a WHERE upper(trim(a.email_id)) = upper(trim(:eid)) order by CUSTOMER_SEQ_NO", nativeQuery = true)
	void delSelectPartiesByEmail(@Param("eid") String eid);
	
	@Query(value = "DELETE FROM Party_Contacts a WHERE a.landline in :lls order by CUSTOMER_SEQ_NO", nativeQuery = true)
	void delSelectPartiesByLandlines(@Param("lls") ArrayList<Long> lls);
}
