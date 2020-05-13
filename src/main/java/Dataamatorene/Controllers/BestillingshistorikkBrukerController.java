package Dataamatorene.Controllers;

import Dataamatorene.App;
import Dataamatorene.Bestilling.Bestilling;
import Dataamatorene.Bestilling.BestillingsRegister;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Dialogs;
import Dataamatorene.Filbehandling.FileSaverTxt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BestillingshistorikkBrukerController {

    // Deklarering for observablelist til tableview

    ObservableList<Bestilling> liste = FXCollections.observableArrayList();
    ObservableList<String> navn = FXCollections.observableArrayList();

    public void initialize() {
        // Finner bestillinger me aktivbrukers brukernavn
        for (Bestilling b: BestillingsRegister.getBestillinger()) {
            if (b.getBrukerT().equals(BrukerRegister.getAktivBruker().getBrukernavn())) {
                liste.add(b);
                navn.add(b.getBestillingsnummerT() + "\t\t\t" + b.getDatoT());
            }
        }

        lvBestillinger.setItems(navn);

        lvBestillinger.setOnMouseClicked(mouseEvent -> {
            int index = lvBestillinger.getSelectionModel().getSelectedIndex();
            VisBestillingController.setAktivBestilling(liste.get(index));
        });

    }

    @FXML
    private ListView<String> lvBestillinger;

    // Metode for å laste ned fil(txt) med bestillingsinformasjon
    @FXML
    void lastNed(ActionEvent event) {
        FileSaverTxt saver = new FileSaverTxt();

        String path;

        File selectedFile;
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT Files", "*.txt"));
        try {
            var test = System.getProperty("user.home") + "/Desktop";
            fc.setInitialDirectory(new File(test));
            selectedFile = fc.showSaveDialog(null);
        } catch (Exception e) {
            fc.setInitialDirectory(null);
            selectedFile = fc.showSaveDialog(null);
        }

        if(selectedFile != null) {
            path = selectedFile.getAbsolutePath();

            try {
                saver.saveBestillingerBruker(new ArrayList<Bestilling>(liste), path);
                Dialogs.showSuccessDialog("Filen ble lagre");
            } catch (IOException e) {
                Dialogs.showErrorDialog("Lagring til fil feilet. Grunn: " + e.getMessage());
            }
        }
    }

    // Metode for å gå til meny
    @FXML
    void tilbake(ActionEvent event) {
        try {
            App.setRoot("FXML/menybruker");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Metode for å åpne informasjon om bestillingen i eget vindu
    @FXML
    void visBestilling(ActionEvent event) {
        if (lvBestillinger.getSelectionModel().getSelectedItem() != null) {

            VisBestillingController.setAktivBestilling(liste.get(lvBestillinger.getSelectionModel().getSelectedIndex()));

            NyBestillingController.openOrders();

            //Dialogs.showSuccessDialog(liste.get(lvBestillinger.getSelectionModel().getSelectedIndex()).toString());
        }


    }

}
