package inventorySystem.model;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addItem(Item item) {
        dbConnect connect = new dbConnect();
        String query = "INSERT INTO items (name, brand, price, stock) VALUES ('" + item.getName() + "','" + item.getBrand() + "'," + item.getPrice() + "," + item.getStock() + ");";
        connect.executeQuery(query);
    }

    public void deleteItem(Item item) {
        dbConnect connect = new dbConnect();
        if (item.getId() == 0) {
            System.out.println("that item is not in the database!!!");
        } else {
            String query = "DELETE FROM items WHERE id  = " + item.getId() + ";";
            connect.executeQuery(query);
            System.out.println("you removed " + item.getName() + " items from inventory.");
        }
    }

    // TODO: Write this function changeItemPrice()
    public void changeItemPrice(int id, float price) {

    }

    // TODO: Don't forget to write this function
    public void reduceItem() {

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void login(String username, String password) {
        dbConnect databaseConnection = new dbConnect();
        String query = "SELECT * FROM users WHERE username = '" + username + "' AND pwd = SHA1('" + password + "');";
        databaseConnection.viewUser(query);
    }


    public void createNewUser() {
        dbConnect databaseConnection = new dbConnect();
        String query = "INSERT INTO users values('" + this.username + "',SHA1('" + this.password + "'));";
        databaseConnection.executeQuery(query);
    }
}
