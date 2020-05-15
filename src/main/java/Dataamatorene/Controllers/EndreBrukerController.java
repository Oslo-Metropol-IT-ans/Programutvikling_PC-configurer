package Dataamatorene.Controllers;

import Dataamatorene.*;

import Dataamatorene.Bestilling.Bestilling;
import Dataamatorene.Bestilling.BestillingsRegister;
import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Brukere.BrukerValidering;
import Dataamatorene.Exceptions.*;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;

import Dataamatorene.Filbehandling.ThreadSaverJobj;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class EndreBrukerController {

    // Ting som kjøres når controlleren starter opp

    public void initialize() {

        // Tableview oppsett
        BrukerRegister.setTableView(tableView);

    }

    // FXML element deklarasjoner
    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<Bruker> tableView;

    @FXML
    private TableColumn<Bruker, String> tbBrukernavn;

    @FXML
    private TableColumn<Bruker, String> tbPassord;

    @FXML
    private TableColumn<Bruker, String> tbNavn;

    @FXML
    private TableColumn<Bruker, String> tbTlfNummer;

    @FXML
    private TableColumn<Bruker, String> tbEmail;


    @FXML
    private TableColumn<Bruker, String> tbRettigheter;

    // Håndtering av endringer i Tableview

    @FXML
    private void txtBrukernavnEdited(TableColumn.CellEditEvent<Bruker, String> event) {
        try{
            String bruker = event.getOldValue();
            event.getRowValue().setBrukernavn(BrukerValidering.sjekkBrukernavn(event.getNewValue()));
            ArrayList<Bestilling> aktiv = BestillingsRegister.getBestillinger();
            for (Bestilling b:aktiv) {
                if (b.getBrukerT().equals(bruker)) {
                    b.setBruker(event.getRowValue());
                }
            }
            BestillingsRegister.setBestillinger(aktiv);
            BestillingsRegister.lagreBestillinger(pane);
            lagre();
        }catch (InvalidBrukerException INE){
            Dialogs.showErrorDialog("Ugyldig navn!",INE.getMessage());
            tableView.refresh();
        }

    }

    @FXML
    private void txtPasswordEdited(TableColumn.CellEditEvent<Bruker, String> event) {
        try{
            event.getRowValue().setPassord(BrukerValidering.sjekkPassord(event.getNewValue()));
            oppdaterBestilling(event);
        }catch (InvalidPasswordException IPE){
            Dialogs.showErrorDialog("Ugyldig passord!",IPE.getMessage());
            tableView.refresh();
        }

    }

    @FXML
    void txtNavnEdited(TableColumn.CellEditEvent<Bruker, String> event) {
        try{
            event.getRowValue().setNavn(BrukerValidering.sjekkValidNavn(event.getNewValue()));
            oppdaterBestilling(event);
        }
        catch (InvalidNameException INE){
            Dialogs.showErrorDialog("Ugyldig navn!", INE.getMessage());
            tableView.refresh();
        }

    }

    @FXML
    void txtTlfNummerEdited(TableColumn.CellEditEvent<Bruker, String> event) {
        try{
            event.getRowValue().setTlfNummer(BrukerValidering.sjekkValidTelefon(event.getNewValue()));
            oppdaterBestilling(event);
        }
        catch (InvalidTelefonException ITE){
            Dialogs.showErrorDialog("Ugyldig telefonnummer!", ITE.getMessage());
            tableView.refresh();
        }
    }

    @FXML
    void txtEmailEdited(TableColumn.CellEditEvent<Bruker, String> event) {
        try {
            event.getRowValue().setEmail(BrukerValidering.sjekkValidEpost(event.getNewValue()));
            oppdaterBestilling(event);
        }
        catch (InvalidEpostException IEE){
            Dialogs.showErrorDialog("Ugyldig epost!", IEE.getMessage());
            tableView.refresh();
        }

    }

    @FXML
    private void txtRettigheterEdited(TableColumn.CellEditEvent<Bruker, String> event) {
        try{
            if (!event.getRowValue().getBrukernavn().equalsIgnoreCase("Admin")) {
                event.getRowValue().setSuperbruker(BrukerValidering.sjekkRettigheter(event.getNewValue()));
                oppdaterBestilling(event);
            } else {
                Dialogs.showErrorDialog("Admin kan kun ha administratorrettigheter");
                tableView.refresh();
            }
        }catch (IllegalArgumentException INE){
            Dialogs.showErrorDialog("Ugyldig rettigheter!",INE.getMessage());
            tableView.refresh();
        }

    }

    // Hvis brukernavn endres må også brukernavn på bestilling endres

    private void oppdaterBestilling(TableColumn.CellEditEvent<Bruker, String> event) {
        ArrayList<Bestilling> aktiv = BestillingsRegister.getBestillinger();
        for (Bestilling b:aktiv) {
            if (b.getBrukerT().equals(event.getRowValue().getBrukernavn())) {
                b.setBruker(event.getRowValue());
            }
        }
        BestillingsRegister.setBestillinger(aktiv);
        BestillingsRegister.lagreBestillinger(pane);
        lagre();
    }

    // Søkefelt deklarasjon

    @FXML
    private TextField txtSok;

    // Tilbakeknapp sin actionevent

    @FXML
    void tilbake(ActionEvent event) {
        try {
            App.setRoot("FXML/menyadmin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Lagre metode som lagrer det nye brukerregisteret til jobj fil

    private void lagre() {
        ThreadSaverJobj saver;
        var ordererd = BrukerRegister.getBrukere();
        saver = new ThreadSaverJobj(ordererd, "src/main/resources/Dataamatorene/Files/Tastatur.jobj", pane);
        saver.save();
    }

    // Søkeknapp sin actionevent

    @FXML
    private void Sok(KeyEvent event){
        String søk = txtSok.getText();

        if(!søk.isEmpty()){
            BrukerRegister.streamBrukernavn(søk);
            BrukerRegister.setAktivTableView(tableView);
        } else{
            BrukerRegister.setTableView(tableView);
        }
    }

    // Sletteknappen sin actionevent

    @FXML
    void slett(ActionEvent event) {
        if(tableView.getSelectionModel().getSelectedItem() != null){
            Bruker b = tableView.getSelectionModel().getSelectedItem();

            if(Dialogs.showConfimationDialog("Er du sikker på at du vil slette:\n" + b.toString())){
                ArrayList<Bruker> endre = BrukerRegister.getBrukere();

                for(int i = 0; i < endre.size(); i++){
                    if(endre.get(i) == b){
                        endre.remove(i);

                        BrukerRegister.update();
                        tableView.refresh();

                        FileSaver saver = new FileSaverJobj();
                        try {
                            saver.save(BrukerRegister.getBrukere(), "src/main/resources/Dataamatorene/Files/Login.jobj");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        else {
            Dialogs.showErrorDialog("Du må velge en person først");
        }
    }


}
