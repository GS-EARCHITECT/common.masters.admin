package enterprise.roles.model.dto;

import java.io.Serializable;

public class RoleMaster_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -106758251048314659L;
	private Long masterRoleSeqNo;
	private String role;
	private String remark;
	private Long specificationSeqNo;

	public Long getMasterRoleSeqNo() {
		return masterRoleSeqNo;
	}

	public void setMasterRoleSeqNo(Long masterRoleSeqNo) {
		this.masterRoleSeqNo = masterRoleSeqNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public RoleMaster_DTO(Long masterRoleSeqNo, String role, String remark, Long specificationSeqNo) {
		super();
		this.masterRoleSeqNo = masterRoleSeqNo;
		this.role = role;
		this.remark = remark;
		this.specificationSeqNo = specificationSeqNo;
	}

	public RoleMaster_DTO() {
		super();
	}

}