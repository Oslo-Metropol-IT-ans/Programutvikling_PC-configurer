package Dataamatorene.Controllers;

import Dataamatorene.App;
import Dataamatorene.Bestilling.Bestilling;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Datakomponenter.KomponentRegister;
import Dataamatorene.Dialogs;
import Dataamatorene.Tasks.*;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MenyAdminController {


    ThreadOpenNewPage threadOpenNewPage;

    ThreadOpenKomponentRegister2 threadOpenKomponentRegister;

    @FXML
    private VBox menyAdmin;

    @FXML
    private Label lblVelkommen;

    @FXML
    private Label lblTilbakemelding;

    @FXML
    private Label lblUpdate;

    @FXML
    private ProgressBar progressBar;

    public void initialize() {
        lblVelkommen.setText(String.format("Velkommen %s!", BrukerRegister.getAktivBruker().getBrukernavn()));
        menyAdmin.setDisable(false);
        progressBar.setVisible(false);

        if (!KomponentRegister.isLasta()){
            threadOpenKomponentRegister = new ThreadOpenKomponentRegister2();
            menyAdmin.setVisible(false);
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

        if (KomponentRegister.isLasta()) {
            System.out.println(Bestilling.getTeller());
        }

    }

    private void threadOpenKomponentRegisterDone (WorkerStateEvent e) {
        Dialogs.showSuccessDialog("Alle filer er åpnet");
        menyAdmin.setVisible(true);
        progressBar.setVisible(false);
        lblTilbakemelding.setText("");
        lblUpdate.textProperty().unbind();
        lblUpdate.setText("");
        KomponentRegister.setLasta(true);
        System.out.println(Bestilling.getTeller());
    }

    private void threadOpenKomponentRegisterFails (WorkerStateEvent e){
        if (Dialogs.showErrorLukkDialog("Kunne ikke laste filer\nKontakt systemansvarlig")) {
            System.exit(0);
        }
    }

    @FXML
    void endreBrukere(ActionEvent event) {
        threadOpenNewPage = new ThreadOpenNewPage("endrebruker");
        threadOpenNewPage.setOnSucceeded(this::threadOpenPageDone);
        threadOpenNewPage.setOnRunning(this::threadOpenPageRunning);
        threadOpenNewPage.setOnFailed(this::threadOpenPageFailes);
        Thread th = new Thread(threadOpenNewPage);
        th.setDaemon(true);
        th.start();

    }

    @FXML
    void leggTil(ActionEvent event) {
        threadOpenNewPage = new ThreadOpenNewPage("lagkomponent");
        threadOpenNewPage.setOnSucceeded(this::threadOpenPageDone);
        threadOpenNewPage.setOnRunning(this::threadOpenPageRunning);
        threadOpenNewPage.setOnFailed(this::threadOpenPageFailes);
        Thread th = new Thread(threadOpenNewPage);
        th.setDaemon(true);
        th.start();
    }

    @FXML
    void endreKompnenter(ActionEvent event) {
        threadOpenNewPage = new ThreadOpenNewPage("endrekomponent");
        threadOpenNewPage.setOnSucceeded(this::threadOpenPageDone);
        threadOpenNewPage.setOnRunning(this::threadOpenPageRunning);
        threadOpenNewPage.setOnFailed(this::threadOpenPageFailes);
        Thread th = new Thread(threadOpenNewPage);
        th.setDaemon(true);
        th.start();
    }

    private void threadOpenPageDone(WorkerStateEvent e){

    }

    private void threadOpenPageRunning(WorkerStateEvent e) {
        lblTilbakemelding.setText("Venligst vent...");
        menyAdmin.setDisable(true);
    }

    private void threadOpenPageFailes(WorkerStateEvent e){
        lblTilbakemelding.setText("Det har skjedd en feil");
        menyAdmin.setDisable(false);
    }


    @FXML
    void seBestillinger(ActionEvent event) {
        threadOpenNewPage = new ThreadOpenNewPage("bestillingshistorikkadmin");
        threadOpenNewPage.setOnSucceeded(this::threadOpenPageDone);
        threadOpenNewPage.setOnRunning(this::threadOpenPageRunning);
        threadOpenNewPage.setOnFailed(this::threadOpenPageFailes);
        Thread th = new Thread(threadOpenNewPage);
        th.setDaemon(true);
        th.start();

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
