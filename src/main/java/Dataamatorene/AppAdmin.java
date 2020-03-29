package Dataamatorene;

import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerJobj;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AppAdmin extends Application {
    //private static Scene scene = App.scene;

    @Override
    public void start(Stage stage) throws IOException {
        App.scene = new Scene(loadFXML("menyadmin"));
        stage.setScene(App.scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        App.scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        FileOpener opener = new FileOpenerJobj();
        try {
            BrukerRegister.setBrukere((ArrayList<Bruker>) opener.read("src/main/java/Dataamatorene/Files/Login.jobj"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        BrukerRegister.setAktivBruker(BrukerRegister.getBrukere().get(0));
        launch();
    }
}
