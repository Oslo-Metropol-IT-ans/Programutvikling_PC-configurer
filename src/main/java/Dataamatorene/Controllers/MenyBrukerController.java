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
            loggUtButton.setVisible(false);
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
        loggUtButton.setVisible(true);
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
    private Label lblUpdate;

    @FXML
    private ProgressBar progressBar;

    @FXML
    void mineBestillinger(ActionEvent event) {
        threadOpenPageSet("bestillingshistorikkbruker");
    }

    @FXML
    void nyBestiliing(ActionEvent event) {
        threadOpenPageSet("nybestilling");
    }

    private void threadOpenPageSet(String s) {
        threadOpenNewPage = new ThreadOpenNewPage(s);
        threadOpenNewPage.setOnSucceeded(this::threadOpenPageDone);
        threadOpenNewPage.setOnRunning(this::threadOpenPageRunning);
        threadOpenNewPage.setOnFailed(this::threadOpenPageFailes);
        progressBar.progressProperty().bind(threadOpenNewPage.progressProperty());
        lblTilbakemelding.setText("Venligst vent...");
        lblUpdate.textProperty().bind(threadOpenNewPage.messageProperty());
        progressBar.setVisible(true);
        menyBruker.setVisible(false);
        loggUtButton.setVisible(false);
        Thread th = new Thread(threadOpenNewPage);
        th.setDaemon(true);
        th.start();
    }

    private void threadOpenPageDone(WorkerStateEvent e){
        App.setRoot(threadOpenNewPage.getValue());
        menyBruker.setVisible(true);
    }

    private void threadOpenPageRunning(WorkerStateEvent e) {
        lblTilbakemelding.setText("Venligst vent...");
        menyBruker.setVisible(false);
        loggUtButton.setVisible(false);
    }

    private void threadOpenPageFailes(WorkerStateEvent e){
        menyBruker.setVisible(true);
        loggUtButton.setVisible(true);

        lblTilbakemelding.setText("Det har skjedd en feil");
        System.err.println(e.getEventType());
    }

    @FXML
    private Button btnAdmin;

    @FXML
    private Button loggUtButton;

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
