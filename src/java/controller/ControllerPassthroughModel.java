package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ControllerPassthroughModel {

    MainController mainController;

    private Pane viewPane;
    private GridPane viewContainer;

    public ControllerPassthroughModel(){
        mainController = MainController.getInstance();
        viewContainer = mainController.getViewContainer();
        viewPane = mainController.getViewPane();
    }

    public Pane getViewPane() {
        return viewPane;
    }

    public GridPane getViewContainer() {
        return viewContainer;
    }
}
