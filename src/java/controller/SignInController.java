package controller;

import bll.DataManager;
import com.sun.tools.javac.Main;
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

    public void onSignIn(ActionEvent event)
    {
        // (not really) todo: future -> authentication

        MainController.getInstance().onMainView(event);
    }
}
