package controller;

import bll.DataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class StatisticsP1Controller implements Initializable {

   @FXML private PieChart statsPie;
   @FXML Button p1Btn;
   @FXML Button p2Btn;
   @FXML Button p3Btn;
   @FXML ChoiceBox selectionBox;
   @FXML Text textAttendance;
   @FXML Text textAbsence;

   private ObservableList<PieChart.Data> pieData;

   public StatisticsP1Controller()
   {

   }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                new PieChart.Data("Absence", DataManager.getInstance().getTotalAbsence()),
                new PieChart.Data("Attendance", DataManager.getInstance().getTotalAttendence())
        );

        statsPie.setData(pieData);
    }

    public void switchPage1(ActionEvent actionEvent)
    {
    }

    public void switchPage2(ActionEvent actionEvent)
    {
        try {
           FXMLLoader.load(getClass().getResource("/view/StatisticsP2.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchPage3(ActionEvent actionEvent)
    {
    }
}
