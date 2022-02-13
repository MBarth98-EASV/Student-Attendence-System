package util;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

public class SceneAnimation {


    public static void loadScene(String fxml, Node component, Pane container, Node body, double duration) throws IOException
    {
        Parent root = FXMLLoader.load(SceneAnimation.class.getResource(fxml));
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
}
