package controller;

import data_transfer.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SportsStoreController {

    @GetMapping("/sports/store")
    public String getSportsApp(){
        return "html/sports_app";
    }

    @PostMapping(value = "/sports/store/order",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity takeOrder(@RequestBody OrderDTO orderDTO){
        System.out.println("SportsStoreController.takeOrder"+orderDTO.toString());
        return new ResponseEntity(orderDTO, HttpStatus.OK);

    }
}
