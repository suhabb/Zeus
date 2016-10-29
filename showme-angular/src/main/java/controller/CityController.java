package controller;

import application_service.CityApplicationService;
import data_transfer.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    protected CityApplicationService cityApplicationService;

    @RequestMapping(value="/city/{cityName}",method= RequestMethod.GET)
      public CityDTO findCity(@PathVariable String cityName) throws Exception{

        System.out.println("CityController.findCity");
        CityDTO cityDTO = cityApplicationService.findByName(cityName);
        return cityDTO;
    }

    @RequestMapping(value="/country/{countrycode}",method= RequestMethod.GET)
    public CityDTO findByCountryCode(@PathVariable String countrycode) throws Exception{

        System.out.println("CityController.findCity");
        CityDTO cityDTO = cityApplicationService.findByCountryCode(countrycode);
        return cityDTO;
    }

    @RequestMapping(value="/test",method= RequestMethod.GET)
    public String test() throws Exception{

        System.out.println("CityController.findCity");
        return "test";
    }
}
