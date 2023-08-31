package enterprise.designations.model.dto;

import java.io.Serializable;

public class DesignationMaster_DTO implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 8131651897718092996L;
	private Long masterDesignationSeqNo;
	private String designation;
	private String remark;
	private Long specificationSeqNo;

	public Long getMasterDesignationSeqNo() {
		return masterDesignationSeqNo;
	}

	public void setMasterDesignationSeqNo(Long masterDesignationSeqNo) {
		this.masterDesignationSeqNo = masterDesignationSeqNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getSpecificationSeqNo() {
		return specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public DesignationMaster_DTO(Long masterDesignationSeqNo, String designation, String remark, Long specificationSeqNo) {
		super();
		this.masterDesignationSeqNo = masterDesignationSeqNo;
		this.designation = designation;
		this.remark = remark;
		this.specificationSeqNo = specificationSeqNo;
	}

	public DesignationMaster_DTO() {
		super();
	}

}