package Dataamatorene.Controllers;

import Dataamatorene.Brukere.BrukerRegister;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MenyBrukerController {

    public void initialize() {
        lblVelkommen.setText(String.format("Velkommen %s!", BrukerRegister.getAktivBruker().getBrukernavn()));
    }

    @FXML
    private Label lblVelkommen;

    @FXML
    void mineBestillinger(ActionEvent event) {

    }

    @FXML
    void nyBestiliing(ActionEvent event) {

    }
}
