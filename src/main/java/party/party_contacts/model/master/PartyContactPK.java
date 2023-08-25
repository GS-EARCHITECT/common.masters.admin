package party.party_contacts.model.master;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * The primary key class for the PARTY_CONTACTS database table.
 * 
 */
@Embeddable
public class PartyContactPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7517919880007403486L;

	@Column(name = "MOBILE_NO")
	private String mobileNo;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	@Column(name = "ON_DTTM")
	private Timestamp onDttm;

	@Column(name = "LANDLINE")
	private String landline;

	@Column(name = "EMAIL_ID")
	private String emailId;

	public PartyContactPK() {
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Long getPartySeqNo() {
		return this.partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public Timestamp getOnDttm() {
		return this.onDttm;
	}

	public void setOnDttm(Timestamp onDttm) {
		this.onDttm = onDttm;
	}

	public String getLandline() {
		return this.landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PartyContactPK)) {
			return false;
		}
		PartyContactPK castOther = (PartyContactPK) other;
		return this.mobileNo.equals(castOther.mobileNo) && (this.partySeqNo == castOther.partySeqNo)
				&& this.onDttm.equals(castOther.onDttm) && this.landline.equals(castOther.landline)
				&& this.emailId.equals(castOther.emailId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.mobileNo.hashCode();
		hash = hash * prime + ((int) (this.partySeqNo ^ (this.partySeqNo >>> 32)));
		hash = hash * prime + this.onDttm.hashCode();
		hash = hash * prime + this.landline.hashCode();
		hash = hash * prime + this.emailId.hashCode();

		return hash;
	}

	public PartyContactPK(String mobileNo, Long partySeqNo, Timestamp onDttm, String landline, String emailId) {
		super();
		this.mobileNo = mobileNo;
		this.partySeqNo = partySeqNo;
		this.onDttm = onDttm;
		this.landline = landline;
		this.emailId = emailId;
	}

}