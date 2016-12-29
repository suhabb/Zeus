package rest_controller;

import application_service.CountryApplicationService;
import data_transfer.ApiFailure;
import data_transfer.ApiResponse;
import data_transfer.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryRestController {


    @Autowired
    protected CountryApplicationService countryApplicationService;

    @GetMapping(value="/v1/country/{countryname}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ApiResponse> findCountry(@PathVariable("countryname") String countryName){
        try {
            CountryDTO countryDTO = countryApplicationService.findByName(countryName);
            return new ResponseEntity<>(countryDTO, HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiFailure(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value="/v1/countrycode/{code}")
    public CountryDTO findByCode(@PathVariable String code) throws Exception{

        CountryDTO countryDTO = countryApplicationService.findByCode(code);
        return countryDTO;
    }

    @GetMapping(value="/v1/country/test")
    public String test() throws Exception{

        System.out.println("CountryRestController");
        return "test";
    }
}
