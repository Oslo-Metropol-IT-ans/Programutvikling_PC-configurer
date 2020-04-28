package Dataamatorene.Controllers;

import Dataamatorene.App;
import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Dialogs;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerJobj;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Youtube {

    public void initialize() {

        BrukerRegister.setAktivBruker(null);

        FileOpener opener = new FileOpenerJobj();
        try {
            BrukerRegister.setBrukere((ArrayList<Bruker>) opener.read("src/main/java/Dataamatorene/Files/Login.jobj"));
        } catch (IOException e) {
            Dialogs.showErrorDialog(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        txtUsername.setOnKeyPressed(keyEvent -> {
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

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    void loggInn(Event event) {
        List<Bruker> liste = BrukerRegister.getBrukere();

        String brukernavn = txtUsername.getText();
        String passord = txtPassword.getText();

        boolean finnes = false;

        for(Bruker b:liste){
            if (brukernavn.equalsIgnoreCase(b.getBrukernavn()) && passord.equals(b.getPassord())){
                finnes = true;
                BrukerRegister.setAktivBruker(b);
                if (b.isSuperbruker()){
                    try {
                        App.setRoot("menyadmin");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    try {

                        App.setRoot("menybruker");
                    } catch (IOException e) {
                        Dialogs.showErrorDialog("Denne siden finnes ikke");
                    }
                }
            }
        }

        if(!finnes){
            Dialogs.showErrorDialog("Brukernavn eller passord er feil");
            txtPassword.setText("");
            txtPassword.requestFocus();
        }
    }

}
