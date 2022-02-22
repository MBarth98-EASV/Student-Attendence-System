/**
 * @Author Philip E. Zadeh
 */

package controller;

import bll.DataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class StatisticsP1Controller implements Initializable {

   @FXML private PieChart statsPie;
   @FXML Button p1Btn;
   @FXML Button p2Btn;
   @FXML Button p3Btn;
   @FXML ComboBox<String> selectionBox;
   @FXML Text textAttendance;
   @FXML Text textAbsence;

   public StatisticsP1Controller()
   {

   }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        selectionBox.getItems().add("week");
        selectionBox.getItems().add("month");
        selectionBox.getItems().add("year");
        selectionBox.getItems().add("total");

        if (selectionBox.getSelectionModel().getSelectedItem() == null)
        {
            selectionBox.getSelectionModel().select("week");

            ObservableList<PieChart.Data> pieDataWeek = FXCollections.observableArrayList(
                    new PieChart.Data("Absence", DataManager.getInstance().getAbsenceWeek()),
                    new PieChart.Data("Attendance", DataManager.getInstance().getAttendanceWeek())
            );

            statsPie.setData(pieDataWeek);

            textAbsence.setText(DataManager.getInstance().percent(DataManager.getInstance().getAbsenceWeek(), DataManager.getInstance().getAttendanceWeek()) + "%");
            textAttendance.setText(DataManager.getInstance().percent(DataManager.getInstance().getAttendanceWeek(),DataManager.getInstance().getAbsenceWeek()) + "%");

        }

    }

    public void switchPage1(ActionEvent actionEvent)
    {
    }

    public void switchPage2(ActionEvent actionEvent)
    {
        MainController.getInstance().showStatsPage2();
    }

    public void switchPage3(ActionEvent actionEvent)
    {
        MainController.getInstance().showStatsPage3();
    }

    public void comboBoxChoice(ActionEvent actionEvent)
    {
        if (!selectionBox.getSelectionModel().getSelectedItem().isEmpty())
        {
            switch (selectionBox.getSelectionModel().getSelectedItem())
            {
                case "week":
                    ObservableList<PieChart.Data> pieDataWeek = FXCollections.observableArrayList(
                            new PieChart.Data("Absence", DataManager.getInstance().getAbsenceWeek()),
                            new PieChart.Data("Attendance", DataManager.getInstance().getAttendanceWeek())
                    );

                    statsPie.setData(pieDataWeek);

                    textAbsence.setText(DataManager.getInstance().percent(DataManager.getInstance().getAbsenceWeek(), DataManager.getInstance().getAttendanceWeek()) + "%");
                    textAttendance.setText(DataManager.getInstance().percent(DataManager.getInstance().getAttendanceWeek(),DataManager.getInstance().getAbsenceWeek()) + "%");

                    break;
                case "month":
                    ObservableList<PieChart.Data> pieDataMonth = FXCollections.observableArrayList(
                            new PieChart.Data("Absence", DataManager.getInstance().getAbsenceMonth()),
                            new PieChart.Data("Attendance", DataManager.getInstance().getAttendanceMonth())
                    );

                    statsPie.setData(pieDataMonth);

                    textAbsence.setText(DataManager.getInstance().percent(DataManager.getInstance().getAbsenceMonth(), DataManager.getInstance().getAttendanceMonth()) + "%");
                    textAttendance.setText(DataManager.getInstance().percent(DataManager.getInstance().getAttendanceMonth(),DataManager.getInstance().getAbsenceMonth()) + "%");
                    break;
                case "year":
                    ObservableList<PieChart.Data> pieDataYear = FXCollections.observableArrayList(
                            new PieChart.Data("Absence", DataManager.getInstance().getAbsenceYear()),
                            new PieChart.Data("Attendance", DataManager.getInstance().getAttendanceYear())
                    );

                    statsPie.setData(pieDataYear);

                    textAbsence.setText(DataManager.getInstance().percent(DataManager.getInstance().getAbsenceYear(), DataManager.getInstance().getAttendanceYear()) + "%");
                    textAttendance.setText(DataManager.getInstance().percent(DataManager.getInstance().getAttendanceYear(),DataManager.getInstance().getAbsenceYear()) + "%");
                    break;

                case "total":
                    ObservableList<PieChart.Data> pieDataTotal = FXCollections.observableArrayList(
                            new PieChart.Data("Absence", DataManager.getInstance().getAbsenceTotal()),
                            new PieChart.Data("Attendance", DataManager.getInstance().getAttendanceTotal())
                    );

                    statsPie.setData(pieDataTotal);

                    textAbsence.setText(DataManager.getInstance().percent(DataManager.getInstance().getAbsenceTotal(), DataManager.getInstance().getAttendanceTotal()) + "%");
                    textAttendance.setText(DataManager.getInstance().percent(DataManager.getInstance().getAttendanceTotal(),DataManager.getInstance().getAbsenceTotal()) + "%");
                    break;
            }
        }
    }
}
