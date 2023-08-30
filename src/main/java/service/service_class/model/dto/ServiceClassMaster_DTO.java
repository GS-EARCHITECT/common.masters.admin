package service.service_class.model.dto;

import java.io.Serializable;

public class ServiceClassMaster_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2199657975128388962L;
	private Long serviceClassSeqNo;
	private String description;
	private String serviceClass;
	private Long specificationSeqNo;
	private String status;

	public Long getServiceClassSeqNo() {
		return serviceClassSeqNo;
	}

	public void setServiceClassSeqNo(Long serviceClassSeqNo) {
		this.serviceClassSeqNo = serviceClassSeqNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}

	public Long getSpecificationSeqNo() {
		return specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ServiceClassMaster_DTO(Long serviceClassSeqNo, String description, String serviceClass,
			Long specificationSeqNo, String status) {
		super();
		this.serviceClassSeqNo = serviceClassSeqNo;
		this.description = description;
		this.serviceClass = serviceClass;
		this.specificationSeqNo = specificationSeqNo;
		this.status = status;
	}

	public ServiceClassMaster_DTO() {
		super();
	}

}