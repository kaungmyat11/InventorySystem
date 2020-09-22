package inventorySystem.model;

public class Item {
    private int id;
    private String name;
    private String brand;
    private float price;
    private int stock;

    public Item(String name, String brand,float price, int stock) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        dbConnect connect = new dbConnect();
        String query = "SELECT * FROM items WHERE name = '" + this.getName() + "' AND brand = '" + this.getBrand() + "'";
        int id = connect.selectItemId(query);
        if (id == 0) {
            System.out.println("This item is not in the database.");
        } else {
            return id;
        }
        return 0;
    }
}
