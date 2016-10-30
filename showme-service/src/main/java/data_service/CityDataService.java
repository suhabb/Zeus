package data_service;

import data_transfer.CityDTO;

import java.util.List;


public interface CityDataService {

    void save(CityDTO cityDTO);

    CityDTO findByName(String name);
    CityDTO findByCountryCode(String countryCode);

    List<CityDTO> findAll();
}
