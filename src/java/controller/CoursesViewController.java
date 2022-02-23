package controller;

import bll.DataManager;
import component.AttendButton;
import component.CourseEntity;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;
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
    private boolean btnShowing;
    private LocalDate day;

    public CoursesViewController() {
        instance = this;
        day = LocalDate.now();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        coursePane.setAlignment(Pos.CENTER);
        coursePane.setOrientation(Orientation.VERTICAL);
        coursePane.setHgap(10);
        coursePane.setVgap(10);

        ArrayList<CourseEntity> initCourseList = setCourses(day);
        scrollPaneCourses.setContent(coursePane);
        selectedCourse = new SimpleObjectProperty<>(initCourseList.get(0));
        initListeners();
        initButton();
        initButtonFunctionListener();
        initOnSliderFull();
        initNextPrevDay();
    }

    //TODO: Indicator for currently active course.
    //          Report = real-time
    //          Debug = Mouse Select
    //TODO: Check for whether course is applicable for status change.


    private ArrayList<CourseEntity> setCourses(LocalDate day){
        ArrayList<CourseEntity> courses = new ArrayList<>(DataManager.getInstance().getUserCourses(day));
        coursePane.getChildren().clear();
        coursePane.getChildren().addAll(courses);

        return courses;
    }

    private void initNextPrevDay(){
        btnNextDay.setOnAction(event -> {
            day = day.plusDays(1);
            setCourses(day);
            setLblDay(day);
            attendButton.hideButton(300);
        });

        btnPrevDay.setOnAction(event -> {
            day = day.minusDays(1);
            setCourses(day);
            setLblDay(day);
            attendButton.hideButton(300);
        });
    }

    private void setLblDay(LocalDate date){
        Locale locale = Locale.getDefault();
        if (LocalDate.now().equals(date)) {
            lblDay.setText("Today");
        } else if (LocalDate.now().minusDays(1).equals(date)) {
            lblDay.setText("Yesterday");
        } else if (LocalDate.now().plusDays(1).equals(date)) {
            lblDay.setText("Tomorrow");
        } else {
            lblDay.setText(date.getDayOfWeek().getDisplayName(TextStyle.SHORT, locale) + " " + date.getDayOfMonth());
        }
    }

    private void initListeners(){
        selectedCourse.addListener((observable, oldValue, newValue) -> selectDeselectCourse(oldValue, newValue));
        selectedCourse.addListener((observable, oldValue, newValue) -> setIsActiveCourse(oldValue, newValue));
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
                    ControllerPassthroughModel.getInstance().setSelectedCourse(selectedCourse.get());
                    MainController.getInstance().showQR();

                }
                else {
                    DataManager.getInstance().changeCourseStatus(selectedCourse.get(), EnumCourseStatus.PARTIAL);
                    attendButton.resetSlider();
                }
            }
        });
    }
    
    private void selectDeselectCourse(CourseEntity oldValue, CourseEntity newValue){
        if (oldValue != null){
            oldValue.setSelected(false);
                oldValue.setIsActiveCourse(false);


        }
        if (newValue != null) {
            newValue.setSelected(true);
            newValue.setIsActiveCourse(true);
        }
    }


    private void setIsActiveCourse(CourseEntity oldValue, CourseEntity newValue){
        if (oldValue != null){
            oldValue.setIsActiveCourse(false);
        }
        if (newValue != null && newValue.getStartTime().toLocalDate().isEqual(LocalDate.now())) {
            newValue.setIsActiveCourse(true);
        }
        else newValue.setIsActiveCourse(false);
    }


    private void attendBtnShowHide(CourseEntity newValue) {
        /* For real-world time usage.
        if (btnShowing)
        if (newValue.getStartTime().minusMinutes(10).isBefore(LocalDateTime.now()) ||
        newValue.getEndTime().isAfter(LocalDateTime.now())){
            return;
        }
        else*/
            /*if (newValue.getStatus() != EnumCourseStatus.NONE){
                attendButton.hideButton(300);
                btnShowing = false;
            }
             */

            if (newValue.isSelected() && newValue.getPerformableAction() && !btnShowing && newValue.isActiveCourse()) {
                if (!newValue.getPerformableAction()){
                    return;
                }
            attendButton.showButton(300, newValue);
            btnShowing = true;
            }

            if (!newValue.getPerformableAction()){
                attendButton.hideButton(300);
                btnShowing = false;
            }

            if (!newValue.isSelected() && btnShowing) {
            attendButton.hideButton(300);
            btnShowing = false;
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
                selectDeselectCourse(null, this.selectedCourse.get());
                setIsActiveCourse(null, this.selectedCourse.get());
                this.selectedCourse.set(selectedCourse);
                attendBtnShowHide(selectedCourse);
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
