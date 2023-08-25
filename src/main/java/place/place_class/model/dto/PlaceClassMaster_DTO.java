package place.place_class.model.dto;

import java.io.Serializable;

public class PlaceClassMaster_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8657186406003020674L;
	private Long placeClassSeqNo;
	private String placeClass;

	public Long getPlaceClassSeqNo() {
		return placeClassSeqNo;
	}

	public void setPlaceClassSeqNo(Long placeClassSeqNo) {
		this.placeClassSeqNo = placeClassSeqNo;
	}

	public String getPlaceClass() {
		return placeClass;
	}

	public void setPlaceClass(String placeClass) {
		this.placeClass = placeClass;
	}

	public PlaceClassMaster_DTO(Long placeClassSeqNo, String placeClass) {
		super();
		this.placeClassSeqNo = placeClassSeqNo;
		this.placeClass = placeClass;
	}

	public PlaceClassMaster_DTO() {
		super();
	}

}