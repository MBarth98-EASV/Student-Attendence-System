package controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class StatisticsP2Controller {

    public StatisticsP2Controller()
    {
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
}
