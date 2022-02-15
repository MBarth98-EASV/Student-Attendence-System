package controller;

import component.CourseEntity;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
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

    private ObjectProperty<CourseEntity> selectedCourse;
    private static CoursesViewController instance;

    public CoursesViewController() {
        instance = this;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        coursePane.setAlignment(Pos.CENTER);
        coursePane.setOrientation(Orientation.VERTICAL);
        coursePane.setHgap(10);
        coursePane.setVgap(10);


        List<CourseEntity> courses = new ArrayList<>();
        courses.add(new CourseEntity("08:15", "0000", "SCO", "Room 30C", EnumCourseStatus.ABSENT));
        courses.add(new CourseEntity("0000", "0000", "COURSE 1", "Here", EnumCourseStatus.NOT_STARTED));
        courses.add(new CourseEntity("0000", "0000", "COURSE 1", "Here", EnumCourseStatus.NONE));
        courses.add(new CourseEntity("0000", "0000", "COURSE 1", "Here", EnumCourseStatus.PARTIAL));
        courses.add(new CourseEntity("0000", "0000", "COURSE 1", "Here", EnumCourseStatus.ATTENDED));
        courses.add(new CourseEntity("0000", "0000", "COURSE 1", "Here", EnumCourseStatus.ATTENDED));

        coursePane.getChildren().addAll(courses);
        scrollPaneCourses.setContent(coursePane);
        selectedCourse = new SimpleObjectProperty<>(courses.get(0));





        selectedCourse.addListener((observable, oldValue, newValue) -> {
            if (oldValue != null){
                oldValue.getController().getCourseVBox().setStyle("" +
                        "-fx-border-width: 0; " +
                        "-fx-border-color: transparent; " +
                        "-fx-background-color: rgba(248, 248, 248, 0.5); " +
                        "-fx-background-radius: 10; " +
                        "-fx-border-radius: 10;");
            }
            if (newValue != null) {
                newValue.getController().getCourseVBox().setStyle("" +
                        "-fx-border-width: 2; " +
                        "-fx-border-color: #5145AD; " +
                        "-fx-background-color: rgba(248, 248, 248, 0.5); " +
                        "-fx-background-radius: 10; " +
                        "-fx-border-radius: 10;");
            }
        });
        
    }

    public CourseEntity getSelectedCourse() {
        return selectedCourse.get();
    }

    public void setSelectedCourse(CourseEntity selectedCourse) {
        this.selectedCourse.set(selectedCourse);
    }


    public static CoursesViewController getInstance(){

        if (instance == null)
        {
            instance = new CoursesViewController();
        }

        return instance;
    }
}
