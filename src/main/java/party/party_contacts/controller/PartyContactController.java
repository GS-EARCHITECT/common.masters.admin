package party.party_contacts.controller;

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

import party.party_contacts.model.dto.PartyContactDTO;
import party.party_contacts.services.I_PartyContactService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/partyContactManagement")
public class PartyContactController 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(PartyContact_Controller.class);

	@Autowired
	private I_PartyContactService partyContactServ;

	@PostMapping("/new")
	public ResponseEntity<PartyContactDTO> newPartyContact(@RequestBody PartyContactDTO PartyContactDTO) 
	{
		PartyContactDTO PartyContactDTO2 = partyContactServ.newPartyContact(PartyContactDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(PartyContactDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectPartyContacts", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyContactDTO>> getSelectPartyContacts(@RequestBody ArrayList<Long> ids)
	{
		ArrayList<PartyContactDTO> PartyContactDTOs = partyContactServ.getSelectPartyContacts(ids);
		return new ResponseEntity<>(PartyContactDTOs, HttpStatus.OK);
	}
	

	@GetMapping(value = "/getSelectPartiesByMobiles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyContactDTO>> getSelectPartiesByMobiles(@RequestBody ArrayList<Long> ids)
	{
		ArrayList<PartyContactDTO> PartyContactDTOs = partyContactServ.getSelectPartiesByMobiles(ids);
		return new ResponseEntity<>(PartyContactDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectPartiesByEmail/{emailid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyContactDTO>> getSelectPartiesByEmail(@PathVariable String emailid)
	{
		ArrayList<PartyContactDTO> PartyContactDTOs = partyContactServ.getSelectPartiesByEmail(emailid);
		return new ResponseEntity<>(PartyContactDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectPartiesByLandlines", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyContactDTO>> getSelectPartiesByLandlines(@RequestBody ArrayList<Long> ids)
	{
		ArrayList<PartyContactDTO> PartyContactDTOs = partyContactServ.getSelectPartiesByLandlines(ids);
		return new ResponseEntity<>(PartyContactDTOs, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getAllPartyContact", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyContactDTO>> getAllPartyContact() {
		ArrayList<PartyContactDTO> PartyContactDTOs = partyContactServ.getAllPartyContacts();
		return new ResponseEntity<>(PartyContactDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectPartyContactsBetweenTimes/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyContactDTO>> getSelectPartyContactsBetweenTimes(@RequestBody ArrayList<Long> ids, @PathVariable String fr, @PathVariable String to)
	{
		ArrayList<PartyContactDTO> PartyContactDTOs = partyContactServ.getSelectPartyContactsBetweenTimes(ids, fr, to);
		return new ResponseEntity<>(PartyContactDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updPartyContact")
	public void updatePartyContact(@RequestBody PartyContactDTO PartyContactDTO) {
		partyContactServ.updPartyContact(PartyContactDTO);
		return;
	}

	@DeleteMapping("/delSelectPartyContacts")
	public void delSelectPartyContacts(@RequestBody ArrayList<Long> ids)
	{
		partyContactServ.delSelectPartyContacts(ids);
	}

	@DeleteMapping("/delSelectPartiesByMobiles")
	public void delSelectPartiesByMobiles(@RequestBody ArrayList<Long> ids)
	{
		partyContactServ.delSelectPartiesByMobiles(ids);
	}
	
	@DeleteMapping("/delSelectPartiesByLandlines")
	public void delSelectPartiesByLandlines(@RequestBody ArrayList<Long> ids)
	{
		partyContactServ.delSelectPartiesByLandlines(ids);
	}
	
	@DeleteMapping("/delSelectPartiesByEmail/{emailid}")
	public void delSelectPartiesByEmail(@PathVariable String emailid)
	{
		partyContactServ.delSelectPartiesByEmail(emailid);
	}
	
	@DeleteMapping("/delSelectPartyContactsBetweenTimes/{fr}/{to}")	
	public void delSelectPartyContactsBetweenTimes(@RequestBody ArrayList<Long> ids, @PathVariable String fr, @PathVariable String to) 
	{
		partyContactServ.delSelectPartyContactsBetweenTimes(ids, fr, to);
		return;
	}

	@DeleteMapping("/delAllPartyContact")
	public void deleteAllPartyContact() {
		partyContactServ.delAllPartyContacts();
		return;
	}
}