package Dataamatorene.Controllers;

import Dataamatorene.App;
import Dataamatorene.Bestilling.VarekodeRegister;
import Dataamatorene.Datakomponenter.*;
import Dataamatorene.Dialogs;
import Dataamatorene.Exceptions.AlreadyTakenVarekodeException;
import Dataamatorene.LastBilde;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class LagKomponentController {

    public void initialize() {

        // Knytter textField til tilhøresnde registreringsknapp
        TextField[] harddiskfelt = {txtVareHarddisk, txtNavnHarddisk, txtPrisHarddisk, txtLagreHarddisk};
        for(TextField t:harddiskfelt){
            t.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerHarddisk(keyEvent);
                }
            });
        }

        TextField[] hovedkortfelt = {txtVareHovedkort, txtNavnHovedkort, txtPrisHovedkort, txtPorterHovedkort};
        for (TextField t:hovedkortfelt) {
            t.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerHovedkort(keyEvent);
                }
            });
        }

        TextField[] lydkortfelt = {txtVareLydkort, txtNavnLydkort, txtPrisLydkort, txtFrekvensLydkort};
        for (TextField t:lydkortfelt) {
            t.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerLydkort(keyEvent);
                }
            });
        }

        TextField[] skjermkortfelt = {txtVareSkjermkort, txtNavnSkjermkort, txtPrisSkjermkort, txtOpplosningSkjermkort};
        for (TextField t:skjermkortfelt) {
            t.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerSkjermkort(keyEvent);
                }
            });
        }

        TextField[] prosessorfelt = {txtVareProsessor, txtNavnProsessor, txtPrisProsessor, txtKjernerProsessor,
                txtFrekvensProsessor, txtTraderProsessor};
        for (TextField t:prosessorfelt) {
            t.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerProsessor(keyEvent);
                }
            });
        }

        TextField[] minnefelt = {txtVareMinne, txtNavnMinne, txtPrisMinne, txtFrekvensMinne};
        for (TextField t:minnefelt) {
            t.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerMinne(keyEvent);
                }
            });
        }

        TextField[] kabinettfelt = {txtVareKabinett, txtNavnKabinett, txtPrisKabinett, txtStorrelseKabinett
                , txtVifterKabientt};
        for (TextField t:kabinettfelt) {
            t.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerKabinett(keyEvent);
                }
            });
        }

        TextField[] skjermfelt = {txtVareSkjerm, txtNavnSkjerm, txtPrisSkjerm, txtStorrelseSkjerm, txtOpplosningSkjerm};
        for (TextField t:skjermfelt) {
            t.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerSkjerm(keyEvent);
                }
            });
        }

        TextField[] tastaturfelt = {txtVareTastatur, txtNavnTastatur, txtPrisTastatur, txtSprakTastatur};
        for (TextField t:tastaturfelt) {
            t.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerTastatur(keyEvent);
                }
            });
        }

        TextField[] musfelt = {txtVareMus, txtNavnMus, txtPrisMus, txtKnapperMus};
        for (TextField t:musfelt) {
            t.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerMus(keyEvent);
                }
            });
        }

        // Initialiserer varekode til textfield
        finnVarekoder();
    }


    // FXML deklarering
    @FXML
    private TextField txtVareHarddisk;

    @FXML
    private TextField txtNavnHarddisk;

    @FXML
    private TextField txtPrisHarddisk;

    @FXML
    private TextField txtLagreHarddisk;

    @FXML
    private TextField txtVareHovedkort;

    @FXML
    private TextField txtNavnHovedkort;

    @FXML
    private TextField txtPrisHovedkort;

    @FXML
    private TextField txtPorterHovedkort;

    @FXML
    private TextField txtVareLydkort;

    @FXML
    private TextField txtNavnLydkort;

    @FXML
    private TextField txtPrisLydkort;

    @FXML
    private TextField txtFrekvensLydkort;

    @FXML
    private ToggleButton tbIntegrertLydkort;

    @FXML
    private TextField txtVareSkjermkort;

    @FXML
    private TextField txtNavnSkjermkort;

    @FXML
    private TextField txtPrisSkjermkort;

    @FXML
    private TextField txtOpplosningSkjermkort;

    @FXML
    private TextField txtVareProsessor;

    @FXML
    private TextField txtNavnProsessor;

    @FXML
    private TextField txtPrisProsessor;

    @FXML
    private TextField txtKjernerProsessor;

    @FXML
    private TextField txtFrekvensProsessor;

    @FXML
    private TextField txtTraderProsessor;

    @FXML
    private TextField txtVareMinne;

    @FXML
    private TextField txtNavnMinne;

    @FXML
    private TextField txtPrisMinne;

    @FXML
    private TextField txtRamMinne;

    @FXML
    private TextField txtFrekvensMinne;

    @FXML
    private TextField txtVareKabinett;

    @FXML
    private TextField txtNavnKabinett;

    @FXML
    private TextField txtPrisKabinett;

    @FXML
    private TextField txtStorrelseKabinett;

    @FXML
    private TextField txtVifterKabientt;

    @FXML
    private TextField txtVareSkjerm;

    @FXML
    private TextField txtNavnSkjerm;

    @FXML
    private TextField txtPrisSkjerm;

    @FXML
    private TextField txtStorrelseSkjerm;

    @FXML
    private TextField txtOpplosningSkjerm;

    @FXML
    private TextField txtVareTastatur;

    @FXML
    private TextField txtNavnTastatur;

    @FXML
    private TextField txtPrisTastatur;

    @FXML
    private TextField txtSprakTastatur;

    @FXML
    private ToggleButton tbMekaniskTastatur;

    @FXML
    private ToggleButton txtRGBTastatur;

    @FXML
    private TextField txtVareMus;

    @FXML
    private TextField txtNavnMus;

    @FXML
    private TextField txtPrisMus;

    @FXML
    private TextField txtKnapperMus;

    @FXML
    private ToggleButton tbTradlosMus;


    @FXML
    private ImageView ivHarddisk;

    // Laste opp bilde til harddisk
    @FXML
    void lastOppHarddisk(Event event) {
        try {
            Image bilde = LastBilde.lasteBilde();
            ivHarddisk.setImage(bilde);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Registrering av harddisk
    @FXML
    void registrerHarddisk(Event event) {

        try {
            String navn = KomponentValidering.navnValidering(txtNavnHarddisk.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareHarddisk.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisHarddisk.getText());
            int lagre = KomponentValidering.lagringValidering(txtLagreHarddisk.getText());
            Image bilde = ivHarddisk.getImage();
            Harddisk h = new Harddisk(navn, pris, varekode, bilde, lagre);
            KomponentRegister.addHarddisk(h);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreHarddisk();
            txtNavnHarddisk.setText("");
            txtLagreHarddisk.setText("");
            txtPrisHarddisk.setText("");
            ivHarddisk.setImage(null);
            Dialogs.showSuccessDialog("Harddisken ble lagret");
            finnVarekoder();
        } catch (IOException e) {
            Dialogs.showErrorDialog("Dette skjedde en feil under lagring");
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareHarddisk.requestFocus();
        }

    }

    // Registrering av hovedkort
    @FXML
    void registrerHovedkort(Event event) {

        try {
            String navn = KomponentValidering.navnValidering(txtNavnHovedkort.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareHovedkort.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisHovedkort.getText());
            int porter = KomponentValidering.porterValidering(txtPorterHovedkort.getText());
            Hovedkort h = new Hovedkort(navn, pris, varekode, null, porter);
            KomponentRegister.addHovedkort(h);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreHovedkort();
            txtNavnHovedkort.setText("");
            txtPorterHovedkort.setText("");
            txtPrisHovedkort.setText("");
            Dialogs.showSuccessDialog("Hovedkortet er lagret");
            finnVarekoder();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareHovedkort.requestFocus();
        }

    }

    // Refistrering av kabientt
    @FXML
    void registrerKabinett(Event event) {

        try{
            String navn = KomponentValidering.navnValidering(txtNavnKabinett.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareKabinett.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisKabinett.getText());
            String størrelse = KomponentValidering.størrelseValidering(txtStorrelseKabinett.getText());
            int vifter = KomponentValidering.vifterValidering(txtVifterKabientt.getText());

            Kabinett k = new Kabinett(navn, pris, varekode, null, størrelse, vifter);
            KomponentRegister.addKabinett(k);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreKabinett();
            txtNavnKabinett.setText("");
            txtPrisKabinett.setText("");
            txtStorrelseKabinett.setText("");
            txtVifterKabientt.setText("");
            Dialogs.showSuccessDialog("Kabinettet ble lagret");
            finnVarekoder();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareKabinett.requestFocus();
        }
    }

    // Registrering av lydkort
    @FXML
    void registrerLydkort(Event event) {

        try{
            String navn = KomponentValidering.navnValidering(txtNavnLydkort.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareLydkort.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisLydkort.getText());
            boolean integrert = tbIntegrertLydkort.isSelected();
            double frekvens = KomponentValidering.frekvensValideringKHz(txtFrekvensLydkort.getText());

            Lydkort l = new Lydkort(navn, pris, varekode, null, integrert, frekvens);
            KomponentRegister.addLydkort(l);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreLydkort();
            txtNavnLydkort.setText("");
            txtPrisLydkort.setText("");
            txtFrekvensLydkort.setText("");
            tbIntegrertLydkort.setSelected(false);
            Dialogs.showSuccessDialog("Lydkortet er lagret");
            finnVarekoder();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareLydkort.requestFocus();
        }

    }

    // Registering av minne
    @FXML
    void registrerMinne(Event event) {

        try{
            String navn = KomponentValidering.navnValidering(txtNavnMinne.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareMinne.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisMinne.getText());
            int ram = KomponentValidering.ramValidering(txtRamMinne.getText());
            double frekvens = KomponentValidering.frekvensValideringGHz(txtFrekvensMinne.getText());

            Minne m = new Minne(navn, pris, varekode, null, ram, frekvens);
            KomponentRegister.addMinne(m);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreMinne();
            txtNavnMinne.setText("");
            txtPrisMinne.setText("");
            txtRamMinne.setText("");
            txtFrekvensMinne.setText("");
            Dialogs.showSuccessDialog("Minnet er lagret");
            finnVarekoder();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareMinne.requestFocus();
        }
    }

    // Registrering av mus
    @FXML
    void registrerMus(Event event) {

        try{
            String navn = KomponentValidering.navnValidering(txtNavnMus.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareMus.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisMus.getText());
            boolean tråd = tbTradlosMus.isSelected();
            int knapper = KomponentValidering.knapperValidering(txtKnapperMus.getText());

            Mus m = new Mus(navn, pris, varekode, null, tråd, knapper);
            KomponentRegister.addMus(m);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreMus();
            txtNavnMus.setText("");
            txtPrisMus.setText("");
            tbTradlosMus.setSelected(false);
            txtKnapperMus.setText("");
            Dialogs.showSuccessDialog("Musen er lagret");
            finnVarekoder();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareMus.requestFocus();
        }
    }

    // Registrering av prosessor
    @FXML
    void registrerProsessor(Event event) {

        try{
            String navn = KomponentValidering.navnValidering(txtNavnProsessor.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareProsessor.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisProsessor.getText());
            int kjerner = KomponentValidering.kjernerValidering(txtKjernerProsessor.getText());
            double frekvens = KomponentValidering.frekvensValideringGHz(txtFrekvensProsessor.getText());
            int trader = KomponentValidering.traderValidering(txtTraderProsessor.getText());

            Prosessor p = new Prosessor(navn, pris, varekode, null, kjerner, frekvens, trader);
            KomponentRegister.addProsessor(p);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreProsessor();
            txtNavnProsessor.setText("");
            txtPrisProsessor.setText("");
            txtKjernerProsessor.setText("");
            txtFrekvensProsessor.setText("");
            txtTraderProsessor.setText("");
            Dialogs.showSuccessDialog("Prosessoren er lagret");
            finnVarekoder();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareProsessor.requestFocus();
        }
    }

    // Registrering av skjerm
    @FXML
    void registrerSkjerm(Event event) {

        try {
            String navn = KomponentValidering.navnValidering(txtNavnSkjerm.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareSkjerm.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisSkjerm.getText());
            String oppløsning = KomponentValidering.opplosningValidering(txtOpplosningSkjerm.getText());
            double størrelse = KomponentValidering.skjermstorrelseValidering(txtStorrelseSkjerm.getText());

            Skjerm s = new Skjerm(navn, pris, varekode, null, oppløsning, størrelse);
            KomponentRegister.addSkjerm(s);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreSkjerm();
            txtNavnSkjerm.setText("");
            txtOpplosningSkjerm.setText("");
            txtPrisSkjerm.setText("");
            txtStorrelseSkjerm.setText("");
            Dialogs.showSuccessDialog("Skjermen ble lagret");
            finnVarekoder();
        } catch (IOException e) {
            Dialogs.showErrorDialog("Dette skjedde en feil under lagring");
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareSkjerm.requestFocus();
        }

    }

    // Registrering av skjermkort
    @FXML
    void registrerSkjermkort(Event event) {

        try{
            String navn = KomponentValidering.navnValidering(txtNavnSkjermkort.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareSkjermkort.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisSkjermkort.getText());
            String oppløsning = KomponentValidering.opplosningValidering(txtOpplosningSkjermkort.getText());

            Skjermkort s = new Skjermkort(navn, pris, varekode, null, oppløsning);
            KomponentRegister.addSkjermkort(s);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreSkjermkort();

            txtNavnSkjermkort.setText("");
            txtPrisSkjermkort.setText("");
            txtOpplosningSkjermkort.setText("");
            Dialogs.showSuccessDialog("Skjermkortet ble lagret");
            finnVarekoder();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareSkjermkort.requestFocus();
        }

    }

    // Registrering av tastatur
    @FXML
    void registrerTastatur(Event event) {

        try{
            String navn = KomponentValidering.navnValidering(txtNavnTastatur.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareTastatur.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisTastatur.getText());
            String språk = txtSprakTastatur.getText();
            boolean mekanisk = tbMekaniskTastatur.isSelected();
            boolean rgb = txtRGBTastatur.isSelected();

            Tastatur t = new Tastatur(navn, pris, varekode, null,  språk, mekanisk, rgb);
            KomponentRegister.addTastatur(t);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreTastatur();
            txtNavnTastatur.setText("");
            txtPrisTastatur.setText("");
            txtSprakTastatur.setText("");
            tbMekaniskTastatur.setSelected(false);
            txtRGBTastatur.setSelected(false);
            Dialogs.showSuccessDialog("Tastaturet ble lagret");
            finnVarekoder();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareTastatur.requestFocus();
        }
    }

    // Til meny knapp
    @FXML
    void tilbake(ActionEvent event) {

        try{
            App.setRoot("menyadmin");
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    // Metoder til å finne neste varekode

    private void finnVarekoder() {
        TextField[] textFields = {txtVareHarddisk, txtVareHovedkort, txtVareLydkort, txtVareSkjermkort, txtVareProsessor,
        txtVareMinne, txtVareKabinett, txtVareSkjerm, txtVareTastatur, txtVareMus};
        ArrayList<ArrayList<? extends Datakomponent>> lister = new ArrayList<>(Arrays.asList(
                KomponentRegister.getHarddiskArrayList(), KomponentRegister.getHovedkortArrayList(),
                KomponentRegister.getLydkortArrayList(), KomponentRegister.getSkjermkortArrayList(),
                KomponentRegister.getProsessorArrayList(), KomponentRegister.getMinneArrayList(),
                KomponentRegister.getKabinettArrayList(), KomponentRegister.getSkjermArrayList(),
                KomponentRegister.getTastaturArrayList(), KomponentRegister.getMusArrayList()));
        for (int i = 0; i < textFields.length; i++) {
            int varekode = (i + 1) * 1000 + 1;
            for (int j = 0; j < lister.get(i).size(); j++) {
                if (varekode == Integer.parseInt(lister.get(i).get(j).getVarekode())) {
                    varekode++;
                }
            }
            textFields[i].setText(String.valueOf(varekode));
        }
    }

}
