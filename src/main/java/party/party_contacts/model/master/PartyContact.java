package party.party_contacts.model.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PARTY_CONTACTS database table.
 * 
 */
@Entity
@Table(name="PARTY_CONTACTS")
public class PartyContact implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PartyContactPK id;

	@Column(name = "REMARK")	
	private String remark;

	@Column(name = "STATUS")
	private String status;

	public PartyContact() {
	}

	public PartyContactPK getId() {
		return this.id;
	}

	public void setId(PartyContactPK id) {
		this.id = id;
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

	public PartyContact(PartyContactPK id, String remark, String status) {
		super();
		this.id = id;
		this.remark = remark;
		this.status = status;
	}
	

}