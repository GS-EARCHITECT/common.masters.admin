package job.job_class_master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the JOB_CLASS_MASTER database table.
 * 
 */
@Entity
@Table(name = "JOB_CLASS_MASTER")
public class JobClassMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOB_CLASS_SEQUENCE")
	@SequenceGenerator(name = "JOB_CLASS_SEQUENCE", sequenceName = "JOB_CLASS_SEQUENCE", allocationSize = 1)
	@Column(name = "JOB_CLASS_SEQ_NO")
	private long jobClassSeqNo;

	@Column(name = "JOB_CLASS")
	private String jobClass;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	public JobClassMaster() {
	}

	public long getJobClassSeqNo() {
		return jobClassSeqNo;
	}

	public void setJobClassSeqNo(long jobClassSeqNo) {
		this.jobClassSeqNo = jobClassSeqNo;
	}

	public String getJobClass() {
		return jobClass;
	}

	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobClass == null) ? 0 : jobClass.hashCode());
		result = prime * result + (int) (jobClassSeqNo ^ (jobClassSeqNo >>> 32));
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		JobClassMaster other = (JobClassMaster) obj;
		if (jobClass == null) {
			if (other.jobClass != null)
				return false;
		} else if (!jobClass.equals(other.jobClass))
			return false;
		if (jobClassSeqNo != other.jobClassSeqNo)
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public JobClassMaster(long jobClassSeqNo, String jobClass, String remark, String status) {
		super();
		this.jobClassSeqNo = jobClassSeqNo;
		this.jobClass = jobClass;
		this.remark = remark;
		this.status = status;
	}

}