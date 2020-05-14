package Dataamatorene.Controllers;

import java.io.IOException;
import java.util.List;

import Dataamatorene.*;
import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Brukere.BrukerValidering;
import Dataamatorene.Exceptions.*;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class NyBrukerController {

    // Kode som kjøres når controlleren startes

    public void initialize() {

        txtPassword.setVisible(false);
        txtPasswordGjenta.setVisible(false);

        TextField[] felt = {txtBrukernavn, pwPassword, pwPasswordGjenta, txtNavn, txtTlfNummer, txtEmail};
        for (int i = 0; i < felt.length; i++) {
            if (i != felt.length-1) {
                int finalI = i;
                felt[i].setOnKeyPressed(keyEvent -> {
                    if (keyEvent.getCode() == KeyCode.ENTER) {
                        felt[finalI +1].requestFocus();
                    }
                });
            }
            else {
                felt[i].setOnKeyPressed(keyEvent -> {
                    if (keyEvent.getCode() == KeyCode.ENTER) {
                        registrer(keyEvent);
                    }
                });
            }
        }

        txtPassword.setOnKeyTyped(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER){
                pwPassword.setText(txtPassword.getText());
            }
        });

        txtPasswordGjenta.setOnKeyTyped(keyEvent -> {
            if(keyEvent.getCode() != KeyCode.ENTER){
                pwPasswordGjenta.setText(txtPasswordGjenta.getText());
            }
        });

        pwPassword.setOnKeyTyped(keyEvent -> {
            if(keyEvent.getCode() != KeyCode.ENTER){
                txtPassword.setText(pwPassword.getText());
            }
        });

        pwPasswordGjenta.setOnKeyTyped(keyEvent -> {
            if(keyEvent.getCode() != KeyCode.ENTER){
                txtPasswordGjenta.setText(pwPasswordGjenta.getText());
            }
        });

        vis.setOnMouseClicked(mouseEvent -> {
            Synlighet(mouseEvent, false);
        });
        visGjenta.setOnMouseClicked(mouseEvent -> {
            Synlighet(mouseEvent, true);
        });
    }

    // FXML deklarasjoner
    @FXML
    private Text vis;

    @FXML
    private Text visGjenta;

    @FXML
    private TextField txtBrukernavn;

    @FXML
    private PasswordField pwPassword;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPasswordGjenta;

    @FXML
    private PasswordField pwPasswordGjenta;

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
        String passordGjenta = txtPasswordGjenta.getText();
        String navn = txtNavn.getText();
        String tlfNummer = txtTlfNummer.getText();
        String email = txtEmail.getText();

        for(Bruker b:liste){
            if (brukernavn.equalsIgnoreCase(b.getBrukernavn())) {
                finnes = true;
                break;
            }
        }

        if(!finnes){
            try{
                BrukerValidering.sjekkPassord(passord);
                BrukerValidering.sjekkPassord(passord, passordGjenta);
                BrukerValidering.sjekkBrukernavn(brukernavn);
                BrukerValidering.sjekkValidNavn(navn);
                BrukerValidering.sjekkValidTelefon(tlfNummer);
                BrukerValidering.sjekkValidEpost(email);
                BrukerRegister.addBruker(new Bruker(brukernavn, passord, navn, tlfNummer, email, Bruker.BrukerType.BRUKER));

                FileSaver saver = new FileSaverJobj();
                try {
                    saver.save(BrukerRegister.getBrukere(), "src/main/resources/Dataamatorene/Files/Login.jobj");
                } catch (IOException e) {
                    Dialogs.showErrorDialog("Det har skjedd en feil ved opprettelse av din bruker");
                }

                Dialogs.showSuccessDialog("Brukeren er nå opprettet");

                try {
                    App.setRoot("FXML/login");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }catch (InvalidPasswordException IPE){

                Dialogs.showErrorDialog(IPE.getMessage());
                txtPassword.setText("");
                pwPassword.setText("");
                pwPassword.requestFocus();

            } catch (InvalidBrukerException | InvalidNameException | InvalidTelefonException | InvalidEpostException IBE){

                Dialogs.showErrorDialog(IBE.getMessage());
                txtBrukernavn.requestFocus();
                txtPassword.setText("");
                pwPassword.setText("");
                txtPasswordGjenta.setText("");
                pwPasswordGjenta.setText("");

            }

        }else {

            Dialogs.showErrorDialog("Ugyldig brukernavn", "Dette brukernavnet finnes fra før");
        }


    }


    void Synlighet(MouseEvent event, boolean gjenta) {
        if(!gjenta) {
            if (pwPassword.isVisible()) {
                txtPassword.setVisible(true);
                pwPassword.setVisible(false);
                txtPassword.requestFocus();
            } else {
                txtPassword.setVisible(false);
                pwPassword.setVisible(true);
                pwPassword.requestFocus();
            }
        }
        else {
            if (pwPasswordGjenta.isVisible()) {
                txtPasswordGjenta.setVisible(true);
                pwPasswordGjenta.setVisible(false);
                txtPasswordGjenta.requestFocus();
            } else {
                txtPasswordGjenta.setVisible(false);
                pwPasswordGjenta.setVisible(true);
                pwPasswordGjenta.requestFocus();
            }
        }

    }

    @FXML
    void tilbake(ActionEvent event) {
        try {
            App.setRoot("FXML/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}