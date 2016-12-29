package data_service;

import data_transfer.CountryDTO;

import java.util.List;

public interface CountryDataService {
    void save(CountryDTO CountryDTO);

    CountryDTO findByCapital(String capital);

    CountryDTO findByCode(String code);

    CountryDTO findByName(String name);

    List<CountryDTO> findAll();
}
