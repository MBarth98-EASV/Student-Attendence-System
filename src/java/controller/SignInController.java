package controller;

import bll.DataManager;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.io.IOException;

public class SignInController {

    @FXML BorderPane signInRoot;
    @FXML Button btnSignIn;
    @FXML TextInputControl usernameField;
    @FXML TextInputControl passwordField;

    private ControllerPassthroughModel passthroughModel;

    public SignInController(){
        passthroughModel = new ControllerPassthroughModel();
    }

    public void onSignIn(ActionEvent event) {
        try {
            //if (usernameField.getText().equals(DataManager.getInstance().getUserLogin()) && passwordField.getText().equals(DataManager.getInstance().getUserPassword())) {
                loadNext();
            //}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void loadNext() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/view/CoursesView.fxml"));
        Scene scene = btnSignIn.getScene();
        root.translateYProperty().set(scene.getHeight());

        passthroughModel.getViewContainer().getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            passthroughModel.getViewContainer().getChildren().remove(signInRoot);
        });
        timeline.play();
    }

}
