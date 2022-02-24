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
/**
 * Author: @Rasmus Scherning Sandbæk
 */
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

    /** The CourseEntity tied to this instance of a controller. */
    private CourseEntity course;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        courseVBox.setOnMouseClicked(event -> {
            CoursesViewController.getInstance().setSelectedCourse(course);
        });
        initStyle();
        Platform.runLater(this::initActiveCourseListener); //Throws nullpointer otherwise
        Platform.runLater(this::initSelectionListener); //Throws nullpointer otherwise
    }

    /**
     * Has to be hardcoded, as the compiler cannot find the accompanying stylesheet when set in FXML or code.
     */
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

    /**
     * Changes the style to be highlighted if selected, or back to default if deselected.
     */
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

    /**
     * Displays the green border on the left of the rootHBox, indicating an ongoing course.
     */
    private void initActiveCourseListener(){
        course.isActiveCourseProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == true){
                rootHBox.setStyle("-fx-border-width: 0 0 0 4; -fx-border-color: #0FB300;");
            }
            else rootHBox.setStyle("-fx-border-width: 0; -fx-border-color: transparent;");
        });
    }

    public String getCourseInfo()
    {
        return this.lblCourseName.getText() + " - " + this.lblLocation.getText();
    }

    /**
     * Sets the label startTime to the Courses starttime, but adds a "0" where necessary to
     * retain coherency of the 00:00 format
     * @param startHour
     * @param startMin
     */
    public void setLblStartTime(int startHour, int startMin) {
        String strHour;
        String strMin;

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

    /**
     * Sets the label endTime to the Courses endTime, but adds a "0" where necessary to
     * retain coherency of the 00:00 format
     * @param endHour
     * @param endMin
     */
    public void setLblEndTime(int endHour, int endMin) {
        String strHour;
        String strMin;

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

    public void setCourse(CourseEntity course) {
        this.course = course;
    }



}
