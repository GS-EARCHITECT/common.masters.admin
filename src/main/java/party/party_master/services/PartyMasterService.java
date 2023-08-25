package party.party_master.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import party.party_master.model.dto.PartyMasterDTO;
import party.party_master.model.master.PartyMaster;
import party.party_master.model.repo.PartyMasterRepo;

@Service("partyServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PartyMasterService implements I_PartyMasterService {
	// private static final Logger logger =
	// LoggerFactory.getLogger(PartyMasterService.class);

	@Autowired
	private PartyMasterRepo partyRepo;

	public PartyMasterDTO newParty(PartyMasterDTO cDTO) {
		if (!partyRepo.existsById(cDTO.getPartySeqNo())) {
			PartyMaster partyMaster = partyRepo.save(this.setPartyMaster(cDTO));
			cDTO = getPartyMasterDTO(partyMaster);
		}
		return cDTO;
	}

	public ArrayList<PartyMasterDTO> getAllParties() {
		ArrayList<PartyMaster> partyList = (ArrayList<PartyMaster>) partyRepo.findAll();
		ArrayList<PartyMasterDTO> cDTOs = new ArrayList<PartyMasterDTO>();
		cDTOs = partyList != null ? this.getPartyMasterDtos(partyList) : null;
		return cDTOs;
	}

	public ArrayList<PartyMasterDTO> getSelectParties(ArrayList<Long> partySeqNos) {
		ArrayList<PartyMasterDTO> cDTOs = new ArrayList<PartyMasterDTO>();
		PartyMasterDTO partyMasterDTO = null;
		ArrayList<PartyMaster> partyMasters = (ArrayList<PartyMaster>) partyRepo.findAll();
		cDTOs = partyMasters != null ? this.getPartyMasterDtos(partyMasters) : null;
		return cDTOs;
	}

	public void updParty(PartyMasterDTO cDTO) {
		if (partyRepo.existsById(cDTO.getPartySeqNo())) {
			partyRepo.save(this.setPartyMaster(cDTO));
		}
		return;
	}

	public void delAllParties() {
		partyRepo.deleteAll();
	}

	public void delSelectParties(ArrayList<Long> partySeqNos) 
	{
		partyRepo.delSelectParties(partySeqNos);

	}

	private ArrayList<PartyMasterDTO> getPartyMasterDtos(ArrayList<PartyMaster> cMasters) {
		PartyMasterDTO cDTO = null;
		ArrayList<PartyMasterDTO> cDTOs = new ArrayList<PartyMasterDTO>();

		for (int i = 0; i < cMasters.size(); i++) 
		{
			cDTO = this.getPartyMasterDTO(cMasters.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private PartyMasterDTO getPartyMasterDTO(PartyMaster cMaster) {
		PartyMasterDTO cDTO = null;
		cDTO = new PartyMasterDTO();
		cDTO.setPartySeqNo(cMaster.getPartySeqNo());
		cDTO.setParty(cMaster.getParty());
		cDTO.setPartyId(cMaster.getPartyId());			
		cDTO.setRemark(cMaster.getRemark());
		cDTO.setStatus(cMaster.getStatus());
		return cDTO;
	}

	private PartyMaster setPartyMaster(PartyMasterDTO cDTO) {
		PartyMaster cMaster = new PartyMaster();
		cMaster.setParty(cDTO.getParty());
		cMaster.setPartyId(cMaster.getPartyId());			
		cMaster.setRemark(cMaster.getRemark());
		cMaster.setStatus(cMaster.getStatus());
		return cMaster;
	}

}