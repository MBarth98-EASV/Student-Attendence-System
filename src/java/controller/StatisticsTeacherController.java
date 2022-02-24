package controller;

import bll.DataManager;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticsTeacherController implements Initializable {


    public class TableModel
    {
        public TableModel(String name, int absence)
        {
            this.name.set(name);
            this.absence.set(String.valueOf(absence));
        }

        public StringProperty name  =new SimpleStringProperty();
        public StringProperty absence = new SimpleStringProperty();
    }

    @FXML
    public TableView<TableModel> courseTable = new TableView<>();

    @FXML
    public TableColumn<TableModel, String> name = new TableColumn<>();

    @FXML
    public TableColumn<TableModel, String> absence = new TableColumn<>();

    public StatisticsTeacherController()
    {
        this.name.setCellValueFactory(param -> param.getValue().name);
        this.absence.setCellValueFactory(param -> param.getValue().absence);

        this.name.setStyle("-fx-opacity: 100");


        courseTable.getColumns().add(name);
        courseTable.getColumns().add(absence);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        courseTable.itemsProperty().set(FXCollections.observableArrayList());
        courseTable.itemsProperty().get().setAll(
                new TableModel("John Wick", 75),
                new TableModel("John Wick 2", 75)
        );


    }

    public void switchPage1(MouseEvent mouseEvent)
    {

    }

    public void switchPage2(MouseEvent mouseEvent)
    {
        MainController.getInstance().showStatsPage2();
    }

}
