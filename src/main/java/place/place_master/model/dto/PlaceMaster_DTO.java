package place.place_master.model.dto;

import java.io.Serializable;

public class PlaceMaster_DTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8879197508084311550L;
	private Long placeSeqNo;
	private String place;
	private String remark;
	private Long spatialSeqNo;
	private Long specification_seq_no;
	private String status;

	public PlaceMaster_DTO() {
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

	public PlaceMaster_DTO(Long placeSeqNo, String place, String remark, Long spatialSeqNo, Long specification_seq_no,
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