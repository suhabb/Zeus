package data_transfer;


import java.util.List;
import java.util.Random;

public class OrderDTO implements ApiResponse {

    private int id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    private List<ProductDTO> productDTOList;


    public OrderDTO(int id, String name, String street, String city, String state, String zip, String country, List<ProductDTO> productDTO) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.productDTOList = productDTO;
    }

    public int getId() {
        Integer orderId = new Random().nextInt(90000) + 10000;
        return orderId;
    }

    public void setId(int id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public List<ProductDTO> getProductDTO() {
        return productDTOList;
    }

    public void setProductDTO(List<ProductDTO> productDTO) {
        this.productDTOList = productDTO;
    }
    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}
