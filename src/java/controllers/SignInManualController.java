package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SignInManualController implements Initializable {


    @FXML public TextField passwordField;
    @FXML public TextField usernameField;
    @FXML public Button btnSignIn;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        usernameField.setText("test@easv365.dk");
        passwordField.setText("●".repeat(8));
    }

    public void onSignIn(ActionEvent event) {
        Stage stage = (Stage) btnSignIn.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(
                    getClass().getResource("/views/MainAttendanceView.fxml"))), stage.getHeight(), stage.getWidth()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
