package Dataamatorene.Controllers;

import Dataamatorene.App;

import Dataamatorene.Bestilling.VarekodeRegister;
import Dataamatorene.Datakomponenter.*;
import Dataamatorene.Dialogs;

import Dataamatorene.Exceptions.AlreadyTakenVarekodeException;
import Dataamatorene.Exceptions.InvalidComponentAttributeException;
import Dataamatorene.Exceptions.InvalidPrisException;
import Dataamatorene.Exceptions.InvalidVarekodeException;
import Dataamatorene.Komponent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class EndreKomponentController {

    String aktiv = "Harddisk";


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

        /*
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

         */


        tbVarHarddisk.setCellValueFactory(new PropertyValueFactory<>("varekode"));
        tbNavnHarddisk.setCellValueFactory(new PropertyValueFactory<>("navn"));
        tbPrisHarddisk.setCellValueFactory(new PropertyValueFactory<>("prisT"));
        tbLagringHarddisk.setCellValueFactory(new PropertyValueFactory<>("lagring"));
        tbBrukerHarddisk.setCellValueFactory(new PropertyValueFactory<>("bruker"));
        tbDatoHarddisk.setCellValueFactory(new PropertyValueFactory<>("tid"));

        tbVareHovedkort.setCellValueFactory(new PropertyValueFactory<>("varekode"));
        tbNavnHovedkort.setCellValueFactory(new PropertyValueFactory<>("navn"));
        tbPrisHovedkort.setCellValueFactory(new PropertyValueFactory<>("prisT"));
        tbPorterHovedkort.setCellValueFactory(new PropertyValueFactory<>("antallPorter"));
        tbBrukerHovedkort.setCellValueFactory(new PropertyValueFactory<>("bruker"));
        tbDatoHovedkort.setCellValueFactory(new PropertyValueFactory<>("tid"));

        tbVareKabinett.setCellValueFactory(new PropertyValueFactory<>("varekode"));
        tbNavnKabinett.setCellValueFactory(new PropertyValueFactory<>("navn"));
        tbPrisKabinett.setCellValueFactory(new PropertyValueFactory<>("prisT"));
        tbStorrelseKabinett.setCellValueFactory(new PropertyValueFactory<>("storrelse"));
        tbVifterKabinett.setCellValueFactory(new PropertyValueFactory<>("antallVifter"));
        tbBrukerKabinett.setCellValueFactory(new PropertyValueFactory<>("bruker"));
        tbDatoKabinett.setCellValueFactory(new PropertyValueFactory<>("tid"));

        tbVareLydkort.setCellValueFactory(new PropertyValueFactory<>("varekode"));
        tbNavnLydkort.setCellValueFactory(new PropertyValueFactory<>("navn"));
        tbPrisLydkort.setCellValueFactory(new PropertyValueFactory<>("prisT"));
        tbFrekvensLydkort.setCellValueFactory(new PropertyValueFactory<>("frekvens"));
        tbIntegrertLydkort.setCellValueFactory(new PropertyValueFactory<>("integrert"));
        tbBrukerLydkort.setCellValueFactory(new PropertyValueFactory<>("bruker"));
        tbDatoLydkort.setCellValueFactory(new PropertyValueFactory<>("tid"));

        tbVareMinne.setCellValueFactory(new PropertyValueFactory<>("varekode"));
        tbNavnMinne.setCellValueFactory(new PropertyValueFactory<>("navn"));
        tbPrisMinne.setCellValueFactory(new PropertyValueFactory<>("prisT"));
        tbRamMinne.setCellValueFactory(new PropertyValueFactory<>("ram"));
        tbFrekvensMinne.setCellValueFactory(new PropertyValueFactory<>("frekvens"));
        tbBrukerMinne.setCellValueFactory(new PropertyValueFactory<>("bruker"));
        tbDatoMinne.setCellValueFactory(new PropertyValueFactory<>("tid"));

        tbVareMus.setCellValueFactory(new PropertyValueFactory<>("varekode"));
        tbNavnMus.setCellValueFactory(new PropertyValueFactory<>("navn"));
        tbPrisMus.setCellValueFactory(new PropertyValueFactory<>("prisT"));
        tbKnapperMus.setCellValueFactory(new PropertyValueFactory<>("antallKnapper"));
        tbTradMus.setCellValueFactory(new PropertyValueFactory<>("trad"));
        tbBrukerMus.setCellValueFactory(new PropertyValueFactory<>("bruker"));
        tbDatoMus.setCellValueFactory(new PropertyValueFactory<>("tid"));

        tbVareProsessor.setCellValueFactory(new PropertyValueFactory<>("varekode"));
        tbNavnProsessor.setCellValueFactory(new PropertyValueFactory<>("navn"));
        tbPrisProsessor.setCellValueFactory(new PropertyValueFactory<>("prisT"));
        tbFrekvenserProsessor.setCellValueFactory(new PropertyValueFactory<>("frekvens"));
        tbKjernerProsessor.setCellValueFactory(new PropertyValueFactory<>("antallKjerner"));
        tbTraderProsessor.setCellValueFactory(new PropertyValueFactory<>("antallTrader"));
        tbBrukerProsessor.setCellValueFactory(new PropertyValueFactory<>("bruker"));
        tbDatoProsessor.setCellValueFactory(new PropertyValueFactory<>("tid"));

        tbVareSkjerm.setCellValueFactory(new PropertyValueFactory<>("varekode"));
        tbNavnSkjerm.setCellValueFactory(new PropertyValueFactory<>("navn"));
        tbPrisSkjerm.setCellValueFactory(new PropertyValueFactory<>("prisT"));
        tbOpplosningSkjerm.setCellValueFactory(new PropertyValueFactory<>("opplosning"));
        tbStorrelseSkjerm.setCellValueFactory(new PropertyValueFactory<>("storrelse"));
        tbBrukerSkjerm.setCellValueFactory(new PropertyValueFactory<>("bruker"));
        tbDatoSkjerm.setCellValueFactory(new PropertyValueFactory<>("tid"));

        tbVareSkjermkort.setCellValueFactory(new PropertyValueFactory<>("varekode"));
        tbNavnSkjermkort.setCellValueFactory(new PropertyValueFactory<>("navn"));
        tbPrisSkjermkort.setCellValueFactory(new PropertyValueFactory<>("prisT"));
        tbOpplosningSkjermkort.setCellValueFactory(new PropertyValueFactory<>("opplosning"));
        tbBrukerSkjermkort.setCellValueFactory(new PropertyValueFactory<>("bruker"));
        tbDatoSkjermkort.setCellValueFactory(new PropertyValueFactory<>("tid"));

        tbVareTastatur.setCellValueFactory(new PropertyValueFactory<>("varekode"));
        tbNavnTastatur.setCellValueFactory(new PropertyValueFactory<>("navn"));
        tbPrisTastatur.setCellValueFactory(new PropertyValueFactory<>("prisT"));
        tbSpråkTastatur.setCellValueFactory(new PropertyValueFactory<>("sprak"));
        tbMekaniskTastatur.setCellValueFactory(new PropertyValueFactory<>("mekanisk"));
        tbRgbTastatur.setCellValueFactory(new PropertyValueFactory<>("rgb"));
        tbBrukerTastatur.setCellValueFactory(new PropertyValueFactory<>("bruker"));
        tbDatoTastatur.setCellValueFactory(new PropertyValueFactory<>("tid"));


        tvHarddisk.setItems(oHarddisk);
        tvHovedkort.setItems(oHovedkort);
        tvKabinett.setItems(oKabinett);
        tvLydkort.setItems(oLydkort);
        tvMinne.setItems(oMinne);
        tvMus.setItems(oMus);
        tvProsessor.setItems(oProsessor);
        tvSkjerm.setItems(oSkjerm);
        tvSkjermkort.setItems(oSkjermkort);
        tvTastatur.setItems(oTastatur);

        Harddisk.setOnSelectionChanged(event -> {
            aktiv = "Harddisk";
        });

        Hovedkort.setOnSelectionChanged(event -> {
            aktiv = "Hovedkort";
        });

        Lydkort.setOnSelectionChanged(event -> {
            aktiv = "Lydkort";
        });

        Skjermkort.setOnSelectionChanged(event -> {
            aktiv = "Skjermkort";
        });

        Prosessor.setOnSelectionChanged(event -> {
            aktiv = "Prosessor";
        });

        Minne.setOnSelectionChanged(event -> {
            aktiv = "Minne";
        });

        Kabinett.setOnSelectionChanged(event -> {
            aktiv = "Kabinett";
        });

        Skjerm.setOnSelectionChanged(event -> {
            aktiv = "Skjerm";
        });

        Tastatur.setOnSelectionChanged(event -> {
            aktiv = "Tastatur";
        });

        Mus.setOnSelectionChanged(event -> {
            aktiv = "Mus";
        });

    }

    @FXML
    private TabPane Tilbehør;

    @FXML
    private TableView<Harddisk> tvHarddisk;

    @FXML
    private TableView<Hovedkort> tvHovedkort;

    @FXML
    private TableView<Lydkort> tvLydkort;

    @FXML
    private TableView<Skjermkort> tvSkjermkort;

    @FXML
    private TableView<Prosessor> tvProsessor;

    @FXML
    private TableView<Minne> tvMinne;

    @FXML
    private TableView<Kabinett> tvKabinett;

    @FXML
    private TableView<Skjerm> tvSkjerm;

    @FXML
    private TableView<Tastatur> tvTastatur;

    @FXML
    private TableView<Mus> tvMus;


    //Harddisk

    @FXML
    private Tab Harddisk;

    @FXML
    private TableColumn<Harddisk, String> tbVarHarddisk;

    @FXML
    private void txtHarddiskVareEdit(TableColumn.CellEditEvent<Harddisk, String> event) {
        try{
            VarekodeRegister.checkVarekode(Integer.parseInt(event.getNewValue()));
            event.getRowValue().setVarekode(KomponentValidering.varekodeValidering(event.getNewValue()));
            LagreKomponent.lagreHarddisk();
            tvHarddisk.refresh();
        }catch (IOException | InvalidVarekodeException | AlreadyTakenVarekodeException e){
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvHarddisk.refresh();
        }
    }

    @FXML
    private TableColumn<Harddisk, String> tbNavnHarddisk;

    @FXML
    private void txtHarddiskNavnEdit(TableColumn.CellEditEvent<Harddisk, String> event) {
        try{
            event.getRowValue().setNavn(KomponentValidering.navnValidering(event.getNewValue()));
            LagreKomponent.lagreHarddisk();
            tvHarddisk.refresh();
        }catch (IOException | InvalidComponentAttributeException e){
            Dialogs.showErrorDialog("Ugyldig navn!",e.getMessage());
            tvHarddisk.refresh();
        }
    }

    @FXML
    private TableColumn<Harddisk, String> tbPrisHarddisk;

    @FXML
    private void txtHarddiskPrisEdit(TableColumn.CellEditEvent<Harddisk, String> event) {
        try{
            event.getRowValue().setPris(KomponentValidering.prisValidering(event.getNewValue()));
            LagreKomponent.lagreHarddisk();
            tvHarddisk.refresh();
        }catch (IOException | InvalidPrisException e){
            Dialogs.showErrorDialog("Ugyldig pris!",e.getMessage());
            tvHarddisk.refresh();
        }

    }

    @FXML
    private TableColumn<Harddisk, String> tbLagringHarddisk;

    @FXML
    private void txtHarddiskLagringEdit(TableColumn.CellEditEvent<Harddisk, String> event) {
        try{
            event.getRowValue().setLagring(KomponentValidering.lagringValidering(event.getNewValue()));
            LagreKomponent.lagreHarddisk();
            tvHarddisk.refresh();
        }catch (IOException | InvalidPrisException e){
            Dialogs.showErrorDialog("Ugyldig lagring!",e.getMessage());
            tvHarddisk.refresh();
        }
    }

    @FXML
    private TableColumn<Harddisk, String> tbBrukerHarddisk;

    @FXML
    private TableColumn<Harddisk, String> tbDatoHarddisk;


    //Hovedkort

    @FXML
    private Tab Hovedkort;

    @FXML
    private TableColumn<Hovedkort, String> tbVareHovedkort;

    @FXML
    private void txtHovedkortVareEdit(TableColumn.CellEditEvent<Hovedkort, String> event) {
        try{
            VarekodeRegister.checkVarekode(Integer.parseInt(event.getNewValue()));
            event.getRowValue().setVarekode(KomponentValidering.varekodeValidering(event.getNewValue()));
            LagreKomponent.lagreHovedkort();
            tvHovedkort.refresh();
        }catch (IOException | InvalidVarekodeException | AlreadyTakenVarekodeException e){
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvHovedkort.refresh();
        }
    }

    @FXML
    private TableColumn<Hovedkort, String> tbNavnHovedkort;

    @FXML
    private void txtHovedkortNavnEdit(TableColumn.CellEditEvent<Hovedkort, String> event) {
        try{
            event.getRowValue().setNavn(KomponentValidering.navnValidering(event.getNewValue()));
            LagreKomponent.lagreHovedkort();
            tvHovedkort.refresh();
        }catch (IOException | InvalidComponentAttributeException e){
            Dialogs.showErrorDialog("Ugyldig navn!",e.getMessage());
            tvHovedkort.refresh();
        }
    }

    @FXML
    private TableColumn<Hovedkort, String> tbPrisHovedkort;

    @FXML
    private void txtHovedkortPrisEdit(TableColumn.CellEditEvent<Hovedkort, String> event) {
        try{
            event.getRowValue().setPris(KomponentValidering.prisValidering(event.getNewValue()));
            LagreKomponent.lagreHovedkort();
            tvHovedkort.refresh();
        }catch (IOException | InvalidPrisException e){
            Dialogs.showErrorDialog("Ugyldig pris!",e.getMessage());
            tvHovedkort.refresh();
        }
    }

    @FXML
    private TableColumn<Hovedkort, String> tbPorterHovedkort;

    @FXML
    private void txtHovedkortPorterEdit(TableColumn.CellEditEvent<Hovedkort, String> event) {
        try{
            event.getRowValue().setAntallPorter(KomponentValidering.porterValidering(event.getNewValue()));
            LagreKomponent.lagreHovedkort();
            tvHovedkort.refresh();
        }catch (IOException | InvalidComponentAttributeException e){
            Dialogs.showErrorDialog("Ugyldig antall porter!",e.getMessage());
            tvHovedkort.refresh();
        }
    }

    @FXML
    private TableColumn<Hovedkort, String> tbBrukerHovedkort;

    @FXML
    private TableColumn<Hovedkort, String> tbDatoHovedkort;


    //Lydkort

    @FXML
    private Tab Lydkort;

    @FXML
    private TableColumn<Lydkort, String> tbVareLydkort;

    @FXML
    private void txtLydkortVareEdit(TableColumn.CellEditEvent<Lydkort, String> event) {
        try{
            VarekodeRegister.checkVarekode(Integer.parseInt(event.getNewValue()));
            event.getRowValue().setVarekode(KomponentValidering.varekodeValidering(event.getNewValue()));
            LagreKomponent.lagreLydkort();
            tvLydkort.refresh();
        }catch (IOException | InvalidVarekodeException | AlreadyTakenVarekodeException e){
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvLydkort.refresh();
        }
    }


    @FXML
    private TableColumn<Lydkort, String> tbNavnLydkort;

    @FXML
    private void txtLydkortNavnEdit(TableColumn.CellEditEvent<Lydkort, String> event) {
        try{
            event.getRowValue().setNavn(KomponentValidering.navnValidering(event.getNewValue()));
            LagreKomponent.lagreLydkort();
            tvLydkort.refresh();
        }catch (IOException | InvalidComponentAttributeException e){
            Dialogs.showErrorDialog("Ugyldig navn!",e.getMessage());
            tvLydkort.refresh();
        }
    }

    @FXML
    private TableColumn<Lydkort, String> tbPrisLydkort;

    @FXML
    private void txtLydkortPrisEdit(TableColumn.CellEditEvent<Lydkort, String> event) {
        try{
            event.getRowValue().setPris(KomponentValidering.prisValidering(event.getNewValue()));
            LagreKomponent.lagreLydkort();
            tvLydkort.refresh();
        }catch (IOException | InvalidPrisException e){
            Dialogs.showErrorDialog("Ugyldig navn!",e.getMessage());
            tvLydkort.refresh();
        }
    }

    @FXML
    private TableColumn<Lydkort, String> tbFrekvensLydkort;

    @FXML
    private void txtLydkortFrekvensEdit(TableColumn.CellEditEvent<Lydkort, String> event) {
        try{
            event.getRowValue().setFrekvens(KomponentValidering.frekvensValideringKHz(event.getNewValue()));
            LagreKomponent.lagreLydkort();
            tvLydkort.refresh();
        }catch (IOException | InvalidComponentAttributeException e){
            Dialogs.showErrorDialog("Ugyldig navn!",e.getMessage());
            tvLydkort.refresh();
        }
    }

    @FXML
    private TableColumn<Lydkort, String> tbIntegrertLydkort;

    @FXML
    private void txtLydkortIntegrertEdit(TableColumn.CellEditEvent<Lydkort, String> event) {
        try{
            event.getRowValue().setIntegrert(KomponentValidering.booleanValidering(event.getNewValue()));
            LagreKomponent.lagreLydkort();
            tvLydkort.refresh();
        }catch (IOException | InvalidComponentAttributeException e){
            Dialogs.showErrorDialog("Ugyldig verdi!",e.getMessage());
            tvLydkort.refresh();
        }
    }

    @FXML
    private TableColumn<Lydkort, String> tbBrukerLydkort;

    @FXML
    private TableColumn<Lydkort, String> tbDatoLydkort;


    // Skjermkort

    @FXML
    private Tab Skjermkort;

    @FXML
    private TableColumn<Skjermkort, String> tbVareSkjermkort;

    @FXML
    private void txtSkjermkortVareEdit(TableColumn.CellEditEvent<Skjermkort, String> event) {
        try {
            VarekodeRegister.checkVarekode(Integer.parseInt(event.getNewValue()));
            event.getRowValue().setVarekode(KomponentValidering.varekodeValidering(event.getNewValue()));
            LagreKomponent.lagreSkjermkort();
            oSkjermkort.setAll(KomponentRegister.getSkjermkortArrayList());
            tvSkjermkort.refresh();
        } catch (IOException | InvalidVarekodeException | AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvSkjermkort.refresh();
        }
    }

    @FXML
    private TableColumn<Skjermkort, String> tbNavnSkjermkort;

    @FXML
    private void txtSkjermkortNavnEdit(TableColumn.CellEditEvent<Skjermkort, String> event) {
        try {
            event.getRowValue().setNavn(KomponentValidering.navnValidering(event.getNewValue()));
            LagreKomponent.lagreSkjermkort();
            tvSkjermkort.refresh();
        } catch (IOException | InvalidComponentAttributeException e) {
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvSkjermkort.refresh();
        }
    }

    @FXML
    private TableColumn<Skjermkort, String> tbPrisSkjermkort;

    @FXML
    private void txtSkjermkortPrisEdit(TableColumn.CellEditEvent<Skjermkort, String> event) {
        try {
            event.getRowValue().setPris(KomponentValidering.prisValidering(event.getNewValue()));
            LagreKomponent.lagreSkjermkort();
            tvSkjermkort.refresh();
        } catch (IOException | InvalidPrisException e) {
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvSkjermkort.refresh();
        }
    }

    @FXML
    private TableColumn<Skjermkort, String> tbOpplosningSkjermkort;

    @FXML
    private void txtSkjermkortOpplosningEdit(TableColumn.CellEditEvent<Skjermkort, String> event) {
        try {
            event.getRowValue().setOpplosning(KomponentValidering.opplosningValidering(event.getNewValue()));
            LagreKomponent.lagreSkjermkort();
            tvSkjermkort.refresh();
        } catch (IOException | InvalidComponentAttributeException e) {
            Dialogs.showErrorDialog("Ugyldig oppløsning!",e.getMessage());
            tvSkjermkort.refresh();
        }
    }

    @FXML
    private TableColumn<Skjermkort, String> tbBrukerSkjermkort;

    @FXML
    private TableColumn<Skjermkort, String> tbDatoSkjermkort;


    // Prosessor

    @FXML
    private Tab Prosessor;

    @FXML
    private TableColumn<Prosessor, String> tbVareProsessor;

    @FXML
    private void txtProsessorVareEdit(TableColumn.CellEditEvent<Prosessor, String> event) {
        try {
            VarekodeRegister.checkVarekode(Integer.parseInt(event.getNewValue()));
            event.getRowValue().setVarekode(KomponentValidering.varekodeValidering(event.getNewValue()));
            LagreKomponent.lagreProsessor();
            tvProsessor.refresh();
        } catch (IOException | InvalidVarekodeException | AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvProsessor.refresh();
        }
    }

    @FXML
    private TableColumn<Prosessor, String> tbNavnProsessor;

    @FXML
    private void txtProsessorNavnEdit(TableColumn.CellEditEvent<Prosessor, String> event) {
        try {
            event.getRowValue().setNavn(KomponentValidering.navnValidering(event.getNewValue()));
            LagreKomponent.lagreProsessor();
            tvProsessor.refresh();
        } catch (IOException | InvalidComponentAttributeException e) {
            Dialogs.showErrorDialog("Ugyldig navn!",e.getMessage());
            tvProsessor.refresh();
        }
    }

    @FXML
    private TableColumn<Prosessor, String> tbPrisProsessor;

    @FXML
    private void txtProsessorPrisEdit(TableColumn.CellEditEvent<Prosessor, String> event) {
        try {
            event.getRowValue().setPris(KomponentValidering.prisValidering(event.getNewValue()));
            LagreKomponent.lagreProsessor();
            tvProsessor.refresh();
        } catch (IOException | InvalidPrisException e) {
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvProsessor.refresh();
        }
    }

    @FXML
    private TableColumn<Prosessor, String> tbKjernerProsessor;

    @FXML
    private void txtProsessorKjernerEdit(TableColumn.CellEditEvent<Prosessor, String> event) {
        try {
            event.getRowValue().setAntallKjerner(KomponentValidering.kjernerValidering(event.getNewValue()));
            LagreKomponent.lagreProsessor();
            tvProsessor.refresh();
        } catch (IOException | InvalidComponentAttributeException e) {
            Dialogs.showErrorDialog("Ugyldig antall kjerner!",e.getMessage());
            tvProsessor.refresh();
        }
    }

    @FXML
    private TableColumn<Prosessor, String> tbFrekvenserProsessor;

    @FXML
    private void txtProsessorFrekvensEdit(TableColumn.CellEditEvent<Prosessor, String> event) {
        try {
            event.getRowValue().setFrekvens(KomponentValidering.frekvensValideringGHz(event.getNewValue()));
            LagreKomponent.lagreProsessor();
            tvProsessor.refresh();
        } catch (IOException | InvalidComponentAttributeException e) {
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvProsessor.refresh();
        }
    }

    @FXML
    private TableColumn<Prosessor, String> tbTraderProsessor;

    @FXML
    private void txtProsessorTraderEdit(TableColumn.CellEditEvent<Prosessor, String> event) {
        try {
            event.getRowValue().setAntallTrader(KomponentValidering.traderValidering(event.getNewValue()));
            LagreKomponent.lagreProsessor();
            tvProsessor.refresh();
        } catch (IOException | InvalidComponentAttributeException e) {
            Dialogs.showErrorDialog("Ugyldig antall tråder!",e.getMessage());
            tvProsessor.refresh();
        }
    }

    @FXML
    private TableColumn<Prosessor, String> tbBrukerProsessor;

    @FXML
    private TableColumn<Prosessor, String> tbDatoProsessor;


    // Minne

    @FXML
    private Tab Minne;

    @FXML
    private TableColumn<Minne, String> tbVareMinne;

    @FXML
    private void txtMinneVareEdit(TableColumn.CellEditEvent<Minne, String> event) {
        try {
            VarekodeRegister.checkVarekode(Integer.parseInt(event.getNewValue()));
            event.getRowValue().setVarekode(KomponentValidering.varekodeValidering(event.getNewValue()));
            LagreKomponent.lagreMinne();
            tvMinne.refresh();
        } catch (IOException | InvalidVarekodeException | AlreadyTakenVarekodeException e){
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvMinne.refresh();
        }
    }

    @FXML
    private TableColumn<Minne, String> tbNavnMinne;

    @FXML
    private void txtMinneNavnEdit(TableColumn.CellEditEvent<Minne, String> event) {
        try {
            event.getRowValue().setNavn(KomponentValidering.navnValidering(event.getNewValue()));
            LagreKomponent.lagreMinne();
            tvMinne.refresh();
        } catch (IOException | InvalidComponentAttributeException e){
            Dialogs.showErrorDialog("Ugyldig navn!",e.getMessage());
            tvMinne.refresh();
        }
    }

    @FXML
    private TableColumn<Minne, String> tbPrisMinne;

    @FXML
    private void txtMinnePrisEdit(TableColumn.CellEditEvent<Minne, String> event) {
        try {
            event.getRowValue().setPris(KomponentValidering.prisValidering(event.getNewValue()));
            LagreKomponent.lagreMinne();
            tvMinne.refresh();
        } catch (IOException | InvalidPrisException e){
            Dialogs.showErrorDialog("Ugyldig pris!",e.getMessage());
            tvMinne.refresh();
        }
    }

    @FXML
    private TableColumn<Minne, String> tbRamMinne;

    @FXML
    private void txtMinneRamEdit(TableColumn.CellEditEvent<Minne, String> event) {
        try {
            event.getRowValue().setRam(KomponentValidering.ramValidering(event.getNewValue()));
            LagreKomponent.lagreMinne();
            tvMinne.refresh();
        } catch (IOException | InvalidComponentAttributeException e){
            Dialogs.showErrorDialog("Ugyldig ram!",e.getMessage());
            tvMinne.refresh();
        }
    }

    @FXML
    private TableColumn<Minne, String> tbFrekvensMinne;

    @FXML
    private void txtMinneFrekvensEdit(TableColumn.CellEditEvent<Minne, String> event) {
        try {
            event.getRowValue().setFrekvens(KomponentValidering.frekvensValideringGHz(event.getNewValue()));
            LagreKomponent.lagreMinne();
            tvMinne.refresh();
        } catch (IOException | InvalidComponentAttributeException e){
            Dialogs.showErrorDialog("Ugyldig frekvens!",e.getMessage());
            tvMinne.refresh();
        }
    }

    @FXML
    private TableColumn<Minne, String> tbBrukerMinne;

    @FXML
    private TableColumn<Minne, String> tbDatoMinne;


    // Kabinett

    @FXML
    private Tab Kabinett;

    @FXML
    private TableColumn<Kabinett, String> tbVareKabinett;

    @FXML
    private void txtKabinettVareEdit(TableColumn.CellEditEvent<Kabinett, String> event) {
        try {
            VarekodeRegister.checkVarekode(Integer.parseInt(event.getNewValue()));
            event.getRowValue().setVarekode(KomponentValidering.varekodeValidering(event.getNewValue()));
            LagreKomponent.lagreKabinett();
            tvKabinett.refresh();
        } catch (IOException | InvalidVarekodeException | AlreadyTakenVarekodeException e){
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvKabinett.refresh();
        }
    }

    @FXML
    private TableColumn<Kabinett, String> tbNavnKabinett;

    @FXML
    private void txtKabinettNavnEdit(TableColumn.CellEditEvent<Kabinett, String> event) {
        try {
            event.getRowValue().setNavn(KomponentValidering.navnValidering(event.getNewValue()));
            LagreKomponent.lagreKabinett();
            tvKabinett.refresh();
        } catch (IOException | InvalidComponentAttributeException e){
            Dialogs.showErrorDialog("Ugyldig navn!",e.getMessage());
            tvKabinett.refresh();
        }
    }

    @FXML
    private TableColumn<Kabinett, String> tbPrisKabinett;

    @FXML
    private void txtKabinettPrisEdit(TableColumn.CellEditEvent<Kabinett, String> event) {
        try {
            event.getRowValue().setPris(KomponentValidering.prisValidering(event.getNewValue()));
            LagreKomponent.lagreKabinett();
            tvKabinett.refresh();
        } catch (IOException | InvalidPrisException e){
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvKabinett.refresh();
        }
    }

    @FXML
    private TableColumn<Kabinett, String> tbStorrelseKabinett;

    @FXML
    private void txtKabinettStorrelseEdit(TableColumn.CellEditEvent<Kabinett, String> event) {
        try {
            event.getRowValue().setStorrelse(KomponentValidering.størrelseValidering(event.getNewValue()));
            LagreKomponent.lagreKabinett();
            tvKabinett.refresh();
        } catch (IOException | InvalidComponentAttributeException e){
            Dialogs.showErrorDialog("Ugyldig størrelse!",e.getMessage());
            tvKabinett.refresh();
        }
    }

    @FXML
    private TableColumn<Kabinett, String> tbVifterKabinett;

    @FXML
    private void txtKabinettVifterEdit(TableColumn.CellEditEvent<Kabinett, String> event) {
        try {
            event.getRowValue().setAntallVifter(KomponentValidering.vifterValidering(event.getNewValue()));
            LagreKomponent.lagreKabinett();
            tvKabinett.refresh();
        } catch (IOException | InvalidVarekodeException e){
            Dialogs.showErrorDialog("Ugyldig antall vifter!",e.getMessage());
            tvKabinett.refresh();
        }
    }

    @FXML
    private TableColumn<Kabinett, String> tbBrukerKabinett;

    @FXML
    private TableColumn<Kabinett, String> tbDatoKabinett;


    // Skjerm

    @FXML
    private Tab Skjerm;

    @FXML
    private TableColumn<Skjerm, String> tbVareSkjerm;

    @FXML
    private void txtSkjermVareEdit(TableColumn.CellEditEvent<Skjerm, String> event) {
        try {
            VarekodeRegister.checkVarekode(Integer.parseInt(event.getNewValue()));
            event.getRowValue().setVarekode(KomponentValidering.varekodeValidering(event.getNewValue()));
            LagreKomponent.lagreSkjerm();
            tvSkjerm.refresh();
        } catch (IOException | InvalidVarekodeException | AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvSkjerm.refresh();
        }
    }

    @FXML
    private TableColumn<Skjerm, String> tbNavnSkjerm;

    @FXML
    private void txtSkjermNavnEdit(TableColumn.CellEditEvent<Skjerm, String> event) {
        try {
            event.getRowValue().setNavn(KomponentValidering.navnValidering(event.getNewValue()));
            LagreKomponent.lagreSkjerm();
            tvSkjerm.refresh();
        } catch (IOException | InvalidComponentAttributeException e) {
            Dialogs.showErrorDialog("Ugyldig navn!",e.getMessage());
            tvSkjerm.refresh();
        }
    }

    @FXML
    private TableColumn<Skjerm, String> tbPrisSkjerm;

    @FXML
    private void txtSkjermPrisEdit(TableColumn.CellEditEvent<Skjerm, String> event) {
        try {
            event.getRowValue().setPris(KomponentValidering.prisValidering(event.getNewValue()));
            LagreKomponent.lagreSkjerm();
            tvSkjerm.refresh();
        } catch (IOException | InvalidPrisException e) {
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvSkjerm.refresh();
        }
    }

    @FXML
    private TableColumn<Skjerm, String> tbOpplosningSkjerm;

    @FXML
    private void txtSkjermOpplosningEdit(TableColumn.CellEditEvent<Skjerm, String> event) {
        try {
            event.getRowValue().setOpplosning(KomponentValidering.opplosningValidering(event.getNewValue()));
            LagreKomponent.lagreSkjerm();
            tvSkjerm.refresh();
        } catch (IOException | InvalidComponentAttributeException e) {
            Dialogs.showErrorDialog("Ugyldig oppløsning!",e.getMessage());
            tvSkjerm.refresh();
        }
    }

    @FXML
    private TableColumn<Skjerm, String> tbStorrelseSkjerm;

    @FXML
    private void txtSkjermStorrelseEdit(TableColumn.CellEditEvent<Skjerm, String> event) {
        try {
            event.getRowValue().setStorrelse(KomponentValidering.skjermstorrelseValidering(event.getNewValue()));
            LagreKomponent.lagreSkjerm();
            tvSkjerm.refresh();
        } catch (IOException | InvalidComponentAttributeException e) {
            Dialogs.showErrorDialog("Ugyldig skjermstørrelse!",e.getMessage());
            tvSkjerm.refresh();
        }
    }

    @FXML
    private TableColumn<Skjerm, String> tbBrukerSkjerm;

    @FXML
    private TableColumn<Skjerm, String> tbDatoSkjerm;


    // Tastatur

    @FXML
    private Tab Tastatur;

    @FXML
    private TableColumn<Tastatur, String> tbVareTastatur;

    @FXML
    private void txtTastaturVareEdit(TableColumn.CellEditEvent<Tastatur, String> event) {
        try {
            VarekodeRegister.checkVarekode(Integer.parseInt(event.getNewValue()));
            event.getRowValue().setVarekode(KomponentValidering.varekodeValidering(event.getNewValue()));
            LagreKomponent.lagreTastatur();
            tvTastatur.refresh();
        } catch (IOException | InvalidVarekodeException | AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvTastatur.refresh();
        }
    }

    @FXML
    private TableColumn<Tastatur, String> tbNavnTastatur;

    @FXML
    private void txtTastaturNavnEdit(TableColumn.CellEditEvent<Tastatur, String> event) {
        try {
            event.getRowValue().setNavn(KomponentValidering.navnValidering(event.getNewValue()));
            LagreKomponent.lagreTastatur();
            tvTastatur.refresh();
        } catch (IOException | InvalidComponentAttributeException e) {
            Dialogs.showErrorDialog("Ugyldig navn!",e.getMessage());
            tvTastatur.refresh();
        }
    }

    @FXML
    private TableColumn<Tastatur, String> tbPrisTastatur;

    @FXML
    private void txtTastaturPrisEdit(TableColumn.CellEditEvent<Tastatur, String> event) {
        try {
            event.getRowValue().setPris(KomponentValidering.prisValidering(event.getNewValue()));
            LagreKomponent.lagreTastatur();
            tvTastatur.refresh();
        } catch (IOException | InvalidPrisException e) {
            Dialogs.showErrorDialog("Ugyldig pris!",e.getMessage());
            tvTastatur.refresh();
        }
    }

    @FXML
    private TableColumn<Tastatur, String> tbSpråkTastatur;

    @FXML
    private void txtTastaturSprakEdit(TableColumn.CellEditEvent<Tastatur, String> event) {
        try {
            event.getRowValue().setSprak(event.getNewValue());
            LagreKomponent.lagreTastatur();
            tvTastatur.refresh();
        } catch (IOException e) {
            Dialogs.showErrorDialog("Ugyldig lagring!",e.getMessage());
            tvTastatur.refresh();
        }
    }

    @FXML
    private TableColumn<Tastatur, String> tbMekaniskTastatur;

    @FXML
    private void txtTastaturMekaniskEdit(TableColumn.CellEditEvent<Tastatur, String> event) {
        try {
            event.getRowValue().setMekanisk(KomponentValidering.booleanValidering(event.getNewValue()));
            LagreKomponent.lagreTastatur();
            tvTastatur.refresh();
        } catch (IOException | InvalidComponentAttributeException e) {
            Dialogs.showErrorDialog("Ugyldig verdi!",e.getMessage());
            tvTastatur.refresh();
        }
    }

    @FXML
    private TableColumn<Tastatur, String> tbRgbTastatur;

    @FXML
    private void txtTastaturRgbEdit(TableColumn.CellEditEvent<Tastatur, String> event) {
        try {
            event.getRowValue().setRgb(KomponentValidering.booleanValidering(event.getNewValue()));
            LagreKomponent.lagreTastatur();
            tvTastatur.refresh();
        } catch (IOException | InvalidComponentAttributeException e) {
            Dialogs.showErrorDialog("Ugyldig verdi!",e.getMessage());
            tvTastatur.refresh();
        }
    }

    @FXML
    private TableColumn<Tastatur, String> tbBrukerTastatur;

    @FXML
    private TableColumn<Tastatur, String> tbDatoTastatur;


    // Mus

    @FXML
    private Tab Mus;

    @FXML
    private TableColumn<Mus, String> tbVareMus;

    @FXML
    private void txtMusVareEdit(TableColumn.CellEditEvent<Mus, String> event) {
        try {
            VarekodeRegister.checkVarekode(Integer.parseInt(event.getNewValue()));
            event.getRowValue().setVarekode(KomponentValidering.varekodeValidering(event.getNewValue()));
            LagreKomponent.lagreMus();
            tvMus.refresh();
        } catch (IOException | InvalidVarekodeException | AlreadyTakenVarekodeException e) {
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvMus.refresh();
        }
    }

    @FXML
    private TableColumn<Mus, String> tbNavnMus;

    @FXML
    private void txtMusNavnEdit(TableColumn.CellEditEvent<Mus, String> event) {
        try {
            event.getRowValue().setNavn(KomponentValidering.navnValidering(event.getNewValue()));
            LagreKomponent.lagreMus();
            tvMus.refresh();
        } catch (IOException | InvalidComponentAttributeException e) {
            Dialogs.showErrorDialog("Ugyldig navn!",e.getMessage());
            tvMus.refresh();
        }
    }

    @FXML
    private TableColumn<Mus, String> tbPrisMus;

    @FXML
    private void txtMusPrisEdit(TableColumn.CellEditEvent<Mus, String> event) {
        try {
            event.getRowValue().setPris(KomponentValidering.prisValidering(event.getNewValue()));
            LagreKomponent.lagreMus();
            tvMus.refresh();
        } catch (IOException | InvalidPrisException e) {
            Dialogs.showErrorDialog("Ugyldig varekode!",e.getMessage());
            tvMus.refresh();
        }
    }

    @FXML
    private TableColumn<Mus, String> tbTradMus;

    @FXML
    private void txtMusTradEdit(TableColumn.CellEditEvent<Mus, String> event) {
        try {
            event.getRowValue().setTrad(KomponentValidering.booleanValidering(event.getNewValue()));
            LagreKomponent.lagreMus();
            tvMus.refresh();
        } catch (IOException | InvalidComponentAttributeException e) {
            Dialogs.showErrorDialog("Ugyldig verdi!",e.getMessage());
            tvMus.refresh();
        }
    }

    @FXML
    private TableColumn<Mus, String> tbKnapperMus;

    @FXML
    private void txtMusKnapperEdit(TableColumn.CellEditEvent<Mus, String> event) {
        try {
            event.getRowValue().setAntallKnapper(KomponentValidering.knapperValidering(event.getNewValue()));
            LagreKomponent.lagreMus();
            tvMus.refresh();
        } catch (IOException | InvalidVarekodeException e) {
            Dialogs.showErrorDialog("Ugyldig antall knapper!",e.getMessage());
            tvMus.refresh();
        }
    }

    @FXML
    private TableColumn<Mus, String> tbBrukerMus;

    @FXML
    private TableColumn<Mus, String> tbDatoMus;


    // Knappefunksjoner

    @FXML
    void slett(ActionEvent event) {
        if (aktiv.equalsIgnoreCase("Harddisk")){
            if (tvHarddisk.isFocusTraversable()){
                if(tvHarddisk.getSelectionModel().getSelectedItem() != null){
                    if (Dialogs.showConfimationDialog("Er du sikker på at du vil slette:" +  "\n" +
                            tvHarddisk.getSelectionModel().getSelectedItem().toString())){
                        Harddisk h = tvHarddisk.getSelectionModel().getSelectedItem();
                        ArrayList<Harddisk> aktiv = KomponentRegister.getHarddiskArrayList();
                        for(int i = 0; i < aktiv.size(); i++){
                            if (h.getVarekode().equals(aktiv.get(i).getVarekode())){
                                aktiv.remove(i);
                                KomponentRegister.setHarddiskArrayList(aktiv);
                                oHarddisk.setAll(KomponentRegister.getHarddiskArrayList());
                                tvHarddisk.refresh();
                                Dialogs.showSuccessDialog("Slettet");
                                try {
                                    LagreKomponent.lagreHarddisk();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }

        if (aktiv.equalsIgnoreCase("Hovedkort")){
            if (tvHovedkort.isFocusTraversable()){
                if(tvHovedkort.getSelectionModel().getSelectedItem() != null){
                    if (Dialogs.showConfimationDialog("Er du sikker på at du vil slette:" +  "\n" +
                            tvHovedkort.getSelectionModel().getSelectedItem().toString())){
                        Hovedkort h = tvHovedkort.getSelectionModel().getSelectedItem();
                        ArrayList<Hovedkort> aktiv = KomponentRegister.getHovedkortArrayList();
                        for(int i = 0; i < aktiv.size(); i++){
                            if (h.getVarekode().equals(aktiv.get(i).getVarekode())){
                                aktiv.remove(i);
                                KomponentRegister.setHovedkortArrayList(aktiv);
                                oHovedkort.setAll(KomponentRegister.getHovedkortArrayList());
                                tvHovedkort.refresh();
                                Dialogs.showSuccessDialog("Slettet");
                                try {
                                    LagreKomponent.lagreHovedkort();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }

        if (aktiv.equalsIgnoreCase("Lydkort")){
            if (tvLydkort.isFocusTraversable()){
                if(tvLydkort.getSelectionModel().getSelectedItem() != null){
                    if (Dialogs.showConfimationDialog("Er du sikker på at du vil slette:" +  "\n" +
                            tvLydkort.getSelectionModel().getSelectedItem().toString())){
                        Lydkort l = tvLydkort.getSelectionModel().getSelectedItem();
                        ArrayList<Lydkort> aktiv = KomponentRegister.getLydkortArrayList();
                        for(int i = 0; i < aktiv.size(); i++){
                            if (l.getVarekode().equals(aktiv.get(i).getVarekode())){
                                aktiv.remove(i);
                                KomponentRegister.setLydkortArrayList(aktiv);
                                oLydkort.setAll(KomponentRegister.getLydkortArrayList());
                                tvLydkort.refresh();
                                Dialogs.showSuccessDialog("Slettet");
                                try {
                                    LagreKomponent.lagreLydkort();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }

        if (aktiv.equalsIgnoreCase("Skjermkort")){
            if (tvSkjermkort.isFocusTraversable()){
                if(tvSkjermkort.getSelectionModel().getSelectedItem() != null){
                    if (Dialogs.showConfimationDialog("Er du sikker på at du vil slette:" +  "\n" +
                            tvSkjermkort.getSelectionModel().getSelectedItem().toString())){
                        Skjermkort s = tvSkjermkort.getSelectionModel().getSelectedItem();
                        ArrayList<Skjermkort> aktiv = KomponentRegister.getSkjermkortArrayList();
                        for(int i = 0; i < aktiv.size(); i++){
                            if (s.getVarekode().equals(aktiv.get(i).getVarekode())){
                                aktiv.remove(i);
                                KomponentRegister.setSkjermkortArrayList(aktiv);
                                oSkjermkort.setAll(KomponentRegister.getSkjermkortArrayList());
                                tvSkjermkort.refresh();
                                Dialogs.showSuccessDialog("Slettet");
                                try {
                                    LagreKomponent.lagreSkjermkort();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }

        if (aktiv.equalsIgnoreCase("Prosessor")){
            if (tvProsessor.isFocusTraversable()){
                if(tvProsessor.getSelectionModel().getSelectedItem() != null){
                    if (Dialogs.showConfimationDialog("Er du sikker på at du vil slette:" +  "\n" +
                            tvProsessor.getSelectionModel().getSelectedItem().toString())){
                        Prosessor p = tvProsessor.getSelectionModel().getSelectedItem();
                        ArrayList<Prosessor> aktiv = KomponentRegister.getProsessorArrayList();
                        for(int i = 0; i < aktiv.size(); i++){
                            if (p.getVarekode().equals(aktiv.get(i).getVarekode())){
                                aktiv.remove(i);
                                KomponentRegister.setProsessorArrayList(aktiv);
                                oProsessor.setAll(KomponentRegister.getProsessorArrayList());
                                tvProsessor.refresh();
                                Dialogs.showSuccessDialog("Slettet");
                                try {
                                    LagreKomponent.lagreProsessor();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }

        if (aktiv.equalsIgnoreCase("Minne")){
            if (tvMinne.isFocusTraversable()){
                if(tvMinne.getSelectionModel().getSelectedItem() != null){
                    if (Dialogs.showConfimationDialog("Er du sikker på at du vil slette:" +  "\n" +
                            tvMinne.getSelectionModel().getSelectedItem().toString())){
                        Minne m = tvMinne.getSelectionModel().getSelectedItem();
                        ArrayList<Minne> aktiv = KomponentRegister.getMinneArrayList();
                        for(int i = 0; i < aktiv.size(); i++){
                            if (m.getVarekode().equals(aktiv.get(i).getVarekode())){
                                aktiv.remove(i);
                                KomponentRegister.setMinneArrayList(aktiv);
                                oMinne.setAll(KomponentRegister.getMinneArrayList());
                                tvMinne.refresh();
                                Dialogs.showSuccessDialog("Slettet");
                                try {
                                    LagreKomponent.lagreMinne();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }

        if (aktiv.equalsIgnoreCase("Kabinett")){
            if (tvKabinett.isFocusTraversable()){
                if(tvKabinett.getSelectionModel().getSelectedItem() != null){
                    if (Dialogs.showConfimationDialog("Er du sikker på at du vil slette:" +  "\n" +
                            tvKabinett.getSelectionModel().getSelectedItem().toString())){
                        Kabinett k = tvKabinett.getSelectionModel().getSelectedItem();
                        ArrayList<Kabinett> aktiv = KomponentRegister.getKabinettArrayList();
                        for(int i = 0; i < aktiv.size(); i++){
                            if (k.getVarekode().equals(aktiv.get(i).getVarekode())){
                                aktiv.remove(i);
                                KomponentRegister.setKabinettArrayList(aktiv);
                                oHarddisk.setAll(KomponentRegister.getHarddiskArrayList());
                                tvKabinett.refresh();
                                Dialogs.showSuccessDialog("Slettet");
                                try {
                                    LagreKomponent.lagreKabinett();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }


        if (aktiv.equalsIgnoreCase("Skjerm")){
            if(tvSkjerm.getSelectionModel().getSelectedItem() != null){
                if (Dialogs.showConfimationDialog("Er du sikker på at du vil slette:" +  "\n" +
                        tvSkjerm.getSelectionModel().getSelectedItem().toString())){
                    Skjerm s = tvSkjerm.getSelectionModel().getSelectedItem();
                    ArrayList<Skjerm> aktiv = KomponentRegister.getSkjermArrayList();
                    for(int i = 0; i < aktiv.size(); i++){
                        if (s.getVarekode().equals(aktiv.get(i).getVarekode())){
                            aktiv.remove(i);
                            KomponentRegister.setSkjermArrayList(aktiv);
                            oSkjerm.setAll(KomponentRegister.getSkjermArrayList());
                            tvSkjerm.refresh();
                            Dialogs.showSuccessDialog("Slettet");
                            try {
                                LagreKomponent.lagreHarddisk();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

        if (aktiv.equalsIgnoreCase("Tastatur")){
            if (tvTastatur.isFocusTraversable()){
                if(tvTastatur.getSelectionModel().getSelectedItem() != null){
                    if (Dialogs.showConfimationDialog("Er du sikker på at du vil slette:" +  "\n" +
                            tvTastatur.getSelectionModel().getSelectedItem().toString())){
                        Tastatur t = tvTastatur.getSelectionModel().getSelectedItem();
                        ArrayList<Tastatur> aktiv = KomponentRegister.getTastaturArrayList();
                        for(int i = 0; i < aktiv.size(); i++){
                            if (t.getVarekode().equals(aktiv.get(i).getVarekode())){
                                aktiv.remove(i);
                                KomponentRegister.setTastaturArrayList(aktiv);
                                oTastatur.setAll(KomponentRegister.getTastaturArrayList());
                                tvTastatur.refresh();
                                Dialogs.showSuccessDialog("Slettet");
                                try {
                                    LagreKomponent.lagreTastatur();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }

        if (aktiv.equalsIgnoreCase("Mus")){
            if (tvMus.isFocusTraversable()){
                if(tvMus.getSelectionModel().getSelectedItem() != null){
                    if (Dialogs.showConfimationDialog("Er du sikker på at du vil slette:" +  "\n" +
                            tvMus.getSelectionModel().getSelectedItem().toString())){
                        Mus m = tvMus.getSelectionModel().getSelectedItem();
                        ArrayList<Mus> aktiv = KomponentRegister.getMusArrayList();
                        for(int i = 0; i < aktiv.size(); i++){
                            if (m.getVarekode().equals(aktiv.get(i).getVarekode())){
                                aktiv.remove(i);
                                KomponentRegister.setMusArrayList(aktiv);
                                oMus.setAll(KomponentRegister.getMusArrayList());
                                tvMus.refresh();
                                Dialogs.showSuccessDialog("Slettet");
                                try {
                                    LagreKomponent.lagreMus();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }

    }
    private static Komponent<? extends Datakomponent> datakomponent;

    public static <T extends Datakomponent> void setDatakomponent(T datakomponentInn) {
        datakomponent.getKomponent().setBilde(datakomponentInn.getBilde());

        try {
            LagreKomponent.lagreAlle();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void vis(ActionEvent event) {

        if (aktiv.equalsIgnoreCase("Harddisk")) {
            if (tvHarddisk.getSelectionModel().getSelectedItem() != null) {
                Harddisk h = tvHarddisk.getSelectionModel().getSelectedItem();

                datakomponent = new Komponent<>(h);
                VisKomponentController.setDatakomponent(h);
                visKomponent();

                //Dialogs.showInformationDialog("Harddisk", h.toString());
            }
        }

        if (aktiv.equalsIgnoreCase("Hovedkort")) {
            if (tvHovedkort.getSelectionModel().getSelectedItem() != null) {
                Hovedkort h = tvHovedkort.getSelectionModel().getSelectedItem();

                datakomponent = new Komponent<>(h);
                visKomponent();
            }
        }

        if (aktiv.equalsIgnoreCase("Lydkort")) {
            if (tvLydkort.getSelectionModel().getSelectedItem() != null) {
                Lydkort l = tvLydkort.getSelectionModel().getSelectedItem();

                datakomponent = new Komponent<>(l);
                visKomponent();
            }
        }

        if (aktiv.equalsIgnoreCase("Skjermkort")) {
            if (tvSkjermkort.getSelectionModel().getSelectedItem() != null) {
                Skjermkort s = tvSkjermkort.getSelectionModel().getSelectedItem();

                datakomponent = new Komponent<>(s);
                visKomponent();
            }
        }

        if (aktiv.equalsIgnoreCase("Prosessor")) {
            if (tvProsessor.getSelectionModel().getSelectedItem() != null) {
                Prosessor p = tvProsessor.getSelectionModel().getSelectedItem();

                datakomponent = new Komponent<>(p);
                visKomponent();
            }
        }

        if (aktiv.equalsIgnoreCase("Minne")) {
            if (tvMinne.getSelectionModel().getSelectedItem() != null) {
                Minne m = tvMinne.getSelectionModel().getSelectedItem();

                datakomponent = new Komponent<>(m);
                visKomponent();
            }
        }

        if (aktiv.equalsIgnoreCase("Kabinett")) {
            if (tvHarddisk.getSelectionModel().getSelectedItem() != null) {
                Kabinett k = tvKabinett.getSelectionModel().getSelectedItem();

                datakomponent = new Komponent<>(k);
                visKomponent();
            }
        }

        if(aktiv.equalsIgnoreCase("Skjerm")) {
            if (tvSkjerm.getSelectionModel().getSelectedItem() != null) {
                Skjerm s = tvSkjerm.getSelectionModel().getSelectedItem();

                datakomponent = new Komponent<>(s);
                visKomponent();
            }
        }

        if (aktiv.equalsIgnoreCase("Tastatur")) {
            if (tvTastatur.getSelectionModel().getSelectedItem() != null) {
                Tastatur t = tvTastatur.getSelectionModel().getSelectedItem();

                datakomponent = new Komponent<>(t);
                visKomponent();
            }
        }

        if(aktiv.equalsIgnoreCase("Mus")) {
            if (tvMus.getSelectionModel().getSelectedItem() != null) {
                Mus m = tvMus.getSelectionModel().getSelectedItem();

                datakomponent = new Komponent<>(m);
                visKomponent();
            }
        }
    }

    private void visKomponent() {
        Parent root;
        try {
            root = App.loadFXML("visKomponent");
            Stage stage = new Stage();
            stage.setTitle("Datakomponent");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            // Hide this current window (if this is what you want)
            //((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void tilbake(ActionEvent event) {

        /*
        KomponentRegister.setHarddiskArrayList(new ArrayList<>(oHarddisk));
        KomponentRegister.setHovedkortArrayList(new ArrayList<>(oHovedkort));
        KomponentRegister.setKabinettArrayList(new ArrayList<>(oKabinett));
        KomponentRegister.setLydkortArrayList(new ArrayList<>(oLydkort));
        KomponentRegister.setMinneArrayList(new ArrayList<>(oMinne));
        KomponentRegister.setMusArrayList(new ArrayList<>(oMus));
        KomponentRegister.setProsessorArrayList(new ArrayList<>(oProsessor));
        KomponentRegister.setSkjermArrayList(new ArrayList<>(oSkjerm));
        KomponentRegister.setSkjermkortArrayList(new ArrayList<>(oSkjermkort));
        KomponentRegister.setTastaturArrayList(new ArrayList<>(oTastatur));
         */

        try{
            //LagreKomponent.lagreAlle();
            App.setRoot("menyadmin");

        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
