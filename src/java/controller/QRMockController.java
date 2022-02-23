package controller;

import bll.DataManager;
import component.CourseEntity;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import util.EnumCourseStatus;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

/**
 * Author: @Rasmus Scherning Sandbæk
 */

public class QRMockController implements Initializable {

    private CourseEntity courseToAttend;

    @FXML public Button scanButton;
    @FXML public ImageView imgViewQR;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        courseToAttend = ControllerPassthroughModel.getInstance().getSelectedCourse();
    }

    /**
     * Plays a small animation on the ImageView to simulate the scanning of a QR code.
     * When done, the course selected in CourseView will either be set to Attend if it has not ended and it started
     * less than five minutes ago. Otherwise, it will be set to partial, meaning partial attendance.
     * @param event
     */
    public void onScanQRCode(ActionEvent event) {
        Image baseImage = imgViewQR.getImage();
        Image whiteImage = generateWhiteImage();
        Timeline timeline = new Timeline();

        KeyFrame qrToWhite = new KeyFrame(Duration.millis(100), new KeyValue(imgViewQR.imageProperty(), whiteImage));
        KeyFrame whiteToQR = new KeyFrame(Duration.millis(1000), new KeyValue(imgViewQR.imageProperty(), baseImage));

        timeline.getKeyFrames().add(qrToWhite);
        timeline.getKeyFrames().add(whiteToQR);
        timeline.setOnFinished(event1 -> {

            if (LocalDateTime.now().isBefore(courseToAttend.getStartTime().plusMinutes(5)) && LocalDateTime.now().isBefore(courseToAttend.getEndTime()))
            {
                DataManager.getInstance().changeCourseStatus(courseToAttend, EnumCourseStatus.ATTENDED);
            }

            else if (LocalDateTime.now().isAfter(courseToAttend.getStartTime().plusMinutes(5)) && LocalDateTime.now().isBefore(courseToAttend.getEndTime()))
            {
                DataManager.getInstance().changeCourseStatus(courseToAttend, EnumCourseStatus.PARTIAL);
            }
            MainController.getInstance().endQR();
        });

        timeline.play();

    }

    /**
     * Generates a completely white image of 1x1 pixel, which can then be scaled to the size of the ImageView.
     * @return a white image.
     */
    private Image generateWhiteImage() {
        Double width = imgViewQR.getImage().getWidth();
        Double height = imgViewQR.getImage().getHeight();

        WritableImage img = new WritableImage(1, 1);
        PixelWriter pw = img.getPixelWriter();

        Color color = Color.WHITE;
        pw.setColor(0, 0, color);
        return img ;
    }
}
