package enterprise.company_unit_class.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_UNIT_CLASS_MASTER database table.
 * 
 */
@Entity
@Table(name = "COMPANY_UNIT_CLASS_MASTER")
public class CompanyUnitClassMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4524548266687361686L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_UNIT_CLASS_SEQUENCE")
	@SequenceGenerator(name = "COMPANY_UNIT_CLASS_SEQUENCE", sequenceName = "COMPANY_UNIT_CLASS_SEQUENCE", allocationSize = 1)
	@Column(name = "UNIT_CLASS_SEQ_NO")
	private Long unitClassSeqNo;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	@Column(name = "UNITCLASS")
	private String unitclass;

	public CompanyUnitClassMaster() {
	}

	public Long getUnitClassSeqNo() {
		return this.unitClassSeqNo;
	}

	public void setUnitClassSeqNo(Long unitClassSeqNo) {
		this.unitClassSeqNo = unitClassSeqNo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSpecificationSeqNo() {
		return this.specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public String getUnitclass() {
		return this.unitclass;
	}

	public void setUnitclass(String unitclass) {
		this.unitclass = unitclass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((unitClassSeqNo == null) ? 0 : unitClassSeqNo.hashCode());
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
		CompanyUnitClassMaster other = (CompanyUnitClassMaster) obj;
		if (unitClassSeqNo == null) {
			if (other.unitClassSeqNo != null)
				return false;
		} else if (!unitClassSeqNo.equals(other.unitClassSeqNo))
			return false;
		return true;
	}

	public CompanyUnitClassMaster(Long unitClassSeqNo, String description, Long specificationSeqNo, String unitclass) {
		super();
		this.unitClassSeqNo = unitClassSeqNo;
		this.description = description;
		this.specificationSeqNo = specificationSeqNo;
		this.unitclass = unitclass;
	}

}