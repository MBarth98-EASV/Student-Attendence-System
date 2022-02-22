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
    private IntegerProperty statusProperty;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime date;



    public CourseEntity(LocalDateTime date, int startHour, int startMin, int endHour, int endMin, String courseName, String courseLocation, EnumCourseStatus status)
    {
        if (date == null) {
            this.date = LocalDateTime.now();
        }
        startTime = this.date.toLocalDate().atTime(startHour, startMin);
        endTime = this.date.toLocalDate().atTime(endHour, endMin);


        selected = new SimpleBooleanProperty();
        this.statusProperty = new SimpleIntegerProperty();
        this.statusProperty.set(status.ordinal());

        FXMLLoader fxmlLoader = new FXMLLoader(getResource("view\\CourseObject.fxml"));

        fxmlLoader.setControllerFactory(param -> controller = new CourseEntityController());

        try {
            view = fxmlLoader.load();
        } catch (IOException ignored) {}

        getChildren().add(view);
        controller.setLblStartTime(startTime.getHour() + ":" + startTime.getMinute());
        controller.setLblEndTime(endTime.getHour() + ":" + endTime.getMinute());
        controller.setCourseName(courseName);
        controller.setLocation(courseLocation);

        controller.setCourse(this);

        switch (status){
            case ATTENDED -> controller.getCircleStatus().setStyle("    -fx-fill: green;    -fx-stroke-width: 0;");
            case ABSENT -> controller.getCircleStatus().setStyle("      -fx-fill: red;      -fx-stroke-width: 0;");
            case PARTIAL -> controller.getCircleStatus().setStyle("     -fx-fill: yellow;   -fx-stroke-width: 0;");
            case NOT_STARTED -> controller.getCircleStatus().setStyle(" -fx-fill: grey;     -fx-stroke-width: 0;");
            default -> controller.getCircleStatus().setOpacity(0);
        }

    }

    private URL getResource(String s)
    {
        return getClass().getClassLoader().getResource(s);
    }

    public void setStatus(EnumCourseStatus status){
        switch (status){
            case ATTENDED -> controller.getCircleStatus().setStyle("    -fx-fill: green;    -fx-stroke-width: 0;");
            case ABSENT -> controller.getCircleStatus().setStyle("      -fx-fill: red;      -fx-stroke-width: 0;");
            case PARTIAL -> controller.getCircleStatus().setStyle("     -fx-fill: yellow;   -fx-stroke-width: 0;");
            case NOT_STARTED -> controller.getCircleStatus().setStyle(" -fx-fill: grey;     -fx-stroke-width: 0;");
            default -> controller.getCircleStatus().setOpacity(0);
        }
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


}
