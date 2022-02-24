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
        selectedCourse = new SimpleObjectProperty<>(initCourseList.get(0)); //Required to avoid NullPointerEx
        initListeners();
        initButton();
        initOnSliderFull();
        initNextPrevDay();
    }


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

    /**
     * Sets the top-center label, or lblDay, depending on the day the user is currently viewing.
     * @param date
     */
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

    /**
     * Listeners for the selectedCourse variable.
     */
    private void initListeners(){
        selectedCourse.addListener((observable, oldValue, newValue) -> selectDeselectCourse(oldValue, newValue));
        selectedCourse.addListener((observable, oldValue, newValue) -> setIsActiveCourse(oldValue, newValue));
        selectedCourse.addListener((observable, oldValue, newValue) -> attendBtnShowHide(newValue));

        selectedCourse.get().getStatusProperty().addListener((observable, oldValue, newValue) -> attendButton.setAttendOrLeave(EnumCourseStatus.values()[newValue.intValue()]));
        selectedCourse.addListener((observable, oldValue, newValue) -> attendButton.setAttendOrLeave(newValue.getStatus()));
    }

    private void initButton(){
        this.attendButton = new AttendButton();
        courseBorderPaneRoot.setBottom(attendButton.getAsNode());
    }

    /**
     * When the slider reaches its max value of 100, the selectedCourse will either be set to Partial if the
     * AttendButton's current function is to leave a course. Otherwise, it set the scene to qrMock, which intends to simulate
     * the scanning of a QR code.
     */
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

    /**
     * Deselects both values.
     * CourseEntity's isSelected is a BooleanProperty with an associated listener, which will then handle setting
     * the CourseEntity's style to the default style.
     * @param oldValue
     * @param newValue
     */
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


    /**
     * Sets the newValue to the Active course via the BooleanProperty present in CourseEntity objects.
     * When isActiveCourse is true, a green bar will appear to the left of the course, signaling that it is ongoing.
     * In deployment, this would be handled by real-world time, rather than clicks.
     * @param oldValue
     * @param newValue
     */
    private void setIsActiveCourse(CourseEntity oldValue, CourseEntity newValue){
        if (oldValue != null){
            oldValue.setIsActiveCourse(false);
        }
        if (newValue != null && newValue.getStartTime().toLocalDate().isEqual(LocalDate.now())) {
            newValue.setIsActiveCourse(true);
        }
        else newValue.setIsActiveCourse(false);
    }



    /**
     * Shows and hides the button depending on the current selected course. Also sets btnShowing,
     * which exists solely to prevent errors.
     * @param newValue - The given course, that decides whether the button should be shown or hidden.
     */
    private void attendBtnShowHide(CourseEntity newValue) {
        /*if (btnShowing)    Real-world time sensitive code, meant for real-world use.
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
            attendButton.showButton(300);
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

    /**
     * Sets the isSelected value of the former and current selected course to false. Used
     * for allowing to deselect the already selected course.
     * Makes sure the former selected course is also not selected.
     * @param oldValue - The former selected course
     * @param newValue - The new selected course
     */
    private void deselectAll(CourseEntity oldValue, CourseEntity newValue){
        if (newValue.isSelected() == true) {
            oldValue.setSelected(false);
            newValue.setSelected(false);
        }
    }


    public CourseEntity getSelectedCourse() {
        return selectedCourse.get();
    }

    /**
     * Called by the course with onMouseClicked. Sets the selectedCourse variable in the CourseViewController.
     * If the user clicks the same Course twice, the course will either be reselected if it's isSelected = false, or
     * it will be deselected if it's already selected, meaning the user meant to deselect it.
     *
     * Also calls attendBtnShowHide and setIsActiveCourse, as the associated Listeners wouldn't call them as the selectedCourse value hasn't changed.
     * @param selectedCourse
     */
    public void setSelectedCourse(CourseEntity selectedCourse) {
        if (selectedCourse.equals(getSelectedCourse())){
            if (!selectedCourse.isSelected())
            {
                selectDeselectCourse(null, selectedCourse);
                setIsActiveCourse(null, selectedCourse);
                this.selectedCourse.set(selectedCourse);
                attendBtnShowHide(selectedCourse);
                return;
            }
            deselectAll(this.selectedCourse.get(), selectedCourse);
            attendBtnShowHide(selectedCourse);
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
