package Dataamatorene.Controllers;

import Dataamatorene.App;
import Dataamatorene.Bestilling.VarekodeRegister;
import Dataamatorene.Datakomponenter.*;
import Dataamatorene.Dialogs;
import Dataamatorene.Exceptions.AlreadyTakenVarekodeException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

import java.io.IOException;

public class LagKomponentController {

    public void initialize() {

        TextField[] harddiskfelt = {txtVareHarddisk, txtNavnHarddisk, txtPrisHarddisk, txtLagreHarddisk};
        for(TextField t:harddiskfelt){
            t.setOnKeyTyped(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerHarddisk(keyEvent);
                }
            });
        }

        TextField[] hovedkortfelt = {txtVareHovedkort, txtNavnHovedkort, txtPrisHovedkort, txtPorterHovedkort};
        for (TextField t:hovedkortfelt) {
            t.setOnKeyTyped(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerHovedkort(keyEvent);
                }
            });
        }

        TextField[] lydkortfelt = {txtVareLydkort, txtNavnLydkort, txtPrisLydkort, txtFrekvensLydkort};
        for (TextField t:lydkortfelt) {
            t.setOnKeyTyped(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerLydkort(keyEvent);
                }
            });
        }

        TextField[] skjermkortfelt = {txtVareSkjermkort, txtNavnSkjermkort, txtPrisSkjermkort, txtOppløsningSkjermkort};
        for (TextField t:skjermkortfelt) {
            t.setOnKeyTyped(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerSkjermkort(keyEvent);
                }
            });
        }

        TextField[] prosessorfelt = {txtVareProsessor, txtNavnProsessor, txtPrisProsessor, txtKjernerProsessor,
                txtFrekvensProsessor, txtTråderProsessor};
        for (TextField t:prosessorfelt) {
            t.setOnKeyTyped(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerProsessor(keyEvent);
                }
            });
        }

        TextField[] minnefelt = {txtVareMinne, txtNavnMinne, txtPrisMinne, txtFrekvensMinne};
        for (TextField t:minnefelt) {
            t.setOnKeyTyped(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerMinne(keyEvent);
                }
            });
        }

        TextField[] kabinettfelt = {txtVareKabinett, txtNavnKabinett, txtPrisKabinett, txtStørelseKabinett, txtVifterKabientt};
        for (TextField t:kabinettfelt) {
            t.setOnKeyTyped(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerKabinett(keyEvent);
                }
            });
        }

        TextField[] skjermfelt = {txtVareSkjerm, txtNavnSkjerm, txtPrisSkjerm, txtStørrelseSkjerm, txtOppløsningSkjerm};
        for (TextField t:skjermfelt) {
            t.setOnKeyTyped(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerSkjerm(keyEvent);
                }
            });
        }

        TextField[] tastaturfelt = {txtVareTastatur, txtNavnTastatur, txtPrisTastatur, txtSpråkTastatur};
        for (TextField t:tastaturfelt) {
            t.setOnKeyTyped(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerTastatur(keyEvent);
                }
            });
        }

        TextField[] musfelt = {txtVareMus, txtNavnMus, txtPrisMus, txtKnapperMus};
        for (TextField t:musfelt) {
            t.setOnKeyTyped(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    registrerMus(keyEvent);
                }
            });
        }

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
    private TextField txtTråderProsessor;

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
    private TextField txtStørelseKabinett;

    @FXML
    private TextField txtVifterKabientt;

    @FXML
    private TextField txtVareSkjerm;

    @FXML
    private TextField txtNavnSkjerm;

    @FXML
    private TextField txtPrisSkjerm;

    @FXML
    private TextField txtStørrelseSkjerm;

    @FXML
    private TextField txtOppløsningSkjerm;

    @FXML
    private TextField txtVareTastatur;

    @FXML
    private TextField txtNavnTastatur;

    @FXML
    private TextField txtPrisTastatur;

    @FXML
    private TextField txtSpråkTastatur;

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
    private ToggleButton tbTrådløsMus;

    @FXML
    void registrerHarddisk(Event event) {

        try {
            String navn = KomponentValidering.navnValidering(txtNavnHarddisk.getText());
            int varekode = KomponentValidering.varekodeValidering(txtVareHarddisk.getText());
            VarekodeRegister.checkVarekode(varekode);
            double pris = KomponentValidering.prisValidering(txtPrisHarddisk.getText());
            int lagre = KomponentValidering.lagringValidering(txtLagreHarddisk.getText());
            Harddisk h = new Harddisk(navn, pris, varekode, lagre);
            KomponentRegister.addHarddisk(h);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreHarddisk();
            txtNavnHarddisk.setText("");
            txtLagreHarddisk.setText("");
            txtPrisHarddisk.setText("");
            txtVareHarddisk.setText("");
            Dialogs.showSuccessDialog("Harddisken ble lagret");
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
            Hovedkort h = new Hovedkort(navn, pris, varekode, porter);
            KomponentRegister.addHovedkort(h);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreHovedkort();
            txtNavnHovedkort.setText("");
            txtPorterHovedkort.setText("");
            txtVareHovedkort.setText("");
            txtPrisHovedkort.setText("");
            Dialogs.showSuccessDialog("Hovedkortet er lagret");
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
            String størrelse = KomponentValidering.størrelseValidering(txtStørelseKabinett.getText());
            int vifter = KomponentValidering.vifterValidering(txtVifterKabientt.getText());
            Kabinett k = new Kabinett(navn, pris, varekode, størrelse, vifter);
            KomponentRegister.addKabinett(k);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreKabinett();
            txtNavnKabinett.setText("");
            txtPrisKabinett.setText("");
            txtStørelseKabinett.setText("");
            txtVareKabinett.setText("");
            txtVifterKabientt.setText("");
            Dialogs.showSuccessDialog("Kabinettet ble lagret");

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

            Lydkort l = new Lydkort(navn, pris, varekode, integrert, frekvens);
            KomponentRegister.addLydkort(l);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreLydkort();
            txtNavnLydkort.setText("");
            txtVareLydkort.setText("");
            txtPrisLydkort.setText("");
            txtFrekvensLydkort.setText("");
            tbIntegrertLydkort.setSelected(false);
            Dialogs.showSuccessDialog("Lydkortet er lagret");
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

            Minne m = new Minne(navn, pris, varekode, ram, frekvens);
            KomponentRegister.addMinne(m);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreMinne();
            txtNavnMinne.setText("");
            txtPrisMinne.setText("");
            txtVareMinne.setText("");
            txtRamMinne.setText("");
            txtFrekvensMinne.setText("");
            Dialogs.showSuccessDialog("Minnet er lagret");
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
            boolean tråd = tbTrådløsMus.isSelected();
            int knapper = KomponentValidering.knapperValidering(txtKnapperMus.getText());

            Mus m = new Mus(navn, pris, varekode, tråd, knapper);
            KomponentRegister.addMus(m);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreMus();
            txtNavnMus.setText("");
            txtPrisMus.setText("");
            txtVareMus.setText("");
            tbTrådløsMus.setSelected(false);
            txtKnapperMus.setText("");
            Dialogs.showSuccessDialog("Musen er lagret");
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
            int tråder = KomponentValidering.tråderValidering(txtTråderProsessor.getText());

            Prosessor p = new Prosessor(navn, pris, varekode, kjerner, frekvens, tråder);
            KomponentRegister.addProsessor(p);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreProsessor();
            txtNavnProsessor.setText("");
            txtPrisProsessor.setText("");
            txtVareProsessor.setText("");
            txtKjernerProsessor.setText("");
            txtFrekvensProsessor.setText("");
            txtTråderProsessor.setText("");
            Dialogs.showSuccessDialog("Prosessoren er lagret");
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
            String oppløsning = KomponentValidering.oppløsningValidering(txtOppløsningSkjerm.getText());
            double størrelse = KomponentValidering.skjermstørrelseValidering(txtStørrelseSkjerm.getText());

            Skjerm s = new Skjerm(navn, pris, varekode, oppløsning, størrelse);
            KomponentRegister.addSkjerm(s);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreSkjerm();
            txtNavnSkjerm.setText("");
            txtOppløsningSkjerm.setText("");
            txtPrisSkjerm.setText("");
            txtVareSkjerm.setText("");
            txtStørrelseSkjerm.setText("");
            Dialogs.showSuccessDialog("Skjermen ble lagret");
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

            Skjermkort s = new Skjermkort(navn, pris, varekode, oppløsning);
            KomponentRegister.addSkjermkort(s);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreSkjermkort();

            txtNavnSkjermkort.setText("");
            txtVareSkjermkort.setText("");
            txtPrisSkjermkort.setText("");
            txtOppløsningSkjermkort.setText("");
            Dialogs.showSuccessDialog("Skjermkortet ble lagret");

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
            String språk = txtSpråkTastatur.getText();
            boolean mekanisk = tbMekaniskTastatur.isSelected();
            boolean rgb = txtRGBTastatur.isSelected();

            Tastatur t = new Tastatur(navn, pris, varekode, språk, mekanisk, rgb);
            KomponentRegister.addTastatur(t);
            VarekodeRegister.addVarekode(String.valueOf(varekode));
            LagreKomponent.lagreTastatur();
            txtNavnTastatur.setText("");
            txtPrisTastatur.setText("");
            txtVareTastatur.setText("");
            txtSpråkTastatur.setText("");
            tbMekaniskTastatur.setSelected(false);
            txtRGBTastatur.setSelected(false);
            Dialogs.showSuccessDialog("Tastaturet ble lagret");
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

}
