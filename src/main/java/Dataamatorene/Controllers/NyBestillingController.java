package Dataamatorene.Controllers;

import Dataamatorene.App;
import Dataamatorene.Bestilling.Bestilling;
import Dataamatorene.Bestilling.BestillingsRegister;
import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Datakomponenter.*;
import Dataamatorene.Dialogs;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;

public class NyBestillingController {

    ObservableList<Harddisk> oHarddisk = FXCollections.observableArrayList(KomponentRegister.getHarddiskArrayList());
    ObservableList<Hovedkort> oHovedkort = FXCollections.observableArrayList(KomponentRegister.getHovedkortArrayList());
    ObservableList<Kabinett> oKabinett = FXCollections.observableArrayList(KomponentRegister.getKabinettArrayList());
    ObservableList<Lydkort> oLydkort = FXCollections.observableArrayList(KomponentRegister.getLydkortArrayList());
    ObservableList<Minne> oMinne = FXCollections.observableArrayList(KomponentRegister.getMinneArrayList());
    ObservableList<Mus> oMus = FXCollections.observableArrayList(KomponentRegister.getMusArrayList());
    ObservableList<Prosessor> oProsessor = FXCollections.observableArrayList(KomponentRegister.getProsessorArrayList());
    ObservableList<Skjerm> oSkjerm = FXCollections.observableArrayList(KomponentRegister.getSkjermArrayList());
    ObservableList<Skjermkort> oSkjermkort = FXCollections.observableArrayList(KomponentRegister.getSkjermkortArrayList());
    ObservableList<Tastatur> oTastatur = FXCollections.observableArrayList(KomponentRegister.getTastaturArrayList());

    double totPris; double harddiskPris = 0; double hovedkortPris = 0; double lydkortPris; double skjermkortPris = 0;
    double prosessorPris = 0; double minnePris = 0; double kabinettPris = 0; double skjermPris = 0;
    double tastarurPris = 0; double musPris = 0;

    public void initialize() {

        oHarddisk.setAll(KomponentRegister.getHarddiskArrayList());
        oHovedkort.setAll(KomponentRegister.getHovedkortArrayList());
        oKabinett.setAll(KomponentRegister.getKabinettArrayList());
        oLydkort.setAll(KomponentRegister.getLydkortArrayList());
        oMinne.setAll(KomponentRegister.getMinneArrayList());
        oMus.setAll(KomponentRegister.getMusArrayList());
        oProsessor.setAll(KomponentRegister.getProsessorArrayList());
        oSkjerm.setAll(KomponentRegister.getSkjermArrayList());
        oSkjermkort.setAll(KomponentRegister.getSkjermkortArrayList());
        oTastatur.setAll(KomponentRegister.getTastaturArrayList());

        ObservableList<String> oHarddiskNavn = FXCollections.observableArrayList();
        for(Harddisk h:oHarddisk) {
            oHarddiskNavn.add(h.getNavn());
        }

        cbHarddisk.setItems(oHarddiskNavn);

        cbHarddisk.setOnHiding(event -> {

            try {
                lblUtHarddisk.setText(String.valueOf(oHarddisk.get(cbHarddisk.getSelectionModel().getSelectedIndex())));

                harddiskPris = (oHarddisk.get(cbHarddisk.getSelectionModel().getSelectedIndex())).getPris();
                totPris = harddiskPris + hovedkortPris + skjermkortPris + lydkortPris + prosessorPris + minnePris + skjermPris
                        + tastarurPris + kabinettPris + musPris;
                lblTotPris.setText("Totalpris: " + totPris + "kr");
            } catch (Exception e) {

            }

        });

        ObservableList<String> oHovedkortNavn = FXCollections.observableArrayList();
        for(Hovedkort h:oHovedkort) {
            oHovedkortNavn.add(h.getNavn());
        }

        cbHovedkort.setItems(oHovedkortNavn);

        cbHovedkort.setOnHiding(event -> {

            try {
                lblUtHovedkort.setText(String.valueOf(oHovedkort.get(cbHovedkort.getSelectionModel().getSelectedIndex())));

                hovedkortPris = (oHovedkort.get(cbHovedkort.getSelectionModel().getSelectedIndex())).getPris();
                totPris = harddiskPris + hovedkortPris + skjermkortPris + lydkortPris + prosessorPris + minnePris + skjermPris
                        + tastarurPris + kabinettPris + musPris;
                lblTotPris.setText("Totalpris: " + totPris + "kr");
            } catch (Exception e) {

            }

        });

        ObservableList<String> oLydkortNavn = FXCollections.observableArrayList();
        for(Lydkort l:oLydkort) {
            oLydkortNavn.add(l.getNavn());
        }

        cbLydkort.setItems(oLydkortNavn);

        cbLydkort.setOnHiding(event -> {

            try {
                lblUtLydkort.setText(String.valueOf(oLydkort.get(cbLydkort.getSelectionModel().getSelectedIndex())));

                lydkortPris = (oLydkort.get(cbLydkort.getSelectionModel().getSelectedIndex())).getPris();
                totPris = harddiskPris + hovedkortPris + skjermkortPris + lydkortPris + prosessorPris + minnePris + skjermPris
                        + tastarurPris + kabinettPris + musPris;
                lblTotPris.setText("Totalpris: " + totPris + "kr");
            } catch (Exception e) {

            }


        });

        ObservableList<String> oSkjermkortNavn = FXCollections.observableArrayList();
        for(Skjermkort s:oSkjermkort) {
            oSkjermkortNavn.add(s.getNavn());
        }

        cbSkjermkort.setItems(oSkjermkortNavn);

        cbSkjermkort.setOnHiding(event -> {

            try {
                lblUtSkjermkort.setText(String.valueOf(oSkjermkort.get(cbSkjermkort.getSelectionModel().getSelectedIndex())));

                skjermkortPris = (oSkjermkort.get(cbSkjermkort.getSelectionModel().getSelectedIndex())).getPris();
                totPris = harddiskPris + hovedkortPris + skjermkortPris + lydkortPris + prosessorPris + minnePris + skjermPris
                        + tastarurPris + kabinettPris + musPris;
                lblTotPris.setText("Totalpris: " + totPris + "kr");
            } catch (Exception e) {

            }


        });

        ObservableList<String> oProsessorNavn = FXCollections.observableArrayList();
        for(Prosessor p:oProsessor) {
            oProsessorNavn.add(p.getNavn());
        }

        cbProsessor.setItems(oProsessorNavn);

        cbProsessor.setOnHiding(event -> {

            try {
                lblUtProsessor.setText(String.valueOf(oProsessor.get(cbProsessor.getSelectionModel().getSelectedIndex())));

                prosessorPris = (oProsessor.get(cbProsessor.getSelectionModel().getSelectedIndex())).getPris();
                totPris = harddiskPris + hovedkortPris + skjermkortPris + lydkortPris + prosessorPris + minnePris + skjermPris
                        + tastarurPris + kabinettPris + musPris;
                lblTotPris.setText("Totalpris: " + totPris + "kr");
            } catch (Exception e) {

            }


        });

        ObservableList<String> oMinneNavn = FXCollections.observableArrayList();
        for(Minne m:oMinne) {
            oMinneNavn.add(m.getNavn());
        }

        cbMinne.setItems(oMinneNavn);

        cbMinne.setOnHiding(event -> {

            try {
                lblUtMinne.setText(String.valueOf(oMinne.get(cbMinne.getSelectionModel().getSelectedIndex())));

                minnePris = (oMinne.get(cbMinne.getSelectionModel().getSelectedIndex())).getPris();
                totPris = harddiskPris + hovedkortPris + skjermkortPris + lydkortPris + prosessorPris + minnePris + skjermPris
                        + tastarurPris + kabinettPris + musPris;
                lblTotPris.setText("Totalpris: " + totPris + "kr");
            } catch (Exception e) {

            }


        });

        ObservableList<String> oKabienttNavn = FXCollections.observableArrayList();
        for(Kabinett k:oKabinett) {
            oKabienttNavn.add(k.getNavn());
        }

        cbKabinett.setItems(oKabienttNavn);

        cbKabinett.setOnHiding(event -> {

            try {
                lblUtKabinett.setText(String.valueOf(oKabinett.get(cbKabinett.getSelectionModel().getSelectedIndex())));

                kabinettPris = (oKabinett.get(cbKabinett.getSelectionModel().getSelectedIndex())).getPris();
                totPris = harddiskPris + hovedkortPris + skjermkortPris + lydkortPris + prosessorPris + minnePris + skjermPris
                        + tastarurPris + kabinettPris + musPris;
                lblTotPris.setText("Totalpris: " + totPris + "kr");
            } catch (Exception e) {

            }

        });

        ObservableList<String> oSkjermNavn = FXCollections.observableArrayList();
        for(Skjerm s:oSkjerm) {
            oSkjermNavn.add(s.getNavn());
        }

        cbSkjerm.setItems(oSkjermNavn);

        cbSkjerm.setOnHiding(event -> {

            try {
                lblUtSkjerm.setText(String.valueOf(oSkjerm.get(cbSkjerm.getSelectionModel().getSelectedIndex())));

                skjermPris = (oSkjerm.get(cbSkjerm.getSelectionModel().getSelectedIndex())).getPris();
                totPris = harddiskPris + hovedkortPris + skjermkortPris + lydkortPris + prosessorPris + minnePris + skjermPris
                        + tastarurPris + kabinettPris + musPris;
                lblTotPris.setText("Totalpris: " + totPris + "kr");
            } catch (Exception e) {

            }

        });

        ObservableList<String> oTastaturNavn = FXCollections.observableArrayList();
        for(Tastatur t:oTastatur) {
            oTastaturNavn.add(t.getNavn());
        }

        cbTastatur.setItems(oTastaturNavn);

        cbTastatur.setOnHiding(event -> {

            try {
                lblUtTastatur.setText(String.valueOf(oTastatur.get(cbTastatur.getSelectionModel().getSelectedIndex())));

                tastarurPris = (oTastatur.get(cbTastatur.getSelectionModel().getSelectedIndex())).getPris();
                totPris = harddiskPris + hovedkortPris + skjermkortPris + lydkortPris + prosessorPris + minnePris + skjermPris
                        + tastarurPris + kabinettPris + musPris;
                lblTotPris.setText("Totalpris: " + totPris + "kr");
            } catch (Exception e) {

            }

        });

        ObservableList<String> oMusNavn = FXCollections.observableArrayList();
        for(Mus m:oMus) {
            oMusNavn.add(m.getNavn());
        }

        cbMus.setItems(oMusNavn);

        cbMus.setOnHiding(event -> {

            try {
                lblUtMus.setText(String.valueOf(oMus.get(cbMus.getSelectionModel().getSelectedIndex())));

                musPris = (oMus.get(cbMus .getSelectionModel().getSelectedIndex())).getPris();
                totPris = harddiskPris + hovedkortPris + skjermkortPris + lydkortPris + prosessorPris + minnePris + skjermPris
                        + tastarurPris + kabinettPris + musPris;
                lblTotPris.setText("Totalpris: " + totPris + "kr");
            } catch (Exception e) {

            }

        });

    }

    @FXML
    private ChoiceBox<String> cbHarddisk;

    @FXML
    private Label lblUtHarddisk;

    @FXML
    private ChoiceBox<String> cbHovedkort;

    @FXML
    private Label lblUtHovedkort;

    @FXML
    private ChoiceBox<String> cbLydkort;

    @FXML
    private Label lblUtLydkort;

    @FXML
    private ChoiceBox<String> cbSkjermkort;

    @FXML
    private Label lblUtSkjermkort;

    @FXML
    private ChoiceBox<String> cbProsessor;

    @FXML
    private Label lblUtProsessor;

    @FXML
    private ChoiceBox<String> cbMinne;

    @FXML
    private Label lblUtMinne;

    @FXML
    private ChoiceBox<String> cbKabinett;

    @FXML
    private Label lblUtKabinett;

    @FXML
    private ChoiceBox<String> cbSkjerm;

    @FXML
    private Label lblUtSkjerm;

    @FXML
    private ChoiceBox<String> cbTastatur;

    @FXML
    private Label lblUtTastatur;

    @FXML
    private ChoiceBox<String> cbMus;

    @FXML
    private Label lblUtMus;

    @FXML
    private Label lblTotPris;

    @FXML
    void bestill(ActionEvent event) {
        if (harddiskPris > 0 && hovedkortPris > 0 && lydkortPris > 0 && skjermkortPris > 0 && prosessorPris > 0
        && minnePris > 0 && kabinettPris > 0 && skjermPris > 0 && tastarurPris > 0 && musPris > 0){
            Bruker b1 = BrukerRegister.getAktivBruker();
            Harddisk h1 = oHarddisk.get(cbHarddisk.getSelectionModel().getSelectedIndex());
            Hovedkort h2 = oHovedkort.get(cbHovedkort.getSelectionModel().getSelectedIndex());
            Lydkort l = oLydkort.get(cbLydkort.getSelectionModel().getSelectedIndex());
            Skjermkort s1 = oSkjermkort.get(cbSkjermkort.getSelectionModel().getSelectedIndex());
            Prosessor p = oProsessor.get(cbProsessor.getSelectionModel().getSelectedIndex());
            Minne m1 = oMinne.get(cbMinne.getSelectionModel().getSelectedIndex());
            Kabinett k = oKabinett.get(cbKabinett.getSelectionModel().getSelectedIndex());
            Skjerm s2 = oSkjerm.get(cbSkjerm.getSelectionModel().getSelectedIndex());
            Tastatur t = oTastatur.get(cbTastatur.getSelectionModel().getSelectedIndex());
            Mus m2 = oMus.get(cbMus.getSelectionModel().getSelectedIndex());

            Bestilling b = new Bestilling(b1, h1, h2, l, s1, p, m1, k, s2, t, m2);

            BestillingsRegister.addBestilling(b);

            FileSaver saver = new FileSaverJobj();
            try {
                saver.save(BestillingsRegister.getBestillinger(), "src/main/java/Dataamatorene/Files/Bestillinger.jobj");
                App.setRoot("menybruker");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else {
            Dialogs.showErrorDialog("Du må velge alle komponenter først!");
        }
    }

    @FXML
    void tilbake(ActionEvent event) {
        try {
            App.setRoot("menybruker");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
