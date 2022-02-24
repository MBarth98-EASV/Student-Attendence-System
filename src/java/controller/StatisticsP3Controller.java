/**
 * @Author Philip E. Zadeh
 */
package controller;

import bll.DataManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticsP3Controller implements Initializable {

    @FXML BarChart<Number, String> monthsBar;

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
}
