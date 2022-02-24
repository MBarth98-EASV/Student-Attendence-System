/**
 * @Author Philip E. Zadeh
 */
package controller;

import bll.DataManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticsP3Controller implements Initializable {

    @FXML BarChart<Number, String> monthsBar;
    @FXML ImageView imgBtn1;
    @FXML ImageView imgBtn2;
    @FXML ImageView imgBtn3;

    public StatisticsP3Controller()
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        populateBarChart();
    }

    public void populateBarChart()
    {
        Axis<Number> xAxis = monthsBar.getXAxis();
        Axis<String> yAxis = monthsBar.getYAxis();

        xAxis.setAutoRanging(false);

        monthsBar.getData().addAll(DataManager.getInstance().getAttendanceBarData());
        monthsBar.getData().addAll(DataManager.getInstance().getAbsenceBarData());
    }

    public void switchPage1(MouseEvent mouseEvent)
    {
        MainController.getInstance().showStatsPage1();
    }

    public void switchPage2(MouseEvent mouseEvent)
    {
        MainController.getInstance().showStatsPage2();
    }

    public void switchPage3(MouseEvent mouseEvent)
    {
    }

    public void onMouseHoverBtn1(MouseEvent mouseEvent)
    {
        imgBtn1.setImage(new Image(getClass().getResourceAsStream("/img/buttonunselectedhover.png")));
    }

    public void onMouseRemoveBtn1(MouseEvent mouseEvent)
    {
        imgBtn1.setImage(new Image(getClass().getResourceAsStream("/img/buttonunselected.png")));
    }

    public void onMouseHoverBtn2(MouseEvent mouseEvent)
    {
        imgBtn2.setImage(new Image(getClass().getResourceAsStream("/img/buttonunselectedhover.png")));
    }

    public void onMouseRemoveBtn2(MouseEvent mouseEvent)
    {
        imgBtn2.setImage(new Image(getClass().getResourceAsStream("/img/buttonunselected.png")));
    }

    public void onMouseHoverBtn3(MouseEvent mouseEvent)
    {
        imgBtn3.setImage(new Image(getClass().getResourceAsStream("/img/buttonselectedhover.png")));
    }

    public void onMouseRemoveBtn3(MouseEvent mouseEvent)
    {
        imgBtn3.setImage(new Image(getClass().getResourceAsStream("/img/buttonselected.png")));
    }
}
