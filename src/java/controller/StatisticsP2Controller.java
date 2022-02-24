/**
 * @Author Philip E. Zadeh
 */

package controller;

import be.CourseModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticsP2Controller implements Initializable {

    @FXML private TableView<CourseModel> courseTable;
    @FXML private TableColumn<CourseModel, String> courseColumn;
    @FXML private TableColumn<CourseModel, String> courseAttendance;

    public StatisticsP2Controller()
    {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        courseColumn.setCellValueFactory(new PropertyValueFactory<CourseModel, String>("courseName"));
        courseAttendance.setCellValueFactory(new PropertyValueFactory<CourseModel, String>("courseAttendance"));

        //MocksData
        courseTable.setItems(getCourses());
    }

    public void switchPage1(MouseEvent mouseEvent)
    {
        MainController.getInstance().showStatsPage1();
    }

    public void switchPage2(MouseEvent mouseEvent)
    {
    }

    public void switchPage3(MouseEvent mouseEvent)
    {
        MainController.getInstance().showStatsPage3();
    }

    /**
     *Populates the table with courses
     *
     */
    public ObservableList<CourseModel> getCourses()
    {
        ObservableList<CourseModel> courses = FXCollections.observableArrayList();

        courses.add(new CourseModel("SCO", "97%"));
        courses.add(new CourseModel("SDE", "81%"));
        courses.add(new CourseModel("ITO", "32%"));
        courses.add(new CourseModel("DBOS", "95%"));
        courses.add(new CourseModel("MEANING", "42%"));

        return courses;
    }
}
