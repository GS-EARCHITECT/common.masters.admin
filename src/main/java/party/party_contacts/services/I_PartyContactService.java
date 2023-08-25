package party.party_contacts.services;

import java.util.ArrayList;

import party.party_contacts.model.dto.PartyContactDTO;

public interface I_PartyContactService
{
	public PartyContactDTO newPartyContact(PartyContactDTO supplierProdServPriceDTO);
    public ArrayList<PartyContactDTO> getAllPartyContacts();
    public ArrayList<PartyContactDTO> getSelectPartyContacts(ArrayList<Long> ids);
    public ArrayList<PartyContactDTO> getSelectPartyContactsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm);
    public ArrayList<PartyContactDTO> getSelectPartiesByMobiles(ArrayList<Long> mbs);
    public ArrayList<PartyContactDTO> getSelectPartiesByEmail(String eid);
    public ArrayList<PartyContactDTO> getSelectPartiesByLandlines(ArrayList<Long> lls);
	public void updPartyContact(PartyContactDTO customerContactDTO);
    public void delAllPartyContacts();    
	void delSelectPartyContactsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm);
	void delSelectPartyContacts(ArrayList<Long> ids);
	void delSelectPartiesByMobiles(ArrayList<Long> mbs);
	void delSelectPartiesByEmail(String eid);
	void delSelectPartiesByLandlines(ArrayList<Long> lls);
}



