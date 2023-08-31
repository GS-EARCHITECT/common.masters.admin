package enterprise.roles.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.roles.model.dto.RoleMaster_DTO;
import enterprise.roles.model.master.RoleMaster;
import enterprise.roles.model.repo.RoleMaster_Repo;

@Service("roleMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class RoleMaster_Service implements I_RoleMaster_Service 
{
	// private static final Logger logger =
	// LoggerFactory.getLogger(RoleMasterService.class);

	@Autowired
	private RoleMaster_Repo roleMasterRepo;

	public RoleMaster_DTO newRole(RoleMaster_DTO cDTO) {
		
		if (!roleMasterRepo.existsById(cDTO.getMasterRoleSeqNo())) 
		{
			RoleMaster roleMaster = roleMasterRepo.save(this.setRoleMaster(cDTO));
			cDTO = getRoleMaster_DTO(roleMaster);
		}
		return cDTO;
	}

	public ArrayList<RoleMaster_DTO> getAllRoles() 
	{
		ArrayList<RoleMaster> roleList = (ArrayList<RoleMaster>) roleMasterRepo.findAll();
		ArrayList<RoleMaster_DTO> cDTOs = new ArrayList<RoleMaster_DTO>();
		cDTOs = roleList != null ? this.getRoleMasterDtos(roleList) : null;
		return cDTOs;
	}

	public ArrayList<RoleMaster_DTO> getSelectRoles(ArrayList<Long> roleSeqNos) {
		ArrayList<RoleMaster_DTO> cDTOs = new ArrayList<RoleMaster_DTO>();
		RoleMaster_DTO roleMasterDTO = null;
		ArrayList<RoleMaster> roleMasters = (ArrayList<RoleMaster>) roleMasterRepo.findAll();
		cDTOs = roleMasters != null ? this.getRoleMasterDtos(roleMasters) : null;
		return cDTOs;
	}

	public void updRole(RoleMaster_DTO cDTO) 
		{
		if (roleMasterRepo.existsById(cDTO.getMasterRoleSeqNo())) 
		{
			roleMasterRepo.save(this.setRoleMaster(cDTO));
		}
		return;
	}

	public void delAllRoles() {
		roleMasterRepo.deleteAll();
	}

	public void delSelectRoles(ArrayList<Long> roleSeqNos) 
	{
		roleMasterRepo.deleteAllById(roleSeqNos);

	}

	private ArrayList<RoleMaster_DTO> getRoleMasterDtos(ArrayList<RoleMaster> cMasters) {
		RoleMaster_DTO cDTO = null;
		ArrayList<RoleMaster_DTO> cDTOs = new ArrayList<RoleMaster_DTO>();

		for (int i = 0; i < cMasters.size(); i++) 
		{
			cDTO = this.getRoleMaster_DTO(cMasters.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private RoleMaster_DTO getRoleMaster_DTO(RoleMaster cMaster) {
		RoleMaster_DTO cDTO = null;
		cDTO = new RoleMaster_DTO();
		cDTO.setMasterRoleSeqNo(cMaster.getMasterRoleSeqNo());
		cDTO.setRole(cMaster.getRole());		
		cDTO.setRemark(cMaster.getRemark());
		cDTO.setSpecificationSeqNo(cMaster.getSpecificationSeqNo());
		return cDTO;
	}

	private RoleMaster setRoleMaster(RoleMaster_DTO cDTO) {
		RoleMaster cMaster = new RoleMaster();
		cMaster.setRole(cDTO.getRole());
		cMaster.setRemark(cMaster.getRemark());
		cMaster.setSpecificationSeqNo(cMaster.getSpecificationSeqNo());
		return cMaster;
	}

}