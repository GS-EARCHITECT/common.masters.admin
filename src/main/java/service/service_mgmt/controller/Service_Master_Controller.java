package service.service_mgmt.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service_mgmt.model.dto.ServiceMasterDTO;
import service_mgmt.service.I_ServiceMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/serviceManagement")
public class Service_Master_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(ServiceMaster_Controller.class);

	@Autowired
	private I_ServiceMasterService serviceMasterServ;
	
	@PostMapping("/new")
	public ResponseEntity<ServiceMasterDTO> newservice(@RequestBody ServiceMasterDTO serviceDTO) {
		ServiceMasterDTO serviceDTO2 = serviceMasterServ.newServiceMaster(serviceDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(serviceDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllserviceies", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceMasterDTO>> getAllServiceMasters() {
		ArrayList<ServiceMasterDTO> serviceDTOs = serviceMasterServ.getAllServiceMasters();
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectServices", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceMasterDTO>> getSelectServiceMasters(@RequestBody ArrayList<Long> serviceSeqNos) {
		ArrayList<ServiceMasterDTO> serviceDTOs = serviceMasterServ.getSelectServices(serviceSeqNos);		
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectServicesByCategories", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceMasterDTO>> getSelectServiceMastersByCategories(@RequestBody ArrayList<BigDecimal> serviceCateSeqNos) {
		ArrayList<ServiceMasterDTO> serviceDTOs = serviceMasterServ.getSelectServicesByCategories(serviceCateSeqNos);		
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectServicesByCompanies", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceMasterDTO>> getSelectServiceMastersByCompanies(@RequestBody ArrayList<Long> cos) {
		ArrayList<ServiceMasterDTO> serviceDTOs = serviceMasterServ.getSelectServicesByCompanies(cos);		
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectServicesByPriceRange/{fr}/{to}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceMasterDTO>> getSelectServiceMastersByPriceRange(@PathVariable Float fr, @PathVariable Float to) {
		ArrayList<ServiceMasterDTO> serviceDTOs = serviceMasterServ.getSelectServicesByPriceRange(fr, to);		
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getById/{serviceSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })	
	public ResponseEntity<ServiceMasterDTO> getServiceMasterById(@PathVariable Long serviceSeqNo) 
	{
		ServiceMasterDTO serviceAccNoDTOs = serviceMasterServ.getServiceMasterById(serviceSeqNo);		
		return new ResponseEntity<>(serviceAccNoDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updservice")
	public void updateservice(@RequestBody ServiceMasterDTO serviceDTO) 
	{
			serviceMasterServ.updServiceMaster(serviceDTO);	
		return;
	}

	@DeleteMapping("/delservice/{serviceSeqNo}")
	public void deleteservice(@PathVariable Long serviceSeqNo) {
		serviceMasterServ.delServiceMaster(serviceSeqNo);
	}

	@DeleteMapping("/delSelectservice")
	public void deleteSelectservice(@RequestBody ArrayList<Long> serviceSeqNoList) {
		serviceMasterServ.delSelectServices(serviceSeqNoList);;
		return;
	}
	
	@DeleteMapping("/delAllservice")
	public void deleteAllservices() {
		serviceMasterServ.delAllServiceMasters();;
		return;
	}
	}