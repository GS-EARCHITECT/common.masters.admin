package resource.resource_master.service;

import java.util.ArrayList;

import resource.resource_master.model.dto.ResourceMaster_DTO;

public interface I_ResourceMaster_Service
{
    abstract public ResourceMaster_DTO newMasterResource(ResourceMaster_DTO resourceMasterDTO);
    abstract public ArrayList<ResourceMaster_DTO> getAllMasterResources();    
    abstract public ArrayList<ResourceMaster_DTO> getSelectMasterResources(ArrayList<Long> ids);
    abstract public void updMasterResource(ResourceMaster_DTO ResourceMaster_DTO);
    abstract public void delAllResourceMasters();    
    abstract public void delSelectMasterResources(ArrayList<Long> ids);
}