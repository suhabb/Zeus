package rest_controller;

import application_service.CountryApplicationService;
import data_transfer.ApiFailure;
import data_transfer.ApiResponse;
import data_transfer.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryRestController {


    @Autowired
    protected CountryApplicationService countryApplicationService;

    @RequestMapping(value="/v1/country/{countryname}",method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ApiResponse> findCity(@PathVariable("countryname") String countryName){
        try {
            System.out.println("CityController.findCity");
            CountryDTO countryDTO = countryApplicationService.findByName(countryName);
            return new ResponseEntity<>(countryDTO, HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiFailure(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value="/v1/countrycode/{code}",method= RequestMethod.GET)
    public CountryDTO findByCode(@PathVariable String code) throws Exception{

        System.out.println("CountryRestController.findCode");
        CountryDTO countryDTO = countryApplicationService.findByCode(code);
        System.out.println("CityRestController.findByCountryCode:"+countryDTO);
        return countryDTO;
    }

    @RequestMapping(value="/v1/country/test",method= RequestMethod.GET)
    public String test() throws Exception{

        System.out.println("CountryRestController");
        return "test";
    }
}
