package Dataamatorene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application { // Klassen for å starte hele programmet (main)

    // Deklarerer scenen
    private static Scene scene;

    // Metoden for å åpne brukergrensesnittet

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"));
        stage.getIcons().add(new Image(new FileInputStream("src/main/java/Dataamatorene/Pictures/java.png")));

        stage.setScene(scene);
        stage.setTitle("Dataamatørene");
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void setRoot(Parent p) {
        scene.setRoot(p);
    }

    // laster FXML

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}