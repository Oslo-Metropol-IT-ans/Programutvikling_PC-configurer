package Dataamatorene.Controllers;

import Dataamatorene.*;

import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Brukere.BrukerValidering;
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
            event.getRowValue().setBrukernavn(BrukerValidering.sjekkBrukernavn(event.getNewValue()));
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
            lagre();
        }catch (InvalidPasswordException INE){
            Dialogs.showErrorDialog("Ugyldig passord!",INE.getMessage());
            //lblTilbakemelding.setText(INE.getMessage());
            tableView.refresh();
        }

    }

    @FXML
    private void txtRettigheterEdited(TableColumn.CellEditEvent<Bruker, String> event) {
        try{
            event.getRowValue().setSuperbruker(BrukerValidering.sjekkRettigheter(event.getNewValue()));
            lagre();
        }catch (IllegalArgumentException INE){
            Dialogs.showErrorDialog("Ugyldig rettigheter!",INE.getMessage());
            //lblTilbakemelding.setText(INE.getMessage());
            tableView.refresh();
        }

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
            saver.save(BrukerRegister.getBrukere(), "src/main/java/Dataamatørene/Files/Login.jobj");
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
