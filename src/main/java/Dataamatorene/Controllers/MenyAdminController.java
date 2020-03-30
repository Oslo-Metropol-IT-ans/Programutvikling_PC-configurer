package Dataamatorene.Controllers;

import Dataamatorene.App;
import Dataamatorene.Bestilling.Bestilling;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Dialogs;
import Dataamatorene.Tasks.ThreadOpenEndreKomponent;
import Dataamatorene.Tasks.ThreadOpenKomponentRegister;
import Dataamatorene.Tasks.ThreadOpenLagKomponent;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenyAdminController {

    static boolean første = true;


    ThreadOpenLagKomponent threadOpenLagKomponent;

    ThreadOpenEndreKomponent threadOpenEndreKomponent;

    ThreadOpenKomponentRegister threadOpenKomponentRegister;

    @FXML
    private AnchorPane menyAdmin;

    @FXML
    private Label lblVelkommen;

    @FXML
    private Label lblTilbakemelding;

    public void initialize() {
        lblVelkommen.setText(String.format("Velkommen %s!", BrukerRegister.getAktivBruker().getBrukernavn()));
        menyAdmin.setDisable(false);

        if (første){
            threadOpenKomponentRegister = new ThreadOpenKomponentRegister();
            menyAdmin.setDisable(true);
            threadOpenKomponentRegister.setOnSucceeded(this::threadOpenKomponentRegisterDone);
            threadOpenKomponentRegister.setOnFailed(this::threadOpenKomponentRegisterFails);
            lblTilbakemelding.setText("Venligst vent...");
            Thread th = new Thread(threadOpenKomponentRegister);
            th.setDaemon(true);
            th.start();
        }

        if (!første) {
            System.out.println(Bestilling.getTeller());
        }

    }

    private void threadOpenKomponentRegisterDone (WorkerStateEvent e) {
        Dialogs.showSuccessDialog("Alle filer er åpnet");
        menyAdmin.setDisable(false);
        lblTilbakemelding.setText("");
        første = false;
        System.out.println(Bestilling.getTeller());
    }

    private void threadOpenKomponentRegisterFails (WorkerStateEvent e){
        Dialogs.showErrorDialog("Kunne ikke laste filer\nKontakt systemansvarlig");
        menyAdmin.setDisable(false);
    }

    @FXML
    void endreBrukere(ActionEvent event) {

        try {
            App.setRoot("endrebruker");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    Alert dialogs = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    void leggTil(ActionEvent event) {
        threadOpenLagKomponent = new ThreadOpenLagKomponent();
        menyAdmin.setDisable(true);
        threadOpenLagKomponent.setOnSucceeded(this::threadOpenDone);
        lblTilbakemelding.setText("Venligst vent...");
        Thread th = new Thread(threadOpenLagKomponent);
        th.setDaemon(true);
        th.start();
    }

    private void threadOpenDone(WorkerStateEvent e){

    }

    @FXML
    void endreKompnenter(ActionEvent event) {
        threadOpenEndreKomponent = new ThreadOpenEndreKomponent();
        menyAdmin.setDisable(true);
        threadOpenEndreKomponent.setOnSucceeded(this::threadOpenDone);
        threadOpenEndreKomponent.setOnFailed(this::threadReadFailes);
        lblTilbakemelding.setText("Venligst vent...");
        Thread th = new Thread(threadOpenEndreKomponent);
        th.setDaemon(true);
        th.start();
    }

    private void threadReadFailes(WorkerStateEvent e){
        lblTilbakemelding.setText("Det har skjedd en feil");
        menyAdmin.setDisable(false);
    }


    @FXML
    void seBestillinger(ActionEvent event) {

        try {
            App.setRoot("endrekomponent");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void loggUt(ActionEvent event) {
        try{
            App.setRoot("login");
        } catch (IOException IOE){
            IOE.printStackTrace();
        }
    }

}
