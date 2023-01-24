package guiController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.other.VistaNavigator;

import java.io.IOException;
public class MainPage1 extends Application {

    @Override
    public void start(Stage stage) throws IOException {
  /*     FXMLLoader fxmlLoader = new FXMLLoader(MainPage1.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Schools of rock");
        stage.setScene(scene);
        stage.show();
    }*/


    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        launch();
    }
}