package controller;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * Author: @Rasmus Scherning Sandbæk
 */
public class MainController implements Initializable {
    
    @FXML Pane viewPane;
    @FXML GridPane viewContainer;

    @FXML ToggleButton tglBtnMainView;
    @FXML ToggleButton tglBtnStats;
    @FXML ToggleButton tglBtnUser;

    private static MainController instance = null;


    public MainController(){
        instance = this;
    }

    public static MainController getInstance(){

        if (instance == null)
        {
            instance = new MainController();
        }

        return instance;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup navGroup = new ToggleGroup();
        navGroup.getToggles().addAll(tglBtnMainView,tglBtnStats,tglBtnUser);
    }

    public void onMainView(ActionEvent event) {
        try {
            loadSecond((Parent) FXMLLoader.load(getClass().getResource("/view/CoursesView.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onShowStats(ActionEvent event) {
        try {
            loadSecond((Parent) FXMLLoader.load(getClass().getResource("/view/StatisticsP1.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStatsPage1()
    {
        try {
            loadSecond((Parent) FXMLLoader.load(getClass().getResource("/view/StatisticsP1.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStatsPage2()
    {
        try {
            loadSecond((Parent) FXMLLoader.load(getClass().getResource("/view/StatisticsP2.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStatsPage3()
    {
        try {
            loadSecond((Parent) FXMLLoader.load(getClass().getResource("/view/StatisticsP3.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onShowUser(ActionEvent event) {
        try {
            loadSecond((Parent) FXMLLoader.load(getClass().getResource("/view/UserSettings.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showQR(){
        try {
            loadSecond((Parent) FXMLLoader.load(getClass().getResource("/view/qrMock.fxml")));
            tglBtnMainView.setDisable(true);
            tglBtnMainView.setOpacity(0);
            tglBtnStats.setDisable(true);
            tglBtnStats.setOpacity(0);
            tglBtnUser.setDisable(true);
            tglBtnUser.setOpacity(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void endQR(){
        try {
            loadSecond((Parent) FXMLLoader.load(getClass().getResource("/view/CoursesView.fxml")));
            tglBtnMainView.setDisable(false);
            tglBtnMainView.setOpacity(1);
            tglBtnStats.setDisable(false);
            tglBtnStats.setOpacity(1);
            tglBtnUser.setDisable(false);
            tglBtnUser.setOpacity(1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pane getViewPane() {
        return viewPane;
    }

    public void setViewPane(Pane viewPane) {
        this.viewPane = viewPane;
    }

    public GridPane getViewContainer() {
        return viewContainer;
    }

    public void setViewContainer(GridPane viewContainer) {
        this.viewContainer = viewContainer;
    }


    private void loadSecond(Parent newView) throws IOException
    {
        Scene scene = tglBtnMainView.getScene();
        newView.translateYProperty().set(scene.getHeight());

        viewContainer.getChildren().add(newView);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(newView.translateYProperty(), 0, Interpolator.LINEAR);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.35), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            viewContainer.getChildren().remove(viewPane);
        });
        timeline.play();
    }


}
