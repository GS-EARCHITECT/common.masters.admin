package service.service_class.service;

import java.util.ArrayList;
import service.service_class.model.dto.ServiceClassMaster_DTO;

public interface I_ServiceClassMaster_Service
{
    abstract public ServiceClassMaster_DTO newServiceClass(ServiceClassMaster_DTO serviceClassMasterDTO);
    abstract public ArrayList<ServiceClassMaster_DTO> getAllServiceClasses();    
    abstract public ArrayList<ServiceClassMaster_DTO> getSelectServiceClasses(ArrayList<Long> ids);
    abstract public void updServiceClass(ServiceClassMaster_DTO serviceClassMasterDTO);
    abstract public void delAllServiceClasses();    
    abstract public void delSelectServiceClasses(ArrayList<Long> ids);
}