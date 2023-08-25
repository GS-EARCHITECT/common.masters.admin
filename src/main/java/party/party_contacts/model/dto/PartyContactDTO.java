package party.party_contacts.model.dto;

import java.io.Serializable;

public class PartyContactDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4954063028122027700L;
	private String mobileNo;
	private Long partySeqNo;
	private String onDttm;
	private String landline;
	private String emailId;
	private String remark;
	private String status;

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public String getOnDttm() {
		return onDttm;
	}

	public void setOnDttm(String onDttm) {
		this.onDttm = onDttm;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PartyContactDTO(String mobileNo, Long partySeqNo, String onDttm, String landline, String emailId,
			String remark, String status) {
		super();
		this.mobileNo = mobileNo;
		this.partySeqNo = partySeqNo;
		this.onDttm = onDttm;
		this.landline = landline;
		this.emailId = emailId;
		this.remark = remark;
		this.status = status;
	}

	public PartyContactDTO() {
		super();
	}

}