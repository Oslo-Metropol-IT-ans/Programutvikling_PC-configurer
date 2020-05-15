package Dataamatorene.Controllers;

import Dataamatorene.App;
import Dataamatorene.Bestilling.Bestilling;
import Dataamatorene.Bestilling.BestillingsRegister;
import Dataamatorene.Bestilling.VarekodeRegister;
import Dataamatorene.Dialogs;
import Dataamatorene.Exceptions.InvalidVarekodeException;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerTxt;
import Dataamatorene.Filbehandling.FileSaverTxt;
import Dataamatorene.Tasks.ThreadOpenNewPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LastOppBestillingerController {

    // Oppretter observableList for bestillinger
    ObservableList<Bestilling> oBestilling = FXCollections.observableArrayList();
    ObservableList<Bestilling> aktivList;

    public void initialize() {
        // Setter opp tableview
        tvBestillinger.setItems(oBestilling);

        // Setter opp choicbox med søkevalg

        String[] valg = {"Bruker", "Rettigheter", "Harddisk", "Hovedkort", "Lydkort", "Skjermkort", "Prosessor","Minne",
                "Kabinett", "Skjerm", "Tastatur", "Mus", "Dato"};

        ObservableList<String> oValg = FXCollections.observableArrayList(valg);

        cbValg.setItems(oValg);
        cbValg.setValue("Bruker");

    }


    boolean opened = false;

    // FXML deklarering
    @FXML
    private AnchorPane apMain;

    @FXML
    private TableView<Bestilling> tvBestillinger;

    @FXML
    private TableColumn<Bestilling, String> tbBruker;

    @FXML
    private TableColumn<Bestilling, String> tbHarddisk;

    // Endre hardisk
    @FXML
    private void txtHarddiskEdit(TableColumn.CellEditEvent<Bestilling, String> event) {
        try {
            event.getRowValue().setHarddisk(VarekodeRegister.chechVarekodeHarddisk(event.getNewValue()));
            tvBestillinger.refresh();
            BestillingsRegister.lagreBestillinger(apMain);
        } catch (InvalidVarekodeException e) {
            Dialogs.showErrorDialog("Denne harddisken finnes ikke!");
            tvBestillinger.refresh();
        }
    }

    @FXML
    private TableColumn<Bestilling, String> tbHovedkort;

    // Endre hovedkort
    @FXML
    private void txtHovedkortEdit(TableColumn.CellEditEvent<Bestilling, String> event) {
        try {
            event.getRowValue().setHovedkort(VarekodeRegister.chechVarekodeHovedkort(event.getNewValue()));
            BestillingsRegister.lagreBestillinger(apMain);
            tvBestillinger.refresh();
        } catch (InvalidVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes ikke!");
            tvBestillinger.refresh();
        }
    }

    @FXML
    private TableColumn<Bestilling, String> bLydkort;

    // Endre lydkort
    @FXML
    private void txtLydkortEdit(TableColumn.CellEditEvent<Bestilling, String> event) {
        try {
            event.getRowValue().setLydkort(VarekodeRegister.chechVarekodeLydkort(event.getNewValue()));
            BestillingsRegister.lagreBestillinger(apMain);
            tvBestillinger.refresh();
        } catch (InvalidVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes ikke");
            tvBestillinger.refresh();
        }

    }

    @FXML
    private TableColumn<Bestilling, String> tbSkjermkort;

    // Endre skjermkort
    @FXML
    private void txtSkjermkortEdit(TableColumn.CellEditEvent<Bestilling, String> event) {
        try {
            event.getRowValue().setSkjermkort(VarekodeRegister.chechVarekodeSkjermkort(event.getNewValue()));
            BestillingsRegister.lagreBestillinger(apMain);
            tvBestillinger.refresh();
        } catch (InvalidVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes ikke");
            tvBestillinger.refresh();
        }
    }

    @FXML
    private TableColumn<Bestilling, String> tbProsessor;

    // Endre prosessor
    @FXML
    private void txtProsessorEdit(TableColumn.CellEditEvent<Bestilling, String> event) {
        try {
            event.getRowValue().setProsessor(VarekodeRegister.chechVarekodeProsessor(event.getNewValue()));
            BestillingsRegister.lagreBestillinger(apMain);
            tvBestillinger.refresh();
        } catch (InvalidVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekden finnes ikke");
            tvBestillinger.refresh();
        }

    }

    @FXML
    private TableColumn<Bestilling, String> tbMinne;

    // Endre minne
    @FXML
    private void txtMinneEdit(TableColumn.CellEditEvent<Bestilling, String> event) {
        try {
            event.getRowValue().setMinne(VarekodeRegister.chechVarekodeMinne(event.getNewValue()));
            BestillingsRegister.lagreBestillinger(apMain);
            tvBestillinger.refresh();
        } catch (InvalidVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes ikke");
            tvBestillinger.refresh();
        }

    }

    @FXML
    private TableColumn<Bestilling, String> tbKabinett;

    // Endre kabinett
    @FXML
    private void txtKabinettEdit(TableColumn.CellEditEvent<Bestilling, String> event) {
        try {
            event.getRowValue().setKabinett(VarekodeRegister.chechVarekodeKabinett(event.getNewValue()));
            BestillingsRegister.lagreBestillinger(apMain);
            tvBestillinger.refresh();
        } catch (InvalidVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes ikke");
            tvBestillinger.refresh();
        }

    }

    @FXML
    private TableColumn<Bestilling, String> tbSkjerm;

    // Endre skjerm
    @FXML
    private void txtSkjermEdit(TableColumn.CellEditEvent<Bestilling, String> event) {
        try {
            event.getRowValue().setSkjerm(VarekodeRegister.chechVarekodeSkjerm(event.getNewValue()));
            BestillingsRegister.lagreBestillinger(apMain);
            tvBestillinger.refresh();
        } catch (InvalidVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes ikke");
            tvBestillinger.refresh();
        }

    }

    @FXML
    private TableColumn<Bestilling, String> tbTastatur;

    // Endre tastatur
    @FXML
    private void txtTastaturEdit(TableColumn.CellEditEvent<Bestilling, String> event) {
        try {
            event.getRowValue().setTastatur(VarekodeRegister.chechVarekodeTastatur(event.getNewValue()));
            BestillingsRegister.lagreBestillinger(apMain);
            tvBestillinger.refresh();
        } catch (InvalidVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes ikke");
            tvBestillinger.refresh();
        }

    }

    @FXML
    private TableColumn<Bestilling, String> tbMus;

    // Endre mus
    @FXML
    private void txtMusEdit(TableColumn.CellEditEvent<Bestilling, String> event) {
        try {
            event.getRowValue().setMus(VarekodeRegister.chechVarekodeMus(event.getNewValue()));
            BestillingsRegister.lagreBestillinger(apMain);
            tvBestillinger.refresh();
        } catch (InvalidVarekodeException e) {
            Dialogs.showErrorDialog("Denne varekoden finnes ikke");
            tvBestillinger.refresh();
        }

    }

    @FXML
    private TableColumn<Bestilling, String> tbDato;

    @FXML
    private TableColumn<Bestilling, String> tbOrdrenummer;

    @FXML
    private TableColumn<Bestilling, String> tbPris;

    @FXML
    private ChoiceBox<String> cbValg;

    @FXML
    private TextField txtSøk;

    // Tastevent for textfelt søk
    @FXML
    void sok(KeyEvent event) {
        String søk = txtSøk.getText();
        if(!søk.isEmpty()) {
            if(cbValg.getSelectionModel().getSelectedItem().equalsIgnoreCase("Bruker")) {
                aktivList = oBestilling.stream().filter(x -> x.getBrukerT().toLowerCase().contains(søk.toLowerCase()))
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                tvBestillinger.setItems(aktivList);
            }

            if(cbValg.getSelectionModel().getSelectedItem().equalsIgnoreCase("Rettigheter")) {
                aktivList = oBestilling.stream().filter(x -> x.getBruker().getRettigheter().toLowerCase()
                        .contains(søk.toLowerCase()))
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                tvBestillinger.setItems(aktivList);
            }

            if(cbValg.getSelectionModel().getSelectedItem().equalsIgnoreCase("Harddisk")) {
                aktivList = oBestilling.stream().filter(x -> x.getHarddiskT().toLowerCase().contains(søk.toLowerCase()))
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                tvBestillinger.setItems(aktivList);
            }

            if(cbValg.getSelectionModel().getSelectedItem().equalsIgnoreCase("Hovedkort")) {
                aktivList = oBestilling.stream().filter(x -> x.getHovedkortT().toLowerCase().contains(søk.toLowerCase()))
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                tvBestillinger.setItems(aktivList);
            }

            if(cbValg.getSelectionModel().getSelectedItem().equalsIgnoreCase("Lydkort")) {
                aktivList = oBestilling.stream().filter(x -> x.getLydkortT().toLowerCase().contains(søk.toLowerCase()))
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                tvBestillinger.setItems(aktivList);
            }

            if(cbValg.getSelectionModel().getSelectedItem().equalsIgnoreCase("Skjermkort")) {
                aktivList = oBestilling.stream().filter(x -> x.getSkjermkortT().toLowerCase().contains(søk.toLowerCase()))
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                tvBestillinger.setItems(aktivList);
            }

            if(cbValg.getSelectionModel().getSelectedItem().equalsIgnoreCase("Prosessor")) {
                aktivList = oBestilling.stream().filter(x -> x.getProsessorT().toLowerCase().contains(søk.toLowerCase()))
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                tvBestillinger.setItems(aktivList);
            }

            if(cbValg.getSelectionModel().getSelectedItem().equalsIgnoreCase("Minne")) {
                aktivList = oBestilling.stream().filter(x -> x.getMinneT().toLowerCase().contains(søk.toLowerCase()))
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                tvBestillinger.setItems(aktivList);
            }

            if(cbValg.getSelectionModel().getSelectedItem().equalsIgnoreCase("Kabinett")) {
                aktivList = oBestilling.stream().filter(x -> x.getKabinettT().toLowerCase().contains(søk.toLowerCase()))
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                tvBestillinger.setItems(aktivList);
            }

            if(cbValg.getSelectionModel().getSelectedItem().equalsIgnoreCase("Skjerm")) {
                aktivList = oBestilling.stream().filter(x -> x.getSkjermT().toLowerCase().contains(søk.toLowerCase()))
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                tvBestillinger.setItems(aktivList);
            }

            if(cbValg.getSelectionModel().getSelectedItem().equalsIgnoreCase("Tastatur")) {
                aktivList = oBestilling.stream().filter(x -> x.getTastaturT().toLowerCase().contains(søk.toLowerCase()))
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                tvBestillinger.setItems(aktivList);
            }

            if(cbValg.getSelectionModel().getSelectedItem().equalsIgnoreCase("Mus")) {
                aktivList = oBestilling.stream().filter(x -> x.getMusT().toLowerCase().contains(søk.toLowerCase()))
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                tvBestillinger.setItems(aktivList);
            }

            if(cbValg.getSelectionModel().getSelectedItem().equalsIgnoreCase("Dato")) {
                aktivList = oBestilling.stream().filter(x -> x.getDatoT().toLowerCase().startsWith(søk.toLowerCase()))
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                tvBestillinger.setItems(aktivList);
            }


        } else tvBestillinger.setItems(oBestilling);
    }

    // Vis bestilling i nytt bilde
    @FXML
    void vis(ActionEvent event) {
        if (tvBestillinger.getSelectionModel().getSelectedItem() != null) {
            Dialogs
                    .showInformationDialog("Bestilling", tvBestillinger
                            .getSelectionModel().getSelectedItem().toString());
        }
    }


    // Laste opp bestillinger fra txt
    @FXML
    void lastOpp(ActionEvent event) {
        opplasting();
    }

    private void opplasting(){
        FileOpener opener = new FileOpenerTxt();

        String path;

        File selectedFile;
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT Files", "*.txt"));
        try {
            var test = System.getProperty("user.home") + "/Desktop";
            fc.setInitialDirectory(new File(test));
            selectedFile = fc.showOpenDialog(null);
        } catch (Exception e) {
            fc.setInitialDirectory(null);
            selectedFile = fc.showOpenDialog(null);
        }

        if(selectedFile != null) {
            path = selectedFile.getAbsolutePath();

            try {
                ArrayList<Bestilling> nye = (ArrayList<Bestilling>) opener.read(path);
                for (Bestilling b:nye) {
                    boolean finnes = false;
                    for (Bestilling b1 : oBestilling) {
                        if (b.getBestillingsnummerT().equals(b1.getBestillingsnummerT())) {
                            finnes = true;
                        }
                    }
                    if (!finnes) {
                        oBestilling.add(b);
                    }
                }
                tvBestillinger.refresh();
                Dialogs.showSuccessDialog("Filen ble lagret");
            } catch (IOException | ClassNotFoundException e) {
                Dialogs.showErrorDialog("Lagring til fil feilet. Grunn: " + e.getMessage());
            }
        }
    }

    // Flytte bestillinger til aktiv
    @FXML
    void flyttAktiv(ActionEvent event) {
        if(tvBestillinger.getSelectionModel().getSelectedItem() != null) {
            Bestilling b = tvBestillinger.getSelectionModel().getSelectedItem();
            boolean finnes = false;
            for (Bestilling b1 : BestillingsRegister.getBestillinger()) {
                if(b1.getBestillingsnummerT().equals(b.getBestillingsnummerT())) {
                    finnes = true;
                }
            }
            if (!finnes) {
                BestillingsRegister.addBestilling(b);
                BestillingsRegister.lagreBestillinger(apMain);
            }
            oBestilling.remove(b);
        }
    }

    ThreadOpenNewPage threadOpenNewPage;

    // Til aktive bestillinger
    @FXML
    void tilbake(ActionEvent event) {
        threadOpenNewPage = new ThreadOpenNewPage("FXML/bestillingshistorikkadmin");
        threadOpenNewPage.setOnSucceeded(this::threadOpenPageDone);
        threadOpenNewPage.setOnRunning(this::threadOpenPageRunning);
        threadOpenNewPage.setOnFailed(this::threadOpenPageFailes);
        Thread th = new Thread(threadOpenNewPage);
        th.setDaemon(true);
        th.start();
    }

    // Metode kjørt ved vellykket innlasting av side
    private void threadOpenPageDone(WorkerStateEvent e){
        App.setRoot(threadOpenNewPage.getValue());
    }

    // Metode kjørt underves av lasting
    private void threadOpenPageRunning(WorkerStateEvent e) {
        apMain.setDisable(true);
    }

    // Metode kjørt ved misslykket lasting
    private void threadOpenPageFailes(WorkerStateEvent e){

    }

    @FXML
    void fcOnOpen(MouseEvent event){
        if (!opened){
            opened = true;
            opplasting();
        }
    }

}
