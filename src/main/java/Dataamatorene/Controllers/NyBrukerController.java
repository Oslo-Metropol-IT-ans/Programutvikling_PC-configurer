package Dataamatorene.Controllers;

import java.io.IOException;
import java.util.List;

import Dataamatorene.*;
import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Brukere.BrukerValidering;
import Dataamatorene.Exceptions.InvalidBrukerException;
import Dataamatorene.Exceptions.InvalidPasswordException;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

public class NyBrukerController {

    // Kode som kjøres når controlleren startes

    public void initialize() {

        txtPassword.setVisible(false);

        txtBrukernavn.setOnKeyTyped(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER)
            txtPassword.requestFocus();
        });

        txtPassword.setOnKeyTyped(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER){
                registrer(keyEvent);
            } else {
                pwPassword.setText(txtPassword.getText());
            }

        });

        pwPassword.setOnKeyTyped(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER){
                registrer(keyEvent);
            } else {
                txtPassword.setText(pwPassword.getText());
            }
        });
    }

    // FXML deklarasjoner

    @FXML
    private TextField txtBrukernavn;

    @FXML
    private Label lblTilbakemelding;

    @FXML
    private PasswordField pwPassword;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnTilbake;

    @FXML
    private Button btnRegistrer;

    @FXML
    private TextField txtNavn;

    @FXML
    private TextField txtTlfNummer;

    @FXML
    private TextField txtEmail;

    // Eventlistenere på knappene

    @FXML
    void registrer(Event event) {

        List<Bruker> liste = BrukerRegister.getBrukere();
        boolean finnes = false;

        String brukernavn = txtBrukernavn.getText();
        String passord = txtPassword.getText();
        String navn = txtNavn.getText();
        String tlfNummer = txtTlfNummer.getText();
        String email = txtEmail.getText();

        for(Bruker b:liste){
            if(brukernavn.equalsIgnoreCase(b.getBrukernavn())){
                finnes = true;
            }
        }

        if(!finnes){
            try{
                BrukerValidering.sjekkPassord(passord);
                BrukerValidering.sjekkBrukernavn(brukernavn);
                BrukerValidering.sjekkValidNavn(navn);
                BrukerValidering.sjekkValidTelefon(tlfNummer);
                BrukerValidering.sjekkValidEpost(email);
                BrukerRegister.addBruker(new Bruker(brukernavn, passord, navn, tlfNummer, email, false));

                FileSaver saver = new FileSaverJobj();
                try {
                    saver.save(BrukerRegister.getBrukere(), "src/main/java/Dataamatorene/Files/Login.jobj");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Dialogs.showSuccessDialog("Brukeren er nå opprettet");

                try {
                    App.setRoot("login");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }catch (InvalidPasswordException IPE){

                Dialogs.showErrorDialog(IPE.getMessage());
                txtPassword.setText("");
                txtPassword.requestFocus();

            } catch (InvalidBrukerException IBE){

                Dialogs.showErrorDialog(IBE.getMessage());
                txtBrukernavn.requestFocus();
                txtPassword.setText("");

            }

        }else {

            Dialogs.showErrorDialog("Ugyldig brukernavn", "Dette brukernavnet finnes fra før");
        }


    }

    @FXML
    void Synlighet(MouseEvent event) {
        if (pwPassword.isVisible()) {
            txtPassword.setVisible(true);
            pwPassword.setVisible(false);
        } else {
            txtPassword.setVisible(false);
            pwPassword.setVisible(true);
        }

    }

    @FXML
    void tilbake(ActionEvent event) {
        try {
            App.setRoot("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}