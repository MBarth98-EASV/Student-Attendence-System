package component;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public final class AttendButton {



        public static void makeText(Stage ownerStage, int toastDelay, int fadeInDelay, int fadeOutDelay)
        {
            Stage toastStage = new Stage();
            toastStage.initOwner(ownerStage);
            toastStage.setResizable(false);
            toastStage.initStyle(StageStyle.TRANSPARENT);

            Button btn = new Button();
            btn.setFont(Font.font("Verdana", 40));
            btn.setTextFill(Color.WHITE);

            StackPane root = new StackPane(btn);
            root.setStyle("-fx-background-radius: 20; -fx-background-color: rgba(0, 0, 0, 0.1); -fx-padding: 10px;");
            root.setOpacity(0);

            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            toastStage.setScene(scene);
            toastStage.show();

            Timeline fadeInTimeline = new Timeline();
            KeyFrame fadeInKey1 = new KeyFrame(Duration.millis(fadeInDelay), new KeyValue(toastStage.getScene().getRoot().opacityProperty(), 1));
            fadeInTimeline.getKeyFrames().add(fadeInKey1);
            
            fadeInTimeline.play();
        }

        public static void hideButton(int fadeOutDelayMs, int toastDelay, Stage toastStage){
                new Thread(() -> {
                    try
                    {
                        Thread.sleep(toastDelay);
                    }
                    catch (InterruptedException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    Timeline fadeOutTimeline = new Timeline();
                    KeyFrame fadeOutKey1 = new KeyFrame(Duration.millis(fadeOutDelayMs), new KeyValue (toastStage.getScene().getRoot().opacityProperty(), 0));
                    fadeOutTimeline.getKeyFrames().add(fadeOutKey1);
                    fadeOutTimeline.setOnFinished((aeb) -> toastStage.close());
                    fadeOutTimeline.play();
                }).start();
        }


}