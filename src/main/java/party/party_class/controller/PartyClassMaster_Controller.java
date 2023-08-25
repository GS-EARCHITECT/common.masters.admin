package party.party_class.controller;

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
import party.party_class.model.dto.PartyClassMaster_DTO;
import party.party_class.service.I_PartyClassMaster_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/partyClassManagement")
public class PartyClassMaster_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(PartyClassMaster_Controller.class);

	@Autowired
	private I_PartyClassMaster_Service partyClassMasterServ;

	@PostMapping("/new")
	public ResponseEntity<PartyClassMaster_DTO> newPartyClass(@RequestBody PartyClassMaster_DTO partyClassDTO) {
		PartyClassMaster_DTO partyClassDTO2 = partyClassMasterServ.newPartyClass(partyClassDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(partyClassDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllPartyClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyClassMaster_DTO>> getAllPartyClasses() {
		ArrayList<PartyClassMaster_DTO> partyClassDTOs = partyClassMasterServ.getAllPartyClasses();
		return new ResponseEntity<>(partyClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectPartyClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyClassMaster_DTO>> getSelectPartyClasses(
			@RequestBody ArrayList<Long> partyClassSeqNos) {
		ArrayList<PartyClassMaster_DTO> partyClassDTOs = partyClassMasterServ.getSelectPartyClasses(partyClassSeqNos);
		return new ResponseEntity<>(partyClassDTOs, HttpStatus.OK);
	}

	@PutMapping("/updPartyClass")
	public void updatePartyClass(@RequestBody PartyClassMaster_DTO partyClassDTO) {
		partyClassMasterServ.updPartyClass(partyClassDTO);
		return;
	}

	@DeleteMapping("/delSelectPartyClasses")
	public void deleteSelectpartyClass(@RequestBody ArrayList<Long> partyClassSeqNoList) {
		partyClassMasterServ.delSelectPartyClasses(partyClassSeqNoList);
		return;
	}

	@DeleteMapping("/delAllPartyClasses")
	public void deleteAllpartyClasses() {
		partyClassMasterServ.delAllPartyClasses();
		return;
	}
}