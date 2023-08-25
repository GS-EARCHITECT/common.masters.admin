package job.job_class_master.model.dto;

import java.io.Serializable;

public class JobClassMaster_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7573540451358424883L;
	private long jobClassSeqNo;
	private String jobClass;
	private String remark;
	private String status;

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

	public JobClassMaster_DTO(long jobClassSeqNo, String jobClass, String remark, String status) {
		super();
		this.jobClassSeqNo = jobClassSeqNo;
		this.jobClass = jobClass;
		this.remark = remark;
		this.status = status;
	}

	public JobClassMaster_DTO() {
		super();
	}

}