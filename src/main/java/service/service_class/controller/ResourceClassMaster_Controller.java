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

import service_class.model.dto.ResourceClassMasterDTO;
import service_class.service.I_ResourceClassMasterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceClassManagement")
public class ResourceClassMaster_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ResourceClassMaster_Controller.class);

	@Autowired
	private I_ResourceClassMasterService resourceClassMasterServ;

	@PostMapping("/new")
	public ResponseEntity<ResourceClassMasterDTO> newResourceClass(
			@RequestBody ResourceClassMasterDTO resourceClassDTO) {
		ResourceClassMasterDTO resourceClassDTO2 = resourceClassMasterServ.newResourceClass(resourceClassDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(resourceClassDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllresourceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceClassMasterDTO>> getAllResourceClasses() {
		ArrayList<ResourceClassMasterDTO> resourceClassDTOs = resourceClassMasterServ.getAllResourceClasses();
		return new ResponseEntity<>(resourceClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectResourceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceClassMasterDTO>> getSelectResourceClasses(
			@RequestBody ArrayList<Long> resourceClassSeqNos) {
		ArrayList<ResourceClassMasterDTO> resourceClassDTOs = resourceClassMasterServ
				.getSelectResourceClasses(resourceClassSeqNos);
		return new ResponseEntity<>(resourceClassDTOs, HttpStatus.OK);
	}

	@PutMapping("/updResourceClass")
	public void updateResourceClass(@RequestBody ResourceClassMasterDTO resourceClassDTO) {
		resourceClassMasterServ.updResourceClass(resourceClassDTO);
		return;
	}

	@DeleteMapping("/delSelectResourceClasses")
	public void deleteSelectresourceClass(@RequestBody ArrayList<Long> resourceClassSeqNoList) {
		resourceClassMasterServ.delSelectResourceClasses(resourceClassSeqNoList);
		return;
	}

	@DeleteMapping("/delAllresourceClass")
	public void deleteAllresourceClasss() {
		resourceClassMasterServ.delAllResourceClasses();
		return;
	}
}