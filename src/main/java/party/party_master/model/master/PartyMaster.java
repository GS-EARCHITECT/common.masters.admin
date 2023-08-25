package party.party_master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the PARTY_MASTER database table.
 * 
 */
@Entity
@Table(name = "PARTY_MASTER")
public class PartyMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "party_sequence")
	@SequenceGenerator(name = "party_sequence", allocationSize = 1)
	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	@Column(name = "PARTY")
	private String party;

	@Column(name = "PARTY_ID")
	private String partyId;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	public PartyMaster() {
	}

	public long getPartySeqNo() {
		return this.partySeqNo;
	}

	public void setPartySeqNo(long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public String getParty() {
		return this.party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getPartyId() {
		return this.partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((party == null) ? 0 : party.hashCode());
		result = prime * result + ((partyId == null) ? 0 : partyId.hashCode());
		result = prime * result + ((partySeqNo == null) ? 0 : partySeqNo.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		PartyMaster other = (PartyMaster) obj;
		if (party == null) {
			if (other.party != null)
				return false;
		} else if (!party.equals(other.party))
			return false;
		if (partyId == null) {
			if (other.partyId != null)
				return false;
		} else if (!partyId.equals(other.partyId))
			return false;
		if (partySeqNo == null) {
			if (other.partySeqNo != null)
				return false;
		} else if (!partySeqNo.equals(other.partySeqNo))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public PartyMaster(Long partySeqNo, String party, String partyId, String remark, String status) {
		super();
		this.partySeqNo = partySeqNo;
		this.party = party;
		this.partyId = partyId;
		this.remark = remark;
		this.status = status;
	}

}