package enterprise.company_class.services;

import java.util.ArrayList;

import enterprise.company_class.model.dto.CompanyClassMaster_DTO;

public interface I_CompanyClassMasterAdmin_Service 
{
	public CompanyClassMaster_DTO newCompanyClass(CompanyClassMaster_DTO companyClassDTO);
	public ArrayList<CompanyClassMaster_DTO> getAllCompanyClasses();
	public ArrayList<CompanyClassMaster_DTO> getSelectCompanyClasses(ArrayList<Long> companyClassSeqNos);
	public void updCompanyClass(CompanyClassMaster_DTO companyClassDTO);	
	public void delAllCompanyClasses();
	public void delSelectCompanyClasses(ArrayList<Long> compClassSeqNos);
}