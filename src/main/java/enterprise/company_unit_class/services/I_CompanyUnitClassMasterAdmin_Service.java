package enterprise.company_unit_class.services;

import java.util.ArrayList;
import enterprise.company_unit_class.model.dto.CompanyUnitClassMaster_DTO;

public interface I_CompanyUnitClassMasterAdmin_Service 
{
	public CompanyUnitClassMaster_DTO newCompanyUnitClass(CompanyUnitClassMaster_DTO companyClassDTO);
	public ArrayList<CompanyUnitClassMaster_DTO> getAllCompanyUnitClasses();
	public ArrayList<CompanyUnitClassMaster_DTO> getSelectCompanyUnitClasses(ArrayList<Long> companyClassSeqNos);
	public void updCompanyUnitClass(CompanyUnitClassMaster_DTO companyClassDTO);	
	public void delAllCompanyUnitClasses();
	public void delSelectCompanyUnitClasses(ArrayList<Long> compClassSeqNos);
}