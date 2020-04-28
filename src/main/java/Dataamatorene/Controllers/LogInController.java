package Dataamatorene.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import Dataamatorene.App;
import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Dialogs;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerJobj;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class LogInController {


    public void initialize() {

        BrukerRegister.setAktivBruker(null);

        // Laster inn brukere
        FileOpener opener = new FileOpenerJobj();
        try {
            BrukerRegister.setBrukere((ArrayList<Bruker>) opener.read("src/main/java/Dataamatorene/Files/Login.jobj"));
        } catch (IOException e) {
            Dialogs.showErrorDialog(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Setter metode på entertrykk i tetfield
        txtBrukernavn.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER){
                txtPassword.requestFocus();
            }

        });

        txtPassword.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER){
                loggInn(keyEvent);
            }
        });

    }

    // FXML deklarering
    @FXML
    private TextField txtBrukernavn;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnNyBruker;

    @FXML
    private Button btnLoggInn;

    @FXML
    private Label lblTilbakemeling;

    // Metode for å logge inn
    @FXML
    void loggInn(Event event) {

        // Henter alle brukere
        List<Bruker> liste = BrukerRegister.getBrukere();

        // Registrerer input
        String brukernavn = txtBrukernavn.getText();
        String passord = txtPassword.getText();

        boolean finnes = false;

        // Kjører løkke for å se etter match med innput
        for(Bruker b:liste){
            if (brukernavn.equalsIgnoreCase(b.getBrukernavn()) && passord.equals(b.getPassord())){
                finnes = true;
                BrukerRegister.setAktivBruker(b);
                if (b.isSuperbruker()){
                    try {
                        // Går til meny admin ved funn av superbruker
                        App.setRoot("menyadmin");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    try {
                        // Går til meny bruker ved funn av sluttbruker
                        App.setRoot("menybruker");
                    } catch (IOException e) {
                        Dialogs.showErrorDialog("Denne siden finnes ikke");
                    }
                }
            }
        }

        // Tilbakemelding til bruker ved misslykket innlogging
        if(!finnes){
            Dialogs.showErrorDialog("Brukernavn eller passord er feil");
            txtPassword.setText("");
            txtPassword.requestFocus();
        }

    }

    // Knapp til registrering av ny bruker
    @FXML
    void nyBruker(ActionEvent event) {
        try {
            App.setRoot("nybruker");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
