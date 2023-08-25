package place.place_master.service;

import java.util.ArrayList;

import place.place_master.model.dto.PlaceMaster_DTO;

public interface I_PlaceMaster_Service
{
    abstract public PlaceMaster_DTO newPlace(PlaceMaster_DTO placeMaster_DTO);
    abstract public ArrayList<PlaceMaster_DTO> getAllPlaces();    
    abstract public ArrayList<PlaceMaster_DTO> getSelectPlaces(ArrayList<Long> ids);
    abstract public void updPlace(PlaceMaster_DTO PlaceMaster_DTO);
    abstract public void delAllPlaces();    
    abstract public void delSelectPlaces(ArrayList<Long> ids);
}