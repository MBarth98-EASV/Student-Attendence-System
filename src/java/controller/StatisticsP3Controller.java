package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

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

    public void switchPage1(ActionEvent actionEvent)
    {
        MainController.getInstance().showStatsPage1();
    }

    public void switchPage2(ActionEvent actionEvent)
    {
        MainController.getInstance().showStatsPage2();
    }

    public void switchPage3(ActionEvent actionEvent)
    {

    }

    public void populateBarChart()
    {
        Axis<Number> xAxis = monthsBar.getXAxis();
        Axis<String> yAxis = monthsBar.getYAxis();


        XYChart.Series attendance = new XYChart.Series();

        attendance.getData().add(new XYChart.Data<>(50, "January"));
        attendance.getData().add(new XYChart.Data<>(50, "February"));
        attendance.getData().add(new XYChart.Data<>(50, "March"));
        attendance.getData().add(new XYChart.Data<>(50, "April"));
        attendance.getData().add(new XYChart.Data<>(50, "May"));
        attendance.getData().add(new XYChart.Data<>(50, "June"));
        attendance.getData().add(new XYChart.Data<>(50, "July"));
        attendance.getData().add(new XYChart.Data<>(50, "August"));
        attendance.getData().add(new XYChart.Data<>(50, "September"));
        attendance.getData().add(new XYChart.Data<>(50, "October"));
        attendance.getData().add(new XYChart.Data<>(50, "November"));
        attendance.getData().add(new XYChart.Data<>(50, "December"));

        monthsBar.getData().addAll(attendance);



        XYChart.Series abense = new XYChart.Series();
        abense.getData().add(new XYChart.Data<>(50, "January"));
        abense.getData().add(new XYChart.Data<>(50, "February"));
        abense.getData().add(new XYChart.Data<>(50, "March"));
        abense.getData().add(new XYChart.Data<>(50, "April"));
        abense.getData().add(new XYChart.Data<>(50, "May"));
        abense.getData().add(new XYChart.Data<>(50, "June"));
        abense.getData().add(new XYChart.Data<>(50, "July"));
        abense.getData().add(new XYChart.Data<>(50, "August"));
        abense.getData().add(new XYChart.Data<>(50, "September"));
        abense.getData().add(new XYChart.Data<>(50, "October"));
        abense.getData().add(new XYChart.Data<>(50, "November"));
        abense.getData().add(new XYChart.Data<>(50, "December"));

        monthsBar.getData().addAll(abense);
    }
}
