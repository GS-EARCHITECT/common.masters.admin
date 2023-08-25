package service.service_class.service;

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
import service.service_class.model.dto.ServiceClassMaster_DTO;
import service.service_class.model.master.ServiceClassMaster;
import service.service_class.model.repo.ServiceClassMaster_Repo;

@Service("serviceClassMasterServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServiceClassMaster_Service implements I_ServiceClassMaster_Service 
{

	@Autowired
	private ServiceClassMaster_Repo serviceClassMasterRepo;

	public ServiceClassMaster_DTO newServiceClass(ServiceClassMaster_DTO lMaster) 
	{
		ServiceClassMaster ServiceClassMaster = serviceClassMasterRepo.save(this.setServiceClassMaster(lMaster));
		lMaster = getServiceClassMaster_DTO(ServiceClassMaster);
		return lMaster;
	}

	public ArrayList<ServiceClassMaster_DTO> getAllServiceClasses()
	{
		ArrayList<ServiceClassMaster> serviceList = (ArrayList<ServiceClassMaster>) serviceClassMasterRepo.findAll();
		ArrayList<ServiceClassMaster_DTO> lMasters = new ArrayList<ServiceClassMaster_DTO>();
		lMasters = serviceList != null ? this.getServiceClassMaster_DTOs(serviceList) : null;
		return lMasters;
	}

	public ArrayList<ServiceClassMaster_DTO> getSelectServiceClasses(ArrayList<Long> ids)
	{
		ArrayList<ServiceClassMaster> lMasters = (ArrayList<ServiceClassMaster>) serviceClassMasterRepo.findAllById(ids);
		ArrayList<ServiceClassMaster_DTO> ServiceClassMaster_DTOs = new ArrayList<ServiceClassMaster_DTO>();
		ServiceClassMaster_DTOs = lMasters != null ? this.getServiceClassMaster_DTOs(lMasters) : null;
		return ServiceClassMaster_DTOs;
	}
   
	public void updServiceClass(ServiceClassMaster_DTO lMaster) 
	{
		ServiceClassMaster serviceClassMaster = null;
		if (serviceClassMasterRepo.existsById(lMaster.getServiceClassSeqNo())) 
		{		
			serviceClassMaster = this.setServiceClassMaster(lMaster);
			serviceClassMaster.setServiceClassSeqNo(lMaster.getServiceClassSeqNo());			
			serviceClassMasterRepo.save(serviceClassMaster);			
		}
		return;
	}

	public void delAllServiceClasses() 
	{
		serviceClassMasterRepo.deleteAll();
	}

	public void delSelectServiceClasses(ArrayList<Long> serviceClassSeqNos) 
	{
		if (serviceClassSeqNos != null) 
		{
			serviceClassMasterRepo.deleteAllById(serviceClassSeqNos);
		}
	}

	
	private ArrayList<ServiceClassMaster_DTO> getServiceClassMaster_DTOs(ArrayList<ServiceClassMaster> lMasters) {
		ServiceClassMaster_DTO lDTO = null;
		ArrayList<ServiceClassMaster_DTO> lMasterDTOs = new ArrayList<ServiceClassMaster_DTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getServiceClassMaster_DTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ServiceClassMaster_DTO getServiceClassMaster_DTO(ServiceClassMaster lMaster) 
	{		
		ServiceClassMaster_DTO lDTO = new ServiceClassMaster_DTO();
		lDTO.setRemark(lMaster.getRemark());		
		lDTO.setServiceClassSeqNo(lMaster.getServiceClassSeqNo());
		lDTO.setServiceClass(lMaster.getServiceClass());
		lDTO.setSpecificationSeqNo(lMaster.getSpecificationSeqNo());				
		lDTO.setDescription(lMaster.getDescription());
		lDTO.setStatus(lMaster.getStatus());		
		return lDTO;
	}

	private ServiceClassMaster setServiceClassMaster(ServiceClassMaster_DTO lDTO) {
		ServiceClassMaster lMaster = new ServiceClassMaster();				
		lMaster.setRemark(lDTO.getRemark());
		lMaster.setSpecificationSeqNo(lDTO.getSpecificationSeqNo());				
		lMaster.setDescription(lDTO.getDescription());
		lMaster.setStatus(lDTO.getStatus());
		lMaster.setServiceClass(lDTO.getServiceClass());		
		return lMaster;
	}
}