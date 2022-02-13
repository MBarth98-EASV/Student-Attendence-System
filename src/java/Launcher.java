import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view/PrimaryView.fxml")));
        primaryStage.setTitle("Attendance Checker");
        primaryStage.setScene(new Scene(root, 360, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
