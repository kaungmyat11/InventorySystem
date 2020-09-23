package inventorySystem.view;

import inventorySystem.controller.BaseController;
import inventorySystem.controller.LoginWindowController;
import inventorySystem.controller.MainWindowController;
import inventorySystem.controller.SignUpWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private ArrayList<Stage> activeStages;

    public ViewFactory() {
        activeStages = new ArrayList<Stage>();
    }

    public void showLoginWindow() {
        System.out.println("Display Login Window");

        BaseController controller = new LoginWindowController(this, "LoginPage.fxml");
        initializeStage(controller);
    }

    public void showMainWindow() {
        System.out.println("Main Window displayed....");

        BaseController controller = new MainWindowController(this, "MainWindow.fxml");
        initializeStage(controller);
    }

    public void showSignUpWindow() {
        System.out.println("Sign Up Window displayed.");

        BaseController controller = new SignUpWindowController(this, "SignUpWindow.fxml");
        initializeStage(controller);
    }

    private void initializeStage(BaseController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        activeStages.add(stage);
    }

    public void closeStage(Stage stageToClose) {
        stageToClose.close();
        System.out.println("Stage is closed");
        activeStages.remove(stageToClose);
    }
}
