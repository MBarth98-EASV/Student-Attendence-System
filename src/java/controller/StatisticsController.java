package controller;

import bll.DataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;


public class StatisticsController implements Initializable {

   @FXML private PieChart statsPie;

   private ObservableList<PieChart.Data> pieData;

   public StatisticsController()
   {

   }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                new PieChart.Data("Absence", DataManager.getInstance().getTotalAbsence()),
                new PieChart.Data("Attendence", DataManager.getInstance().getTotalAttendence())
        );

        statsPie.setData(pieData);
    }
}
