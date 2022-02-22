package controller;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import util.SceneAnimation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{

    @FXML Pane viewContainer;

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
    public void initialize(URL location, ResourceBundle resources)
    {
        ToggleGroup navGroup = new ToggleGroup();
        navGroup.getToggles().addAll(tglBtnMainView,tglBtnStats,tglBtnUser);
    }

    public void onMainView(ActionEvent event)
    {
        try
        {
            SceneAnimation.loadContent("/view/CoursesView.fxml", viewContainer, Orientation.VERTICAL, 0.32);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void onShowStats(ActionEvent event)
    {
        try
        {
            SceneAnimation.loadContent("/view/StatisticsP1.fxml", viewContainer, Orientation.VERTICAL, 0.32);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showStatsPage1()
    {
        try
        {
            SceneAnimation.loadContent("/view/StatisticsP1.fxml", viewContainer, Orientation.HORIZONTAL, 0.32);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showStatsPage2()
    {
        try
        {
            SceneAnimation.loadContent("/view/StatisticsP2.fxml", viewContainer, Orientation.HORIZONTAL, 0.32);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showStatsPage3()
    {
        try
        {
            SceneAnimation.loadContent("/view/StatisticsP3.fxml", viewContainer,  Orientation.HORIZONTAL, 0.32);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void onShowUser(ActionEvent event)
    {
        try
        {
            SceneAnimation.loadContent("/view/UserSettings.fxml", viewContainer,  Orientation.VERTICAL, 0.32);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showQR()
    {
        try
        {
            SceneAnimation.loadContent("/view/qrMock.fxml", viewContainer,  Orientation.VERTICAL, 0.32);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void endQR()
    {
        try
        {
            SceneAnimation.loadContent("/view/CoursesView.fxml", viewContainer, Orientation.VERTICAL, 0.32);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
