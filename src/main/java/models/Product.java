package models;

public class Product {
    private int id;
    private String name;
    private int price;
    private String img;
    private Category category;
    private Boolean status;

    public Product(String name, int price, String img, Category category, Boolean status) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.category = category;
        this.status = status;
    }

    public Product(int id, String name, int price, String img, Category category, Boolean status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.category = category;
        this.status = status;
    }

    public int getId() {
        return id;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
