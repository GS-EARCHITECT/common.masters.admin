package resource.resource_master.controller;

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

import resource.resource_master.model.dto.ResourceMaster_DTO;
import resource.resource_master.service.I_ResourceMaster_Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceMasterManagement")
public class ResourceMaster_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(ResourceMaster_Controller.class);

	@Autowired
	private I_ResourceMaster_Service resourceMasterServ;
	
	@PostMapping("/new")
	public ResponseEntity<ResourceMaster_DTO> newresource(@RequestBody ResourceMaster_DTO resourceDTO) {
		ResourceMaster_DTO resourceDTO2 = resourceMasterServ.newMasterResource(resourceDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(resourceDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAlMasterResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceMaster_DTO>> getAllMasterResources() {
		ArrayList<ResourceMaster_DTO> resourceDTOs = resourceMasterServ.getAllMasterResources();
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectMasterResources", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceMaster_DTO>> getSelectMasterResources(@RequestBody ArrayList<Long> resourceSeqNos) {
		ArrayList<ResourceMaster_DTO> resourceDTOs = resourceMasterServ.getSelectMasterResources(resourceSeqNos);		
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}	
	
	@PutMapping("/updMasterResource")
	public void updateMasterResource(@RequestBody ResourceMaster_DTO resourceDTO) 
	{
			resourceMasterServ.updMasterResource(resourceDTO);	
		return;
	}

	@DeleteMapping("/delSelectMasterResources")
	public void deleteSelectMasterResources(@RequestBody ArrayList<Long> resourceSeqNoList) 
	{
		resourceMasterServ.delSelectMasterResources(resourceSeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllresource")
	public void deleteAllresources() {
		resourceMasterServ.delAllResourceMasters();;
		return;
	}
	}