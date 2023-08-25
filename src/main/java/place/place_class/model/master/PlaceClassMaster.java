package place.place_class.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the PLACE_CLASS_MASTER database table.
 * 
 */
@Entity
@Table(name = "PLACE_CLASS_MASTER")
public class PlaceClassMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLACE_CLASS_SEQUENCE")
	@SequenceGenerator(name = "PLACE_CLASS_SEQUENCE", sequenceName = "PLACE_CLASS_SEQUENCE", allocationSize = 1)
	@Column(name = "PLACE_CLASS_SEQ_NO")
	private Long placeClassSeqNo;

	@Column(name = "PLACE_CLASS")
	private String placeClass;

	public PlaceClassMaster() {
	}

	public Long getPlaceClassSeqNo() {
		return this.placeClassSeqNo;
	}

	public void setPlaceClassSeqNo(Long placeClassSeqNo) {
		this.placeClassSeqNo = placeClassSeqNo;
	}

	public String getPlaceClass() {
		return this.placeClass;
	}

	public void setPlaceClass(String placeClass) {
		this.placeClass = placeClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placeClass == null) ? 0 : placeClass.hashCode());
		result = prime * result + ((placeClassSeqNo == null) ? 0 : placeClassSeqNo.hashCode());
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
		PlaceClassMaster other = (PlaceClassMaster) obj;
		if (placeClass == null) {
			if (other.placeClass != null)
				return false;
		} else if (!placeClass.equals(other.placeClass))
			return false;
		if (placeClassSeqNo == null) {
			if (other.placeClassSeqNo != null)
				return false;
		} else if (!placeClassSeqNo.equals(other.placeClassSeqNo))
			return false;
		return true;
	}

	public PlaceClassMaster(Long placeClassSeqNo, String placeClass) {
		super();
		this.placeClassSeqNo = placeClassSeqNo;
		this.placeClass = placeClass;
	}

}