package job.job_master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the JOB_MASTER database table.
 * 
 */
@Entity
@Table(name = "JOB_MASTER")
public class JobMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MASTER_JOB_SEQUENCE")
	@SequenceGenerator(name = "MASTER_JOB_SEQUENCE", sequenceName = "MASTER_JOB_SEQUENCE", allocationSize = 1)
	@Column(name = "MASTER_JOB_SEQ_NO")
	private long masterJobSeqNo;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "JOB")
	private String job;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	@Column(name = "DURATION")
	private Float duration;

	@Column(name = "DURATION_CODE_SEQ_NO")
	private Long durationCodeSeqNo;

	@Column(name = "REMARK")
	private String remark;

	public JobMaster() {
	}

	public long getMasterJobSeqNo() {
		return this.masterJobSeqNo;
	}

	public void setMasterJobSeqNo(long masterJobSeqNo) {
		this.masterJobSeqNo = masterJobSeqNo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getDuration() {
		return this.duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public Long getDurationCodeSeqNo() {
		return this.durationCodeSeqNo;
	}

	public void setDurationCodeSeqNo(Long durationCodeSeqNo) {
		this.durationCodeSeqNo = durationCodeSeqNo;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getSpecificationSeqNo() {
		return this.specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((durationCodeSeqNo == null) ? 0 : durationCodeSeqNo.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + (int) (masterJobSeqNo ^ (masterJobSeqNo >>> 32));
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((specificationSeqNo == null) ? 0 : specificationSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobMaster other = (JobMaster) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (durationCodeSeqNo == null) {
			if (other.durationCodeSeqNo != null)
				return false;
		} else if (!durationCodeSeqNo.equals(other.durationCodeSeqNo))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (masterJobSeqNo != other.masterJobSeqNo)
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (specificationSeqNo == null) {
			if (other.specificationSeqNo != null)
				return false;
		} else if (!specificationSeqNo.equals(other.specificationSeqNo))
			return false;
		return true;
	}

	public JobMaster(long masterJobSeqNo, String description, String job, Long specificationSeqNo, Float duration,
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

}