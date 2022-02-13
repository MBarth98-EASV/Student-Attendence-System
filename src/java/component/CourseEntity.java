package component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import util.EnumCourseStatus;

import java.io.IOException;
import java.net.URL;

public class CourseEntity extends Pane
{
    private Node view;
    private CourseEntityController controller;

    public CourseEntity(String startTime, String endTime, String courseName, String courseLocation, EnumCourseStatus status)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getResource("view\\CourseObject.fxml"));

        fxmlLoader.setControllerFactory(param -> controller = new CourseEntityController());

        try {
            view = fxmlLoader.load();
        } catch (IOException ignored) {}

        getChildren().add(view);
        controller.setLblStartTime(startTime);
        controller.setLblEndTime(endTime);
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

    public CourseEntityController getController(){
        return controller;
    }

}
