package party.party_master.model.dto;

import java.io.Serializable;

public class PartyMasterDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 626656603095556532L;
	private Long partySeqNo;
	private String party;
	private String partyId;
	private String remark;
	private String status;

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
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

	public PartyMasterDTO(Long partySeqNo, String party, String partyId, String remark, String status) {
		super();
		this.partySeqNo = partySeqNo;
		this.party = party;
		this.partyId = partyId;
		this.remark = remark;
		this.status = status;
	}

	public PartyMasterDTO() {
		super();
	}

}