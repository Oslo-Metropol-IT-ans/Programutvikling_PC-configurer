package Dataamatorene.Controllers;

import Dataamatorene.App;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Datakomponenter.KomponentRegister;
import Dataamatorene.Dialogs;
import Dataamatorene.Tasks.ThreadOpenKomponentRegister;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenyBrukerController {

    ThreadOpenKomponentRegister threadOpenKomponentRegister;

    public void initialize() {
        lblVelkommen.setText(String.format("Velkommen %s!", BrukerRegister.getAktivBruker().getBrukernavn()));

        if (BrukerRegister.getAktivBruker().getRettigheter().equalsIgnoreCase("Admin")) {
            btnAdmin.setVisible(true);
        } else btnAdmin.setVisible(false);

        if (!KomponentRegister.isLasta()){
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
        KomponentRegister.setLasta(true);
    }

    private void threadOpenKomponentRegisterFails (WorkerStateEvent e){
        if (Dialogs.showErrorLukkDialog("Det har skjedd en feil med bestillingssytemet\nKontakt butikken på " +
                "tlf: 12345678")) {
            System.exit(0);
        }
    }

    @FXML
    private AnchorPane menyBruker;

    @FXML
    private Label lblVelkommen;

    @FXML
    private Label lblTilbakemelding;

    @FXML
    void mineBestillinger(ActionEvent event) {
        try {
            App.setRoot("bestillingshistorikkbruker");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    private Button btnAdmin;

    @FXML
    void admin(ActionEvent event) {
        try {
            App.setRoot("menyadmin");
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
