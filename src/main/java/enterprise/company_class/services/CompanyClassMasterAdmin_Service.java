package enterprise.company_class.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.company_class.model.dto.CompanyClassMaster_DTO;
import enterprise.company_class.model.master.CompanyClassMaster;
import enterprise.company_class.model.repo.CompanyClassMasterAdmin_Repo;

@Service("companyClassAdminServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyClassMasterAdmin_Service implements I_CompanyClassMasterAdmin_Service 
{
	// private static final Logger logger =
	// LoggerFactory.getLogger(CompanyClassMasterService.class);

	@Autowired
	private CompanyClassMasterAdmin_Repo companyClassAdminRepo;

	public CompanyClassMaster_DTO newCompanyClass(CompanyClassMaster_DTO cDTO) 
	{
		if (!companyClassAdminRepo.existsById(cDTO.getCompanyClassSeqNo())) 
		{
			CompanyClassMaster companyUnitClass = companyClassAdminRepo.save(this.setCompanyClassMaster(cDTO));
			cDTO = getCompanyClassMaster_DTO(companyUnitClass);
		}
		return cDTO;
	}

	public ArrayList<CompanyClassMaster_DTO> getAllCompanyClasses() 
	{
		ArrayList<CompanyClassMaster> companyUnitList = (ArrayList<CompanyClassMaster>) companyClassAdminRepo.findAll();
		ArrayList<CompanyClassMaster_DTO> cDTOs = new ArrayList<CompanyClassMaster_DTO>();
		cDTOs = companyUnitList != null ? this.getCompanyClassMasterDtos(companyUnitList) : null;
		return cDTOs;
	}

	public ArrayList<CompanyClassMaster_DTO> getSelectCompanyClasses(ArrayList<Long> companyUnitSeqNos) {
		ArrayList<CompanyClassMaster_DTO> cDTOs = new ArrayList<CompanyClassMaster_DTO>();
		ArrayList<CompanyClassMaster> companyUnitClasss = (ArrayList<CompanyClassMaster>) companyClassAdminRepo.findAll();
		cDTOs = companyUnitClasss != null ? this.getCompanyClassMasterDtos(companyUnitClasss) : null;
		return cDTOs;
	}

	public void updCompanyClass(CompanyClassMaster_DTO cDTO) 
	{
		if (companyClassAdminRepo.existsById(cDTO.getCompanyClassSeqNo()))
				{
			companyClassAdminRepo.save(this.setCompanyClassMaster(cDTO));
		}
		return;
	}

	public void delAllCompanyClasses() 
	{
		companyClassAdminRepo.deleteAll();
	}

	public void delSelectCompanyClasses(ArrayList<Long> companyUnitSeqNos) 
	{
		companyClassAdminRepo.deleteAllById(companyUnitSeqNos);

	}

	private ArrayList<CompanyClassMaster_DTO> getCompanyClassMasterDtos(ArrayList<CompanyClassMaster> cClasss) {
		CompanyClassMaster_DTO cDTO = null;
		ArrayList<CompanyClassMaster_DTO> cDTOs = new ArrayList<CompanyClassMaster_DTO>();

		for (int i = 0; i < cClasss.size(); i++) 
		{
			cDTO = this.getCompanyClassMaster_DTO(cClasss.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private CompanyClassMaster_DTO getCompanyClassMaster_DTO(CompanyClassMaster cClass) {
		CompanyClassMaster_DTO cDTO = null;
		cDTO = new CompanyClassMaster_DTO();
		cDTO.setCompanyClassSeqNo(cClass.getCompanyClassSeqNo());
		cDTO.setCompanyClass(cClass.getCompanyClass());
		cDTO.setDescription(cClass.getDescription());
		cDTO.setSpecificationSeqNo(cClass.getSpecificationSeqNo());		
		return cDTO;
	}

	private CompanyClassMaster setCompanyClassMaster(CompanyClassMaster_DTO cDTO)
	{
		CompanyClassMaster cClass = new CompanyClassMaster();
		cClass.setCompanyClass(cDTO.getCompanyClass());
		cClass.setDescription(cDTO.getDescription());
		cClass.setSpecificationSeqNo(cDTO.getSpecificationSeqNo());		
		return cClass;
	}

}