package controller;

import data_transfer.OrderDTO;
import data_transfer.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import util.OrderUtil;

@Controller
public class SportsStoreController {

    @GetMapping("/sports/store")
       public String getSportsApp(){
        return "html/sports_app";
    }

    @GetMapping("/sports/admin")
    public String getAdminStoreApp(){
        return "html/sports_admin";
    }

    @GetMapping(value = "/sports/admin/orders",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getOrders(){
        System.out.println("SportsStoreController.getOrders");
        return new ResponseEntity(OrderUtil.getOrders(), HttpStatus.OK);
    }

    @PostMapping(value = "/sports/store/order",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity takeOrder(@RequestBody OrderDTO orderDTO){
        System.out.println("SportsStoreController.takeOrder"+orderDTO.toString());
        return new ResponseEntity(orderDTO, HttpStatus.OK);

    }

    @PostMapping(value = "/sports/admin/login",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity authenticate(@RequestBody UserDTO userDTO){
        System.out.println("SportsStoreController.authenticate:"+userDTO.toString());
        return new ResponseEntity(Boolean.TRUE, HttpStatus.OK);

    }
}
