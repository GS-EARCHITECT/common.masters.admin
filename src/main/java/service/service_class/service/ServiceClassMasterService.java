package service.service_class.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("serviceClassMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServiceClassMaster_Service implements I_ServiceClassMaster_Service 
{

	@Autowired
	private ServiceClassMaster_Repo serviceClassMasterRepo;

	public ServiceClassMaster_DTO newServiceClass(ServiceClassMasterDTO lMaster) 
	{
		ServiceClassMaster ServiceClassMaster = serviceClassMasterRepo.save(this.setServiceClassMaster(lMaster));
		lMaster = getServiceClassMasterDTO(ServiceClassMaster);
		return lMaster;
	}

	public ArrayList<ServiceClassMasterDTO> getAllServiceClasses()
	{
		ArrayList<ServiceClassMaster> serviceList = (ArrayList<ServiceClassMaster>) serviceClassMasterRepo.findAll();
		ArrayList<ServiceClassMasterDTO> lMasters = new ArrayList<ServiceClassMasterDTO>();
		lMasters = serviceList != null ? this.getServiceClassMasterDTOs(serviceList) : null;
		return lMasters;
	}

	public ArrayList<ServiceClassMasterDTO> getSelectServiceClasses(ArrayList<Long> ids)
	{
		ArrayList<ServiceClassMaster> lMasters = serviceClassMasterRepo.getSelectServiceClasses(ids);
		ArrayList<ServiceClassMasterDTO> serviceClassMasterDTOs = new ArrayList<ServiceClassMasterDTO>();
		serviceClassMasterDTOs = lMasters != null ? this.getServiceClassMasterDTOs(lMasters) : null;
		return serviceClassMasterDTOs;
	}
   
	public void updServiceClass(ServiceClassMasterDTO lMaster) 
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
			serviceClassMasterRepo.delSelectServiceClasses(serviceClassSeqNos);
		}
	}

	
	private ArrayList<ServiceClassMasterDTO> getServiceClassMasterDTOs(ArrayList<ServiceClassMaster> lMasters) {
		ServiceClassMasterDTO lDTO = null;
		ArrayList<ServiceClassMasterDTO> lMasterDTOs = new ArrayList<ServiceClassMasterDTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getServiceClassMasterDTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ServiceClassMasterDTO getServiceClassMasterDTO(ServiceClassMaster lMaster) 
	{		
		ServiceClassMasterDTO lDTO = new ServiceClassMasterDTO();
		lDTO.setRemark(lMaster.getRemark());		
		lDTO.setServiceClassSeqNo(lMaster.getServiceClassSeqNo());
		lDTO.setServiceClass(lMaster.getServiceClass());
		lDTO.setSpecificationSeqNo(lMaster.getSpecificationSeqNo());				
		lDTO.setDescription(lMaster.getDescription());
		lDTO.setStatus(lMaster.getStatus());		
		return lDTO;
	}

	private ServiceClassMaster setServiceClassMaster(ServiceClassMasterDTO lDTO) {
		ServiceClassMaster lMaster = new ServiceClassMaster();				
		lMaster.setRemark(lDTO.getRemark());
		lMaster.setSpecificationSeqNo(lDTO.getSpecificationSeqNo());				
		lMaster.setDescription(lDTO.getDescription());
		lMaster.setStatus(lDTO.getStatus());
		lMaster.setServiceClass(lDTO.getServiceClass());		
		return lMaster;
	}
}