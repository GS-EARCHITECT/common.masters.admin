package enterprise.company_class.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class CompanyClassMaster_DTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4153135642139812866L;
	private Long companyClassSeqNo;	
	
	@NotEmpty
	@Size(min = 2, message = "user name should have at least 2 characters")
	private String companyClass;
	
	private String description;
	private String remark;
	private Long specificationSeqNo;
	private String status;

	public Long getCompanyClassSeqNo() {
		return companyClassSeqNo;
	}

	public void setCompanyClassSeqNo(Long companyClassSeqNo) {
		this.companyClassSeqNo = companyClassSeqNo;
	}

	public String getCompanyClass() {
		return companyClass;
	}

	public void setCompanyClass(String companyClass) {
		this.companyClass = companyClass;
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

	public CompanyClassMaster_DTO(Long companyClassSeqNo, String companyClass, String description, String remark,
			Long specificationSeqNo, String status) {
		super();
		this.companyClassSeqNo = companyClassSeqNo;
		this.companyClass = companyClass;
		this.description = description;
		this.remark = remark;
		this.specificationSeqNo = specificationSeqNo;
		this.status = status;
	}

	public CompanyClassMaster_DTO() {
		super();
	}

}