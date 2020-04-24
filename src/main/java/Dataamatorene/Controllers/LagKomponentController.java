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

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class LagKomponentController {

    public void initialize() {

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

        TextField[] skjermkortfelt = {txtVareSkjermkort, txtNavnSkjermkort, txtPrisSkjermkort, txtOppløsningSkjermkort};
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

        TextField[] kabinettfelt = {txtVareKabinett, txtNavnKabinett, txtPrisKabinett, txtStorrelseKabinett, txtVifterKabientt};
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

        finnVarekodeHarddisk();
        finnVarekodeHovedkort();
        finnVarekodeLydkort();
        finnVarekodeSkjermkort();
        finnVarekodeProsessor();
        finnVarekodeMinne();
        finnVarekodeKabientt();
        finnVarekodeSkjerm();
        finnVarekodeKabientt();
        finnVarekodeTastatur();
        finnVarekodeMus();
    }


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
    private TextField txtOppløsningSkjermkort;

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

    @FXML
    void lastOppHarddisk(Event event) {
        try {
            Image bilde = LastBilde.lasteBilde();
            ivHarddisk.setImage(bilde);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    ArrayList<Method> metoder = new ArrayList<>();

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
            finnVarekodeHarddisk();

        } catch (IOException e) {
            Dialogs.showErrorDialog("Dette skjedde en feil under lagring");
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareHarddisk.requestFocus();
        }

    }

    @FXML
    void registrerHovedkort(Event event) {

        try {
            String navn = KomponentValidering.navnValidering(txtNavnHovedkort.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareHovedkort.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisHovedkort.getText());
            int porter = KomponentValidering.porterValidering(txtPorterHovedkort.getText());
            //Hovedkort h = new Hovedkort(navn, pris, varekode, null, porter);
            //KomponentRegister.addHovedkort(h);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreHovedkort();
            txtNavnHovedkort.setText("");
            txtPorterHovedkort.setText("");
            txtPrisHovedkort.setText("");
            Dialogs.showSuccessDialog("Hovedkortet er lagret");
            if (KomponentRegister.getHovedkortArrayList().size() < 9) {
                txtVareHovedkort.setText("0200" + (KomponentRegister.getHovedkortArrayList().size() + 1));
            } else txtVareHovedkort.setText("020" + (KomponentRegister.getHovedkortArrayList().size() + 1));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareHovedkort.requestFocus();
        }

    }

    @FXML
    void registrerKabinett(Event event) {

        try{
            String navn = KomponentValidering.navnValidering(txtNavnKabinett.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareKabinett.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisKabinett.getText());
            String størrelse = KomponentValidering.størrelseValidering(txtStorrelseKabinett.getText());
            int vifter = KomponentValidering.vifterValidering(txtVifterKabientt.getText());

            //Kabinett k = new Kabinett(navn, pris, varekode, null, størrelse, vifter);
            //KomponentRegister.addKabinett(k);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreKabinett();
            txtNavnKabinett.setText("");
            txtPrisKabinett.setText("");
            txtStorrelseKabinett.setText("");
            txtVifterKabientt.setText("");
            Dialogs.showSuccessDialog("Kabinettet ble lagret");
            if (KomponentRegister.getKabinettArrayList().size() < 9) {
                txtVareKabinett.setText("0700" + (KomponentRegister.getKabinettArrayList().size() + 1));
            } else txtVareKabinett.setText("070" + (KomponentRegister.getKabinettArrayList().size() + 1));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareKabinett.requestFocus();
        }
    }

    @FXML
    void registrerLydkort(Event event) {

        try{
            String navn = KomponentValidering.navnValidering(txtNavnLydkort.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareLydkort.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisLydkort.getText());
            boolean integrert = tbIntegrertLydkort.isSelected();
            double frekvens = KomponentValidering.frekvensValideringKHz(txtFrekvensLydkort.getText());

            //Lydkort l = new Lydkort(navn, pris, varekode, null, integrert, frekvens);
            //KomponentRegister.addLydkort(l);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreLydkort();
            txtNavnLydkort.setText("");
            txtPrisLydkort.setText("");
            txtFrekvensLydkort.setText("");
            tbIntegrertLydkort.setSelected(false);
            Dialogs.showSuccessDialog("Lydkortet er lagret");
            if (KomponentRegister.getLydkortArrayList().size() < 9) {
                txtVareLydkort.setText("0300" + (KomponentRegister.getLydkortArrayList().size() + 1));
            } else txtVareLydkort.setText("030" + (KomponentRegister.getLydkortArrayList().size() + 1));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareLydkort.requestFocus();
        }

    }

    @FXML
    void registrerMinne(Event event) {

        try{
            String navn = KomponentValidering.navnValidering(txtNavnMinne.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareMinne.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisMinne.getText());
            int ram = KomponentValidering.ramValidering(txtRamMinne.getText());
            double frekvens = KomponentValidering.frekvensValideringGHz(txtFrekvensMinne.getText());

            //Minne m = new Minne(navn, pris, varekode, null, ram, frekvens);
            //KomponentRegister.addMinne(m);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreMinne();
            txtNavnMinne.setText("");
            txtPrisMinne.setText("");
            txtRamMinne.setText("");
            txtFrekvensMinne.setText("");
            Dialogs.showSuccessDialog("Minnet er lagret");
            if (KomponentRegister.getMinneArrayList().size() < 9) {
                txtVareMinne.setText("0600" + (KomponentRegister.getMinneArrayList().size() + 1));
            } else txtVareMinne.setText("060" + (KomponentRegister.getMinneArrayList().size() + 1));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareMinne.requestFocus();
        }
    }

    @FXML
    void registrerMus(Event event) {

        try{
            String navn = KomponentValidering.navnValidering(txtNavnMus.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareMus.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisMus.getText());
            boolean tråd = tbTradlosMus.isSelected();
            int knapper = KomponentValidering.knapperValidering(txtKnapperMus.getText());

            //Mus m = new Mus(navn, pris, varekode, null, tråd, knapper);
            //KomponentRegister.addMus(m);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreMus();
            txtNavnMus.setText("");
            txtPrisMus.setText("");
            tbTradlosMus.setSelected(false);
            txtKnapperMus.setText("");
            Dialogs.showSuccessDialog("Musen er lagret");
            if (KomponentRegister.getMusArrayList().size() < 9) {
                txtVareMus.setText("1000" + (KomponentRegister.getMusArrayList().size() + 1));
            } else txtVareMus.setText("100" + (KomponentRegister.getMusArrayList().size() + 1));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareMus.requestFocus();
        }
    }

    @FXML
    void registrerProsessor(Event event) {

        try{
            String navn = KomponentValidering.navnValidering(txtNavnProsessor.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareProsessor.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisProsessor.getText());
            int kjerner = KomponentValidering.kjernerValidering(txtKjernerProsessor.getText());
            double frekvens = KomponentValidering.frekvensValideringGHz(txtFrekvensProsessor.getText());
            int tråder = KomponentValidering.tråderValidering(txtTraderProsessor.getText());

            //Prosessor p = new Prosessor(navn, pris, varekode, null, kjerner, frekvens, tråder);
            //KomponentRegister.addProsessor(p);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreProsessor();
            txtNavnProsessor.setText("");
            txtPrisProsessor.setText("");
            txtKjernerProsessor.setText("");
            txtFrekvensProsessor.setText("");
            txtTraderProsessor.setText("");
            Dialogs.showSuccessDialog("Prosessoren er lagret");
            if (KomponentRegister.getProsessorArrayList().size() < 9) {
                txtVareProsessor.setText("0500" + (KomponentRegister.getProsessorArrayList().size() + 1));
            } else txtVareProsessor.setText("050" + (KomponentRegister.getProsessorArrayList().size() + 1));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareProsessor.requestFocus();
        }
    }

    @FXML
    void registrerSkjerm(Event event) {

        try {
            String navn = KomponentValidering.navnValidering(txtNavnSkjerm.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareSkjerm.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisSkjerm.getText());
            String oppløsning = KomponentValidering.oppløsningValidering(txtOpplosningSkjerm.getText());
            double størrelse = KomponentValidering.skjermstørrelseValidering(txtStorrelseSkjerm.getText());

            //Skjerm s = new Skjerm(navn, pris, varekode, null, oppløsning, størrelse);
            //KomponentRegister.addSkjerm(s);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreSkjerm();
            txtNavnSkjerm.setText("");
            txtOpplosningSkjerm.setText("");
            txtPrisSkjerm.setText("");
            txtStorrelseSkjerm.setText("");
            Dialogs.showSuccessDialog("Skjermen ble lagret");
            if (KomponentRegister.getSkjermArrayList().size() < 9) {
                txtVareSkjerm.setText("0800" + (KomponentRegister.getSkjermArrayList().size() + 1));
            } else txtVareSkjerm.setText("080" + (KomponentRegister.getSkjermArrayList().size() + 1));
        } catch (IOException e) {
            Dialogs.showErrorDialog("Dette skjedde en feil under lagring");
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareSkjerm.requestFocus();
        }

    }

    @FXML
    void registrerSkjermkort(Event event) {

        try{
            String navn = KomponentValidering.navnValidering(txtNavnSkjermkort.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareSkjermkort.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisSkjermkort.getText());
            String oppløsning = KomponentValidering.oppløsningValidering(txtOppløsningSkjermkort.getText());

            //Skjermkort s = new Skjermkort(navn, pris, varekode, null, oppløsning);
            //KomponentRegister.addSkjermkort(s);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreSkjermkort();

            txtNavnSkjermkort.setText("");
            txtPrisSkjermkort.setText("");
            txtOppløsningSkjermkort.setText("");
            Dialogs.showSuccessDialog("Skjermkortet ble lagret");
            finnVarekodeSkjermkort();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareSkjermkort.requestFocus();
        }

    }


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

            //Tastatur t = new Tastatur(navn, pris, varekode, null,  språk, mekanisk, rgb);
            //KomponentRegister.addTastatur(t);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreTastatur();
            txtNavnTastatur.setText("");
            txtPrisTastatur.setText("");
            txtSprakTastatur.setText("");
            tbMekaniskTastatur.setSelected(false);
            txtRGBTastatur.setSelected(false);
            Dialogs.showSuccessDialog("Tastaturet ble lagret");
            if (KomponentRegister.getTastaturArrayList().size() < 9) {
                txtVareTastatur.setText("0900" + (KomponentRegister.getTastaturArrayList().size() + 1));
            } else txtVareTastatur.setText("090" + (KomponentRegister.getTastaturArrayList().size() + 1));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Dialogs.showErrorDialog("Det har skjedd en feil\n" + e.getMessage());
        } catch (AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes allerede");
            txtVareTastatur.requestFocus();
        }
    }

    @FXML
    void tilbake(ActionEvent event) {

        try{
            App.setRoot("menyadmin");
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    private void finnVarekodeHarddisk() {
        int varekodeHarddisk = 1001;
        for (int i = 0; i < KomponentRegister.getHarddiskArrayList().size(); i++) {
            if(varekodeHarddisk == Integer.parseInt(KomponentRegister.getHarddiskArrayList().get(i).getVarekode())) {
                varekodeHarddisk++;
            }
        }
        txtVareHarddisk.setText("0" + varekodeHarddisk);
    }

    private void finnVarekodeHovedkort() {
        int varekodeHovedkort = 2001;
        for (int i = 0; i < KomponentRegister.getHovedkortArrayList().size(); i++) {
            if (varekodeHovedkort == Integer.parseInt(KomponentRegister.getHovedkortArrayList().get(i).getVarekode())) {
                varekodeHovedkort++;
            }
        }
        txtVareHovedkort.setText("0" + varekodeHovedkort);
    }

    private void finnVarekodeLydkort() {
        int varekodeLydkort = 3002;
        for (int i = 0; i < KomponentRegister.getLydkortArrayList().size(); i++) {
            if (varekodeLydkort == Integer.parseInt(KomponentRegister.getLydkortArrayList().get(i).getVarekode())) {
                varekodeLydkort++;
            }
        }
        txtVareLydkort.setText("0" + varekodeLydkort);
    }

    private void finnVarekodeSkjermkort() {
        int varekodeSkjermkort = 4001;
        for (int i = 0; i < KomponentRegister.getSkjermkortArrayList().size(); i++) {
            if (varekodeSkjermkort == Integer.parseInt(KomponentRegister.getSkjermkortArrayList().get(i).getVarekode())) {
                varekodeSkjermkort++;
            }
        }
        txtVareSkjermkort.setText("0" + varekodeSkjermkort);
    }

    private void finnVarekodeProsessor() {
        int varekodeProsessor = 5001;
        for (int i = 0; i < KomponentRegister.getProsessorArrayList().size(); i++) {
            if (varekodeProsessor == Integer.parseInt(KomponentRegister.getProsessorArrayList().get(i).getVarekode())) {
                varekodeProsessor++;
            }
        }
        txtVareProsessor.setText("0" + varekodeProsessor);
    }

    private void finnVarekodeMinne() {
        int varekodeMinne = 6001;
        for (int i = 0; i < KomponentRegister.getMinneArrayList().size(); i++) {
            if (varekodeMinne == Integer.parseInt(KomponentRegister.getMinneArrayList().get(i).getVarekode())) {
                varekodeMinne++;
            }
        }
        txtVareMinne.setText("0" + varekodeMinne);
    }

    private void finnVarekodeKabientt() {
        int varekodeKabinett = 7001;
        for (int i = 0; i < KomponentRegister.getKabinettArrayList().size(); i++) {
            if (varekodeKabinett == Integer.parseInt(KomponentRegister.getKabinettArrayList().get(i).getVarekode())) {
                varekodeKabinett++;
            }
        }
        txtVareKabinett.setText("0" + varekodeKabinett);
    }

    private void finnVarekodeSkjerm() {
        int varekodeSkjerm = 8001;
        for (int i = 0; i < KomponentRegister.getSkjermArrayList().size(); i++) {
            if (varekodeSkjerm == Integer.parseInt(KomponentRegister.getSkjermArrayList().get(i).getVarekode())) {
                varekodeSkjerm++;
            }
        }
        txtVareSkjerm.setText("0" + varekodeSkjerm);
    }

    private void finnVarekodeTastatur() {
        int varekodeTastatur = 9001;
        for (int i = 0; i < KomponentRegister.getTastaturArrayList().size(); i++) {
            if (varekodeTastatur == Integer.parseInt(KomponentRegister.getTastaturArrayList().get(i).getVarekode())) {
                varekodeTastatur++;
            }
        }
        txtVareTastatur.setText("0" + varekodeTastatur);
    }

    private void finnVarekodeMus() {
        int varekodeMus = 10001;
        for (int i = 0; i < KomponentRegister.getMusArrayList().size(); i++) {
            if (varekodeMus == Integer.parseInt(KomponentRegister.getMusArrayList().get(i).getVarekode())) {
                varekodeMus++;
            }
        }
        txtVareMus.setText("0" + varekodeMus);
    }

}
