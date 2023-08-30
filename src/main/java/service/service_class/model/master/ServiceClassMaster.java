package service.service_class.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SERVICE_CLASS_MASTER database table.
 * 
 */
@Entity
@Table(name = "SERVICE_CLASS_MASTER")
public class ServiceClassMaster implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SERVICE_CLASS_SEQUENCE")
	@SequenceGenerator(name = "SERVICE_CLASS_SEQUENCE", sequenceName = "SERVICE_CLASS_SEQUENCE", allocationSize = 1)
	@Column(name = "SERVICE_CLASS_SEQ_NO")
	private long serviceClassSeqNo;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "SERVICE_CLASS")
	private String serviceClass;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	@Column(name = "STATUS")
	private String status;

	public ServiceClassMaster() {
	}

	public long getServiceClassSeqNo() {
		return this.serviceClassSeqNo;
	}

	public void setServiceClassSeqNo(long serviceClassSeqNo) {
		this.serviceClassSeqNo = serviceClassSeqNo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServiceClass() {
		return this.serviceClass;
	}

	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}

	public Long getSpecificationSeqNo() {
		return this.specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (serviceClassSeqNo ^ (serviceClassSeqNo >>> 32));
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
		ServiceClassMaster other = (ServiceClassMaster) obj;
		if (serviceClassSeqNo != other.serviceClassSeqNo)
			return false;
		return true;
	}

	public ServiceClassMaster(long serviceClassSeqNo, String description, String serviceClass,
			java.lang.Long specificationSeqNo, String status) {
		super();
		this.serviceClassSeqNo = serviceClassSeqNo;
		this.description = description;
		this.serviceClass = serviceClass;
		this.specificationSeqNo = specificationSeqNo;
		this.status = status;
	}

}