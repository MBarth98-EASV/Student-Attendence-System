package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import util.Course;
import util.EnumCourseStatus;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML TilePane scrollPaneCourses;
    @FXML Label lblDay;
    @FXML Button btnNextDay;
    @FXML Button btnPrevDay;
    @FXML ToggleButton tglBtnMainView;
    @FXML ToggleButton tglBtnStats;
    @FXML ToggleButton tglBtnUser;
    @FXML AnchorPane anchorPaneAttend;
    @FXML Button btnAttendLeave;
    @FXML Slider sliderAttendLeave;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scrollPaneCourses.getChildren().add(new Course("none","none","none","none", EnumCourseStatus.ATTENDED));

    }


    public void onMainView(ActionEvent event) {
    }

    public void onShowStats(ActionEvent event) {
    }

    public void onShowUser(ActionEvent event) {
    }
}
