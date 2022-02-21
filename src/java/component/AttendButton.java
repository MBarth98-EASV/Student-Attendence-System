package component;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import util.EnumCourseStatus;

import java.sql.Time;

public final class AttendButton {


private EnumCourseStatus status;
private Button btn;
private GridPane root;
private Slider slider;

private static final double BTN_PREF_HEIGHT = 50;
private static final double SLIDER_PREF_HEIGHT = 50;
private static final double ATTEND_WIDTH = 300;




    public AttendButton(){
        btn = new Button();
        btn.setFont(Font.font("Roboto", 20));
        btn.setText("Attend");

        btn.getStylesheets().add(this.getClass().getResource("/css/AttendButton.css").toExternalForm());
        btn.setDisable(true);

        slider = new Slider(0, 100, 0);
        slider.getStylesheets().add(this.getClass().getResource("/css/AttendSlider.css").toExternalForm());

        root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(btn);
        root.getChildren().add(slider);
        root.getChildren().get(0).translateYProperty().set(-3);
        root.getChildren().get(1).translateYProperty().set(-3);
        root.setStyle("-fx-background-radius: 20; -fx-background-color: rgba(0, 0, 0, 0); -fx-padding: 10px;");
        root.setOpacity(0);

        root.setMaxHeight(0);
        root.setMinHeight(0);
        root.setPrefHeight(0);

        btn.setPrefWidth(ATTEND_WIDTH);
        btn.setMinWidth(ATTEND_WIDTH);
        btn.setMaxWidth(ATTEND_WIDTH);
        btn.setPrefHeight(BTN_PREF_HEIGHT);
        btn.setMinHeight(BTN_PREF_HEIGHT);
        btn.setMaxHeight(BTN_PREF_HEIGHT);


        slider.setPrefWidth(ATTEND_WIDTH);
        slider.setMinWidth(ATTEND_WIDTH);
        slider.setMaxWidth(ATTEND_WIDTH);
        slider.setPrefHeight(SLIDER_PREF_HEIGHT);
        slider.setMinHeight(SLIDER_PREF_HEIGHT);
        slider.setMaxHeight(SLIDER_PREF_HEIGHT);
    }

    public Button getBtn(){
        return btn;
    }

    public Slider getSlider() {
        return slider;
    }

    public GridPane getAsNode(){
        return root;
    }

    public void showButton(int fadeInDelay, CourseEntity selectedCourse) {
        Double height = root.getHeight();
        height.intValue();
        root.setOpacity(1);

        Timeline fadeInTimeline = new Timeline();
        Timeline btnFadeInTimeLine = new Timeline();

        KeyFrame prefHeight = new KeyFrame(Duration.millis(fadeInDelay), new KeyValue(root.prefHeightProperty(), 55));
        KeyFrame minHeight = new KeyFrame(Duration.millis(fadeInDelay), new KeyValue(root.minHeightProperty(), 55));
        KeyFrame maxHeight = new KeyFrame(Duration.millis(fadeInDelay), new KeyValue(root.maxHeightProperty(), 55));
        KeyFrame rootOpacity = new KeyFrame(Duration.millis(fadeInDelay), new KeyValue(root.opacityProperty(), 1));
        KeyFrame btnOpacity = new KeyFrame(Duration.millis(fadeInDelay), new KeyValue(btn.opacityProperty(), 1));
        KeyFrame sliderOpacity = new KeyFrame(Duration.millis(fadeInDelay), new KeyValue(slider.opacityProperty(), 1));


        fadeInTimeline.getKeyFrames().add(prefHeight);
        fadeInTimeline.getKeyFrames().add(minHeight);
        fadeInTimeline.getKeyFrames().add(maxHeight);
        btnFadeInTimeLine.getKeyFrames().add(btnOpacity);
        btnFadeInTimeLine.getKeyFrames().add(sliderOpacity);
        btnFadeInTimeLine.getKeyFrames().add(rootOpacity);

        fadeInTimeline.setOnFinished(event -> btnFadeInTimeLine.play());

        fadeInTimeline.play();


    }

    public void hideButton(int fadeOutDelayMs){

        Timeline fadeOutTimeline = new Timeline();
        Timeline btnFadeOutTimeline = new Timeline();

        KeyFrame prefHeight = new KeyFrame(Duration.millis(fadeOutDelayMs), new KeyValue(root.prefHeightProperty(), 0));
        KeyFrame minHeight = new KeyFrame(Duration.millis(fadeOutDelayMs), new KeyValue(root.minHeightProperty(), 0));
        KeyFrame maxHeight = new KeyFrame(Duration.millis(fadeOutDelayMs), new KeyValue(root.maxHeightProperty(), 0));
        KeyFrame rootOpacity = new KeyFrame(Duration.millis(fadeOutDelayMs), new KeyValue(root.opacityProperty(), 0));
        KeyFrame btnOpacity = new KeyFrame(Duration.millis(fadeOutDelayMs), new KeyValue(btn.opacityProperty(), 0));
        KeyFrame sliderOpacity = new KeyFrame(Duration.millis(fadeOutDelayMs), new KeyValue(slider.opacityProperty(), 0));

        fadeOutTimeline.getKeyFrames().add(prefHeight);
        fadeOutTimeline.getKeyFrames().add(minHeight);
        fadeOutTimeline.getKeyFrames().add(maxHeight);
        btnFadeOutTimeline.getKeyFrames().add(btnOpacity);
        btnFadeOutTimeline.getKeyFrames().add(sliderOpacity);
        btnFadeOutTimeline.getKeyFrames().add(rootOpacity);

        root.setOpacity(0);
        btnFadeOutTimeline.setOnFinished((aeb) -> {
            fadeOutTimeline.play();
        });

        btnFadeOutTimeline.play();
    }

    private void sliderFullListener(){
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.doubleValue() == slider.getMax()){

            }
            else {
                Timeline sliderTimeline = new Timeline();

               KeyFrame prefHeight = new KeyFrame(Duration.millis(400), new KeyValue(slider.valueProperty()));
            }
        });
    }

    private void setAttendOrLeave(boolean courseAttended){

    }


}