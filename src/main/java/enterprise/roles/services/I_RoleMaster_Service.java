package enterprise.roles.services;

import java.util.ArrayList;

import enterprise.roles.model.dto.RoleMaster_DTO;

public interface I_RoleMaster_Service 
{
	public RoleMaster_DTO newRole(RoleMaster_DTO roleDTO);
	public ArrayList<RoleMaster_DTO> getAllRoles();
	public ArrayList<RoleMaster_DTO> getSelectRoles(ArrayList<Long> roleSeqNos);
	public void updRole(RoleMaster_DTO roleDTO);	
	public void delAllRoles();
	public void delSelectRoles(ArrayList<Long> roleSeqNos);
}