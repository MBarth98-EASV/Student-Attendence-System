/**
 * @Author Philip E. Zadeh
 */

package controller;

import be.CourseModel;
import bll.DataManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticsP2Controller implements Initializable {

    @FXML private TableView<CourseModel> courseTable;
    @FXML private TableColumn<CourseModel, String> courseColumn;
    @FXML private TableColumn<CourseModel, String> courseAttendance;
    @FXML ImageView imgBtn1;
    @FXML ImageView imgBtn2;
    @FXML ImageView imgBtn3;

    public StatisticsP2Controller()
    {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        courseColumn.setCellValueFactory(new PropertyValueFactory<CourseModel, String>("courseName"));
        courseAttendance.setCellValueFactory(new PropertyValueFactory<CourseModel, String>("courseAttendance"));

        //MocksData
        courseTable.setItems(DataManager.getInstance().getCourses());
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
        imgBtn2.setImage(new Image(getClass().getResourceAsStream("/img/buttonselectedhover.png")));
    }

    public void onMouseRemoveBtn2(MouseEvent mouseEvent)
    {
        imgBtn2.setImage(new Image(getClass().getResourceAsStream("/img/buttonselected.png")));
    }

    public void onMouseHoverBtn3(MouseEvent mouseEvent)
    {
        imgBtn3.setImage(new Image(getClass().getResourceAsStream("/img/buttonunselectedhover.png")));
    }

    public void onMouseRemoveBtn3(MouseEvent mouseEvent)
    {
        imgBtn3.setImage(new Image(getClass().getResourceAsStream("/img/buttonunselected.png")));
    }
}
