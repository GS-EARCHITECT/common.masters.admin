package service.service_mgmt.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service_mgmt.model.dto.ServiceMasterDTO;
import service_mgmt.model.master.ServiceMaster;
import service_mgmt.model.repo.ServiceMasterRepo;

@Service("serviceMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServiceMasterService implements I_ServiceMasterService {

	@Autowired
	private ServiceMasterRepo serviceMasterRepo;

	public ServiceMasterDTO newServiceMaster(ServiceMasterDTO lMasters) {
		ServiceMaster ServiceMaster = serviceMasterRepo.save(this.setServiceMaster(lMasters));
		lMasters = getServiceMasterDTO(ServiceMaster);
		return lMasters;
	}

	public ArrayList<ServiceMasterDTO> getAllServiceMasters() {
		ArrayList<ServiceMaster> serviceList = (ArrayList<ServiceMaster>) serviceMasterRepo.findAll();
		ArrayList<ServiceMasterDTO> lMasterss = new ArrayList<ServiceMasterDTO>();
		lMasterss = serviceList != null ? this.getServiceMasterDTOs(serviceList) : null;
		return lMasterss;
	}

	public ArrayList<ServiceMasterDTO> getSelectServices(ArrayList<Long> ids)
	{
		ArrayList<ServiceMaster> lMasters = serviceMasterRepo.getSelectServices(ids);
		ArrayList<ServiceMasterDTO> ServiceMasterDTOs = new ArrayList<ServiceMasterDTO>();
		ServiceMasterDTO ServiceMasterDTO = null;

		if (lMasters!=null) 
		{
		for (int i = 0; i < lMasters.size(); i++) {
			ServiceMasterDTO = this.getServiceMasterDTO(lMasters.get(i));
			ServiceMasterDTOs.add(ServiceMasterDTO);
		}
		}
		return ServiceMasterDTOs;
	}
   
	public ArrayList<ServiceMasterDTO> getSelectServicesByPriceRange(Float fr, Float to)
	{
		ArrayList<ServiceMaster> lMasters = serviceMasterRepo.getSelectServicesByPriceRange(fr, to);
		ArrayList<ServiceMasterDTO> ServiceMasterDTOs = new ArrayList<ServiceMasterDTO>();
		ServiceMasterDTO ServiceMasterDTO = null;

		if (lMasters!=null) 
		{
		for (int i = 0; i < lMasters.size(); i++) {
			ServiceMasterDTO = this.getServiceMasterDTO(lMasters.get(i));
			ServiceMasterDTOs.add(ServiceMasterDTO);
		}
		}
		return ServiceMasterDTOs;
	}

	
	public ArrayList<ServiceMasterDTO> getSelectServicesByCategories(ArrayList<BigDecimal> ids)
	{
		ArrayList<ServiceMaster> lMasters = serviceMasterRepo.getSelectServicesByCategories(ids);
		ArrayList<ServiceMasterDTO> ServiceMasterDTOs = new ArrayList<ServiceMasterDTO>();
		ServiceMasterDTO ServiceMasterDTO = null;

		if (lMasters!=null) 
		{
		for (int i = 0; i < lMasters.size(); i++) {
			ServiceMasterDTO = this.getServiceMasterDTO(lMasters.get(i));
			ServiceMasterDTOs.add(ServiceMasterDTO);
		}
		}
		return ServiceMasterDTOs;
	}

	public ArrayList<ServiceMasterDTO> getSelectServicesByCompanies(ArrayList<Long> ids)
	{
		ArrayList<ServiceMaster> lMasters = serviceMasterRepo.getSelectServicesByCompanies(ids);
		ArrayList<ServiceMasterDTO> ServiceMasterDTOs = new ArrayList<ServiceMasterDTO>();
		ServiceMasterDTO ServiceMasterDTO = null;

		if (lMasters!=null) 
		{
		for (int i = 0; i < lMasters.size(); i++) {
			ServiceMasterDTO = this.getServiceMasterDTO(lMasters.get(i));
			ServiceMasterDTOs.add(ServiceMasterDTO);
		}
		}
		return ServiceMasterDTOs;
	}

	
	public ServiceMasterDTO getServiceMasterById(Long serviceSeqNo) {
		Optional<ServiceMaster> ServiceMaster = serviceMasterRepo.findById(serviceSeqNo);
		ServiceMasterDTO lMasters = null;
		if (ServiceMaster.isPresent()) {
			lMasters = ServiceMaster != null ? this.getServiceMasterDTO(ServiceMaster.get()) : null;
		}
		return lMasters;
	}

	public void updServiceMaster(ServiceMasterDTO lMaster) 
	{
		ServiceMaster serviceMaster = this.setServiceMaster(lMaster);
		if (serviceMasterRepo.existsById(lMaster.getServiceSeqNo())) 
				{		
			serviceMaster.setServiceSeqNo(lMaster.getServiceSeqNo());			
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
		if (serviceSeqNos != null) {
			serviceMasterRepo.delSelectServices(serviceSeqNos);
		}
	}

	
	private ArrayList<ServiceMasterDTO> getServiceMasterDTOs(ArrayList<ServiceMaster> lMasters) {
		ServiceMasterDTO lDTO = null;
		ArrayList<ServiceMasterDTO> lMasterDTOs = new ArrayList<ServiceMasterDTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getServiceMasterDTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ServiceMasterDTO getServiceMasterDTO(ServiceMaster lMaster) 
	{		
		ServiceMasterDTO lDTO = new ServiceMasterDTO();
		lDTO.setRemark(lMaster.getRemark());		
		lDTO.setServiceSeqNo(lMaster.getServiceSeqNo());
		lDTO.setUnitRate(lMaster.getUnitRate());
		lDTO.setUnitRateSeqNo(lMaster.getUnitRateSeqNo());
		lDTO.setDiscSeqNo(lMaster.getDiscSeqNo());
		lDTO.setTaxSeqNo(lMaster.getTaxSeqNo());
		lDTO.setDuration(lMaster.getDuration());
		lDTO.setSpecSeqNo(lMaster.getSpecSeqNo());				
		lDTO.setDescription(lMaster.getDescription());
		lDTO.setStatus(lMaster.getStatus());
		lDTO.setServiceId(lMaster.getServiceId());
		lDTO.setDurationCodeSeqNo(lMaster.getDurationCodeSeqNo());
		lDTO.setCompanySeqNo(lMaster.getCompanySeqNo());
		lDTO.setServiceCategorySeqNo(lMaster.getServiceCategorySeqNo());
		lDTO.setDiscPer(lMaster.getDiscPer());
		lDTO.setDiscVal(lMaster.getDiscVal());
		lDTO.setTaxPer(lMaster.getTaxPer());
		return lDTO;
	}

	private ServiceMaster setServiceMaster(ServiceMasterDTO lDTO)
	{
		ServiceMaster lMaster = new ServiceMaster();				
		lMaster.setRemark(lDTO.getRemark());
		lMaster.setUnitRate(lDTO.getUnitRate());
		lMaster.setUnitRateSeqNo(lDTO.getUnitRateSeqNo());
		lMaster.setDiscSeqNo(lDTO.getDiscSeqNo());
		lMaster.setTaxSeqNo(lDTO.getTaxSeqNo());
		lMaster.setDuration(lDTO.getDuration());
		lMaster.setSpecSeqNo(lDTO.getSpecSeqNo());				
		lMaster.setDescription(lDTO.getDescription());
		lMaster.setStatus(lDTO.getStatus());
		lMaster.setServiceId(lDTO.getServiceId());
		lMaster.setDurationCodeSeqNo(lDTO.getDurationCodeSeqNo());
		lMaster.setCompanySeqNo(lDTO.getCompanySeqNo());
		lMaster.setServiceCategorySeqNo(lDTO.getServiceCategorySeqNo());
		lMaster.setDiscPer(lDTO.getDiscPer());
		lMaster.setDiscVal(lDTO.getDiscVal());
		lMaster.setTaxPer(lDTO.getTaxPer());
		return lMaster;
	}
}