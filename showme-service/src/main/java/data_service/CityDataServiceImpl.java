package data_service;

import data_transfer.CityDTO;
import domain.City;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CityRepository;

import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private MapperFacade mapper;



    @Override
    public void save(CityDTO cityDTO){
        City city = mapper.map(cityDTO,City.class);
        cityRepository.save(city);
    }

    @Override
    public CityDTO findByName(String name){
        City city = cityRepository.findByName(name);
        CityDTO cityDTO = mapper.map(city,CityDTO.class);
        return cityDTO;
    }

    @Override
    public CityDTO findByCountryCode(String countryCode) {
        City city = cityRepository.findByCountryCode(countryCode);
        CityDTO cityDTO = mapper.map(city,CityDTO.class);
        return cityDTO;
    }

    @Override
    public List<CityDTO> findAll(){
        List<City> cityList = cityRepository.findAll();
        List<CityDTO> cityDTOList = mapper.mapAsList(cityList, CityDTO.class);
        return cityDTOList;
    }
}
