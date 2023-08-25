package resource.resource_class.service;

import java.util.ArrayList;

import resource.resource_class.model.dto.ResourceClassMasterDTO;

public interface I_ResourceClassMasterService
{
    abstract public ResourceClassMasterDTO newResourceClass(ResourceClassMasterDTO resourceClassMasterDTO);
    abstract public ArrayList<ResourceClassMasterDTO> getAllResourceClasses();    
    abstract public ArrayList<ResourceClassMasterDTO> getSelectResourceClasses(ArrayList<Long> ids);
    abstract public void updResourceClass(ResourceClassMasterDTO resourceClassMasterDTO);
    abstract public void delAllResourceClasses();    
    abstract public void delSelectResourceClasses(ArrayList<Long> ids);
}