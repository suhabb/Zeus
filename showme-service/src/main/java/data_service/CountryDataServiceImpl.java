package data_service;

import data_transfer.CountryDTO;
import domain.Country;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CountryRepository;

import java.util.List;

@Service
public class CountryDataServiceImpl implements CountryDataService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private MapperFacade mapper;

    @Override
    public void save(CountryDTO CountryDTO){
        Country country = mapper.map(CountryDTO,Country.class);
        countryRepository.save(country);
    }

    @Override
    public CountryDTO findByCapital(String capital){
        Country country = countryRepository.findByCapital(capital);
        CountryDTO CountryDTO = mapper.map(country,CountryDTO.class);
        return CountryDTO;
    }

    @Override
    public CountryDTO findByCode(String code) {
        Country country = countryRepository.findByCode(code);
        CountryDTO CountryDTO = mapper.map(country,CountryDTO.class);
        return CountryDTO;
    }

    @Override
    public CountryDTO findByName(String name) {
        Country country = countryRepository.findByCode(name);
        CountryDTO CountryDTO = mapper.map(country,CountryDTO.class);
        return CountryDTO;
    }

    @Override
    public List<CountryDTO> findAll(){
        List<Country> countryList = countryRepository.findAll();
        List<CountryDTO> CountryDTOList = mapper.mapAsList(countryList, CountryDTO.class);
        return CountryDTOList;
    }
}
