package Dataamatorene.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
        FileOpener opener = new FileOpenerJobj();
        try {
            BrukerRegister.setBrukere((ArrayList<Bruker>) opener.read("src/main/java/Dataamatorene/Files/Login.jobj"));
        } catch (IOException e) {
            Dialogs.showErrorDialog(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




        System.out.println(BrukerRegister.getBrukere().stream().map(Bruker::getBrukernavn).collect(Collectors.joining(" | ")));

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

    @FXML
    void loggInn(Event event) {

        List<Bruker> liste = BrukerRegister.getBrukere();

        String brukernavn = txtBrukernavn.getText();
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
            //lblTilbakemeling.setText("Brukernavn eller passord er feil");
            Dialogs.showErrorDialog("Brukernavn eller passord er feil");
            txtPassword.setText("");
            txtBrukernavn.requestFocus();
        }

    }

    @FXML
    void nyBruker(ActionEvent event) {
        try {
            App.setRoot("nybruker");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
