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
	private Long masterJobSeqNo;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "JOB")
	private String job;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	public JobMaster() {
	}

	public Long getMasterJobSeqNo() {
		return this.masterJobSeqNo;
	}

	public void setMasterJobSeqNo(Long masterJobSeqNo) {
		this.masterJobSeqNo = masterJobSeqNo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Long getSpecificationSeqNo() {
		return this.specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public JobMaster(Long masterJobSeqNo, String description, String job, Long specificationSeqNo) {
		super();
		this.masterJobSeqNo = masterJobSeqNo;
		this.description = description;
		this.job = job;
		this.specificationSeqNo = specificationSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((masterJobSeqNo == null) ? 0 : masterJobSeqNo.hashCode());
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
		if (masterJobSeqNo == null) {
			if (other.masterJobSeqNo != null)
				return false;
		} else if (!masterJobSeqNo.equals(other.masterJobSeqNo))
			return false;
		return true;
	}

}