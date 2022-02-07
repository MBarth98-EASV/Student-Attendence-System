package components;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;

public class CalenderEntityController implements Initializable
{
    @FXML Label lblStartTime;
    @FXML Label lblEndTime;
    @FXML Label lblCourseName;
    @FXML Label lblLocation;
    @FXML ProgressBar barStatus;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
