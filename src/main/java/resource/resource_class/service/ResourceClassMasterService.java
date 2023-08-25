package resource.resource_class.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import resource.resource_class.model.dto.ResourceClassMasterDTO;
import resource.resource_class.model.master.ResourceClassMaster;
import resource.resource_class.model.repo.ResourceClassMasterRepo;

@Service("resourceClassMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceClassMasterService implements I_ResourceClassMasterService 
{

	@Autowired
	private ResourceClassMasterRepo resourceClassMasterRepo;

	public ResourceClassMasterDTO newResourceClass(ResourceClassMasterDTO lMaster) 
	{
		ResourceClassMaster ResourceClassMaster = resourceClassMasterRepo.save(this.setResourceClassMaster(lMaster));
		lMaster = getResourceClassMasterDTO(ResourceClassMaster);
		return lMaster;
	}

	public ArrayList<ResourceClassMasterDTO> getAllResourceClasses()
	{
		ArrayList<ResourceClassMaster> resourceList = (ArrayList<ResourceClassMaster>) resourceClassMasterRepo.findAll();
		ArrayList<ResourceClassMasterDTO> lMasters = new ArrayList<ResourceClassMasterDTO>();
		lMasters = resourceList != null ? this.getResourceClassMasterDTOs(resourceList) : null;
		return lMasters;
	}

	public ArrayList<ResourceClassMasterDTO> getSelectResourceClasses(ArrayList<Long> ids)
	{
		ArrayList<ResourceClassMaster> lMasters = resourceClassMasterRepo.getSelectResourceClasses(ids);
		ArrayList<ResourceClassMasterDTO> resourceClassMasterDTOs = new ArrayList<ResourceClassMasterDTO>();
		resourceClassMasterDTOs = lMasters != null ? this.getResourceClassMasterDTOs(lMasters) : null;
		return resourceClassMasterDTOs;
	}
   
	public void updResourceClass(ResourceClassMasterDTO lMaster) 
	{
		ResourceClassMaster resourceClassMaster = null;
		if (resourceClassMasterRepo.existsById(lMaster.getResourceClassSeqNo())) 
		{		
			resourceClassMaster = this.setResourceClassMaster(lMaster);
			resourceClassMaster.setResourceClassSeqNo(lMaster.getResourceClassSeqNo());			
			resourceClassMasterRepo.save(resourceClassMaster);			
		}
		return;
	}

	public void delAllResourceClasses() 
	{
		resourceClassMasterRepo.deleteAll();
	}

	public void delSelectResourceClasses(ArrayList<Long> resourceClassSeqNos) 
	{
		if (resourceClassSeqNos != null) 
		{
			resourceClassMasterRepo.delSelectResourceClasses(resourceClassSeqNos);
		}
	}

	
	private ArrayList<ResourceClassMasterDTO> getResourceClassMasterDTOs(ArrayList<ResourceClassMaster> lMasters) {
		ResourceClassMasterDTO lDTO = null;
		ArrayList<ResourceClassMasterDTO> lMasterDTOs = new ArrayList<ResourceClassMasterDTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getResourceClassMasterDTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ResourceClassMasterDTO getResourceClassMasterDTO(ResourceClassMaster lMaster) 
	{		
		ResourceClassMasterDTO lDTO = new ResourceClassMasterDTO();
		lDTO.setRemark(lMaster.getRemark());		
		lDTO.setResourceClassSeqNo(lMaster.getResourceClassSeqNo());
		lDTO.setResourceClass(lMaster.getResourceClass());
		lDTO.setSpecificationSeqNo(lMaster.getSpecificationSeqNo());				
		lDTO.setDescription(lMaster.getDescription());
		lDTO.setStatus(lMaster.getStatus());		
		return lDTO;
	}

	private ResourceClassMaster setResourceClassMaster(ResourceClassMasterDTO lDTO) {
		ResourceClassMaster lMaster = new ResourceClassMaster();				
		lMaster.setRemark(lDTO.getRemark());
		lMaster.setSpecificationSeqNo(lDTO.getSpecificationSeqNo());				
		lMaster.setDescription(lDTO.getDescription());
		lMaster.setStatus(lDTO.getStatus());
		lMaster.setResourceClass(lDTO.getResourceClass());		
		return lMaster;
	}
}