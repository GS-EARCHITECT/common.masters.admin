package party.party_class.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import party.party_class.model.master.PartyClassMaster;

@Repository("partyClassMasterRepo")
public interface PartyClassMaster_Repo extends JpaRepository<PartyClassMaster, Long> 
{}
