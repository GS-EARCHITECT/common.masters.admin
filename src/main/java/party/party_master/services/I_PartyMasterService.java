package party.party_master.services;

import java.util.ArrayList;

import party.party_master.model.dto.PartyMasterDTO;

public interface I_PartyMasterService 
{
	public PartyMasterDTO newParty(PartyMasterDTO partyDTO);
	public ArrayList<PartyMasterDTO> getAllParties();
	public ArrayList<PartyMasterDTO> getSelectParties(ArrayList<Long> partySeqNos);
	public void updParty(PartyMasterDTO partyDTO);	
	public void delAllParties();
	public void delSelectParties(ArrayList<Long> partySeqNos);
}