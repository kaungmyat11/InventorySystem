package inventorySystem.controller;

import inventorySystem.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpWindowController extends BaseController{
    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField pwdField;

    @FXML
    private PasswordField confirmPwdField;

    @FXML
    private Label messageLabel;

    public SignUpWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void backBtnAction(ActionEvent event) {
        System.out.println("Back Btn Clicked");
    }

    @FXML
    void signUpBtnAction(ActionEvent event) {
        System.out.println("Sign Up Btn Clicked");
    }
}
