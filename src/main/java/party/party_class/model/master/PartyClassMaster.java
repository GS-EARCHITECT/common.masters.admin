package party.party_class.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the Party_CLASS_MASTER database table.
 * 
 */
@Entity
@Table(name = "PARTY_CLASS_MASTER")
public class PartyClassMaster implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8958804966726141357L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARTY_CLASS_SEQUENCE")
	@SequenceGenerator(name = "PARTY_CLASS_SEQUENCE", sequenceName = "PARTY_CLASS_SEQUENCE", allocationSize = 1)
	@Column(name = "Party_CLASS_SEQ_NO")
	private Long PartyClassSeqNo;

	@Column(name = "Party_CLASS")
	private String PartyClass;

	public PartyClassMaster() {
	}

	public Long getPartyClassSeqNo() {
		return this.PartyClassSeqNo;
	}

	public void setPartyClassSeqNo(Long PartyClassSeqNo) {
		this.PartyClassSeqNo = PartyClassSeqNo;
	}

	public String getPartyClass() {
		return this.PartyClass;
	}

	public void setPartyClass(String PartyClass) {
		this.PartyClass = PartyClass;
	}

	
	public PartyClassMaster(Long PartyClassSeqNo, String PartyClass) {
		super();
		this.PartyClassSeqNo = PartyClassSeqNo;
		this.PartyClass = PartyClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PartyClassSeqNo == null) ? 0 : PartyClassSeqNo.hashCode());
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
		PartyClassMaster other = (PartyClassMaster) obj;
		if (PartyClassSeqNo == null) {
			if (other.PartyClassSeqNo != null)
				return false;
		} else if (!PartyClassSeqNo.equals(other.PartyClassSeqNo))
			return false;
		return true;
	}
	
	
}