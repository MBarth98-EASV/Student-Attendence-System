package controller;

import javafx.event.ActionEvent;

public class StatisticsP3Controller {

    public StatisticsP3Controller()
    {

    }

    public void switchPage1(ActionEvent actionEvent)
    {
        MainController.getInstance().showStatsPage1();
    }

    public void switchPage2(ActionEvent actionEvent)
    {
        MainController.getInstance().showStatsPage2();
    }

    public void switchPage3(ActionEvent actionEvent)
    {

    }
}
