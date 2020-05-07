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
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class EndreKomponentController {

    // Starter controlleren på harddisk siden

    String aktiv = "Harddisk";

    // Deklarerer alle listene for hver datakomponent

    ObservableList<Harddisk> oHarddisk;
    ObservableList<Hovedkort> oHovedkort;
    ObservableList<Kabinett> oKabinett;
    ObservableList<Lydkort> oLydkort;
    ObservableList<Minne> oMinne;
    ObservableList<Mus> oMus;
    ObservableList<Prosessor> oProsessor;
    ObservableList<Skjerm> oSkjerm;
    ObservableList<Skjermkort> oSkjermkort;
    ObservableList<Tastatur> oTastatur;

    // alt som må kjøres når controlleren starter

    public void initialize() {
        oHarddisk = FXCollections.observableArrayList(KomponentRegister.getHarddiskArrayList());
        oHovedkort = FXCollections.observableArrayList(KomponentRegister.getHovedkortArrayList());
        oKabinett = FXCollections.observableArrayList(KomponentRegister.getKabinettArrayList());
        oLydkort = FXCollections.observableArrayList(KomponentRegister.getLydkortArrayList());
        oMinne = FXCollections.observableArrayList(KomponentRegister.getMinneArrayList());
        oMus = FXCollections.observableArrayList(KomponentRegister.getMusArrayList());
        oProsessor = FXCollections.observableArrayList(KomponentRegister.getProsessorArrayList());
        oSkjerm = FXCollections.observableArrayList(KomponentRegister.getSkjermArrayList());
        oSkjermkort = FXCollections.observableArrayList(KomponentRegister.getSkjermkortArrayList());
        oTastatur = FXCollections.observableArrayList(KomponentRegister.getTastaturArrayList());

        views = new ArrayList<>(Arrays.asList(tvHarddisk, tvHovedkort,
                tvLydkort, tvSkjermkort, tvProsessor, tvMinne, tvKabinett,
                tvSkjerm, tvTastatur, tvMus));

        lister = new ArrayList<>(Arrays.asList(oHarddisk, oHovedkort,
                oLydkort, oSkjermkort, oProsessor,
                oMinne, oKabinett, oSkjerm, oTastatur, oMus));

        registre = new ArrayList<>(Arrays.asList(KomponentRegister.getHarddiskArrayList()
                , KomponentRegister.getHovedkortArrayList(), KomponentRegister.getLydkortArrayList()
                , KomponentRegister.getSkjermkortArrayList(), KomponentRegister.getProsessorArrayList()
                , KomponentRegister.getMinneArrayList(), KomponentRegister.getKabinettArrayList()
                , KomponentRegister.getSkjermArrayList(), KomponentRegister.getTastaturArrayList()
                , KomponentRegister.getMusArrayList()));


        // Tableview oppsett
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

        // Når du velger en ny komponent du ser på
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

    // FXML deklarasjoner

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


    // All kode for harddisk
    @FXML
    private Tab Harddisk;


    @FXML
    private TableColumn<Harddisk, String> tbVarHarddisk;

    // Endring av harddisk i tableview

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

    // Endring av harddisk i tableview

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

    // Endring av harddisk i tableview

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

    // Endring av harddisk i tableview

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


    // All kode for hovedkort

    @FXML
    private Tab Hovedkort;

    @FXML
    private TableColumn<Hovedkort, String> tbVareHovedkort;

    // Endring av hovedkort i tableview

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

    // Endring av hovedkort i tableview

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

    // Endring av hovedkort i tableview

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

    // Endring av hovedkort i tableview

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


    // All kode for lydkort

    @FXML
    private Tab Lydkort;

    @FXML
    private TableColumn<Lydkort, String> tbVareLydkort;

    // Endring av lydkort i tableview

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

    // Endring av lydkort i tableview

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

    // Endring av lydkort i tableview

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

    // Endring av lydkort i tableview

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

    // Endring av lydkort i tableview

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


    // All kode for skjermkort

    @FXML
    private Tab Skjermkort;

    @FXML
    private TableColumn<Skjermkort, String> tbVareSkjermkort;

    // Endring av skjermkort i tableview

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

    // Endring av skjermkort i tableview

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

    // Endring av skjermkort i tableview

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

    // Endring av skjermkort i tableview

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


    // All kode for prosessor

    @FXML
    private Tab Prosessor;

    @FXML
    private TableColumn<Prosessor, String> tbVareProsessor;

    // Endring av prosessor i tableview

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

    // Endring av prosessor i tableview

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

    // Endring av prosessor i tableview

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

    // Endring av prosessor i tableview

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

    // Endring av prosessor i tableview

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

    // Endring av prosessor i tableview

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


    // All kode for minne

    @FXML
    private Tab Minne;

    @FXML
    private TableColumn<Minne, String> tbVareMinne;

    // Endring av minne i tableview

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

    // Endring av minne i tableview

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

    // Endring av minne i tableview

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

    // Endring av minne i tableview

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

    // Endring av minne i tableview

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


    // All kode for kabinett

    @FXML
    private Tab Kabinett;

    @FXML
    private TableColumn<Kabinett, String> tbVareKabinett;

    // Endring av kabinett i tableview

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

    // Endring av kabinett i tableview

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

    // Endring av kabinett i tableview

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

    // Endring av kabinett i tableview

    @FXML
    private void txtKabinettStorrelseEdit(TableColumn.CellEditEvent<Kabinett, String> event) {
        try {
            event.getRowValue().setStorrelse(KomponentValidering.storrelseValidering(event.getNewValue()));
            LagreKomponent.lagreKabinett();
            tvKabinett.refresh();
        } catch (IOException | InvalidComponentAttributeException e){
            Dialogs.showErrorDialog("Ugyldig størrelse!",e.getMessage());
            tvKabinett.refresh();
        }
    }

    @FXML
    private TableColumn<Kabinett, String> tbVifterKabinett;

    // Endring av kabinett i tableview

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


    // All kode for skjerm

    @FXML
    private Tab Skjerm;

    @FXML
    private TableColumn<Skjerm, String> tbVareSkjerm;

    // Endring av skjerm i tableview

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

    // Endring av skjerm i tableview

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

    // Endring av skjerm i tableview

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

    // Endring av skjerm i tableview

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

    // Endring av skjerm i tableview

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


    // All kode for tastatur

    @FXML
    private Tab Tastatur;

    @FXML
    private TableColumn<Tastatur, String> tbVareTastatur;

    // Endring av tastatur i tableview

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

    // Endring av tastatur i tableview

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

    // Endring av tastatur i tableview

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

    // Endring av tastatur i tableview

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

    // Endring av tastatur i tableview

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

    // Endring av tastatur i tableview

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


    // All kode for mus

    @FXML
    private Tab Mus;

    @FXML
    private TableColumn<Mus, String> tbVareMus;

    // Endring av mus i tableview

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

    // Endring av mus i tableview

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

    // Endring av mus i tableview

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

    // Endring av mus i tableview

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

    // Endring av mus i tableview

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


    // Søk
    String[] fane = {"Harddisk", "Hovedkort", "Lydkort", "Skjermkort", "Prosessor", "Minne", "Kabinett", "Skjerm",
            "Tastatur", "Mus"};
    ArrayList<TableView<? extends Datakomponent>> views;

    ArrayList<ObservableList<? extends Datakomponent>> lister;

    ArrayList<ArrayList<? extends Datakomponent>> registre;
    @FXML
    private JFXTextField txtSok;

    @FXML
    void sok(KeyEvent event) {
        for (int i = 0; i < fane.length; i++) {
            if(fane[i].equalsIgnoreCase(aktiv)) {
                ObservableList aktivListe = lister.get(i)
                        .filtered(x -> x.getBeskrivelse().toLowerCase().contains(txtSok.getText().toLowerCase()));

                try {
                    views.get(i).setItems(aktivListe);
                } catch (Exception e) {

                }


            }
        }

    }


    // Knappefunksjoner

    // Slette komponent
    @FXML
    void slett(ActionEvent event) {
        for (int i = 0; i < fane.length; i++) {
            if (fane[i].equalsIgnoreCase(aktiv)) {
                if (views.get(i).getSelectionModel().getSelectedItem() != null) {
                    if (Dialogs.showConfimationDialog("Er du sikker på at du vil slette?\n" +
                            views.get(i).getSelectionModel().getSelectedItem().toString())){
                        var d = views.get(i).getSelectionModel().getSelectedItem();
                        var aktiv = registre.get(i);
                        for (int j = 0; j < registre.get(i).size(); j++) {
                            if (d.getVarekode().equals(aktiv.get(j).getVarekode())) {
                                aktiv.remove(d);
                                try {
                                    aktiv.get(0).lagre(aktiv);
                                    initialize();
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

    // Vise komponent

    @FXML
    void vis(ActionEvent event) {

        for (int i = 0; i < fane.length; i++) {
            if (fane[i].equalsIgnoreCase(aktiv)) {
                velgKomponent(views.get(i));

            }
        }

    }

    private void velgKomponent(TableView<? extends Datakomponent> view) {
        if(view.getSelectionModel().getSelectedItem() != null) {
            var d = view.getSelectionModel().getSelectedItem();
            datakomponent = new Komponent<>(d);
            VisKomponentController.setDatakomponent(d);
            visKomponent();
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
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Tilbakeknapp

    @FXML
    void tilbake(ActionEvent event) {

        try{
            //LagreKomponent.lagreAlle();
            App.setRoot("menyadmin");

        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
