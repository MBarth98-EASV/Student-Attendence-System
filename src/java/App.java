import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class App extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/MainAttendanceView.fxml")));
            primaryStage.setTitle("Attendance Checker");
            primaryStage.setScene(new Scene(root, 1200, 600));
            primaryStage.show();
        }


    public static void main(String[] args) {
        launch(args);
    }
}
