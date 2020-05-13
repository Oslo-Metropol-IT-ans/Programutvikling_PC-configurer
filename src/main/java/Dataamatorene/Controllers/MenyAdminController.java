package Dataamatorene.Controllers;

import Dataamatorene.App;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Datakomponenter.KomponentRegister;
import Dataamatorene.Dialogs;
import Dataamatorene.Tasks.*;
import com.jfoenix.controls.JFXProgressBar;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MenyAdminController {

    // Deklarering av task

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
        if(BrukerRegister.getAktivBruker().getNavn() != null) {
            lblVelkommen.setText(String.format("Velkommen %s!", BrukerRegister.getAktivBruker().getNavn()));
        } else lblVelkommen.setText(String.format("Velkommen %s!", BrukerRegister.getAktivBruker().getBrukernavn()));


        menyAdmin.setDisable(false);
        progressBar.setVisible(false);

        // Laster registerene i ny tråd hvis dette ikke er lastet
        if (!KomponentRegister.isLasta()) {
            threadOpenKomponentRegister = new ThreadOpenKomponentRegister();
            menyAdmin.setVisible(false);
            loggUtButton.setVisible(false);
            progressBar.setVisible(true);
            progressBar.progressProperty().bind(threadOpenKomponentRegister.progressProperty());
            lblUpdate.textProperty().bind(threadOpenKomponentRegister.messageProperty());
            threadOpenKomponentRegister.setOnSucceeded(this::threadOpenKomponentRegisterDone);
            threadOpenKomponentRegister.setOnRunning(this::threaDOpenKomponentRegisterRunning);
            threadOpenKomponentRegister.setOnFailed(this::threadOpenKomponentRegisterFails);
            lblTilbakemelding.setText("Venligst vent...");
            Thread th = new Thread(threadOpenKomponentRegister);
            th.setDaemon(true);
            th.start();
        }
    }

    // Metode ved vellykket kjøring av tråd
    private void threadOpenKomponentRegisterDone (WorkerStateEvent e) {
        menyAdmin.getScene().setCursor(Cursor.DEFAULT);
        menyAdmin.setVisible(true);
        loggUtButton.setVisible(true);
        progressBar.setVisible(false);
        progressBar.progressProperty().unbind();
        lblTilbakemelding.setText("");
        lblUpdate.textProperty().unbind();
        lblUpdate.setText("");
        KomponentRegister.setLasta(true);
    }

    private void threaDOpenKomponentRegisterRunning(WorkerStateEvent e) {
        menyAdmin.getScene().setCursor(Cursor.WAIT);
    }

    // Metode ved misslykket lasting av tråd, programmet lukkes
    private void threadOpenKomponentRegisterFails (WorkerStateEvent e){
        if (Dialogs.showErrorLukkDialog("Kunne ikke laste filer\nKontakt systemansvarlig")) {
            System.exit(0);
        }
    }

    // Metoder for lasting av side i ny trå
    @FXML
    void seBestillinger(ActionEvent event) {
        threadOpenPageSet("FXML/bestillingshistorikkadmin");
    }

    @FXML
    void endreBrukere(ActionEvent event) {
        threadOpenPageSet("FXML/endrebruker");
    }

    @FXML
    void leggTil(ActionEvent event) {
        threadOpenPageSet("FXML/lagkomponent");
    }

    @FXML
    void endreKompnenter(ActionEvent event) {
        threadOpenPageSet("FXML/endrekomponent");
    }

    // Metode for å laste ny side i egen tråd
    public void threadOpenPageSet(String s) {
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

    // Metode kjørt ved vellykket innlasting av side
    private void threadOpenPageDone(WorkerStateEvent e){
        menyAdmin.getScene().setCursor(Cursor.DEFAULT);
        lblTilbakemelding.setText("");
        lblUpdate.textProperty().unbind();
        progressBar.progressProperty().unbind();

        App.setRoot(threadOpenNewPage.getValue());
    }

    // Metode kjørt underves av lasting
    private void threadOpenPageRunning(WorkerStateEvent e) {
        menyAdmin.getScene().setCursor(Cursor.WAIT);
        lblTilbakemelding.setText("Venligst vent...");

        menyAdmin.setVisible(false);
        loggUtButton.setVisible(false);
    }

    // Metode kjørt ved misslykket lasting
    private void threadOpenPageFailes(WorkerStateEvent e){
        lblTilbakemelding.setText("Det har skjedd en feil");
        menyAdmin.setVisible(true);
        loggUtButton.setVisible(true);
    }


    // Metode for å logge ut
    @FXML
    void loggUt(ActionEvent event) {
        try{
            App.setRoot("FXML/login");
        } catch (IOException IOE){
            IOE.printStackTrace();
        }
    }

    // Metode for å gå til sluttbrukers grensesnitt
    @FXML
    void brukerside(ActionEvent event) {
        try {
            App.setRoot("FXML/menybruker");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
