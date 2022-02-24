package component;

import bll.Authentication;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import util.EnumCourseStatus;
/**
 * Author: @Rasmus Scherning Sandbæk, alcoolis
 */
public final class AttendButton {


private Button btn;
private GridPane root;
private Slider slider;

    /**Determines whether the button should be set to Leave or Attend mode.
     */
private boolean buttonAttendFunction;

private static final double BTN_PREF_HEIGHT = 50;
private static final double SLIDER_PREF_HEIGHT = 50;
private static final double ATTEND_WIDTH = 300;
private static final double ROOT_PREF_HEIGHT = 55;


    /**
     * Creates the object while also creating all the visual components/nodes associated with the object.
     * Sets the size of the components to the preferred sizes specified as constants/private static final above.
     */
    public AttendButton()
    {
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

        slider.setOnMouseReleased(event -> sliderReturnAnimation());

        if (Authentication.getInstance().getUserType() == Authentication.TYPE.TEACHER)
        {
            btn.getStylesheets().clear();
            btn.getStylesheets().add(this.getClass().getResource("/css/AttendButton.css").toExternalForm());
            btn.setDisable(false);

            btn.setOnMouseReleased(event -> {
                hideButton(100);
            });

            root.getChildren().remove(slider);
        }

    }

    public Slider getSlider() {
        return slider;
    }

    /**
     * The root of the attendButton, containing all other components.
     * @return
     */
    public GridPane getAsNode(){
        return root;
    }

    /**
     * A two part animation, which first expands the root GridPane containing the button components,
     * and then plays a button fade-in animation, tied to the opacityProperty.
     * Shows the button and makes it clickable.
     * @param fadeInDelay
     */
    public void showButton(int fadeInDelay) {
        Double height = root.getHeight();
        height.intValue();
        root.setOpacity(1);

        Timeline fadeInTimeline = new Timeline();
        Timeline btnFadeInTimeLine = new Timeline();

        KeyFrame prefHeight = new KeyFrame(Duration.millis(fadeInDelay), new KeyValue(root.prefHeightProperty(), ROOT_PREF_HEIGHT));
        KeyFrame minHeight = new KeyFrame(Duration.millis(fadeInDelay), new KeyValue(root.minHeightProperty(), ROOT_PREF_HEIGHT));
        KeyFrame maxHeight = new KeyFrame(Duration.millis(fadeInDelay), new KeyValue(root.maxHeightProperty(), ROOT_PREF_HEIGHT));
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

    /**
     * A two part animation, inverse of the showButton method.
     * First plays the button fade-out animation, and then animates the root GridPane's height to zero, so that it is hidden.
     * Also sets the slider's value to zero, to avoid it already being at 100 when the button reappears.
     * @param fadeOutDelayMs
     */
    public void hideButton(int fadeOutDelayMs){

        Timeline fadeOutTimeline = new Timeline();
        Timeline btnFadeOutTimeline = new Timeline();

        KeyFrame prefHeight = new KeyFrame(Duration.millis(fadeOutDelayMs-100), new KeyValue(root.prefHeightProperty(), 0));
        KeyFrame minHeight = new KeyFrame(Duration.millis(fadeOutDelayMs-100), new KeyValue(root.minHeightProperty(), 0));
        KeyFrame maxHeight = new KeyFrame(Duration.millis(fadeOutDelayMs-100), new KeyValue(root.maxHeightProperty(), 0));
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
            slider.setValue(0);
        });

        btnFadeOutTimeline.play();
    }

    /**
     * A delayed hideButton method, encased in a sleeping Thread.
     * User for leaving as Course, as that would not change the current scene.
     */
    public void resetSlider(){
        new Thread(() -> {
            try {
                Thread.sleep(300);
                hideButton(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * Animates the resetting of the slider value to 0, should the user not have made it to 100.
     */
    private void sliderReturnAnimation(){
        if (slider.getValue() == slider.getMax()){
            return;
        }
        else {
            Timeline sliderTimeline = new Timeline();

            KeyFrame slideDown = new KeyFrame(Duration.millis(30), new KeyValue(slider.valueProperty(), 0));
            sliderTimeline.getKeyFrames().add(slideDown);
            sliderTimeline.play();
        }
    }

    public boolean isButtonAttendFunction(){
        return buttonAttendFunction;
    }

    /**
     * Sets the style of the button, depending on the status of the status of the selectedCourse
     * @param courseStatus
     */
    public void setAttendOrLeave(EnumCourseStatus courseStatus)
    {
        btn.setOpacity(1);
        btn.getStylesheets().clear();

        if (Authentication.getInstance().getUserType() == Authentication.TYPE.TEACHER)
        {
            btn.getStylesheets().add(this.getClass().getResource("/css/AttendButton.css").toExternalForm());
            btn.setText("Create QR");

            return;
        }

        if (courseStatus == EnumCourseStatus.ATTENDED || courseStatus == EnumCourseStatus.PARTIAL) {
            slider.setOpacity(1);
            btn.getStylesheets().add(this.getClass().getResource("/css/LeaveButton.css").toExternalForm());
            btn.setText("Leave");
            buttonAttendFunction = false;
        }
        else {

            slider.setOpacity(1);
            btn.getStylesheets().add(this.getClass().getResource("/css/AttendButton.css").toExternalForm());
            btn.setText("Attend");
            buttonAttendFunction = true;
        }
    }


}