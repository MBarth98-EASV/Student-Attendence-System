package controller;

import component.CourseEntity;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

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

    public ObjectProperty<CourseEntity> getSelectedCourse() {
        return new SimpleObjectProperty<>(selectedCourse);
    }

    public void setSelectedCourse(CourseEntity newSelectedCourse) {
        selectedCourse = newSelectedCourse;
    }

}
