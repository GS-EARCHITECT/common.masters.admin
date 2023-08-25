package service.service_master.model.dto;

import java.io.Serializable;

public class ServiceMaster_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6794950918108392172L;
	private Long masterServiceSeqNo;
	private String description;
	private String serviceName;
	private Long specificationSeqNo;

	public Long getMasterServiceSeqNo() {
		return masterServiceSeqNo;
	}

	public void setMasterServiceSeqNo(Long masterServiceSeqNo) {
		this.masterServiceSeqNo = masterServiceSeqNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Long getSpecificationSeqNo() {
		return specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public ServiceMaster_DTO(Long masterServiceSeqNo, String description, String serviceName, Long specificationSeqNo) {
		super();
		this.masterServiceSeqNo = masterServiceSeqNo;
		this.description = description;
		this.serviceName = serviceName;
		this.specificationSeqNo = specificationSeqNo;
	}

	public ServiceMaster_DTO() {
		super();
	}

}