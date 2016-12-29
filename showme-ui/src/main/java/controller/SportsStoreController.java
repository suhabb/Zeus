package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SportsStoreController {

    @GetMapping("/sports/store")
    public String getSportsApp(){
        return "html/sports_app";
    }
}
