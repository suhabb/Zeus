package data_transfer;


public class ProductDTO implements ApiResponse {

    private int id;
    private String category;
    private String description;
    private String name;
    private String price;
    private int count;

    public ProductDTO(int id, String category, String description, String name, String price,int count) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.name = name;
        this.price = price;
        this.count=count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
