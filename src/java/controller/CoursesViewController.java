package controller;

import bll.DataManager;
import com.sun.tools.javac.Main;
import component.AttendButton;
import component.CourseEntity;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
    @FXML BorderPane courseBorderPaneRoot;

    private ObjectProperty<CourseEntity> selectedCourse;
    private static CoursesViewController instance;
    private AttendButton attendButton;

    public CoursesViewController() {
        instance = this;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        coursePane.setAlignment(Pos.CENTER);
        coursePane.setOrientation(Orientation.VERTICAL);
        coursePane.setHgap(10);
        coursePane.setVgap(10);

        List<CourseEntity> courses = new ArrayList<>(DataManager.getInstance().getUserCourses());

        coursePane.getChildren().addAll(courses);
        scrollPaneCourses.setContent(coursePane);
        selectedCourse = new SimpleObjectProperty<>(courses.get(0));
        initListeners();
        initButton();
        initButtonFunctionListener();
        initOnSliderFull();

        btnNextDay.setOnAction(event -> attendBtnShowHide(selectedCourse.get()));
        btnPrevDay.setOnAction(event -> {attendButton.getAsNode().setPrefSize(0,0); attendButton.getAsNode().setMinSize(0, 0); attendButton.getAsNode().setMaxSize(0,0);});
    }

    //TODO: Indicator for currently active course

    private void initListeners(){
        selectedCourse.addListener((observable, oldValue, newValue) -> selectDeselectStyle(oldValue, newValue));
        selectedCourse.addListener((observable, oldValue, newValue) -> attendBtnShowHide(newValue));
    }

    private void initButton(){
        this.attendButton = new AttendButton();
        courseBorderPaneRoot.setBottom(attendButton.getAsNode());
    }

    private void initButtonFunctionListener(){
        selectedCourse.get().getStatusProperty().addListener((observable, oldValue, newValue)
                -> attendButton.setAttendOrLeave(EnumCourseStatus.values()[newValue.intValue()]));
    }

    private void initOnSliderFull(){
        attendButton.getSlider().valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.doubleValue() == attendButton.getSlider().getMax()){
                if (attendButton.isButtonAttendFunction()){
                    MainController.getInstance().showQR();
                }
                else {
                    //DATAMANAGER SET COURSE STATUS
                }
            }
        });
    }
    
    private void selectDeselectStyle(CourseEntity oldValue, CourseEntity newValue)
    {
            oldValue.getController().getCourseVBox().setStyle("" +
                    "-fx-border-width: 0; " +
                    "-fx-border-color: transparent; " +
                    "-fx-background-color: rgba(248, 248, 248, 0.5); " +
                    "-fx-background-radius: 10; " +
                    "-fx-border-radius: 10;");

            newValue.getController().getCourseVBox().setStyle("" +
                    "-fx-border-width: 2; " +
                    "-fx-border-color: #5145AD; " +
                    "-fx-background-color: rgba(248, 248, 248, 0.5); " +
                    "-fx-background-radius: 10; " +
                    "-fx-border-radius: 10;");

        oldValue.setSelected(false);
        newValue.setSelected(true);

    }

    private void attendBtnShowHide(CourseEntity newValue)
    {
        if (newValue.getStatus() != EnumCourseStatus.NONE)
        {
            if (newValue.isSelected())
            {
                attendButton.showButton(300, newValue);
            }
            else
            {
                attendButton.hideButton(300);
            }
        }
    }


    private void deselectAll(CourseEntity oldValue, CourseEntity newValue){
        if (newValue.isSelected() == true) {
            oldValue.getController().getCourseVBox().setStyle("" +
                    "-fx-border-width: 0; " +
                    "-fx-border-color: transparent; " +
                    "-fx-background-color: rgba(248, 248, 248, 0.5); " +
                    "-fx-background-radius: 10; " +
                    "-fx-border-radius: 10;");
            oldValue.setSelected(false);

            newValue.getController().getCourseVBox().setStyle("" +
                    "-fx-border-width: 0; " +
                    "-fx-border-color: transparent; " +
                    "-fx-background-color: rgba(248, 248, 248, 0.5); " +
                    "-fx-background-radius: 10; " +
                    "-fx-border-radius: 10;");
            newValue.setSelected(false);
        }
    }


    public CourseEntity getSelectedCourse() {
        return selectedCourse.get();
    }

    public void setSelectedCourse(CourseEntity selectedCourse) {
        if (selectedCourse.equals(getSelectedCourse())){
            if (!selectedCourse.isSelected())
            {
                selectDeselectStyle(null, this.selectedCourse.get());
                this.selectedCourse.set(selectedCourse);
                return;
            }
            deselectAll(this.selectedCourse.get(), selectedCourse);
            attendBtnShowHide(selectedCourse);
        }
        this.selectedCourse.set(selectedCourse);
        attendButton.setAttendOrLeave(selectedCourse.getStatus());
    }


    public static CoursesViewController getInstance(){

        if (instance == null)
        {
            instance = new CoursesViewController();
        }

        return instance;
    }
}
