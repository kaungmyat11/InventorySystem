package inventorySystem.model;

import java.sql.*;

public class dbConnect {
    private Connection connection;
    private Statement statement;

    public dbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/inventory_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void executeQuery(String query) {
        try {
            int result = statement.executeUpdate(query);
            if (result == 1) {
                System.out.println("Successfully Done!");
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error in SQL Statement: " + e);
        }
    }

    public boolean viewUser(String query) {
        try {
            ResultSet resultSet;
            resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                String username = resultSet.getString(1);
                String password = resultSet.getString(2);
                System.out.println("Username : " + username + "\t Password: " + password);
                System.out.println("You have successfully logged in");
                connection.close();
                return true;
            } else {
                System.out.println("Please check your username and password !!!!!");
                connection.close();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error in SQL Statement: " + e);
            return false;
        }
    }

    public int selectItemId(String query) {
        try {
            ResultSet resultSet;
            resultSet = statement.executeQuery(query);
            int id;
            if (resultSet.next()) {
                id = resultSet.getInt(1);
                return id;
            }
            return 0;
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return 0;
        }
    }

    public void showItems(String query) {
        try {
            ResultSet resultSet;
            resultSet = statement.executeQuery(query);
            int id;
            String name;
            String brand;
            float price;
            int stock;
            while (resultSet.next()) {
                id = resultSet.getInt(1);
                name = resultSet.getString(2);
                brand = resultSet.getString(3);
                price = resultSet.getFloat(4);
                stock = resultSet.getInt(5);
                System.out.println("Item Id : " + id);
                System.out.println("Item Name : " + name);
                System.out.println("Item Brand : " + brand);
                System.out.println("Item Price : $" + price);
                System.out.println("Item Stock : " + stock);
                System.out.println("____________________");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in SQL Statement: " + e);
        }
    }
}
