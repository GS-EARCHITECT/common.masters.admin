package place.place_master.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import place.place_master.model.dto.PlaceMaster_DTO;
import place.place_master.model.master.PlaceMaster;
import place.place_master.model.repo.PlaceMaster_Repo;

@Service("placeMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PlaceMaster_Service implements I_PlaceMaster_Service 
{

	@Autowired
	private PlaceMaster_Repo placeMasterRepo;

	public PlaceMaster_DTO newPlace(PlaceMaster_DTO lMaster) 
	{
		PlaceMaster PlaceMaster = placeMasterRepo.save(this.setPlaceMaster(lMaster));
		lMaster = getPlaceMasterDTO(PlaceMaster);
		return lMaster;
	}

	public ArrayList<PlaceMaster_DTO> getAllPlaces() 
	{
		ArrayList<PlaceMaster> placeList = (ArrayList<PlaceMaster>) placeMasterRepo.findAll();
		ArrayList<PlaceMaster_DTO> lMasters = new ArrayList<PlaceMaster_DTO>();
		lMasters = placeList != null ? this.getPlaceMasterDTOs(placeList) : null;
		return lMasters;
	}

	public ArrayList<PlaceMaster_DTO> getSelectPlaces(ArrayList<Long> ids)
	{
		ArrayList<PlaceMaster> lMasters = placeMasterRepo.getSelectPlaces(ids);
		ArrayList<PlaceMaster_DTO> placeMaster_DTOs = new ArrayList<PlaceMaster_DTO>();
		placeMaster_DTOs = lMasters != null ? this.getPlaceMasterDTOs(lMasters) : null;
		return placeMaster_DTOs;
	}

	public void updPlace(PlaceMaster_DTO lMaster) 
	{
		PlaceMaster placeMaster = this.setPlaceMaster(lMaster);
		if (placeMasterRepo.existsById(lMaster.getPlaceSeqNo())) 
		{		
			placeMaster.setPlaceSeqNo(lMaster.getPlaceSeqNo());			
			placeMasterRepo.save(placeMaster);			
		}
		return;
	}

	public void delAllPlaces() {
		placeMasterRepo.deleteAll();
	}

	public void delSelectPlaces(ArrayList<Long> placeSeqNos) 
	{
		if (placeSeqNos != null) 
		{
		placeMasterRepo.delSelectPlaces(placeSeqNos);
		}
	}

	
	private ArrayList<PlaceMaster_DTO> getPlaceMasterDTOs(ArrayList<PlaceMaster> lMasters) {
		PlaceMaster_DTO lDTO = null;
		ArrayList<PlaceMaster_DTO> lMasterDTOs = new ArrayList<PlaceMaster_DTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getPlaceMasterDTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private PlaceMaster_DTO getPlaceMasterDTO(PlaceMaster lMaster) 
	{		
		PlaceMaster_DTO lDTO = new PlaceMaster_DTO();
		lDTO.setRemark(lMaster.getRemark());		
		lDTO.setPlaceSeqNo(lMaster.getPlaceSeqNo());
		lDTO.setPlace(lMaster.getPlace());
		lDTO.setSpatialSeqNo(lMaster.getSpatialSeqNo());		
		lDTO.setStatus(lMaster.getStatus());
		lDTO.setSpecification_seq_no(lMaster.getSpecification_seq_no());
		lDTO.setRemark(lMaster.getRemark());
		return lDTO;
	}

	private PlaceMaster setPlaceMaster(PlaceMaster_DTO lDTO)
	{
		PlaceMaster lMaster = new PlaceMaster();				
		lMaster.setRemark(lDTO.getRemark());
		lMaster.setPlace(lDTO.getPlace());
		lMaster.setSpatialSeqNo(lDTO.getSpatialSeqNo());		
		lMaster.setStatus(lDTO.getStatus());
		lMaster.setSpecification_seq_no(lDTO.getSpecification_seq_no());
		lMaster.setRemark(lDTO.getRemark());		
		return lMaster;
	}
}