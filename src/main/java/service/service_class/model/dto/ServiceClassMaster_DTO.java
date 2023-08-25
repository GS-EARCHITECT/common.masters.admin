package service.service_class.model.dto;

import java.io.Serializable;

public class ServiceClassMaster_DTO implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7483337602951096186L;
	private Long serviceClassSeqNo;
	private String description;
	private String remark;
	private String serviceClass;
	private Long specificationSeqNo;
	private String status;

	public ServiceClassMaster_DTO() {
	}

	public Long getServiceClassSeqNo() {
		return this.serviceClassSeqNo;
	}

	public void setServiceClassSeqNo(Long serviceClassSeqNo) {
		this.serviceClassSeqNo = serviceClassSeqNo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((serviceClass == null) ? 0 : serviceClass.hashCode());
		result = prime * result + (int) (serviceClassSeqNo ^ (serviceClassSeqNo >>> 32));
		result = prime * result + ((specificationSeqNo == null) ? 0 : specificationSeqNo.hashCode());
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
		ServiceClassMaster_DTO other = (ServiceClassMaster_DTO) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (serviceClass == null) {
			if (other.serviceClass != null)
				return false;
		} else if (!serviceClass.equals(other.serviceClass))
			return false;
		if (serviceClassSeqNo != other.serviceClassSeqNo)
			return false;
		if (specificationSeqNo == null) {
			if (other.specificationSeqNo != null)
				return false;
		} else if (!specificationSeqNo.equals(other.specificationSeqNo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public ServiceClassMaster_DTO(Long serviceClassSeqNo, String description, String remark, String serviceClass,
			java.lang.Long specificationSeqNo, String status) {
		super();
		this.serviceClassSeqNo = serviceClassSeqNo;
		this.description = description;
		this.remark = remark;
		this.serviceClass = serviceClass;
		this.specificationSeqNo = specificationSeqNo;
		this.status = status;
	}

}