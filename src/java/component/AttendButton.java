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

private Stage btnStage;
private Stage ownerStage;


    public AttendButton(Stage ownerStage){
        this.ownerStage = ownerStage;
        btnStage = new Stage();
        btnStage.initOwner(ownerStage);
        btnStage.setResizable(false);
        btnStage.initStyle(StageStyle.TRANSPARENT);

    }

    public void showButton(int fadeInDelay, CourseEntity selectedCourse) {

            Button btn = new Button();
            btn.setFont(Font.font("Roboto", 40));
            btn.setTextFill(Color.WHITE);

            StackPane root = new StackPane(btn);
            root.setStyle("-fx-background-radius: 20; -fx-background-color: rgba(0, 0, 0, 0.1); -fx-padding: 10px;");
            root.setOpacity(0);

            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            btnStage.setY(ownerStage.getY());
            btnStage.setX(ownerStage.getX());
            btnStage.setScene(scene);
            btnStage.show();

            Timeline fadeInTimeline = new Timeline();
            KeyFrame fadeInKey = new KeyFrame(Duration.millis(fadeInDelay), new KeyValue(btnStage.getScene().getRoot().opacityProperty(), 1));
            fadeInTimeline.getKeyFrames().add(fadeInKey);

            fadeInTimeline.play();
    }

    public void hideButton(int fadeOutDelayMs, int toastDelay){
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
            KeyFrame fadeOutKey = new KeyFrame(Duration.millis(fadeOutDelayMs), new KeyValue (btnStage.getScene().getRoot().opacityProperty(), 0));
            fadeOutTimeline.getKeyFrames().add(fadeOutKey);
            fadeOutTimeline.setOnFinished((aeb) -> btnStage.close());
            fadeOutTimeline.play();
        }).start();
    }


}