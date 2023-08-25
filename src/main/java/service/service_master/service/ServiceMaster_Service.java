package service.service_master.service;

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
import service.service_master.model.dto.ServiceMaster_DTO;
import service.service_master.model.master.ServiceMaster;
import service.service_master.model.repo.ServiceMaster_Repo;

@Service("serviceMasterServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServiceMaster_Service implements I_ServiceMaster_Service 
{

	@Autowired
	private ServiceMaster_Repo serviceMasterRepo;

	public ServiceMaster_DTO newServiceMaster(ServiceMaster_DTO lMasters) {
		ServiceMaster ServiceMaster = serviceMasterRepo.save(this.setServiceMaster(lMasters));
		lMasters = getServiceMaster_DTO(ServiceMaster);
		return lMasters;
	}

	public ArrayList<ServiceMaster_DTO> getAllServiceMasters() {
		ArrayList<ServiceMaster> serviceList = (ArrayList<ServiceMaster>) serviceMasterRepo.findAll();
		ArrayList<ServiceMaster_DTO> lMasterss = new ArrayList<ServiceMaster_DTO>();
		lMasterss = serviceList != null ? this.getServiceMaster_DTOs(serviceList) : null;
		return lMasterss;
	}

	public ArrayList<ServiceMaster_DTO> getSelectServices(ArrayList<Long> ids)
	{
		ArrayList<ServiceMaster> lMasters = (ArrayList<ServiceMaster>) serviceMasterRepo.findAllById(ids);
		ArrayList<ServiceMaster_DTO> serviceMaster_DTOs = new ArrayList<ServiceMaster_DTO>();
		serviceMaster_DTOs = lMasters != null ? this.getServiceMaster_DTOs(lMasters) : null;
		return serviceMaster_DTOs;
	}

	public void updServiceMaster(ServiceMaster_DTO lMaster) 
	{
		ServiceMaster serviceMaster = this.setServiceMaster(lMaster);
		if (serviceMasterRepo.existsById(lMaster.getMasterServiceSeqNo())) 
		{		
			serviceMaster.setMasterServiceSeqNo(lMaster.getMasterServiceSeqNo());			
			serviceMasterRepo.save(serviceMaster);			
		}
		return;
	}

	public void delServiceMaster(Long serviceSeqNo) {
		if (serviceMasterRepo.existsById(serviceSeqNo)) {
			serviceMasterRepo.deleteById(serviceSeqNo);
		}
		return;
	}

	public void delAllServiceMasters() {
		serviceMasterRepo.deleteAll();
	}

	public void delSelectServices(ArrayList<Long> serviceSeqNos) {
		if (serviceSeqNos != null) 
		{
		serviceMasterRepo.deleteAllById(serviceSeqNos);;
		}
	}

	
	private ArrayList<ServiceMaster_DTO> getServiceMaster_DTOs(ArrayList<ServiceMaster> lMasters) {
		ServiceMaster_DTO lDTO = null;
		ArrayList<ServiceMaster_DTO> lMasterDTOs = new ArrayList<ServiceMaster_DTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getServiceMaster_DTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ServiceMaster_DTO getServiceMaster_DTO(ServiceMaster lMaster) 
	{		
		ServiceMaster_DTO lDTO = new ServiceMaster_DTO();				
		lDTO.setMasterServiceSeqNo(lMaster.getMasterServiceSeqNo());						
		lDTO.setDescription(lMaster.getDescription());
		lDTO.setServiceName(lMaster.getServiceName());		
		lDTO.setSpecificationSeqNo(lMaster.getSpecificationSeqNo());
		return lDTO;
	}

	private ServiceMaster setServiceMaster(ServiceMaster_DTO lDTO)
	{
		ServiceMaster lMaster = new ServiceMaster();				
		lMaster.setDescription(lDTO.getDescription());
		lMaster.setServiceName(lDTO.getServiceName());		
		lMaster.setSpecificationSeqNo(lDTO.getSpecificationSeqNo());		
		return lMaster;
	}
}