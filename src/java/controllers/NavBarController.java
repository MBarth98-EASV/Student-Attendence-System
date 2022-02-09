package controllers;

import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.action.ActionTrigger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class NavBarController implements Initializable {

    @ActionTrigger("mainview")
    @FXML public ToggleButton tglBtnMainView;

    @ActionTrigger("stats")
    @FXML public ToggleButton tglBtnStats;

    @ActionTrigger("user")
    @FXML public ToggleButton tglBtnUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(tglBtnMainView, tglBtnStats, tglBtnUser);
        tglBtnMainView.fire();


    }


    public void onMainView(ActionEvent event) {

    }

    public void onShowStats(ActionEvent event) {
    }

    public void onShowUser(ActionEvent event) {
    }
}
