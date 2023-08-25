package party.party_class.model.dto;

import java.io.Serializable;

public class PartyClassMaster_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6676991319616933437L;
	private Long PartyClassSeqNo;
	private String PartyClass;

	public Long getPartyClassSeqNo() {
		return PartyClassSeqNo;
	}

	public void setPartyClassSeqNo(Long partyClassSeqNo) {
		PartyClassSeqNo = partyClassSeqNo;
	}

	public String getPartyClass() {
		return PartyClass;
	}

	public void setPartyClass(String partyClass) {
		PartyClass = partyClass;
	}

	public PartyClassMaster_DTO(Long partyClassSeqNo, String partyClass) {
		super();
		PartyClassSeqNo = partyClassSeqNo;
		PartyClass = partyClass;
	}

	public PartyClassMaster_DTO() {
		super();
	}

}