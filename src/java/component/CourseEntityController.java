package component;

import controller.ControllerPassthroughModel;
import controller.CoursesViewController;
import controller.MainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class CourseEntityController implements Initializable
{

    @FXML private VBox courseVBox;
    @FXML VBox timeVBox;
    @FXML HBox rootHBox;
    @FXML private Label lblStartTime;
    @FXML private Label lblEndTime;
    @FXML private Label lblCourseName;
    @FXML private Label lblLocation;
    @FXML Circle circleStatus;

    /** The Course tied to this instance of a controller. */
    private CourseEntity course;

    public CourseEntityController() {
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        courseVBox.setOnMouseClicked(event -> {
            CoursesViewController.getInstance().setSelectedCourse(course);
        });
        initStyle();
    }

    private void initStyle(){
        lblCourseName.setFont(Font.font("roboto"));
        lblCourseName.setStyle("-fx-font-size: 18;\n" +
                "    -fx-font-family: \"Roboto\";\n" +
                "    -fx-text-fill: #f8f8f8;\n" +
                "    -fx-font-weight: bold;");
        lblLocation.setStyle("    -fx-font-size: 14;\n" +
                "    -fx-font-family: \"Roboto\";\n" +
                "    -fx-text-fill: #f8f8f8;");
        lblStartTime.setStyle(" -fx-font-size: 14;\n" +
                "    -fx-font-family: \"Roboto\";\n" +
                "    -fx-text-fill: #f8f8f8;");
        lblEndTime.setStyle(" -fx-font-size: 12;\n" +
                "    -fx-font-family: \"Roboto\";\n" +
                "    -fx-text-fill: #f8f8f8;");
        courseVBox.setStyle("-fx-background-color: rgba(248, 248, 248, 0.5);\n" +
                "    -fx-background-radius: 10;");
        timeVBox.setStyle("-fx-background-color: transparent;\n" +
                "    -fx-border-width: 0 2 0 0;\n" +
                "    -fx-border-color: #f8f8f8;");
        rootHBox.setStyle("-fx-background-color: transparent;");

    }

    public VBox getCourseVBox() {
        return courseVBox;
    }

    public VBox getTimeVBox() {
        return timeVBox;
    }

    public HBox getRootHBox() {
        return rootHBox;
    }

    public Label getLblStartTime() {
        return lblStartTime;
    }

    public Label getLblEndTime() {
        return lblEndTime;
    }

    public Label getLblCourseName() {
        return lblCourseName;
    }

    public Label getLblLocation() {
        return lblLocation;
    }


    public void setLblStartTime(String startTime) {
        lblStartTime.setText(startTime);
    }

    public void setLblEndTime(String endTime) {
        lblEndTime.setText(endTime);
    }

    public void setCourseName(String name){
        lblCourseName.setText(name);
    }

    public void setLocation(String location){
        lblLocation.setText(location);
    }

    public Circle getCircleStatus() {
        return circleStatus;
    }

    public void setCircleStatus(Circle circleStatus) {
        this.circleStatus = circleStatus;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }



}
