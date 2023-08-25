package service.service_class.controller;

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
import service.service_class.model.dto.ServiceClassMaster_DTO;
import service.service_class.service.I_ServiceClassMaster_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/serviceClassManagement")
public class ServiceClassMaster_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(serviceClassMaster_Controller.class);

	@Autowired
	private I_ServiceClassMaster_Service serviceClassMasterServ;

	@PostMapping("/new")
	public ResponseEntity<ServiceClassMaster_DTO> newserviceClass(
			@RequestBody ServiceClassMaster_DTO serviceClassDTO) {
		ServiceClassMaster_DTO serviceClassDTO2 = serviceClassMasterServ.newServiceClass(serviceClassDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(serviceClassDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllServiceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceClassMaster_DTO>> getAllServiceClasses() {
		ArrayList<ServiceClassMaster_DTO> serviceClassDTOs = serviceClassMasterServ.getAllServiceClasses();
		return new ResponseEntity<>(serviceClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectServiceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceClassMaster_DTO>> getSelectServiceClasses(
			@RequestBody ArrayList<Long> serviceClassSeqNos) {
		ArrayList<ServiceClassMaster_DTO> serviceClassDTOs = serviceClassMasterServ
				.getSelectServiceClasses(serviceClassSeqNos);
		return new ResponseEntity<>(serviceClassDTOs, HttpStatus.OK);
	}

	@PutMapping("/updServiceClass")
	public void updateServiceClass(@RequestBody ServiceClassMaster_DTO serviceClassDTO) {
		serviceClassMasterServ.updServiceClass(serviceClassDTO);
		return;
	}

	@DeleteMapping("/delSelectServiceClasses")
	public void deleteSelectServiceClass(@RequestBody ArrayList<Long> serviceClassSeqNoList) {
		serviceClassMasterServ.delSelectServiceClasses(serviceClassSeqNoList);
		return;
	}

	@DeleteMapping("/delAllServiceClass")
	public void deleteAllServiceClasss() {
		serviceClassMasterServ.delAllServiceClasses();
		return;
	}
}