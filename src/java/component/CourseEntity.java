package component;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import util.EnumCourseStatus;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Author: @Rasmus Scherning Sandbæk
 */
public class CourseEntity extends Pane
{
    private Node view;
    private CourseEntityController controller;

    /** A separate indicator for selection is needed within the course object itself, as the ChangeListener in the
     * controller, will not respond unless the actual value changes. As such, deselection in its current state would not work,
     * since clicking on the same course object twice would not change the value of CourseViewControler.selectedCourse and therefore
     * not trigger the listener.
     */
    private BooleanProperty selected;
    private IntegerProperty statusProperty; //Determines button functionality and availability
    private BooleanProperty isActiveCourse; //When true, a green bar appears to the left of the course to indicate it is ongoing.
    private boolean performableAction;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDate date;



    public CourseEntity(LocalDate date, int startHour, int startMin, int endHour, int endMin, String courseName, String courseLocation, EnumCourseStatus status)
    {
        if (date == null) {
            this.date = LocalDate.now();
        }
        else {
            this.date = date;
        }
        startTime = this.date.atTime(startHour, startMin);
        endTime = this.date.atTime(endHour, endMin);


        selected = new SimpleBooleanProperty();
        isActiveCourse = new SimpleBooleanProperty();
        this.statusProperty = new SimpleIntegerProperty();
        this.statusProperty.set(status.ordinal());
        this.statusProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() == EnumCourseStatus.NOT_STARTED.ordinal()) {
                performableAction = false;
            } else performableAction = true;
        });

        FXMLLoader fxmlLoader = new FXMLLoader(getResource("view\\CourseObject.fxml"));
        fxmlLoader.setControllerFactory(param -> controller = new CourseEntityController());
        try {
            view = fxmlLoader.load();
        } catch (IOException ignored) {}
        getChildren().add(view);


        controller.setLblStartTime(startTime.getHour(),startTime.getMinute());
        controller.setLblEndTime(endTime.getHour(), endTime.getMinute());
        controller.setCourseName(courseName);
        controller.setLocation(courseLocation);
        controller.setCourse(this);


        switch (status) {
            case ATTENDED -> setStatus(EnumCourseStatus.ATTENDED);
            case ABSENT -> setStatus(EnumCourseStatus.ABSENT);
            case PARTIAL -> setStatus(EnumCourseStatus.PARTIAL);
            case NOT_STARTED -> setStatus(EnumCourseStatus.NOT_STARTED);
        }

        if (this.date.isAfter(LocalDate.now())) {
            setStatus(EnumCourseStatus.NOT_STARTED);
        }

        setPerformableAction(status);

    }

    /**
     * Ensures courses that hasn't yet started or don't have a status cannot be Attended or left.
     * @param status
     */
    private void setPerformableAction(EnumCourseStatus status) {
        if (status == EnumCourseStatus.NOT_STARTED) {
            performableAction = false;
        } else performableAction = true;
    }

    private URL getResource(String s)
    {
        return getClass().getClassLoader().getResource(s);
    }

    /**
     * Sets the graphical status indicator colour, as well the statusProperty. Also calls setPerformableAction.
     * @param status
     */
    public void setStatus(EnumCourseStatus status){
        switch (status){
            case ATTENDED -> controller.getCircleStatus().setStyle("    -fx-fill: #0FB300;    -fx-stroke-width: 0;");
            case ABSENT -> controller.getCircleStatus().setStyle("      -fx-fill: #D82F2A;      -fx-stroke-width: 0;");
            case PARTIAL -> controller.getCircleStatus().setStyle("     -fx-fill: #ecf005;   -fx-stroke-width: 0;");
            case NOT_STARTED -> controller.getCircleStatus().setStyle(" -fx-fill: #6b6868;     -fx-stroke-width: 0;");
            default -> controller.getCircleStatus().setOpacity(0);
        }
        setPerformableAction(status);
        this.statusProperty.set(status.ordinal());
    }

    public EnumCourseStatus getStatus(){
        return EnumCourseStatus.values()[statusProperty.get()];
    }

    public IntegerProperty getStatusProperty(){
        return statusProperty;
    }

    public CourseEntityController getController(){
        return controller;
    }

    public boolean isSelected() {
        return selected.get();
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }

    public BooleanProperty getSelectedProperty(){
        return selected;
    }


    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean getPerformableAction(){
        return performableAction;
    }


    public boolean isActiveCourse() {
        return isActiveCourse.get();
    }

    public BooleanProperty isActiveCourseProperty() {
        return isActiveCourse;
    }

    public void setIsActiveCourse(boolean isActiveCourse) {
        this.isActiveCourse.set(isActiveCourse);
    }



}
