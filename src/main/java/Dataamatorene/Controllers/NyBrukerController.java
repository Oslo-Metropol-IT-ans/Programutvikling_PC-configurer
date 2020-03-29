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

public class NyBrukerController {

    public void initialize() {
        txtBrukernavn.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER)
            txtPassword.requestFocus();
        });

        txtPassword.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER){
                registrer(keyEvent);
            }

        });
    }

    @FXML
    private TextField txtBrukernavn;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblTilbakemelding;

    @FXML
    private Button btnTilbake;

    @FXML
    private Button btnRegistrer;


    @FXML
    void registrer(Event event) {

        List<Bruker> liste = BrukerRegister.getBrukere();
        boolean finnes = false;

        String brukernavn = txtBrukernavn.getText();
        String passord = txtPassword.getText();

        for(Bruker b:liste){
            if(brukernavn.equalsIgnoreCase(b.getBrukernavn())){
                finnes = true;
            }
        }

        if(!finnes){
            try{
                BrukerValidering.sjekkPassord(passord);
                BrukerValidering.sjekkBrukernavn(brukernavn);
                BrukerRegister.addBruker(new Bruker(brukernavn, passord, false));

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
    void TEST(ActionEvent event) {

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