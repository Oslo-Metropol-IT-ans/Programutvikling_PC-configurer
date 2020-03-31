package Dataamatorene.Controllers;

import Dataamatorene.App;
import Dataamatorene.Bestilling.Bestilling;
import Dataamatorene.Bestilling.BestillingsRegister;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Dialogs;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverTxt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BestillingshistorikkBrukerController {

    ObservableList<Bestilling> liste = FXCollections.observableArrayList();
    ObservableList<String> navn = FXCollections.observableArrayList();

    public void initialize() {
        for (Bestilling b: BestillingsRegister.getBestillinger()) {
            if (b.getBrukerT().equals(BrukerRegister.getAktivBruker().getBrukernavn())) {
                liste.add(b);
                navn.add(b.getBestillingsnummerT());
            }
        }

        lvBestillinger.setItems(navn);
    }

    @FXML
    private ListView<String> lvBestillinger;

    @FXML
    void lastNed(ActionEvent event) {
        FileSaverTxt saver = new FileSaverTxt();

        String path;

        FileChooser fc = new FileChooser();

        fc.setInitialDirectory(new File("/Users/NicolaiMolstad/Desktop"));
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT Files", "*.txt")
        );

        File selectedFile = fc.showSaveDialog(null);

        if(selectedFile != null) {
            path = selectedFile.getAbsolutePath();

            try {
                saver.saveBestillinger(new ArrayList<Bestilling>(liste), path);
                Dialogs.showSuccessDialog("Filen ble lagre");
            } catch (IOException e) {
                Dialogs.showErrorDialog("Lagring til fil feilet. Grunn: " + e.getMessage());
            }
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

    @FXML
    void visBestilling(ActionEvent event) {
        if (lvBestillinger.getSelectionModel().getSelectedItem() != null) {
            Bestilling b = liste.get(lvBestillinger.getSelectionModel().getSelectedIndex());
            Dialogs.showInformationDialog("Bestillingsdetaljer", b.toString());
        }
    }

}
