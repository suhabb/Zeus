package application_service;

import data_service.CountryDataService;
import data_transfer.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {


    @Autowired
    protected CountryDataService countryDataService;


    @Override
    public CountryDTO findByName(String name) {
        return countryDataService.findByCode(name);
    }


    @Override
    public void save(CountryDTO countryDTO) {
        countryDataService.save(countryDTO);
    }

    @Override
    public CountryDTO findByCapital(String capital) {
        return countryDataService.findByCapital(capital);
    }

    @Override
    public CountryDTO findByCode(String countryCode) {
        return countryDataService.findByCode(countryCode);
    }
    @Override
    public List<CountryDTO> findAll() {
        return countryDataService.findAll();
    }
}

