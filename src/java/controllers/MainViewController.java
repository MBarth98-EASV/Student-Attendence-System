package controllers;

import components.CalenderEntityControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import util.Course;
import util.EnumCourseStatus;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

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
    Pane coursePane;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        coursePane = new Pane();
        scrollPaneCourses.setContent(coursePane);
        coursePane.getChildren().add(new CalenderEntityControl());
    }


    public void onMainView(ActionEvent event) {
    }

    public void onShowStats(ActionEvent event) {
    }

    public void onShowUser(ActionEvent event) {
    }
}
