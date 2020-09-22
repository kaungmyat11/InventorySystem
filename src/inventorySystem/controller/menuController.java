package inventorySystem.controller;

import inventorySystem.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class menuController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameTextField;

    @FXML
    void quitBtnAction(ActionEvent event) {
        System.out.println("Quit Btn Clicked");
    }

    @FXML
    void signInBtnAction(ActionEvent event) {
        System.out.println("Sign In btn clicked");
        String username = usernameTextField.getText();
        String password = passwordField.getText();

        User user = new User(username, password);
        user.login(user.getUsername(), user.getPassword());
    }

}
