package controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInManualController implements Initializable {


    public TextField passwordField;
    public TextField usernameField;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        usernameField.setText("test@easv365.dk");
        passwordField.setText("●".repeat(8));
    }
}
