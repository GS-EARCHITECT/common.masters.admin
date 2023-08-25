package resource.resource_master.model.dto;

import java.io.Serializable;

public class ResourceMaster_DTO implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1907797078515290941L;
	private Long masterResourceSeqNo;
	private String description;
	private String resourceName;
	private Long specificationSeqNo;

	public Long getMasterResourceSeqNo() {
		return masterResourceSeqNo;
	}

	public void setMasterResourceSeqNo(Long masterResourceSeqNo) {
		this.masterResourceSeqNo = masterResourceSeqNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Long getSpecificationSeqNo() {
		return specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public ResourceMaster_DTO(Long masterResourceSeqNo, String description, String resourceName,
			Long specificationSeqNo) {
		super();
		this.masterResourceSeqNo = masterResourceSeqNo;
		this.description = description;
		this.resourceName = resourceName;
		this.specificationSeqNo = specificationSeqNo;
	}

	public ResourceMaster_DTO() {
		super();
	}

}