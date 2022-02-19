package controller;

import bll.DataManager;
import component.AttendButton;
import component.CourseEntity;
import javafx.application.Platform;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import util.EnumCourseStatus;
import util.Toast;

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

        //courseBorderPaneRoot.setBottom(attendButton);

        List<CourseEntity> courses = new ArrayList<>(DataManager.getInstance().getUserCourses());

        coursePane.getChildren().addAll(courses);
        scrollPaneCourses.setContent(coursePane);
        selectedCourse = new SimpleObjectProperty<>(courses.get(0));
        initListeners();

        Platform.runLater(this::initButton);
    }

    //TODO: Make deselection happen if the same course is selected twice
    //TODO: Make a dynamic attend/leave button, that functions similarly to Toast.java
    //TODO: Indicator for currently active course

    private void initListeners(){
        selectedCourse.addListener((observable, oldValue, newValue) -> selectDeselectStyle(oldValue, newValue));
        selectedCourse.addListener((observable, oldValue, newValue) -> attendLeaveBtn(oldValue, newValue));
    }

    public void initButton(){
        this.attendButton = new AttendButton();
        courseBorderPaneRoot.setBottom(attendButton.getAsNode());
        courseBorderPaneRoot.getBottom().setOpacity(1);
    }
    
    private void selectDeselectStyle(CourseEntity oldValue, CourseEntity newValue){
        if (oldValue != null){
            oldValue.getController().getCourseVBox().setStyle("" +
                    "-fx-border-width: 0; " +
                    "-fx-border-color: transparent; " +
                    "-fx-background-color: rgba(248, 248, 248, 0.5); " +
                    "-fx-background-radius: 10; " +
                    "-fx-border-radius: 10;");
            oldValue.setSelected(false);

        }
        if (newValue != null) {
            newValue.getController().getCourseVBox().setStyle("" +
                    "-fx-border-width: 2; " +
                    "-fx-border-color: #5145AD; " +
                    "-fx-background-color: rgba(248, 248, 248, 0.5); " +
                    "-fx-background-radius: 10; " +
                    "-fx-border-radius: 10;");
            newValue.setSelected(true);
            return;
        }
    }

    private void attendLeaveBtn(CourseEntity oldValue, CourseEntity newValue) {
        if (newValue.isSelected()) {
            attendButton.showButton(1000, newValue);
        }
        if (!newValue.isSelected()) {
            attendButton.hideButton(100, 100);
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
        }
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
