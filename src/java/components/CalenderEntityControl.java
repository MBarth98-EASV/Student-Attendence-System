package components;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;


import java.io.IOException;
import java.net.URL;

public class CalenderEntityControl extends Pane
{
    private Node view;
    private CalenderEntityController controller;

    public CalenderEntityControl()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getResource("views\\CalenderEntity.fxml"));

        fxmlLoader.setControllerFactory(param -> controller = new CalenderEntityController());

        try
        {
            view = fxmlLoader.load();
        }
        catch (IOException ignored) {}

        getChildren().add(view);
    }

    private URL getResource(String s)
    {
        return getClass().getClassLoader().getResource(s);
    }

    public CalenderEntityController getController(){
        return controller;
    }

}
