package resource.resource_master.service;

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

import resource.resource_master.model.dto.ResourceMaster_DTO;
import resource.resource_master.model.master.ResourceMaster;
import resource.resource_master.model.repo.ResourceMaster_Repo;

@Service("resourceMasterServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceMaster_Service implements I_ResourceMaster_Service 
{

	@Autowired
	private ResourceMaster_Repo resourceMasterRepo;

	public ResourceMaster_DTO newMasterResource(ResourceMaster_DTO lMasters) {
		ResourceMaster ResourceMaster = resourceMasterRepo.save(this.setResourceMaster(lMasters));
		lMasters = getResourceMaster_DTO(ResourceMaster);
		return lMasters;
	}

	public ArrayList<ResourceMaster_DTO> getAllMasterResources() 
	{
		ArrayList<ResourceMaster> resourceList = (ArrayList<ResourceMaster>) resourceMasterRepo.findAll();
		ArrayList<ResourceMaster_DTO> lMasterss = new ArrayList<ResourceMaster_DTO>();
		lMasterss = resourceList != null ? this.getResourceMaster_DTOs(resourceList) : null;
		return lMasterss;
	}

	public ArrayList<ResourceMaster_DTO> getSelectMasterResources(ArrayList<Long> ids)
	{
		ArrayList<ResourceMaster> lMasters = (ArrayList<ResourceMaster>) resourceMasterRepo.findAllById(ids);
		ArrayList<ResourceMaster_DTO> lMasterss = new ArrayList<ResourceMaster_DTO>();
		lMasterss = lMasters != null ? this.getResourceMaster_DTOs(lMasters) : null;		
		return lMasterss;
	}
   
	public void updMasterResource(ResourceMaster_DTO lMaster) 
	{
		ResourceMaster resourceMaster2 = this.setResourceMaster(lMaster);
		if (resourceMasterRepo.existsById(lMaster.getMasterResourceSeqNo())) 
				{		
			resourceMaster2.setMasterResourceSeqNo(lMaster.getMasterResourceSeqNo());			
			resourceMasterRepo.save(resourceMaster2);			
		}
		return;
	}

	public void delAllResourceMasters() 
	{
		resourceMasterRepo.deleteAll();
	}

	public void delSelectMasterResources(ArrayList<Long> resourceSeqNos) 
	{
		if (resourceSeqNos != null) {
			resourceMasterRepo.deleteAllById(resourceSeqNos);
		}
	}
	
	private ArrayList<ResourceMaster_DTO> getResourceMaster_DTOs(ArrayList<ResourceMaster> lMasters) 
	{
		ResourceMaster_DTO lDTO = null;
		ArrayList<ResourceMaster_DTO> lMasterDTOs = new ArrayList<ResourceMaster_DTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getResourceMaster_DTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ResourceMaster_DTO getResourceMaster_DTO(ResourceMaster lMaster) 
	{		
		ResourceMaster_DTO lDTO = new ResourceMaster_DTO();
		lDTO.setDescription(lMaster.getDescription());		
		lDTO.setMasterResourceSeqNo(lMaster.getMasterResourceSeqNo());
		lDTO.setResourceName(lMaster.getResourceName());
		lDTO.setSpecificationSeqNo(lMaster.getSpecificationSeqNo());				
		return lDTO;
	}

	private ResourceMaster setResourceMaster(ResourceMaster_DTO lDTO)
	{
		ResourceMaster lMaster = new ResourceMaster();				
		lMaster.setDescription(lDTO.getDescription());
		lMaster.setResourceName(lDTO.getResourceName());
		lMaster.setSpecificationSeqNo(lDTO.getSpecificationSeqNo());
		return lMaster;
	}
}