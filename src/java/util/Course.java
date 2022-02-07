package util;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Course extends HBox {

    public Course(String timeStart, String timeEnd, String courseName, String courseLocation, EnumCourseStatus status){
        super();
        VBox time = new VBox();
        Label lblTimeStart = new Label(timeStart);
        Label line = new Label("-----");
        Label lblTimeEnd = new Label(timeEnd);
        time.getChildren().addAll(lblTimeStart, line, lblTimeEnd);

        VBox course = new VBox();
        course.setStyle("-fx-background-color: rgba(255,255,255, 0.2)");
        Label lblCourseName = new Label(courseName);
        Label lblCourseLocation = new Label(courseLocation);
        ProgressBar barStatus = new ProgressBar();
        switch (status){
            case ATTENDED -> barStatus.setStyle("-fx-background-color: green");
            case ABSENT -> barStatus.setStyle("-fx-background-color: red");
            case PARTIAL -> barStatus.setStyle("-fx-background-color: yellow");
            case NOT_STARTED -> barStatus.setStyle("-fx-background-color: grey");
            default -> barStatus.setOpacity(0);
        }
        course.getChildren().addAll(lblCourseName,lblCourseLocation, barStatus);

        this.getChildren().addAll(time, course);



    }


    /**
     * HBOX
     * Time
     *       VBOX WITH Label + label
     * COURSE
     *       VBOX Label + space + Label + Bar
     */

}
