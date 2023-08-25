package place.place_master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the PLACE_MASTER database table.
 * 
 */
@Entity
@Table(name = "PLACE_MASTER")
public class PlaceMaster implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 952445728136536399L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLACE_MASTER_SEQUENCE")
	@SequenceGenerator(name = "PLACE_MASTER_SEQUENCE", sequenceName = "PLACE_MASTER_SEQUENCE", allocationSize = 1)
	@Column(name = "PLACE_SEQ_NO")
	private Long placeSeqNo;

	@Column(name = "PLACE")
	private String place;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "SPATIAL_SEQ_NO")
	private Long spatialSeqNo;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specification_seq_no;

	@Column(name = "STATUS")
	private String status;

	public PlaceMaster() {
	}

	public Long getPlaceSeqNo() {
		return this.placeSeqNo;
	}

	public void setPlaceSeqNo(Long placeSeqNo) {
		this.placeSeqNo = placeSeqNo;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getSpatialSeqNo() {
		return this.spatialSeqNo;
	}

	public void setSpatialSeqNo(Long spatialSeqNo) {
		this.spatialSeqNo = spatialSeqNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSpecification_seq_no() {
		return specification_seq_no;
	}

	public void setSpecification_seq_no(Long specification_seq_no) {
		this.specification_seq_no = specification_seq_no;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placeSeqNo == null) ? 0 : placeSeqNo.hashCode());
		result = prime * result + ((spatialSeqNo == null) ? 0 : spatialSeqNo.hashCode());
		result = prime * result + ((specification_seq_no == null) ? 0 : specification_seq_no.hashCode());
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
		PlaceMaster other = (PlaceMaster) obj;
		if (placeSeqNo == null) {
			if (other.placeSeqNo != null)
				return false;
		} else if (!placeSeqNo.equals(other.placeSeqNo))
			return false;
		if (spatialSeqNo == null) {
			if (other.spatialSeqNo != null)
				return false;
		} else if (!spatialSeqNo.equals(other.spatialSeqNo))
			return false;
		if (specification_seq_no == null) {
			if (other.specification_seq_no != null)
				return false;
		} else if (!specification_seq_no.equals(other.specification_seq_no))
			return false;
		return true;
	}

	public PlaceMaster(Long placeSeqNo, String place, String remark, Long spatialSeqNo, Long specification_seq_no,
			String status) {
		super();
		this.placeSeqNo = placeSeqNo;
		this.place = place;
		this.remark = remark;
		this.spatialSeqNo = spatialSeqNo;
		this.specification_seq_no = specification_seq_no;
		this.status = status;
	}

}