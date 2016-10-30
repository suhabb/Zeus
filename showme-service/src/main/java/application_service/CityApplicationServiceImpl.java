package application_service;

import data_service.CityDataService;
import data_transfer.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityApplicationServiceImpl implements CityApplicationService {

    @Autowired
    protected CityDataService cityDataService;


    @Override
    public void save(CityDTO cityDTO){
        cityDataService.save(cityDTO);
    }

    @Override
    public CityDTO findByName(String name){
        return cityDataService.findByName(name);
    }

    @Override
    public CityDTO findByCountryCode(String countryCode) {
        return cityDataService.findByCountryCode(countryCode);
    }


    @Override
    public List<CityDTO> findAll(){
        return cityDataService.findAll();
    }
}
