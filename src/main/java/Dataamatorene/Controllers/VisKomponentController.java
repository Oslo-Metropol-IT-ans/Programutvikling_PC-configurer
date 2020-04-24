package Dataamatorene.Controllers;

import Dataamatorene.Datakomponenter.Datakomponent;
import Dataamatorene.Komponent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VisKomponentController {

    private static Komponent<? extends Datakomponent> datakomponent;

    public static <T extends Datakomponent> void setDatakomponent(T datakomponentInn) {
        datakomponent = new Komponent<>(datakomponentInn);
    }

    public void initialize() throws FileNotFoundException {
        lblToString.setText(datakomponent.getKomponent().getBeskrivelse());
        if (datakomponent.getKomponent().getBilde() != null) {
            ivBilde.setImage(datakomponent.getKomponent().getBilde());
        } else ivBilde.setImage(new Image(new FileInputStream("src/main/java/Dataamatorene/Pictures/nia.jpg")));
    }

    @FXML
    private Label lblToString;

    @FXML
    private ImageView ivBilde;

    @FXML
    private Button lagreButton;

    @FXML
    void lastOpp(ActionEvent event) {
        Image bilde = lasteBildeFil();
        datakomponent.getKomponent().setBilde(bilde);
        ivBilde.setImage(bilde);
    }

    @FXML
    void lagre(ActionEvent event) {
        EndreKomponentController.setDatakomponent(datakomponent.getKomponent());
        // get a handle to the stage
        Stage stage = (Stage) lagreButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    private static Image lasteBildeFil() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            return new Image(selectedFile.toURI().toString()    );
        }

        return null;
    }

}
