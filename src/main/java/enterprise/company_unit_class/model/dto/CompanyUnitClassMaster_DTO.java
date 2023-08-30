package enterprise.company_unit_class.model.dto;

import java.io.Serializable;

public class CompanyUnitClassMaster_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5562271870463619943L;
	private Long unitClassSeqNo;
	private String description;
	private Long specificationSeqNo;
	private String unitclass;

	public Long getUnitClassSeqNo() {
		return unitClassSeqNo;
	}

	public void setUnitClassSeqNo(Long unitClassSeqNo) {
		this.unitClassSeqNo = unitClassSeqNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSpecificationSeqNo() {
		return specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public String getUnitclass() {
		return unitclass;
	}

	public void setUnitclass(String unitclass) {
		this.unitclass = unitclass;
	}

	public CompanyUnitClassMaster_DTO(Long unitClassSeqNo, String description, Long specificationSeqNo,
			String unitclass) {
		super();
		this.unitClassSeqNo = unitClassSeqNo;
		this.description = description;
		this.specificationSeqNo = specificationSeqNo;
		this.unitclass = unitclass;
	}

	public CompanyUnitClassMaster_DTO() {
		super();
	}

}