package enterprise.company_class.model.master;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_CLASS_MASTER database table.
 * 
 */
@Entity
@Table(name = "COMPANY_CLASS_MASTER")
public class CompanyClassMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_class_sequence")
	@SequenceGenerator(name = "company_class_sequence", sequenceName = "company_class_sequence", allocationSize = 1)
	@Column(name = "COMPANY_CLASS_SEQ_NO")
	private Long companyClassSeqNo;

	@NotBlank(message = "-Company Class Mandatory-")
	@Column(name = "COMPANY_CLASS")
	private String companyClass;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	public CompanyClassMaster() {
	}

	public Long getCompanyClassSeqNo() {
		return this.companyClassSeqNo;
	}

	public void setCompanyClassSeqNo(Long companyClassSeqNo) {
		this.companyClassSeqNo = companyClassSeqNo;
	}

	public String getCompanyClass() {
		return this.companyClass;
	}

	public void setCompanyClass(String companyClass) {
		this.companyClass = companyClass;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyClassSeqNo == null) ? 0 : companyClassSeqNo.hashCode());
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
		CompanyClassMaster other = (CompanyClassMaster) obj;
		if (companyClassSeqNo == null) {
			if (other.companyClassSeqNo != null)
				return false;
		} else if (!companyClassSeqNo.equals(other.companyClassSeqNo))
			return false;
		return true;
	}

	public CompanyClassMaster(Long companyClassSeqNo,
			@NotBlank(message = "-Company Class Mandatory-") String companyClass, String description,
			Long specificationSeqNo) {
		super();
		this.companyClassSeqNo = companyClassSeqNo;
		this.companyClass = companyClass;
		this.description = description;
		this.specificationSeqNo = specificationSeqNo;
	}

}