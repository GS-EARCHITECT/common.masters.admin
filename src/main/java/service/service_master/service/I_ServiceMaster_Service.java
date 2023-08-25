package service.service_master.service;

import java.util.ArrayList;
import service.service_master.model.dto.ServiceMaster_DTO;

public interface I_ServiceMaster_Service
{
    abstract public ServiceMaster_DTO newServiceMaster(ServiceMaster_DTO serviceCategoryMasterDTO);
    abstract public ArrayList<ServiceMaster_DTO> getAllServiceMasters();    
    abstract public ArrayList<ServiceMaster_DTO> getSelectServices(ArrayList<Long> ids);
    abstract public void updServiceMaster(ServiceMaster_DTO ServiceMaster_DTO);
    abstract public void delServiceMaster(Long serviceSeqNo);
    abstract public void delAllServiceMasters();    
    abstract public void delSelectServices(ArrayList<Long> ids);
}