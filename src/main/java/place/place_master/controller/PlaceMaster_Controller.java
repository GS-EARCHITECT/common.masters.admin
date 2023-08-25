package place.place_master.controller;

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

import place.place_master.model.dto.PlaceMaster_DTO;
import place.place_master.service.I_PlaceMaster_Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/placeManagement")
public class PlaceMaster_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(PlaceMaster_Controller.class);

	@Autowired
	private I_PlaceMaster_Service placeMasterServ;
	
	@PostMapping("/new")
	public ResponseEntity<PlaceMaster_DTO> newplace(@RequestBody PlaceMaster_DTO placeDTO) {
		PlaceMaster_DTO placeDTO2 = placeMasterServ.newPlace(placeDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(placeDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllPlaces", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PlaceMaster_DTO>> getAllPlaces() 
	{
		ArrayList<PlaceMaster_DTO> placeDTOs = placeMasterServ.getAllPlaces();
		return new ResponseEntity<>(placeDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectPlaces", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PlaceMaster_DTO>> getSelectPlaces(@RequestBody ArrayList<Long> placeSeqNos) {
		ArrayList<PlaceMaster_DTO> placeDTOs = placeMasterServ.getSelectPlaces(placeSeqNos);		
		return new ResponseEntity<>(placeDTOs, HttpStatus.OK);
	}	
	
	@PutMapping("/updPlace")
	public void updatePlace(@RequestBody PlaceMaster_DTO placeDTO) 
	{
			placeMasterServ.updPlace(placeDTO);	
		return;
	}

	@DeleteMapping("/delSelectplace")
	public void deleteSelectplace(@RequestBody ArrayList<Long> placeSeqNoList) 
	{
		placeMasterServ.delSelectPlaces(placeSeqNoList);;
		return;
	}
	
	@DeleteMapping("/delAllplace")
	public void deleteAllplaces() {
		placeMasterServ.delAllPlaces();
		return;
	}
	}