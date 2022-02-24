/**
 * @Author Philip E. Zadeh
 */
package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
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


        XYChart.Series attendance = new XYChart.Series();

        attendance.getData().add(new XYChart.Data<>(60, "January"));
        attendance.getData().add(new XYChart.Data<>(60, "February"));
        attendance.getData().add(new XYChart.Data<>(60, "March"));
        attendance.getData().add(new XYChart.Data<>(60, "April"));
        attendance.getData().add(new XYChart.Data<>(60, "May"));
        attendance.getData().add(new XYChart.Data<>(60, "June"));
        attendance.getData().add(new XYChart.Data<>(60, "July"));
        attendance.getData().add(new XYChart.Data<>(60, "August"));
        attendance.getData().add(new XYChart.Data<>(60, "September"));
        attendance.getData().add(new XYChart.Data<>(60, "October"));
        attendance.getData().add(new XYChart.Data<>(60, "November"));
        attendance.getData().add(new XYChart.Data<>(60, "December"));

        monthsBar.getData().addAll(attendance);



        XYChart.Series abense = new XYChart.Series();
        abense.getData().add(new XYChart.Data<>(40, "January"));
        abense.getData().add(new XYChart.Data<>(40, "February"));
        abense.getData().add(new XYChart.Data<>(40, "March"));
        abense.getData().add(new XYChart.Data<>(40, "April"));
        abense.getData().add(new XYChart.Data<>(40, "May"));
        abense.getData().add(new XYChart.Data<>(40, "June"));
        abense.getData().add(new XYChart.Data<>(40, "July"));
        abense.getData().add(new XYChart.Data<>(40, "August"));
        abense.getData().add(new XYChart.Data<>(40, "September"));
        abense.getData().add(new XYChart.Data<>(40, "October"));
        abense.getData().add(new XYChart.Data<>(40, "November"));
        abense.getData().add(new XYChart.Data<>(40, "December"));

        monthsBar.getData().addAll(abense);
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
