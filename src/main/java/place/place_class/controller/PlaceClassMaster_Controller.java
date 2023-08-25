package place.place_class.controller;

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
import place.place_class.model.dto.PlaceClassMaster_DTO;
import place.place_class.service.I_PlaceClassMaster_Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/placeClassManagement")
public class PlaceClassMaster_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(PlaceClassMaster_Controller.class);

	@Autowired
	private I_PlaceClassMaster_Service placeClassMasterServ;

	@PostMapping("/new")
	public ResponseEntity<PlaceClassMaster_DTO> newPlaceClass(
			@RequestBody PlaceClassMaster_DTO placeClassDTO) {
		PlaceClassMaster_DTO placeClassDTO2 = placeClassMasterServ.newPlaceClass(placeClassDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(placeClassDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllPlaceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PlaceClassMaster_DTO>> getAllPlaceClasses() {
		ArrayList<PlaceClassMaster_DTO> placeClassDTOs = placeClassMasterServ.getAllPlaceClasses();
		return new ResponseEntity<>(placeClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectPlaceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PlaceClassMaster_DTO>> getSelectPlaceClasses(
			@RequestBody ArrayList<Long> placeClassSeqNos) {
		ArrayList<PlaceClassMaster_DTO> placeClassDTOs = placeClassMasterServ
				.getSelectPlaceClasses(placeClassSeqNos);
		return new ResponseEntity<>(placeClassDTOs, HttpStatus.OK);
	}

	@PutMapping("/updPlaceClass")
	public void updatePlaceClass(@RequestBody PlaceClassMaster_DTO placeClassDTO) {
		placeClassMasterServ.updPlaceClass(placeClassDTO);
		return;
	}

	@DeleteMapping("/delSelectPlaceClasses")
	public void deleteSelectplaceClass(@RequestBody ArrayList<Long> placeClassSeqNoList) {
		placeClassMasterServ.delSelectPlaceClasses(placeClassSeqNoList);
		return;
	}

	@DeleteMapping("/delAllplaceClass")
	public void deleteAllplaceClasss() {
		placeClassMasterServ.delAllPlaceClasses();
		return;
	}
}