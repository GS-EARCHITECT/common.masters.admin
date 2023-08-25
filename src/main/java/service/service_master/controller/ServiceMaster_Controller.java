package service.service_master.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.service_master.model.dto.ServiceMaster_DTO;
import service.service_master.service.I_ServiceMaster_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/serviceManagement")
public class ServiceMaster_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(ServiceMaster_Controller.class);

	@Autowired
	private I_ServiceMaster_Service serviceMasterServ;
	
	@PostMapping("/new")
	public ResponseEntity<ServiceMaster_DTO> newService(@RequestBody ServiceMaster_DTO serviceDTO) {
		ServiceMaster_DTO serviceDTO2 = serviceMasterServ.newServiceMaster(serviceDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(serviceDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllServices", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceMaster_DTO>> getAllServiceMasters() {
		ArrayList<ServiceMaster_DTO> serviceDTOs = serviceMasterServ.getAllServiceMasters();
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectServices", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceMaster_DTO>> getSelectServiceMasters(@RequestBody ArrayList<Long> serviceSeqNos) {
		ArrayList<ServiceMaster_DTO> serviceDTOs = serviceMasterServ.getSelectServices(serviceSeqNos);		
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}	
	
	@PutMapping("/updService")
	public void updateService(@RequestBody ServiceMaster_DTO serviceDTO) 
	{
		serviceMasterServ.updServiceMaster(serviceDTO);	
		return;
	}

	@DeleteMapping("/delSelectServices")
	public void deleteSelectServices(@RequestBody ArrayList<Long> serviceSeqNoList) 
	{
		serviceMasterServ.delSelectServices(serviceSeqNoList);;
		return;
	}
	
	@DeleteMapping("/delAllServices")
	public void deleteAllServices() {
		serviceMasterServ.delAllServiceMasters();;
		return;
	}
	}