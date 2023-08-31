package enterprise.designations.services;

import java.util.ArrayList;
import enterprise.designations.model.dto.DesignationMaster_DTO;

public interface I_DesignationMaster_Service 
{
	public DesignationMaster_DTO newDesignation(DesignationMaster_DTO designationDTO);
	public ArrayList<DesignationMaster_DTO> getAllDesignations();
	public ArrayList<DesignationMaster_DTO> getSelectDesignations(ArrayList<Long> designationSeqNos);
	public void updDesignation(DesignationMaster_DTO designationDTO);	
	public void delAllDesignations();
	public void delSelectDesignations(ArrayList<Long> designationSeqNos);
}