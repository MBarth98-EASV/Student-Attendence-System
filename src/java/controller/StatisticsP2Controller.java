package controller;

import javafx.event.ActionEvent;

public class StatisticsP2Controller {

    public StatisticsP2Controller()
    {
    }

    public void switchPage1(ActionEvent actionEvent)
    {
        MainController.getInstance().showStatsPage1();
    }

    public void switchPage2(ActionEvent actionEvent)
    {
    }

    public void switchPage3(ActionEvent actionEvent)
    {
        MainController.getInstance().showStatsPage3();
    }
}
