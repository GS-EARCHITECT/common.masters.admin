package job.job_class_master.controller;

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

import job.job_class_master.model.dto.JobClassMaster_DTO;
import job.job_class_master.services.I_JobClassMaster_Service;

@RestController
@RequestMapping("/jobClassMasterMgmt")
public class JobClassMaster_Controller 
{
	@Autowired
	private I_JobClassMaster_Service jobClassMasterService;

	@PostMapping("/new")
	public ResponseEntity<JobClassMaster_DTO> newJobClass(@RequestBody JobClassMaster_DTO jcmDTO) {
		JobClassMaster_DTO JobClassMaster_DTO2 = jobClassMasterService.newJobClass(jcmDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(JobClassMaster_DTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectJobClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobClassMaster_DTO>> getSelectJobClassMasters(
			@RequestBody ArrayList<Long> jobClassMasterSeqNos) {
		ArrayList<JobClassMaster_DTO> JobClassMaster_DTOs = jobClassMasterService
				.getSelectJobClasses(jobClassMasterSeqNos);
		return new ResponseEntity<>(JobClassMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobClassMaster_DTO>> getAllJobClassMasters() 
	{
		ArrayList<JobClassMaster_DTO> JobClassMaster_DTOs = jobClassMasterService.getAllJobClasses();
		return new ResponseEntity<>(JobClassMaster_DTOs, HttpStatus.OK);
	}

	@PutMapping("/jobClass")
	public void updateJobClassMaster(@RequestBody JobClassMaster_DTO jcmDTO) {
		jobClassMasterService.updJobClass(jcmDTO);
	}

	@DeleteMapping("/delAllJobClassMasters")
	public void deleteAllJobClassMasters() {
		jobClassMasterService.delAllJobClasses();
	}

	@DeleteMapping("/delSelectJobClasses")
	public void deleteSelectJobClassMasters(@RequestBody ArrayList<Long> JobClassMasterSeqNoList) 
	{
		jobClassMasterService.delSelectJobClasses(JobClassMasterSeqNoList);
	}
}