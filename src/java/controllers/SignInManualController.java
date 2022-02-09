package controllers;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SignInManualController implements Initializable {


    @FXML public TextField passwordField;
    @FXML public TextField usernameField;
    @FXML public Button btnSignIn;
    @FXML public BorderPane signInManRoot;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        usernameField.setText("test@easv365.dk");
        passwordField.setText("●".repeat(8));
    }

    public void onSignIn(ActionEvent event) {
        Stage stage = (Stage) btnSignIn.getScene().getWindow();
        try {
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/MainAttendanceView.fxml")));

        Parent oldRoot = btnSignIn.getScene().getRoot();

        Scene scene = btnSignIn.getScene();
        //Set Y of second scene to Height of window
        newRoot.translateYProperty().set(scene.getHeight());
        //Add second scene. Now both first and second scene is present
        signInManRoot.getChildren().add(newRoot);

        //Create new TimeLine animation
        Timeline timeline = new Timeline();
        //Animate Y property
        KeyValue kv = new KeyValue(newRoot.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        //After completing animation, remove first scene
        timeline.setOnFinished(t -> {
            btnSignIn.getScene().setRoot(newRoot);
        });
        timeline.play();
        } catch (IOException e) {
            e.printStackTrace();

    }


/*
        try {
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(
                    getClass().getResource("/views/MainAttendanceView.fxml"))), stage.getHeight(), stage.getWidth()));
        } catch (IOException e) {
            e.printStackTrace();
        }

 */
    }
}
