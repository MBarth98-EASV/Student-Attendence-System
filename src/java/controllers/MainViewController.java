package controllers;

import components.CalenderEntityControl;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.Duration;
import util.EnumCourseStatus;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    public Pane viewBodyContainer;
    public GridPane mainViewBody;

    @FXML ScrollPane scrollPaneCourses;
    @FXML Label lblDay;
    @FXML Button btnNextDay;
    @FXML Button btnPrevDay;
    @FXML ToggleButton tglBtnMainView;
    @FXML ToggleButton tglBtnStats;
    @FXML ToggleButton tglBtnUser;
    @FXML AnchorPane anchorPaneAttend;
    @FXML Button btnAttendLeave;
    @FXML Slider sliderAttendLeave;
    TilePane coursePane;


    private void loadSecond(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/views/signInManuel.fxml"));
        Scene scene = btnAttendLeave.getScene();
        root.translateYProperty().set(scene.getHeight());

        viewBodyContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(10), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            viewBodyContainer.getChildren().remove(mainViewBody);
        });
        timeline.play();
    }

    private void loadScene(String fxml, Node component, Pane container, Node body, double duration) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = component.getScene();
        root.translateYProperty().set(scene.getHeight());

        container.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(duration), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            container.getChildren().remove(body);
        });
        timeline.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        coursePane = new TilePane();
        coursePane.setAlignment(Pos.CENTER);
        coursePane.setOrientation(Orientation.VERTICAL);
        coursePane.setHgap(10);
        coursePane.setVgap(10);

        coursePane.getChildren().add(new CalenderEntityControl("0000", "0000", "COURSE 1", "Here", EnumCourseStatus.ATTENDED));
        coursePane.getChildren().add(new CalenderEntityControl("0000", "0000", "COURSE 1", "Here", EnumCourseStatus.ATTENDED));

        coursePane.getChildren().add(new CalenderEntityControl("0000", "0000", "COURSE 1", "Here", EnumCourseStatus.ATTENDED));

        coursePane.getChildren().add(new CalenderEntityControl("0000", "0000", "COURSE 1", "Here", EnumCourseStatus.ATTENDED));
        coursePane.getChildren().add(new CalenderEntityControl("0000", "0000", "COURSE 1", "Here", EnumCourseStatus.ATTENDED));
        scrollPaneCourses.setContent(coursePane);
    }


    public void onMainView(ActionEvent event)
    {
        try
        {
            loadSecond(event);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void onShowStats(ActionEvent event) {
    }

    public void onShowUser(ActionEvent event) {
    }
}
