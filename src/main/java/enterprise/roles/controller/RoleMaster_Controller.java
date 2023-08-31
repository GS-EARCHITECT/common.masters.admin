package enterprise.roles.controller;

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
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import enterprise.roles.model.dto.RoleMaster_DTO;
import enterprise.roles.services.I_RoleMaster_Service;

@RestController
@RequestMapping("/roleMasterManagement")
public class RoleMaster_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(Role_Role_Cuntroller.class);

	@Autowired
	private I_RoleMaster_Service roleServ;

	@PostMapping("/new")
	public ResponseEntity<RoleMaster_DTO> newRole(@RequestBody RoleMaster_DTO roleDTO) {
		RoleMaster_DTO roleDTO2 = roleServ.newRole(roleDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(roleDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllRoles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<RoleMaster_DTO>> getAllRoles() {
		ArrayList<RoleMaster_DTO> roleDTOs = roleServ.getAllRoles();
		// logger.info("size :"+roleDTOs.size());
		return new ResponseEntity<>(roleDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectRoles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<RoleMaster_DTO>> getSelectRoles(@RequestBody ArrayList<Long> roleCuSeqNos) {
		ArrayList<RoleMaster_DTO> roleDTOs = roleServ.getSelectRoles(roleCuSeqNos);
		return new ResponseEntity<>(roleDTOs, HttpStatus.OK);
	}

	@PutMapping("/updRole")
	public void updateRole(@RequestBody RoleMaster_DTO roleDTO) {
		roleServ.updRole(roleDTO);
	}

	@DeleteMapping("/delSelectRoles")
	public void deleteSelectRoles(@RequestBody ArrayList<Long> coSeqNoList) {
		roleServ.delSelectRoles(coSeqNoList);
	}

	@DeleteMapping("/delAllRoles")
	public void deleteAllRoles() {
		roleServ.delAllRoles();
	}
}