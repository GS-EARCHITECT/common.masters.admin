package party.party_contacts.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import party.party_contacts.model.dto.PartyContactDTO;
import party.party_contacts.model.master.PartyContact;
import party.party_contacts.model.master.PartyContactPK;
import party.party_contacts.model.repo.PartyContactRepo;

@Service("partyContactServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PartyContactService implements I_PartyContactService 
{

	@Autowired
	private PartyContactRepo partyContactRepo;

	public PartyContactDTO newPartyContact(PartyContactDTO lPartyContact) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime onDateTime = LocalDateTime.parse(lPartyContact.getOnDttm(), formatter);		
		Timestamp onTS = Timestamp.valueOf(onDateTime);		
		PartyContactPK partyContactPK = new PartyContactPK();
		partyContactPK.setPartySeqNo(lPartyContact.getPartySeqNo());
		partyContactPK.setEmailId(lPartyContact.getEmailId());
		partyContactPK.setLandline(lPartyContact.getLandline());
		partyContactPK.setMobileNo(lPartyContact.getMobileNo());		
		partyContactPK.setOnDttm(onTS);		
		PartyContact partyContact = null;

		if (!partyContactRepo.existsById(partyContactPK)) {
			partyContact = this.setPartyContact(lPartyContact);
			partyContact.setId(partyContactPK);
			lPartyContact = getPartyContactDTO(partyContactRepo.save(partyContact));
		}
		return lPartyContact;
	}

	public ArrayList<PartyContactDTO> getAllPartyContacts() {
		ArrayList<PartyContact> supplierList = (ArrayList<PartyContact>) partyContactRepo.findAll();
		ArrayList<PartyContactDTO> lPartyContacts = new ArrayList<PartyContactDTO>();
		lPartyContacts = supplierList != null ? this.getPartyContactDTOs(supplierList) : null;
		return lPartyContacts;
	}

	public ArrayList<PartyContactDTO> getSelectPartyContactsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime frDateTime = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime toDateTime = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(frDateTime);
		Timestamp toTsTimestamp = Timestamp.valueOf(toDateTime);
		ArrayList<PartyContact> partyContacts = partyContactRepo.getSelectPartyContactsBetweenTimes(ids, frTsTimestamp, toTsTimestamp);
		ArrayList<PartyContactDTO> partyContactDTOs = partyContacts != null	? this.getPartyContactDTOs(partyContacts) : null;
		return partyContactDTOs;

	}
	
	public ArrayList<PartyContactDTO> getSelectPartyContacts(ArrayList<Long> ids) 
	{
		ArrayList<PartyContact> lPartyContact = partyContactRepo.getSelectPartyContacts(ids);				
		ArrayList<PartyContactDTO> partyContactDTOs = lPartyContact != null	? this.getPartyContactDTOs(lPartyContact): null;
		return partyContactDTOs;
	}
	
	public ArrayList<PartyContactDTO> getSelectPartiesByLandlines(ArrayList<Long> lls)
	{
			ArrayList<PartyContact> lPartyContact = partyContactRepo.getSelectPartiesByLandlines(lls);
			ArrayList<PartyContactDTO> partyContactDTOs = lPartyContact != null	? this.getPartyContactDTOs(lPartyContact): null;
			return partyContactDTOs;
	}
	    
	    
	public ArrayList<PartyContactDTO> getSelectPartiesByEmail(String eid)
	{
		ArrayList<PartyContact> lPartyContact = partyContactRepo.getSelectPartiesByEmail(eid);
		ArrayList<PartyContactDTO> partyContactDTOs = lPartyContact != null	? this.getPartyContactDTOs(lPartyContact): null;
		return partyContactDTOs;
	}
	
    public ArrayList<PartyContactDTO> getSelectPartiesByMobiles(ArrayList<Long> mbs)
	{
		ArrayList<PartyContact> lPartyContact = partyContactRepo.getSelectPartiesByMobiles(mbs);
		ArrayList<PartyContactDTO> partyContactDTOs = lPartyContact != null	? this.getPartyContactDTOs(lPartyContact): null;
		return partyContactDTOs;
	}

	public void updPartyContact(PartyContactDTO lPartyContact) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		Timestamp onTS = Timestamp.valueOf(lPartyContact.getOnDttm());		
		PartyContactPK partyContactPK = new PartyContactPK();
		partyContactPK.setPartySeqNo(lPartyContact.getPartySeqNo());
		partyContactPK.setEmailId(lPartyContact.getEmailId());
		partyContactPK.setLandline(lPartyContact.getLandline());
		partyContactPK.setMobileNo(lPartyContact.getMobileNo());		
		partyContactPK.setOnDttm(onTS);		
		PartyContact partyContact = null;
		
		if (partyContactRepo.existsById(partyContactPK)) 
		{
			partyContactRepo.save(this.setPartyContact(lPartyContact));
		}
		return;
	}

	public void delSelectPartyContactsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime frDateTime = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime toDateTime = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(frDateTime);
		Timestamp toTsTimestamp = Timestamp.valueOf(toDateTime);		
		partyContactRepo.delSelectPartyContactsBetweenTimes(ids, frTsTimestamp, toTsTimestamp);
		return;
	}

	
	public void delSelectPartyContacts(ArrayList<Long> ids)
	{
		partyContactRepo.delSelectPartyContacts(ids);		
		return;
	}

	public void delSelectPartiesByMobiles(ArrayList<Long> mbs) 
	{
		partyContactRepo.delSelectPartiesByMobiles(mbs);		
		return;
	}
	
	
	public void delSelectPartiesByEmail(String eid) 
	{
		partyContactRepo.delSelectPartiesByEmail(eid);		
		return;
	}

	public void delSelectPartiesByLandlines(ArrayList<Long> lls) 
	{
		partyContactRepo.delSelectPartiesByLandlines(lls);		
		return;
	}
	
	public void delAllPartyContacts() {
		partyContactRepo.deleteAll();
	}

	private ArrayList<PartyContactDTO> getPartyContactDTOs(
			ArrayList<PartyContact> lPartyContact) {
		PartyContactDTO lDTO = null;
		ArrayList<PartyContactDTO> lPartyContactDTOs = new ArrayList<PartyContactDTO>();
		for (int i = 0; i < lPartyContact.size(); i++) {
			lDTO = getPartyContactDTO(lPartyContact.get(i));
			lPartyContactDTOs.add(lDTO);
		}
		return lPartyContactDTOs;
	}

	private PartyContactDTO getPartyContactDTO(PartyContact lPartyContact) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		PartyContactDTO lDTO = new PartyContactDTO();
		lDTO.setOnDttm(formatter.format(lPartyContact.getId().getOnDttm().toLocalDateTime()));
		lDTO.setPartySeqNo(lPartyContact.getId().getPartySeqNo());
		lDTO.setEmailId(lPartyContact.getId().getEmailId());
		lDTO.setLandline(lPartyContact.getId().getLandline());
		lDTO.setMobileNo(lPartyContact.getId().getMobileNo());
		lDTO.setStatus(lPartyContact.getStatus());
		lDTO.setRemark(lPartyContact.getRemark());		
		return lDTO;
	}

	private PartyContact setPartyContact(PartyContactDTO lDTO) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime onDateTime = LocalDateTime.parse(lDTO.getOnDttm(), formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(onDateTime);
		PartyContactPK partyContactPK = new PartyContactPK();
		partyContactPK.setPartySeqNo(lDTO.getPartySeqNo());		
		partyContactPK.setEmailId(lDTO.getEmailId());
		partyContactPK.setLandline(lDTO.getLandline());
		partyContactPK.setMobileNo(lDTO.getMobileNo());		
		partyContactPK.setOnDttm(frTsTimestamp);
		PartyContact lPartyContact = new PartyContact();
		lPartyContact.setId(partyContactPK);
		lPartyContact.setStatus(lDTO.getStatus());
		lPartyContact.setRemark(lDTO.getRemark());		
		return lPartyContact;
	}
}