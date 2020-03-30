package Dataamatorene.Controllers;

import Dataamatorene.App;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Dialogs;
import Dataamatorene.Tasks.ThreadOpenKomponentRegister;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenyBrukerController {

    ThreadOpenKomponentRegister threadOpenKomponentRegister;

    private static boolean første = true;

    public void initialize() {
        lblVelkommen.setText(String.format("Velkommen %s!", BrukerRegister.getAktivBruker().getBrukernavn()));

        if (første){
            threadOpenKomponentRegister = new ThreadOpenKomponentRegister();
            menyBruker.setDisable(true);
            threadOpenKomponentRegister.setOnSucceeded(this::threadOpenKomponentRegisterDone);
            threadOpenKomponentRegister.setOnFailed(this::threadOpenKomponentRegisterFails);
            lblTilbakemelding.setText("Venligst vent...");
            Thread th = new Thread(threadOpenKomponentRegister);
            th.setDaemon(true);
            th.start();
        }
    }

    private void threadOpenKomponentRegisterDone (WorkerStateEvent e) {
        Dialogs.showSuccessDialog("Alle filer er åpnet");
        menyBruker.setDisable(false);
        lblTilbakemelding.setText("");
        første = false;
    }

    private void threadOpenKomponentRegisterFails (WorkerStateEvent e){
        Dialogs.showErrorDialog("Kunne ikke laste filer\nKontakt systemansvarlig");
        menyBruker.setDisable(false);
    }

    @FXML
    private AnchorPane menyBruker;

    @FXML
    private Label lblVelkommen;

    @FXML
    private Label lblTilbakemelding;

    @FXML
    void mineBestillinger(ActionEvent event) {

    }

    @FXML
    void nyBestiliing(ActionEvent event) {
        try {
            App.setRoot("nybestilling");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void loggUt(ActionEvent event) {
        try {
            App.setRoot("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
