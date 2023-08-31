package enterprise.designations.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.designations.model.dto.DesignationMaster_DTO;
import enterprise.designations.model.master.DesignationMaster;
import enterprise.designations.model.repo.DesignationMaster_Repo;

@Service("designationMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class DesignationMaster_Service implements I_DesignationMaster_Service 
{
	// private static final Logger logger =
	// LoggerFactory.getLogger(DesignationMasterService.class);

	@Autowired
	private DesignationMaster_Repo designationMasterRepo;

	public DesignationMaster_DTO newDesignation(DesignationMaster_DTO cDTO) {
		
		if (!designationMasterRepo.existsById(cDTO.getMasterDesignationSeqNo())) 
		{
			DesignationMaster designationMaster = designationMasterRepo.save(this.setDesignationMaster(cDTO));
			cDTO = getDesignationMaster_DTO(designationMaster);
		}
		return cDTO;
	}

	public ArrayList<DesignationMaster_DTO> getAllDesignations() 
	{
		ArrayList<DesignationMaster> designationList = (ArrayList<DesignationMaster>) designationMasterRepo.findAll();
		ArrayList<DesignationMaster_DTO> cDTOs = new ArrayList<DesignationMaster_DTO>();
		cDTOs = designationList != null ? this.getDesignationMasterDtos(designationList) : null;
		return cDTOs;
	}

	public ArrayList<DesignationMaster_DTO> getSelectDesignations(ArrayList<Long> designationSeqNos) {
		ArrayList<DesignationMaster_DTO> cDTOs = new ArrayList<DesignationMaster_DTO>();
		ArrayList<DesignationMaster> designationMasters = (ArrayList<DesignationMaster>) designationMasterRepo.findAll();
		cDTOs = designationMasters != null ? this.getDesignationMasterDtos(designationMasters) : null;
		return cDTOs;
	}

	public void updDesignation(DesignationMaster_DTO cDTO) 
		{
		if (designationMasterRepo.existsById(cDTO.getMasterDesignationSeqNo())) 
		{
			designationMasterRepo.save(this.setDesignationMaster(cDTO));
		}
		return;
	}

	public void delAllDesignations() {
		designationMasterRepo.deleteAll();
	}

	public void delSelectDesignations(ArrayList<Long> designationSeqNos) 
	{
		designationMasterRepo.deleteAllById(designationSeqNos);

	}

	private ArrayList<DesignationMaster_DTO> getDesignationMasterDtos(ArrayList<DesignationMaster> cMasters) {
		DesignationMaster_DTO cDTO = null;
		ArrayList<DesignationMaster_DTO> cDTOs = new ArrayList<DesignationMaster_DTO>();

		for (int i = 0; i < cMasters.size(); i++) 
		{
			cDTO = this.getDesignationMaster_DTO(cMasters.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private DesignationMaster_DTO getDesignationMaster_DTO(DesignationMaster cMaster) {
		DesignationMaster_DTO cDTO = null;
		cDTO = new DesignationMaster_DTO();
		cDTO.setMasterDesignationSeqNo(cMaster.getMasterDesignationSeqNo());
		cDTO.setDesignation(cMaster.getDesignation());		
		cDTO.setRemark(cMaster.getRemark());
		cDTO.setSpecificationSeqNo(cMaster.getSpecificationSeqNo());
		return cDTO;
	}

	private DesignationMaster setDesignationMaster(DesignationMaster_DTO cDTO) {
		DesignationMaster cMaster = new DesignationMaster();
		cMaster.setDesignation(cDTO.getDesignation());
		cMaster.setRemark(cMaster.getRemark());
		cMaster.setSpecificationSeqNo(cMaster.getSpecificationSeqNo());
		return cMaster;
	}

}