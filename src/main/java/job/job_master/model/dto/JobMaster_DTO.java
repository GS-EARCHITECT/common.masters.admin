package job.job_master.model.dto;

import java.io.Serializable;

public class JobMaster_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5754784176029228756L;
	private Long masterJobSeqNo;
	private String description;
	private String job;
	private Long specificationSeqNo;

	public Long getMasterJobSeqNo() {
		return masterJobSeqNo;
	}

	public void setMasterJobSeqNo(Long masterJobSeqNo) {
		this.masterJobSeqNo = masterJobSeqNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Long getSpecificationSeqNo() {
		return specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public JobMaster_DTO(Long masterJobSeqNo, String description, String job, Long specificationSeqNo) {
		super();
		this.masterJobSeqNo = masterJobSeqNo;
		this.description = description;
		this.job = job;
		this.specificationSeqNo = specificationSeqNo;
	}

	public JobMaster_DTO() {
		super();
	}

}