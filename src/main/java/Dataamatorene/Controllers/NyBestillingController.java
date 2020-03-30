package Dataamatorene.Controllers;

import Dataamatorene.App;
import Dataamatorene.Datakomponenter.*;
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

            lblUtHarddisk.setText(String.valueOf(oHarddisk.get(cbHarddisk.getSelectionModel().getSelectedIndex())));
        });

        ObservableList<String> oHovedkortNavn = FXCollections.observableArrayList();
        for(Hovedkort h:oHovedkort) {
            oHovedkortNavn.add(h.getNavn());
        }

        cbHovedkort.setItems(oHovedkortNavn);

        cbHovedkort.setOnHiding(event -> {

            lblUtHovedkort.setText(String.valueOf(oHovedkort.get(cbHovedkort.getSelectionModel().getSelectedIndex())));
        });

        ObservableList<String> oLydkortNavn = FXCollections.observableArrayList();
        for(Lydkort l:oLydkort) {
            oLydkortNavn.add(l.getNavn());
        }

        cbLydkort.setItems(oLydkortNavn);

        cbLydkort.setOnHiding(event -> {

            lblUtLydkort.setText(String.valueOf(oLydkort.get(cbLydkort.getSelectionModel().getSelectedIndex())));
        });

        ObservableList<String> oSkjermkortNavn = FXCollections.observableArrayList();
        for(Skjermkort s:oSkjermkort) {
            oSkjermkortNavn.add(s.getNavn());
        }

        cbSkjermkort.setItems(oSkjermkortNavn);

        cbSkjermkort.setOnHiding(event -> {

            lblUtSkjermkort.setText(String.valueOf(oSkjermkort.get(cbSkjermkort.getSelectionModel().getSelectedIndex())));
        });

        ObservableList<String> oProsessorNavn = FXCollections.observableArrayList();
        for(Prosessor p:oProsessor) {
            oProsessorNavn.add(p.getNavn());
        }

        cbProsessor.setItems(oProsessorNavn);

        cbProsessor.setOnHiding(event -> {

            lblUtProsessor.setText(String.valueOf(oProsessor.get(cbProsessor.getSelectionModel().getSelectedIndex())));
        });

        ObservableList<String> oMinneNavn = FXCollections.observableArrayList();
        for(Minne m:oMinne) {
            oMinneNavn.add(m.getNavn());
        }

        cbMinne.setItems(oMinneNavn);

        cbMinne.setOnHiding(event -> {

            lblUtMinne.setText(String.valueOf(oMinne.get(cbMinne.getSelectionModel().getSelectedIndex())));
        });

        ObservableList<String> oKabienttNavn = FXCollections.observableArrayList();
        for(Kabinett k:oKabinett) {
            oKabienttNavn.add(k.getNavn());
        }

        cbKabinett.setItems(oKabienttNavn);

        cbKabinett.setOnHiding(event -> {

            lblUtKabinett.setText(String.valueOf(oKabinett.get(cbKabinett.getSelectionModel().getSelectedIndex())));
        });

        ObservableList<String> oSkjermNavn = FXCollections.observableArrayList();
        for(Skjerm s:oSkjerm) {
            oSkjermNavn.add(s.getNavn());
        }

        cbSkjerm.setItems(oSkjermNavn);

        cbSkjerm.setOnHiding(event -> {

            lblUtSkjerm.setText(String.valueOf(oSkjerm.get(cbSkjerm.getSelectionModel().getSelectedIndex())));
        });

        ObservableList<String> oTastaturNavn = FXCollections.observableArrayList();
        for(Tastatur t:oTastatur) {
            oTastaturNavn.add(t.getNavn());
        }

        cbTastatur.setItems(oTastaturNavn);

        cbTastatur.setOnHiding(event -> {

            lblUtTastatur.setText(String.valueOf(oTastatur.get(cbTastatur.getSelectionModel().getSelectedIndex())));
        });

        ObservableList<String> oMusNavn = FXCollections.observableArrayList();
        for(Mus m:oMus) {
            oMusNavn.add(m.getNavn());
        }

        cbMus.setItems(oMusNavn);

        cbMus.setOnHiding(event -> {

            lblUtMus.setText(String.valueOf(oMus.get(cbMus.getSelectionModel().getSelectedIndex())));
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
    void tilbake(ActionEvent event) {
        try {
            App.setRoot("menybruker");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
