package resource.resource_class.model.dto;

import java.io.Serializable;

public class ResourceClassMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6261948832917948940L;
	private Long resourceClassSeqNo;
	private String description;
	private String remark;
	private String resourceClass;
	private Long specificationSeqNo;
	private String status;

	public Long getResourceClassSeqNo() {
		return resourceClassSeqNo;
	}

	public void setResourceClassSeqNo(Long resourceClassSeqNo) {
		this.resourceClassSeqNo = resourceClassSeqNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getResourceClass() {
		return resourceClass;
	}

	public void setResourceClass(String resourceClass) {
		this.resourceClass = resourceClass;
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

	public ResourceClassMasterDTO(Long resourceClassSeqNo, String description, String remark, String resourceClass,
			Long specificationSeqNo, String status) {
		super();
		this.resourceClassSeqNo = resourceClassSeqNo;
		this.description = description;
		this.remark = remark;
		this.resourceClass = resourceClass;
		this.specificationSeqNo = specificationSeqNo;
		this.status = status;
	}

	public ResourceClassMasterDTO() {
		super();
	}

}