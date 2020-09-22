package inventorySystem;

import inventorySystem.model.dbConnect;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {



    public static void viewItems() {
        dbConnect connection = new dbConnect();
        String query = "SELECT * FROM items";
        connection.showItems(query);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader root = new FXMLLoader(getClass().getResource("/inventorySystem/view/Menu.fxml"));
        stage.setTitle("Inventory System");
        Scene scene = new Scene((Parent)root.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
