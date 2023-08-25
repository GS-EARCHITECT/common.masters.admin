package place.place_class.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import place.place_class.model.dto.PlaceClassMaster_DTO;
import place.place_class.model.master.PlaceClassMaster;
import place.place_class.model.repo.PlaceClassMaster_Repo;

@Service("placeClassMasterServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PlaceClassMasterService implements I_PlaceClassMaster_Service {

	@Autowired
	private PlaceClassMaster_Repo placeClassMasterRepo;

	public PlaceClassMaster_DTO newPlaceClass(PlaceClassMaster_DTO lMaster) {
		PlaceClassMaster PlaceClassMaster = placeClassMasterRepo.save(this.setPlaceClassMaster(lMaster));
		lMaster = getPlaceClassMaster_DTO(PlaceClassMaster);
		return lMaster;
	}

	public ArrayList<PlaceClassMaster_DTO> getAllPlaceClasses() {
		ArrayList<PlaceClassMaster> placeList = (ArrayList<PlaceClassMaster>) placeClassMasterRepo.findAll();
		ArrayList<PlaceClassMaster_DTO> lMasters = new ArrayList<PlaceClassMaster_DTO>();
		lMasters = placeList != null ? this.getPlaceClassMaster_DTOs(placeList) : null;
		return lMasters;
	}

	public ArrayList<PlaceClassMaster_DTO> getSelectPlaceClasses(ArrayList<Long> ids) {
		ArrayList<PlaceClassMaster> lMasters = placeClassMasterRepo.getSelectPlaceClasses(ids);
		ArrayList<PlaceClassMaster_DTO> placeClassMasterDTOs = new ArrayList<PlaceClassMaster_DTO>();
		placeClassMasterDTOs = lMasters != null ? this.getPlaceClassMaster_DTOs(lMasters) : null;
		return placeClassMasterDTOs;
	}

	public void updPlaceClass(PlaceClassMaster_DTO lMaster) {
		PlaceClassMaster placeClassMaster = null;
		if (placeClassMasterRepo.existsById(lMaster.getPlaceClassSeqNo())) {
			placeClassMaster = this.setPlaceClassMaster(lMaster);
			placeClassMaster.setPlaceClassSeqNo(lMaster.getPlaceClassSeqNo());
			placeClassMasterRepo.save(placeClassMaster);
		}
		return;
	}

	public void delAllPlaceClasses() {
		placeClassMasterRepo.deleteAll();
	}

	public void delSelectPlaceClasses(ArrayList<Long> placeClassSeqNos) {
		if (placeClassSeqNos != null) {
			placeClassMasterRepo.delSelectPlaceClasses(placeClassSeqNos);
		}
	}

	private ArrayList<PlaceClassMaster_DTO> getPlaceClassMaster_DTOs(ArrayList<PlaceClassMaster> lMasters) {
		PlaceClassMaster_DTO lDTO = null;
		ArrayList<PlaceClassMaster_DTO> lMasterDTOs = new ArrayList<PlaceClassMaster_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getPlaceClassMaster_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private PlaceClassMaster_DTO getPlaceClassMaster_DTO(PlaceClassMaster lMaster) {
		PlaceClassMaster_DTO lDTO = new PlaceClassMaster_DTO();
		lDTO.setPlaceClassSeqNo(lMaster.getPlaceClassSeqNo());
		lDTO.setPlaceClass(lMaster.getPlaceClass());
		return lDTO;
	}

	private PlaceClassMaster setPlaceClassMaster(PlaceClassMaster_DTO lDTO) {
		PlaceClassMaster lMaster = new PlaceClassMaster();
		lMaster.setPlaceClass(lDTO.getPlaceClass());
		return lMaster;
	}
}