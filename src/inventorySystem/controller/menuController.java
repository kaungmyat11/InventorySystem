package inventorySystem.controller;

import inventorySystem.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class menuController {
    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Label errorMessageLabel;

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
        boolean isOk = user.login(user.getUsername(), user.getPassword());
        AnchorPane.setLeftAnchor(errorMessageLabel, 0.0);
        AnchorPane.setRightAnchor(errorMessageLabel, 0.0);
        errorMessageLabel.setAlignment(Pos.CENTER);
        if (isOk) {
            errorMessageLabel.setText("SignIn Successful");
        } else {
            errorMessageLabel.setText("Please check your username and password again!");
        }
    }

}
