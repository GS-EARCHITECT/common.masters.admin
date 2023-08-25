package party.party_master.controller;

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

import party.party_master.model.dto.PartyMasterDTO;
import party.party_master.services.I_PartyMasterService;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/partyManagemente")
public class Party_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(Party_Party_Cuntroller.class);

	@Autowired
	private I_PartyMasterService partyServ;

	@PostMapping("/new")
	public ResponseEntity<PartyMasterDTO> newParty(@RequestBody PartyMasterDTO partyDTO) {
		PartyMasterDTO partyDTO2 = partyServ.newParty(partyDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(partyDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyMasterDTO>> getAllParties() {
		ArrayList<PartyMasterDTO> partyDTOs = partyServ.getAllParties();
		// logger.info("size :"+partyDTOs.size());
		return new ResponseEntity<>(partyDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyMasterDTO>> getSelectParties(@RequestBody ArrayList<Long> partyCuSeqNos) {
		ArrayList<PartyMasterDTO> partyDTOs = partyServ.getSelectParties(partyCuSeqNos);
		return new ResponseEntity<>(partyDTOs, HttpStatus.OK);
	}

	@PutMapping("/updParty")
	public void updateParty(@RequestBody PartyMasterDTO partyDTO) {
		partyServ.updParty(partyDTO);
	}

	@DeleteMapping("/delSelectParties")
	public void deleteSelectParties(@RequestBody ArrayList<Long> coSeqNoList) {
		partyServ.delSelectParties(coSeqNoList);
	}

	@DeleteMapping("/delAllParties")
	public void deleteAllPartys() {
		partyServ.delAllParties();
	}
}