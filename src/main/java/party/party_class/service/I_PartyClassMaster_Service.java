package party.party_class.service;

import java.util.ArrayList;
import party.party_class.model.dto.PartyClassMaster_DTO;

public interface I_PartyClassMaster_Service
{
    abstract public PartyClassMaster_DTO newPartyClass(PartyClassMaster_DTO partyClassMasterDTO);
    abstract public ArrayList<PartyClassMaster_DTO> getAllPartyClasses();    
    abstract public ArrayList<PartyClassMaster_DTO> getSelectPartyClasses(ArrayList<Long> ids);
    abstract public void updPartyClass(PartyClassMaster_DTO partyClassMasterDTO);
    abstract public void delAllPartyClasses();    
    abstract public void delSelectPartyClasses(ArrayList<Long> ids);
}