package controller;

import bll.DataManager;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

public class StatisticsTeacherController implements Initializable {


    public class TableModel
    {
        public TableModel(String name, int absence)
        {
            this.name = new SimpleStringProperty(name);
            this.absence = new SimpleObjectProperty<>(new TextField(String.valueOf(absence)));
        }

        private final StringProperty name;
        private final ObjectProperty<TextField> absence;

        public ObjectProperty<TextField> absenceProperty() {
            return absence;
        }

        public StringProperty nameProperty() {
            return name;
        }

    }

    @FXML
    public TableView<TableModel> courseTable = new TableView<>();

    @FXML
    public TableColumn<TableModel, String> name = new TableColumn<>();

    @FXML
    public TableColumn<TableModel, TextField> absence = new TableColumn<>();

    public StatisticsTeacherController()
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        name.setCellValueFactory(param -> param.getValue().nameProperty());
        absence.setCellValueFactory(param -> param.getValue().absenceProperty());


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
