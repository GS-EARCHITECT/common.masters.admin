package service.service_mgmt.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import service_mgmt.model.dto.ServiceMasterDTO;

public interface I_ServiceMasterService
{
    abstract public ServiceMasterDTO newServiceMaster(ServiceMasterDTO serviceCategoryMasterDTO);
    abstract public ArrayList<ServiceMasterDTO> getAllServiceMasters();    
    abstract public ServiceMasterDTO getServiceMasterById(Long serviceCategorySeqNo);
    abstract public ArrayList<ServiceMasterDTO> getSelectServicesByCategories(ArrayList<BigDecimal> ids);
    abstract public ArrayList<ServiceMasterDTO> getSelectServicesByCompanies(ArrayList<Long> ids);
    abstract public ArrayList<ServiceMasterDTO> getSelectServicesByPriceRange(Float fr, Float to);
    abstract public ArrayList<ServiceMasterDTO> getSelectServices(ArrayList<Long> ids);
    abstract public void updServiceMaster(ServiceMasterDTO ServiceMasterDTO);
    abstract public void delServiceMaster(Long serviceSeqNo);
    abstract public void delAllServiceMasters();    
    abstract public void delSelectServices(ArrayList<Long> ids);
}