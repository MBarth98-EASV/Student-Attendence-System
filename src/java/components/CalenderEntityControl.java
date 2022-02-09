package components;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import util.EnumCourseStatus;


import java.io.IOException;
import java.net.URL;

public class CalenderEntityControl extends Pane
{
    private Node view;
    private CalenderEntityController controller;

    public CalenderEntityControl(String startTime, String endTime, String courseName, String courseLocation, EnumCourseStatus status)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getResource("views\\CalenderEntity.fxml"));


        //this.getStylesheets().add(this.getClass().getResource("styles/CourseEntity.css").toExternalForm());
        //this.getStylesheets().add(this.getClass().getResource("resources/styles/CourseEntity.css").toExternalForm());

        fxmlLoader.setControllerFactory(param -> controller = new CalenderEntityController());

        try {
            view = fxmlLoader.load();
        } catch (IOException ignored) {}

        getChildren().add(view);

        controller.setLblStartTime(startTime);
        controller.setLblEndTime(endTime);
        controller.setCourseName(courseName);
        controller.setLocation(courseLocation);

        switch (status){
            case ATTENDED -> controller.getBarStatus().setStyle("-fx-background-color: green");
            case ABSENT -> controller.getBarStatus().setStyle("-fx-background-color: red");
            case PARTIAL -> controller.getBarStatus().setStyle("-fx-background-color: yellow");
            case NOT_STARTED -> controller.getBarStatus().setStyle("-fx-background-color: grey");
            default -> controller.getBarStatus().setOpacity(0);
        }
    }

    private URL getResource(String s)
    {
        return getClass().getClassLoader().getResource(s);
    }

    public CalenderEntityController getController(){
        return controller;
    }

}
