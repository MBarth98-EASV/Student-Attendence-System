package controller;

import component.CourseEntity;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
/**
 * A dirty fix for getting necessary objects from one controller to another, without them
 * interacting directly. Gone in refactored version.
 * Author: @Rasmus Scherning Sandbæk
 */
public class ControllerPassthroughModel {

    private MainController mainController;
    private static ControllerPassthroughModel instance;

    private Pane viewPane;
    private GridPane viewContainer;

    private CourseEntity selectedCourse;

    public ControllerPassthroughModel(){
        instance = this;
        mainController = MainController.getInstance();
        viewContainer = mainController.getViewContainer();
        viewPane = mainController.getViewPane();
    }

    public static ControllerPassthroughModel getInstance(){

        if (instance == null)
        {
            instance = new ControllerPassthroughModel();
        }

        return instance;
    }


    public Pane getViewPane() {
        return viewPane;
    }

    public GridPane getViewContainer() {
        return viewContainer;
    }

    public ObjectProperty<CourseEntity> getSelectedCourseProperty() {
        return new SimpleObjectProperty<>(selectedCourse);
    }

    public CourseEntity getSelectedCourse(){
        return selectedCourse;
    }

    public void setSelectedCourse(CourseEntity newSelectedCourse) {
        selectedCourse = newSelectedCourse;
    }

}
