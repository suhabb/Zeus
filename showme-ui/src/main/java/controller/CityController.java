package controller;

import data_transfer.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service_access.CityApplicationServiceAccess;

@Controller
public class CityController {

    @Autowired
    protected CityApplicationServiceAccess cityApplicationServiceAccess;

    @RequestMapping("/city/{cityName}")
    public CityDTO getCityInfo(@PathVariable("cityName") String cityName){
        System.out.println("CityController.test");
        CityDTO cityDTO = cityApplicationServiceAccess.getCityInfo(cityName);
        System.out.println("CityController.getCityInfo:"+cityDTO);
        return cityDTO;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "Server Test:Success";

    }


}
