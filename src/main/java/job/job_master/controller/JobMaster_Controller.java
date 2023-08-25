package job.job_master.controller;

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

import job.job_master.model.dto.JobMaster_DTO;
import job.job_master.services.I_JobMaster_Service;

@RestController
@RequestMapping("/jobMasterMgmt")
public class JobMaster_Controller 
{
	@Autowired
	private I_JobMaster_Service jobMasterService;

	@PostMapping("/new")
	public ResponseEntity<JobMaster_DTO> newJob(@RequestBody JobMaster_DTO jcmDTO) {
		JobMaster_DTO JobMaster_DTO2 = jobMasterService.newJobMaster(jcmDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(JobMaster_DTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectJobMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobMaster_DTO>> getSelectJobMasters(
			@RequestBody ArrayList<Long> jobMasterSeqNos) {
		ArrayList<JobMaster_DTO> JobMaster_DTOs = jobMasterService
				.getSelectJobMasters(jobMasterSeqNos);
		return new ResponseEntity<>(JobMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobMaster_DTO>> getAllJobMasters() 
	{
		ArrayList<JobMaster_DTO> JobMaster_DTOs = jobMasterService.getAllJobMasters();
		return new ResponseEntity<>(JobMaster_DTOs, HttpStatus.OK);
	}

	@PutMapping("/jobMaster")
	public void updateJobMaster(@RequestBody JobMaster_DTO jcmDTO) {
		jobMasterService.updJobMaster(jcmDTO);
	}

	@DeleteMapping("/delAllJobMasters")
	public void deleteAllJobMasters() {
		jobMasterService.delAllJobMasters();
	}

	@DeleteMapping("/delSelectJobMasters")
	public void deleteSelectJobMasters(@RequestBody ArrayList<Long> jobMasterSeqNoList) 
	{
		jobMasterService.delSelectJobMasters(jobMasterSeqNoList);
	}
}