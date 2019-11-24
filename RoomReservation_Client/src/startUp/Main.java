package startUp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main extends Application {
    public static Stage stage;

    public static void main(String[] args) {
        try {
            System.out.println("\n \n Thread Is Sleeping for Server Startup ... ! \n \n");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            URL url = new File("RoomReservation_Client/assets/xmls/Login.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene mainScene = new Scene(root);
            primaryStage.setScene(mainScene);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setTitle("Login");
            stage = primaryStage;
            primaryStage.show();
        } catch (MalformedURLException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
    }
}