package rest_controller;

import application_service.CityApplicationService;
import data_transfer.ApiFailure;
import data_transfer.ApiResponse;
import data_transfer.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityRestController {

    @Autowired
    protected CityApplicationService cityApplicationService;

    @RequestMapping(value="/v1/city/{cityname}",method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
      public ResponseEntity<ApiResponse> findCity(@PathVariable("cityname") String cityName){
        try {
            System.out.println("CityController.findCity");
            CityDTO cityDTO = cityApplicationService.findByName(cityName);
            return new ResponseEntity<>(cityDTO, HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiFailure(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value="/country/{countrycode}",method= RequestMethod.GET)
    public CityDTO findByCountryCode(@PathVariable String countrycode) throws Exception{

        System.out.println("CityController.findCity");
        CityDTO cityDTO = cityApplicationService.findByCountryCode(countrycode);
        System.out.println("CityRestController.findByCountryCode:"+cityDTO);
        return cityDTO;
    }

    @RequestMapping(value="/test",method= RequestMethod.GET)
    public String test() throws Exception{

        System.out.println("CityController.findCity");
        return "test";
    }
}
