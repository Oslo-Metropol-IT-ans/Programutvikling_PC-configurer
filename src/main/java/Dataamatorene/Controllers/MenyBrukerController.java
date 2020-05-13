package Dataamatorene.Controllers;

import Dataamatorene.App;
import Dataamatorene.Bestilling.Bestilling;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Datakomponenter.KomponentRegister;
import Dataamatorene.Dialogs;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerTxt;
import Dataamatorene.Tasks.ThreadOpenKomponentRegister;
import Dataamatorene.Tasks.ThreadOpenNewPage;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MenyBrukerController {

    // Deklarering av tasks

    ThreadOpenKomponentRegister threadOpenKomponentRegister;

    ThreadOpenNewPage threadOpenNewPage;

    // Alt som kjøres når controlleren kjøres

    public void initialize() {

        // velkommen tekst

        lblVelkommen.setText(String.format("Velkommen %s!", BrukerRegister.getAktivBruker().getBrukernavn()));

        // Hvis administrasjonsbruker så vises adminknapp

        if (BrukerRegister.getAktivBruker().getRettigheter().equalsIgnoreCase("Admin")) {
            btnAdmin.setVisible(true);
        } else btnAdmin.setVisible(false);

        // usynligjør progressbaren

        progressBar.setVisible(false);

        // Trådprogrammering for å laste alt som må lastes

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
        menyBruker.setVisible(true);
        loggUtButton.setVisible(true);
        progressBar.setVisible(false);
        lblTilbakemelding.setText("");
        KomponentRegister.setLasta(true);
    }

    // hvis tråden feiler

    private void threadOpenKomponentRegisterFails (WorkerStateEvent e){
        if (Dialogs.showErrorLukkDialog("Det har skjedd en feil med bestillingssytemet\nKontakt butikken på " +
                "tlf: 12345678")) {
            System.exit(0);
        }
    }

    // FXML deklarasjoner

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

    // knappene sine actionevent

    @FXML
    void mineBestillinger(ActionEvent event) {
        threadOpenPageSet("FXML/bestillingshistorikkbruker");
    }

    @FXML
    void nyBestiliing(ActionEvent event) {
        threadOpenPageSet("FXML/nybestilling");
    }

    @FXML
    void lastOpp(ActionEvent event) {
        FileOpener opener = new FileOpenerTxt();

        String path;

        File selectedFile;
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT Files", "*.txt"));
        try {
            var test = System.getProperty("user.home") + "/Desktop";
            fc.setInitialDirectory(new File(test));
            selectedFile = fc.showOpenDialog(null);
        } catch (Exception e) {
            fc.setInitialDirectory(null);
            selectedFile = fc.showOpenDialog(null);
        }

        if (selectedFile != null) {
            path = selectedFile.getAbsolutePath();

            try {
                ArrayList<Bestilling> nye = (ArrayList<Bestilling>) opener.read(path);

                VisBestillingerController.setListeBestillinger(nye);
                Parent root;
                try {
                    root = App.loadFXML("FXML/visbestillinger");
                    Stage stage = new Stage();
                    stage.setTitle("Bestilling");
                    stage.setScene(new Scene(root, 900, 600));
                    stage.show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    // Opprettelse av tråd og lasting av ny side i egen tråd
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

    // Når tråden er ferdig

    private void threadOpenPageDone(WorkerStateEvent e){
        App.setRoot(threadOpenNewPage.getValue());
        menyBruker.setVisible(true);
    }

    // Når tråden kjører

    private void threadOpenPageRunning(WorkerStateEvent e) {
        lblTilbakemelding.setText("Venligst vent...");
        menyBruker.setVisible(false);
        loggUtButton.setVisible(false);
    }

    // Når tråden feiler

    private void threadOpenPageFailes(WorkerStateEvent e){
        menyBruker.setVisible(true);
        loggUtButton.setVisible(true);

        lblTilbakemelding.setText("Det har skjedd en feil");
        System.err.println(e.getEventType());
    }

    // FXML deklarasjoner

    @FXML
    private Button btnAdmin;

    @FXML
    private Button loggUtButton;

    // Knapper sine actionevent

    @FXML
    void admin(ActionEvent event) {
        try {
            App.setRoot("FXML/menyadmin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void loggUt(ActionEvent event) {
        try {
            App.setRoot("FXML/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
