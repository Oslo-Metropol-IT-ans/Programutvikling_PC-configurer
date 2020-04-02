package Dataamatorene.Controllers;

import Dataamatorene.*;

import Dataamatorene.Bestilling.Bestilling;
import Dataamatorene.Bestilling.BestillingsRegister;
import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Brukere.BrukerValidering;
import Dataamatorene.Datakomponenter.KomponentRegister;
import Dataamatorene.Exceptions.InvalidBrukerException;
import Dataamatorene.Exceptions.InvalidPasswordException;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.util.ArrayList;

public class EndreBrukerController {

    public void initialize() {

        tbBrukernavn.setCellValueFactory(new PropertyValueFactory<Bruker, String>("brukernavn"));
        tbPassord.setCellValueFactory(new PropertyValueFactory<Bruker, String>("passord"));
        tbRettigheter.setCellValueFactory(new PropertyValueFactory<Bruker, String>("rettigheter"));

        BrukerRegister.setTableView(tableView);

    }

    @FXML
    private TableView<Bruker> tableView;

    @FXML
    private TableColumn<Bruker, String> tbBrukernavn;

    @FXML
    private TableColumn<Bruker, String> tbPassord;

    @FXML
    private TableColumn<Bruker, String> tbRettigheter;

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
            BestillingsRegister.lagreBestillinger();
            lagre();
        }catch (InvalidBrukerException INE){
            Dialogs.showErrorDialog("Ugyldig navn!",INE.getMessage());
            //lblTilbakemelding.setText(INE.getMessage());
            tableView.refresh();
        }

    }

    @FXML
    private void txtPasswordEdited(TableColumn.CellEditEvent<Bruker, String> event) {
        try{
            event.getRowValue().setPassord(BrukerValidering.sjekkPassord(event.getNewValue()));
            oppdaterBestilling(event);
        }catch (InvalidPasswordException INE){
            Dialogs.showErrorDialog("Ugyldig passord!",INE.getMessage());
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

    private void oppdaterBestilling(TableColumn.CellEditEvent<Bruker, String> event) {
        ArrayList<Bestilling> aktiv = BestillingsRegister.getBestillinger();
        for (Bestilling b:aktiv) {
            if (b.getBrukerT().equals(event.getRowValue().getBrukernavn())) {
                b.setBruker(event.getRowValue());
            }
        }
        BestillingsRegister.setBestillinger(aktiv);
        BestillingsRegister.lagreBestillinger();
        lagre();
    }

    @FXML
    private TextField txtSøk;

    @FXML
    void tilbake(ActionEvent event) {
        try {
            App.setRoot("menyadmin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void lagre() {
        FileSaver saver = new FileSaverJobj();
        try {
            saver.save(BrukerRegister.getBrukere(), "src/main/java/Dataamatorene/Files/Login.jobj");
        } catch (IOException e) {
            Dialogs.showErrorDialog("Kunne ikke lagre");
        }
    }


    @FXML
    private void Søk(KeyEvent event){
        String søk = txtSøk.getText();

        if(!søk.isEmpty()){
            Streams.streamBrukernavn(søk);
            BrukerRegister.setAktivTableView(tableView);
        } else{
            BrukerRegister.setTableView(tableView);
        }
    }

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
                            saver.save(BrukerRegister.getBrukere(), "src/main/java/Dataamatorene/Files/Login.jobj");
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
