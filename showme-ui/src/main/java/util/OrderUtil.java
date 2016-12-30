package util;

import data_transfer.OrderDTO;
import data_transfer.ProductDTO;

import java.util.Arrays;
import java.util.List;

public class OrderUtil {

    public static List<OrderDTO> getOrders(){

        ProductDTO productDTO1= new ProductDTO(1212,"Watersports","A boat for one person","Kayak","275",2);
        ProductDTO productDTO2= new ProductDTO(1213,"Soccer","A boat for one person","Rohit","223",4);
        ProductDTO productDTO3= new ProductDTO(1214,"Stadium","A boat for one person","RAHUL","22563",1);
        ProductDTO productDTO4= new ProductDTO(1215,"Cap","A boat for one person","Daniel","23.24",2);
        ProductDTO productDTO5= new ProductDTO(1215,"Chess","A fun game for the family","Bond","23.24",1);
        OrderDTO orderDTO1 = new OrderDTO(1212,"Su","hathway road","Kings College","London","LN5678","UK",Arrays.asList(productDTO1,productDTO2));
        OrderDTO orderDTO2 = new OrderDTO(1213,"Ku","Hanna road","Cambdrige College","Cambridge","CM5678","UK",Arrays.asList(productDTO2));
        OrderDTO orderDTO3 = new OrderDTO(1214,"Ru","Ikea road","Birmingham College","Birmingham","BM5678","UK",Arrays.asList(productDTO3,productDTO5));
        OrderDTO orderDTO4 = new OrderDTO(1215,"Lu","braodway road","Edinburgh College","Edinburgh","ED5678","UK",Arrays.asList(productDTO4));
        return Arrays.asList(orderDTO1,orderDTO2,orderDTO3,orderDTO4);


    }
}
