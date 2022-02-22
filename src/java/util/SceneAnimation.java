package util;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;

public class SceneAnimation
{
    public static void loadContent(String fxml, Pane anchorNode, Orientation orientation, double duration) throws IOException
    {
        Timeline timeline = new Timeline();
        KeyValue kv;

        Node newContent = FXMLLoader.load(Objects.requireNonNull(SceneAnimation.class.getResource(fxml)));

        anchorNode.getChildren().add(newContent);

        if (orientation == Orientation.VERTICAL)
        {
            newContent.translateYProperty().set(anchorNode.getHeight());
            kv = new KeyValue(newContent.translateYProperty(), 0, Interpolator.LINEAR);
        }
        else
        {
            newContent.translateXProperty().set(anchorNode.getWidth());
            kv = new KeyValue(newContent.translateXProperty(), 0, Interpolator.LINEAR);
        }

        KeyFrame kf = new KeyFrame(Duration.seconds(duration), kv);

        timeline.getKeyFrames().add(kf);

        timeline.setOnFinished(t -> {
            anchorNode.getChildren().setAll(newContent);
        });

        timeline.play();
    }
}
