package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class MainViewController {

    @FXML ScrollPane scrollPaneCourses;
    @FXML Label lblDay;
    @FXML Button btnNextDay;
    @FXML Button btnPrevDay;
    @FXML ToggleButton tglBtnMainView;
    @FXML ToggleButton tglBtnStats;
    @FXML ToggleButton tglBtnUser;
    @FXML AnchorPane anchorPaneAttend;
    @FXML Button btnAttendLeave;
    @FXML Slider sliderAttendLeave;




    public void onMainView(ActionEvent event) {
    }

    public void onShowStats(ActionEvent event) {
    }

    public void onShowUser(ActionEvent event) {
    }
}
