package party.party_class.service;

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
import party.party_class.model.dto.PartyClassMaster_DTO;
import party.party_class.model.master.PartyClassMaster;
import party.party_class.model.repo.PartyClassMaster_Repo;

@Service("partyClassMasterServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PartyClassMaster_Service implements I_PartyClassMaster_Service 
{

	@Autowired
	private PartyClassMaster_Repo partyClassMasterRepo;

	public PartyClassMaster_DTO newPartyClass(PartyClassMaster_DTO lMaster) {
		PartyClassMaster PartyClassMaster = partyClassMasterRepo.save(this.setPartyClassMaster(lMaster));
		lMaster = getPartyClassMaster_DTO(PartyClassMaster);
		return lMaster;
	}

	public ArrayList<PartyClassMaster_DTO> getAllPartyClasses() {
		ArrayList<PartyClassMaster> partyList = (ArrayList<PartyClassMaster>) partyClassMasterRepo.findAll();
		ArrayList<PartyClassMaster_DTO> lMasters = new ArrayList<PartyClassMaster_DTO>();
		lMasters = partyList != null ? this.getPartyClassMaster_DTOs(partyList) : null;
		return lMasters;
	}

	public ArrayList<PartyClassMaster_DTO> getSelectPartyClasses(ArrayList<Long> ids) {
		ArrayList<PartyClassMaster> lMasters = (ArrayList<PartyClassMaster>) partyClassMasterRepo.findAllById(ids);
		ArrayList<PartyClassMaster_DTO> partyClassMasterDTOs = new ArrayList<PartyClassMaster_DTO>();
		partyClassMasterDTOs = lMasters != null ? this.getPartyClassMaster_DTOs(lMasters) : null;
		return partyClassMasterDTOs;
	}

	public void updPartyClass(PartyClassMaster_DTO lMaster) {
		PartyClassMaster partyClassMaster = null;
		if (partyClassMasterRepo.existsById(lMaster.getPartyClassSeqNo())) {
			partyClassMaster = this.setPartyClassMaster(lMaster);
			partyClassMaster.setPartyClassSeqNo(lMaster.getPartyClassSeqNo());
			partyClassMasterRepo.save(partyClassMaster);
		}
		return;
	}

	public void delAllPartyClasses() {
		partyClassMasterRepo.deleteAll();
	}

	public void delSelectPartyClasses(ArrayList<Long> partyClassSeqNos) {
		if (partyClassSeqNos != null) {
			partyClassMasterRepo.deleteAllById(partyClassSeqNos);;
		}
	}

	private ArrayList<PartyClassMaster_DTO> getPartyClassMaster_DTOs(ArrayList<PartyClassMaster> lMasters) {
		PartyClassMaster_DTO lDTO = null;
		ArrayList<PartyClassMaster_DTO> lMasterDTOs = new ArrayList<PartyClassMaster_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getPartyClassMaster_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private PartyClassMaster_DTO getPartyClassMaster_DTO(PartyClassMaster lMaster) {
		PartyClassMaster_DTO lDTO = new PartyClassMaster_DTO();
		lDTO.setPartyClassSeqNo(lMaster.getPartyClassSeqNo());
		lDTO.setPartyClass(lMaster.getPartyClass());
		return lDTO;
	}

	private PartyClassMaster setPartyClassMaster(PartyClassMaster_DTO lDTO) {
		PartyClassMaster lMaster = new PartyClassMaster();
		lMaster.setPartyClass(lDTO.getPartyClass());
		return lMaster;
	}
}