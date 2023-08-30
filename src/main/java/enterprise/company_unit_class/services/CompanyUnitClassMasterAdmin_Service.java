package enterprise.company_unit_class.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.company_unit_class.model.dto.CompanyUnitClassMaster_DTO;
import enterprise.company_unit_class.model.master.CompanyUnitClassMaster;
import enterprise.company_unit_class.model.repo.CompanyUnitClassMasterAdmin_Repo;

@Service("compUnitClassAdminServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyUnitClassMasterAdmin_Service implements I_CompanyUnitClassMasterAdmin_Service 
{
	// private static final Logger logger =
	// LoggerFactory.getLogger(CompanyUnitClassMasterService.class);

	@Autowired
	private CompanyUnitClassMasterAdmin_Repo compUnitClassAdminRepo;

	public CompanyUnitClassMaster_DTO newCompanyUnitClass(CompanyUnitClassMaster_DTO cDTO) 
	{
		if (!compUnitClassAdminRepo.existsById(cDTO.getUnitClassSeqNo())) 
		{
			CompanyUnitClassMaster companyUnitClass = compUnitClassAdminRepo.save(this.setCompanyUnitClassMaster(cDTO));
			cDTO = getCompanyUnitClassMaster_DTO(companyUnitClass);
		}
		return cDTO;
	}

	public ArrayList<CompanyUnitClassMaster_DTO> getAllCompanyUnitClasses() 
	{
		ArrayList<CompanyUnitClassMaster> companyUnitList = (ArrayList<CompanyUnitClassMaster>) compUnitClassAdminRepo.findAll();
		ArrayList<CompanyUnitClassMaster_DTO> cDTOs = new ArrayList<CompanyUnitClassMaster_DTO>();
		cDTOs = companyUnitList != null ? this.getCompanyUnitClassMasterDtos(companyUnitList) : null;
		return cDTOs;
	}

	public ArrayList<CompanyUnitClassMaster_DTO> getSelectCompanyUnitClasses(ArrayList<Long> companyUnitSeqNos) {
		ArrayList<CompanyUnitClassMaster_DTO> cDTOs = new ArrayList<CompanyUnitClassMaster_DTO>();
		ArrayList<CompanyUnitClassMaster> companyUnitClasss = (ArrayList<CompanyUnitClassMaster>) compUnitClassAdminRepo.findAll();
		cDTOs = companyUnitClasss != null ? this.getCompanyUnitClassMasterDtos(companyUnitClasss) : null;
		return cDTOs;
	}

	public void updCompanyUnitClass(CompanyUnitClassMaster_DTO cDTO) 
	{
		if (compUnitClassAdminRepo.existsById(cDTO.getUnitClassSeqNo()))
				{
			compUnitClassAdminRepo.save(this.setCompanyUnitClassMaster(cDTO));
		}
		return;
	}

	public void delAllCompanyUnitClasses() 
	{
		compUnitClassAdminRepo.deleteAll();
	}

	public void delSelectCompanyUnitClasses(ArrayList<Long> companyUnitSeqNos) 
	{
		compUnitClassAdminRepo.deleteAllById(companyUnitSeqNos);

	}

	private ArrayList<CompanyUnitClassMaster_DTO> getCompanyUnitClassMasterDtos(ArrayList<CompanyUnitClassMaster> cClasss) {
		CompanyUnitClassMaster_DTO cDTO = null;
		ArrayList<CompanyUnitClassMaster_DTO> cDTOs = new ArrayList<CompanyUnitClassMaster_DTO>();

		for (int i = 0; i < cClasss.size(); i++) 
		{
			cDTO = this.getCompanyUnitClassMaster_DTO(cClasss.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private CompanyUnitClassMaster_DTO getCompanyUnitClassMaster_DTO(CompanyUnitClassMaster cClass) {
		CompanyUnitClassMaster_DTO cDTO = null;
		cDTO = new CompanyUnitClassMaster_DTO();
		cDTO.setUnitClassSeqNo(cClass.getUnitClassSeqNo());
		cDTO.setUnitclass(cClass.getUnitclass());
		cDTO.setDescription(cClass.getDescription());
		cDTO.setSpecificationSeqNo(cClass.getSpecificationSeqNo());		
		return cDTO;
	}

	private CompanyUnitClassMaster setCompanyUnitClassMaster(CompanyUnitClassMaster_DTO cDTO)
	{
		CompanyUnitClassMaster cClass = new CompanyUnitClassMaster();
		cClass.setUnitclass(cDTO.getUnitclass());
		cClass.setDescription(cDTO.getDescription());
		cClass.setSpecificationSeqNo(cDTO.getSpecificationSeqNo());		
		return cClass;
	}

}