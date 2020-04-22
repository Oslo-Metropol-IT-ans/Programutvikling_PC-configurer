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
import Dataamatorene.LagreBilde;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


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

    double totPris; Double harddiskPris = 0.0; double hovedkortPris = 0; double lydkortPris; double skjermkortPris = 0;
    double prosessorPris = 0; double minnePris = 0; double kabinettPris = 0; double skjermPris = 0;
    double tastarurPris = 0; double musPris = 0;

    public void initialize() throws FileNotFoundException {

        // Alle bestillingsbokser i en

        titledPanes = new ArrayList<>(Arrays.asList(tpHarddisk, tpHovedkort, tpLydkort, tpSkjermkort, tpProsessor,
                tpMinne, tpKabinett, tpSkjerm, tpTastatur, tpMus));

        scrollPanes = new ArrayList<>(Arrays.asList(spHarddisk, spHovedkort, spLydkort, spSkjermkort, spProsessor,
                spMinne, spKabinett, spSkjerm, spTastatur, spMus));

        observableLists = new ArrayList<>(Arrays.asList(oHarddisk,
                oHovedkort, oLydkort, oSkjermkort, oProsessor, oMinne, oKabinett, oSkjerm, oTastatur, oMus));

        labels = new ArrayList<>(Arrays.asList(lblUtHarddisk, lblUtHovedkort, lblUtLydkort, lblUtSkjermkort, lblUtProsessor, lblUtMinne,
                 lblUtKabinett, lblUtSkjerm, lblUtTastatur, lblUtMus));

        priser = new ArrayList<>(Arrays.asList(harddiskPris, hovedkortPris, lydkortPris, skjermkortPris, prosessorPris, minnePris
                 , kabinettPris, skjermPris, tastarurPris, musPris));


        for (int i = 0; i < titledPanes.size(); i++) {
            double x = titledPanes.get(i).getLayoutX();
            double y = titledPanes.get(i).getLayoutY();

            VBox vBox = new VBox(10);

            for (int j = 0; j < observableLists.get(i).size(); j++) {
                HBox hBox = new HBox(10);
                Label label = new Label(observableLists.get(i).get(j).toString());
                label.setStyle("-fx-border-width: 0 0 1 0; -fx-border-color: white; -fx-border-style: solid; -fx-text-alignment: left!important;");
                ImageView image;
                if (observableLists.get(i).get(j).getBilde() != null) {
                     image = new ImageView(observableLists.get(i).get(j).getBilde());
                } else image = new ImageView(new Image(new FileInputStream("src/main/java/Dataamatorene/Pictures/nia.jpg")));
                image.setFitHeight(80);
                image.setPreserveRatio(true);
                label.setPrefWidth(1115);
                label.setPrefHeight(80);
                hBox.getChildren().addAll(image, label);

                int finalI = i;
                int finalJ = j;
                image.setOnMouseClicked(mouseEvent -> {
                    titledPanes.get(finalI).setLayoutX(x);
                    titledPanes.get(finalI).setLayoutY(y);
                    labels.get(finalI).setText(observableLists.get(finalI)
                            .get(observableLists.get(finalI).indexOf(observableLists.get(finalI).get(finalJ))).toString());
                    titledPanes.get(finalI).setExpanded(false);
                    titledPanes.get(finalI).setPrefWidth(150);
                    titledPanes.get(finalI).toBack();
                });

                label.setOnMouseClicked(mouseEvent -> {
                    titledPanes.get(finalI).setLayoutX(x);
                    titledPanes.get(finalI).setLayoutY(y);
                    labels.get(finalI).setText(observableLists.get(finalI)
                            .get(observableLists.get(finalI).indexOf(observableLists.get(finalI).get(finalJ))).toString());
                    titledPanes.get(finalI).setExpanded(false);
                    titledPanes.get(finalI).setPrefWidth(150);
                    titledPanes.get(finalI).toBack();
                });
                vBox.getChildren().add(hBox);
                vBox.setPrefWidth(1123.5);

                titledPanes.get(i).setExpanded(false);
                scrollPanes.get(i).setContent(vBox);

                titledPanes.get(i).setOnMouseClicked(mouseEvent -> {
                    if (titledPanes.get(finalI).isExpanded()) {
                        titledPanes.get(finalI).toFront();
                        titledPanes.get(finalI).setLayoutX(20);
                        titledPanes.get(finalI).setLayoutY(20);
                        titledPanes.get(finalI).setPrefWidth(1125);
                        titledPanes.get(finalI).setPrefHeight(600);
                    } else {
                        titledPanes.get(finalI).setPrefWidth(150);
                        titledPanes.get(finalI).setLayoutX(x);
                        titledPanes.get(finalI).setLayoutY(y);
                    }
                });
            }
        }



    }

    @FXML
    private TitledPane tpHarddisk;

    @FXML
    private ScrollPane spHarddisk;

    @FXML
    private Label lblUtHarddisk;

    @FXML
    private TitledPane tpHovedkort;

    @FXML
    private ScrollPane spHovedkort;

    @FXML
    private Label lblUtHovedkort;

    @FXML
    private TitledPane tpLydkort;

    @FXML
    private ScrollPane spLydkort;

    @FXML
    private Label lblUtLydkort;

    @FXML
    private TitledPane tpSkjermkort;

    @FXML
    private ScrollPane spSkjermkort;

    @FXML
    private Label lblUtSkjermkort;

    @FXML
    private TitledPane tpProsessor;

    @FXML
    private ScrollPane spProsessor;

    @FXML
    private Label lblUtProsessor;

    @FXML
    private TitledPane tpMinne;

    @FXML
    private ScrollPane spMinne;

    @FXML
    private Label lblUtMinne;

    @FXML
    private TitledPane tpKabinett;

    @FXML
    private ScrollPane spKabinett;

    @FXML
    private Label lblUtKabinett;

    @FXML
    private TitledPane tpSkjerm;

    @FXML
    private ScrollPane spSkjerm;

    @FXML
    private Label lblUtSkjerm;

    @FXML
    private TitledPane tpTastatur;

    @FXML
    private ScrollPane spTastatur;

    @FXML
    private Label lblUtTastatur;

    @FXML
    private TitledPane tpMus;

    @FXML
    private ScrollPane spMus;

    @FXML
    private Label lblUtMus;

    @FXML
    private Label lblTotPris;

    @FXML
    void bestill(ActionEvent event) {

    }

    @FXML
    void tilbake(ActionEvent event) {
        try {
            App.setRoot("menybruker");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<TitledPane> titledPanes;

    private ArrayList<ScrollPane> scrollPanes;

    private ArrayList<ObservableList<? extends Datakomponent>> observableLists;

    private ArrayList<Label> labels;

    private ArrayList<Double> priser;

}
