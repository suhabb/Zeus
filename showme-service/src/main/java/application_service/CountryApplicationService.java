package application_service;

import data_transfer.CountryDTO;

import java.util.List;


public interface CountryApplicationService {
    CountryDTO findByName(String name);

    void save(CountryDTO cityDTO);

    CountryDTO findByCapital(String capital);

    CountryDTO findByCode(String code);


    List<CountryDTO> findAll();
}
