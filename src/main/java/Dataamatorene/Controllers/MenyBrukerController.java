package Dataamatorene.Controllers;

import Dataamatorene.App;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Datakomponenter.KomponentRegister;
import Dataamatorene.Dialogs;
import Dataamatorene.Tasks.ThreadOpenKomponentRegister;
import Dataamatorene.Tasks.ThreadOpenNewPage;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MenyBrukerController {

    ThreadOpenKomponentRegister threadOpenKomponentRegister;

    ThreadOpenNewPage threadOpenNewPage;

    public void initialize() {
        lblVelkommen.setText(String.format("Velkommen %s!", BrukerRegister.getAktivBruker().getBrukernavn()));

        if (BrukerRegister.getAktivBruker().getRettigheter().equalsIgnoreCase("Admin")) {
            btnAdmin.setVisible(true);
        } else btnAdmin.setVisible(false);

        progressBar.setVisible(false);

        if (!KomponentRegister.isLasta()){
            threadOpenKomponentRegister = new ThreadOpenKomponentRegister();
            menyBruker.setVisible(false);
            threadOpenKomponentRegister.setOnSucceeded(this::threadOpenKomponentRegisterDone);
            threadOpenKomponentRegister.setOnFailed(this::threadOpenKomponentRegisterFails);
            lblTilbakemelding.setText("Venligst vent...");
            progressBar.setVisible(true);
            progressBar.progressProperty().bind(threadOpenKomponentRegister.progressProperty());
            Thread th = new Thread(threadOpenKomponentRegister);
            th.setDaemon(true);
            th.start();
        }
    }

    private void threadOpenKomponentRegisterDone (WorkerStateEvent e) {
        Dialogs.showSuccessDialog("Alle filer er åpnet");
        menyBruker.setVisible(true);
        progressBar.setVisible(false);
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
    private VBox menyBruker;

    @FXML
    private Label lblVelkommen;

    @FXML
    private Label lblTilbakemelding;

    @FXML
    private ProgressBar progressBar;

    @FXML
    void mineBestillinger(ActionEvent event) {
        threadOpenNewPage = new ThreadOpenNewPage("bestillingshistorikkbruker");
        threadOpenNewPage.setOnSucceeded(this::threadOpenPageDone);
        threadOpenNewPage.setOnRunning(this::threadOpenPageRunning);
        threadOpenNewPage.setOnFailed(this::threadOpenPageFailes);
        Thread th = new Thread(threadOpenNewPage);
        th.setDaemon(true);
        th.start();
    }

    @FXML
    void nyBestiliing(ActionEvent event) {
        threadOpenNewPage = new ThreadOpenNewPage("nybestilling");
        threadOpenNewPage.setOnSucceeded(this::threadOpenPageDone);
        threadOpenNewPage.setOnRunning(this::threadOpenPageRunning);
        threadOpenNewPage.setOnFailed(this::threadOpenPageFailes);
        Thread th = new Thread(threadOpenNewPage);
        th.setDaemon(true);
        th.start();
    }

    private void threadOpenPageDone(WorkerStateEvent e){
        menyBruker.setDisable(false);
    }

    private void threadOpenPageRunning(WorkerStateEvent e) {
        lblTilbakemelding.setText("Venligst vent...");
        menyBruker.setDisable(true);
    }

    private void threadOpenPageFailes(WorkerStateEvent e){
        menyBruker.setDisable(false);
        lblTilbakemelding.setText("Det har skjedd en feil");
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
