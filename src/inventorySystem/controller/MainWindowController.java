package inventorySystem.controller;

import inventorySystem.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainWindowController extends BaseController{

    @FXML
    private Label usernameLabel;

    @FXML
    void logOutBtnAction(ActionEvent event) {
        System.out.println("Log Out Btn Clicked");

    }

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }
}
