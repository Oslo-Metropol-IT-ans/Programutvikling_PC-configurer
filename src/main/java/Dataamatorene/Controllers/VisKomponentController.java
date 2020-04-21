package Dataamatorene.Controllers;

import Dataamatorene.Datakomponenter.Datakomponent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class VisKomponentController {

    private static Datakomponent datakomponent;

    public static <T extends Datakomponent> void setDatakomponent(T datakomponentInn) {
        datakomponent = datakomponentInn;
    }

    public void initialize() {
        lblToString.setText(datakomponent.toString());
        if (datakomponent.getBilde() != null) {
            ivBilde.setImage(datakomponent.getBilde());
        }
    }

    @FXML
    private Label lblToString;

    @FXML
    private ImageView ivBilde;

    @FXML
    private Button lagreButton;

    @FXML
    void lastOpp(ActionEvent event) {
        datakomponent.setBilde(lasteBildeFil());
    }

    @FXML
    void lagre(ActionEvent event) {
        EndreKomponentController.setDatakomponent(datakomponent);
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
            String path = selectedFile.getPath();
            return new Image(selectedFile.getPath());
        }

        return null;
    }

}
