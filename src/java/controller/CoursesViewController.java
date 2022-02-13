package controller;

import component.CourseEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import util.EnumCourseStatus;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CoursesViewController implements Initializable {

    @FXML ScrollPane scrollPaneCourses;
    @FXML Label lblDay;
    @FXML Button btnNextDay;
    @FXML Button btnPrevDay;
    @FXML FlowPane coursePane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        coursePane.setAlignment(Pos.CENTER);
        coursePane.setOrientation(Orientation.VERTICAL);
        coursePane.setHgap(10);
        coursePane.setVgap(10);


        List<CourseEntity> courses = new ArrayList<>();
        courses.add(new CourseEntity("0000", "0000", "COURSE 1", "Here", EnumCourseStatus.ABSENT));
        courses.add(new CourseEntity("0000", "0000", "COURSE 1", "Here", EnumCourseStatus.NOT_STARTED));
        courses.add(new CourseEntity("0000", "0000", "COURSE 1", "Here", EnumCourseStatus.NONE));
        courses.add(new CourseEntity("0000", "0000", "COURSE 1", "Here", EnumCourseStatus.PARTIAL));
        courses.add(new CourseEntity("0000", "0000", "COURSE 1", "Here", EnumCourseStatus.ATTENDED));
        courses.add(new CourseEntity("0000", "0000", "COURSE 1", "Here", EnumCourseStatus.ATTENDED));

        coursePane.getChildren().addAll(courses);


        scrollPaneCourses.setContent(coursePane);
    }


}
