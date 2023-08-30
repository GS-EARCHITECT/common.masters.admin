package enterprise.company_unit_class.controller;

import java.util.ArrayList;
import javax.validation.Valid;
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
import enterprise.company_unit_class.exception_handler.*;
import enterprise.company_unit_class.model.dto.CompanyUnitClassMaster_DTO;
import enterprise.company_unit_class.services.I_CompanyUnitClassMasterAdmin_Service;


@RestController
@RequestMapping("/companyUnitClassAdminManagement")
public class CompanyUnitClassMasterAdmin_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(Unit_Unit_Classntroller.class);

	@Autowired
	private I_CompanyUnitClassMasterAdmin_Service companyUnitClassAdminServ;

	@PostMapping("/new")
	public ResponseEntity<CompanyUnitClassMaster_DTO> newUnit(@Valid @RequestBody CompanyUnitClassMaster_DTO companyUnitClassDTO) {
		CompanyUnitClassMaster_DTO companyUnitClassDTO2 = companyUnitClassAdminServ.newCompanyUnitClass(companyUnitClassDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyUnitClassDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllCompanyUnitClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitClassMaster_DTO>> getAllCompanyUnitClasses() {
		ArrayList<CompanyUnitClassMaster_DTO> companyUnitClassDTOs = companyUnitClassAdminServ.getAllCompanyUnitClasses();
		return new ResponseEntity<>(companyUnitClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCompanyUnitClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitClassMaster_DTO>> getSelectCompanyUnitClasses(@RequestBody ArrayList<Long> companyUnitClassSeqNos) {
		ArrayList<CompanyUnitClassMaster_DTO> companyUnitClassDTOs = companyUnitClassAdminServ.getSelectCompanyUnitClasses(companyUnitClassSeqNos);
		
		if(companyUnitClassDTOs==null) 
		{
		throw new CompanyUnitClass_Exception("Not found Tutorial with id = ");	
		}
		else
		{
		return new ResponseEntity<>(companyUnitClassDTOs, HttpStatus.OK);
		}
	}

	@PutMapping("/updCompanyUnitClass")
	public void updateCompanyUnitClass(@Valid @RequestBody CompanyUnitClassMaster_DTO companyUnitClassDTO) 
	{
		companyUnitClassAdminServ.updCompanyUnitClass(companyUnitClassDTO);
	}

	@DeleteMapping("/delSelectCompanyUnitClasses")
	public void deleteSelectCompanyUnitClasses(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitClassAdminServ.delSelectCompanyUnitClasses(coSeqNoList);
	}

	@DeleteMapping("/delAllCompanyUnitClasses")
	public void deleteAllCompanyUnitClasses() {
		companyUnitClassAdminServ.delAllCompanyUnitClasses();
	}
}