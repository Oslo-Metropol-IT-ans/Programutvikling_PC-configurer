package Dataamatorene.Controllers;

import Dataamatorene.App;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Datakomponenter.KomponentRegister;
import Dataamatorene.Dialogs;
import Dataamatorene.Tasks.*;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MenyAdminController {

    ThreadOpenNewPage threadOpenNewPage;

    ThreadOpenKomponentRegister threadOpenKomponentRegister;

    @FXML
    private VBox menyAdmin;

    @FXML
    private Label lblVelkommen;

    @FXML
    private Label lblTilbakemelding;

    @FXML
    private Label lblUpdate;

    @FXML
    public ProgressBar progressBar;

    @FXML
    private Button loggUtButton;

    public void initialize() {
        lblVelkommen.setText(String.format("Velkommen %s!", BrukerRegister.getAktivBruker().getBrukernavn()));
        menyAdmin.setDisable(false);
        progressBar.setVisible(false);

        if (!KomponentRegister.isLasta()) {
            threadOpenKomponentRegister = new ThreadOpenKomponentRegister();
            menyAdmin.setVisible(false);
            loggUtButton.setVisible(false);
            progressBar.setVisible(true);
            progressBar.progressProperty().bind(threadOpenKomponentRegister.progressProperty());
            lblUpdate.textProperty().bind(threadOpenKomponentRegister.messageProperty());
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
        menyAdmin.setVisible(true);
        loggUtButton.setVisible(true);
        progressBar.setVisible(false);
        progressBar.progressProperty().unbind();
        lblTilbakemelding.setText("");
        lblUpdate.textProperty().unbind();
        lblUpdate.setText("");
        KomponentRegister.setLasta(true);
    }

    private void threadOpenKomponentRegisterFails (WorkerStateEvent e){
        if (Dialogs.showErrorLukkDialog("Kunne ikke laste filer\nKontakt systemansvarlig")) {
            System.exit(0);
        }
    }

    @FXML
    void seBestillinger(ActionEvent event) {
        threadOpenPageSet("bestillingshistorikkadmin");
    }

    @FXML
    void endreBrukere(ActionEvent event) {
        threadOpenPageSet("endrebruker");
    }

    @FXML
    void leggTil(ActionEvent event) {
        threadOpenPageSet("lagkomponent");
    }

    @FXML
    void endreKompnenter(ActionEvent event) {
        threadOpenPageSet("endrekomponent");
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
        Thread th = new Thread(threadOpenNewPage);
        th.setDaemon(true);
        th.start();
    }

    private void threadOpenPageDone(WorkerStateEvent e){
        lblTilbakemelding.setText("");
        lblUpdate.textProperty().unbind();
        progressBar.progressProperty().unbind();

        App.setRoot(threadOpenNewPage.getValue());
    }

    private void threadOpenPageRunning(WorkerStateEvent e) {
        lblTilbakemelding.setText("Venligst vent...");

        menyAdmin.setVisible(false);
        loggUtButton.setVisible(false);
    }

    private void threadOpenPageFailes(WorkerStateEvent e){
        lblTilbakemelding.setText("Det har skjedd en feil");
        menyAdmin.setVisible(true);
        loggUtButton.setVisible(true);
    }


    @FXML
    void loggUt(ActionEvent event) {
        try{
            App.setRoot("login");
        } catch (IOException IOE){
            IOE.printStackTrace();
        }
    }

    @FXML
    void brukerside(ActionEvent event) {
        try {
            App.setRoot("menybruker");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
