package enterprise.designations.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the DESIGNATION_MASTER database table.
 * 
 */
@Entity
@Table(name = "DESIGNATION_MASTER")
public class DesignationMaster implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 4790158729194091602L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "master_designation_sequence")
	@SequenceGenerator(name = "master_designation_sequence", sequenceName = "master_designation_sequence", allocationSize = 1)
	@Column(name = "MASTER_DESIGNATION_SEQ_NO")
	private Long masterDesignationSeqNo;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "SPECIFICATION_SEQ_NO")
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
		DesignationMaster other = (DesignationMaster) obj;
		if (specificationSeqNo == null) {
			if (other.specificationSeqNo != null)
				return false;
		} else if (!specificationSeqNo.equals(other.specificationSeqNo))
			return false;
		return true;
	}

	public DesignationMaster(Long masterDesignationSeqNo, String designation, String remark, Long specificationSeqNo) {
		super();
		this.masterDesignationSeqNo = masterDesignationSeqNo;
		this.designation = designation;
		this.remark = remark;
		this.specificationSeqNo = specificationSeqNo;
	}

	public DesignationMaster() {
		super();
	}

}