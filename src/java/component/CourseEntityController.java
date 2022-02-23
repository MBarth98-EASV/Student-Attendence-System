package component;

import controller.ControllerPassthroughModel;
import controller.CoursesViewController;
import controller.MainController;
import javafx.application.Platform;
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
        Platform.runLater(this::initActiveCourseListener);
        Platform.runLater(this::initSelectionListener);
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

    private void initSelectionListener(){
        course.getSelectedProperty().addListener((observable, oldValue, newValue) -> {
            if (course.isSelected()){
                courseVBox.setStyle("-fx-background-color: rgba(248, 248, 248, 0.8);\n" +
                        "    -fx-background-radius: 10;");
                lblCourseName.setStyle("-fx-font-size: 18;\n" +
                        "    -fx-font-family: \"Roboto\";\n" +
                        "    -fx-text-fill: #5145AD;\n" +
                        "    -fx-font-weight: bold;");
                lblLocation.setStyle("    -fx-font-size: 14;\n" +
                        "    -fx-font-family: \"Roboto\";\n" +
                        "    -fx-text-fill: #5145AD;");
            }
            else {
                courseVBox.setStyle("-fx-background-color: rgba(248, 248, 248, 0.5);\n" +
                        "    -fx-background-radius: 10;");
                lblCourseName.setFont(Font.font("roboto"));
                lblCourseName.setStyle("-fx-font-size: 18;\n" +
                        "    -fx-font-family: \"Roboto\";\n" +
                        "    -fx-text-fill: #f8f8f8;\n" +
                        "    -fx-font-weight: bold;");
                lblLocation.setStyle("    -fx-font-size: 14;\n" +
                        "    -fx-font-family: \"Roboto\";\n" +
                        "    -fx-text-fill: #f8f8f8;");
            }

        });
    }

    private void initActiveCourseListener(){
        course.isActiveCourseProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == true){
                rootHBox.setStyle("-fx-border-width: 0 0 0 4; -fx-border-color: #0FB300;");
            }
            else rootHBox.setStyle("-fx-border-width: 0; -fx-border-color: transparent;");
        });
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


    public void setLblStartTime(int startHour, int startMin) {
        String strHour = new String();
        String strMin = new String();

        if (startHour < 10){
            strHour = "0" + startHour;
        }
        else strHour = String.valueOf(startHour);

        if (startMin < 10) {
            strMin = "0" + startMin;
        }
        else strMin = String.valueOf(startMin);

        lblStartTime.setText(strHour + ":" + strMin);
    }

    public void setLblEndTime(int endHour, int endMin) {
        String strHour = new String();
        String strMin = new String();

        if (endHour < 10){
            strHour = "0" + endHour;
        }
        else strHour = String.valueOf(endHour);

        if (endMin < 10) {
            strMin = "0" + endMin;
        }
        else strMin = String.valueOf(endMin);

        lblEndTime.setText(strHour + ":" + strMin);
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
