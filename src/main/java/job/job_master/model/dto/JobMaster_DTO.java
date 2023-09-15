package job.job_master.model.dto;

import java.io.Serializable;
import javax.persistence.*;

public class JobMaster_DTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8597016999940694442L;
	private long masterJobSeqNo;
	private String description;
	private String job;
	private Long specificationSeqNo;
	private Float duration;
	private Long durationCodeSeqNo;
	private String remark;

	public long getMasterJobSeqNo() {
		return masterJobSeqNo;
	}

	public void setMasterJobSeqNo(long masterJobSeqNo) {
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

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public Long getDurationCodeSeqNo() {
		return durationCodeSeqNo;
	}

	public void setDurationCodeSeqNo(Long durationCodeSeqNo) {
		this.durationCodeSeqNo = durationCodeSeqNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public JobMaster_DTO(long masterJobSeqNo, String description, String job, Long specificationSeqNo, Float duration,
			Long durationCodeSeqNo, String remark) {
		super();
		this.masterJobSeqNo = masterJobSeqNo;
		this.description = description;
		this.job = job;
		this.specificationSeqNo = specificationSeqNo;
		this.duration = duration;
		this.durationCodeSeqNo = durationCodeSeqNo;
		this.remark = remark;
	}

	public JobMaster_DTO() {
		super();
	}

}