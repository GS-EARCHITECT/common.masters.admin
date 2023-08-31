package enterprise.roles.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ROLE_MASTER database table.
 * 
 */
@Entity
@Table(name = "ROLE_MASTER")
public class RoleMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3784179299838452297L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "master_role_sequence")
	@SequenceGenerator(name = "master_role_sequence", sequenceName = "master_role_sequence", allocationSize = 1)
	@Column(name = "MASTER_ROLE_SEQ_NO")
	private Long masterRoleSeqNo;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "SPECIFICATION_SEQ_NO")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((specificationSeqNo == null) ? 0 : specificationSeqNo.hashCode());
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
		RoleMaster other = (RoleMaster) obj;
		if (specificationSeqNo == null) {
			if (other.specificationSeqNo != null)
				return false;
		} else if (!specificationSeqNo.equals(other.specificationSeqNo))
			return false;
		return true;
	}

	public RoleMaster(Long masterRoleSeqNo, String role, String remark, Long specificationSeqNo) {
		super();
		this.masterRoleSeqNo = masterRoleSeqNo;
		this.role = role;
		this.remark = remark;
		this.specificationSeqNo = specificationSeqNo;
	}

	public RoleMaster() {
		super();
	}

}