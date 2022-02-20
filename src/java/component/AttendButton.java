package component;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import util.EnumCourseStatus;

public final class AttendButton {


private EnumCourseStatus status;
private Button btn;
private AnchorPane root;


    public AttendButton(){
        btn = new Button();
        btn.setFont(Font.font("Roboto", 40));
        btn.setTextFill(Color.WHITE);

        root = new AnchorPane(btn);
        root.setStyle("-fx-background-radius: 20; -fx-background-color: rgba(0, 0, 0, 0.1); -fx-padding: 10px;");
        root.setOpacity(0);

    }

    public Button getBtn(){
        return btn;
    }

    public AnchorPane getAsNode(){
        return root;
    }

    private void toggleUI(boolean show)
    {
        if (show)
        {
            FadeTransition fadeTransition = new FadeTransition(
                    Duration.millis(200), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();
        }
        else
        {
            Timeline timeLine = new Timeline(new KeyFrame(
                    Duration.millis(100), event ->
            {
                FadeTransition fadeTransition = new FadeTransition(
                        Duration.millis(500), root);
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                fadeTransition.play();
            }));
            timeLine.play();
        }

    }

    public void showButton(int fadeInDelay, CourseEntity selectedCourse) {
        Double height = root.getHeight();
        height.intValue();
        root.setOpacity(1);

        Timeline fadeInTimeline = new Timeline();

        KeyFrame prefHeight = new KeyFrame(Duration.millis(fadeInDelay), new KeyValue(root.prefHeightProperty(), 40));
        KeyFrame minHeight = new KeyFrame(Duration.millis(fadeInDelay), new KeyValue(root.minHeightProperty(), 40));
        KeyFrame maxHeight = new KeyFrame(Duration.millis(fadeInDelay), new KeyValue(root.maxHeightProperty(), 40));

        fadeInTimeline.getKeyFrames().add(prefHeight);
        fadeInTimeline.getKeyFrames().add(minHeight);
        fadeInTimeline.getKeyFrames().add(maxHeight);

        fadeInTimeline.play();


    }

    public void hideButton(int fadeOutDelayMs, int toastDelay){

        /*  new Thread(() -> {
            try
            {
                Thread.sleep(toastDelay);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

         */
        Timeline fadeOutTimeline = new Timeline();
        KeyFrame prefHeight = new KeyFrame(Duration.millis(fadeOutDelayMs), new KeyValue(root.prefHeightProperty(), 0));
        KeyFrame minHeight = new KeyFrame(Duration.millis(fadeOutDelayMs), new KeyValue(root.minHeightProperty(), 0));
        KeyFrame maxHeight = new KeyFrame(Duration.millis(fadeOutDelayMs), new KeyValue(root.maxHeightProperty(), 0));
        
        fadeOutTimeline.getKeyFrames().add(prefHeight);
        fadeOutTimeline.getKeyFrames().add(minHeight);
        fadeOutTimeline.getKeyFrames().add(maxHeight);

        fadeOutTimeline.setOnFinished((aeb) -> root.setOpacity(0));
        fadeOutTimeline.play();
        //}).start();


    }


}