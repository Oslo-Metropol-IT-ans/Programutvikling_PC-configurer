package Dataamatorene.Controllers;

import Dataamatorene.Bestilling.Bestilling;
import Dataamatorene.Datakomponenter.Datakomponent;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class VisBestillingerController {

    private static ArrayList<Bestilling> listeBestillinger;
    private static Bestilling aktivBestilling;

    public static void setListeBestillinger(ArrayList<Bestilling> b) {
        listeBestillinger = b;
    }

    public void initialize() {
        lblLeft.setText("");

        bestillings = FXCollections.observableArrayList(listeBestillinger);
        stringBestilling = FXCollections.observableArrayList();

        for (Bestilling b:listeBestillinger) {
            stringBestilling.add(b.getBestillingsnummerT());
        }
        listBestilling.setOnMouseClicked(mouseEvent -> {
            aktivBestilling = bestillings.get(listBestilling.getSelectionModel().getSelectedIndex());
            lblRight.setText("Totalpris: " + aktivBestilling.getPrisT());
            datakomponents = FXCollections.observableArrayList(new ArrayList<>(Arrays.asList(aktivBestilling.getHarddisk(),
                    aktivBestilling.getHovedkort(), aktivBestilling.getLydkort(), aktivBestilling.getSkjermkort(),
                    aktivBestilling.getProsessor(), aktivBestilling.getMinne(), aktivBestilling.getKabinett(),
                    aktivBestilling.getSkjerm(), aktivBestilling.getTastatur(), aktivBestilling.getMus())));
            if (listKomponent.getSelectionModel().getSelectedItem() != null) {
                visKomponent();
            }
        });

        listBestilling.setItems(stringBestilling);
        listKomponent.setItems(strings);

        listKomponent.setOnMouseClicked(mouseEvent -> {
            visKomponent();
        });


    }

    private void visKomponent() {
        visKomponentInner(listKomponent, datakomponents, lblInfromasjonBestilling, lblLeft, image);
    }

    static void visKomponentInner(JFXListView<String> listKomponent, ObservableList<? extends Datakomponent> datakomponents, Label lblInfromasjonBestilling, Label lblLeft, ImageView image) {
        int index = listKomponent.getSelectionModel().getSelectedIndex();
        var komponent = datakomponents.get(index);
        lblInfromasjonBestilling.setText(komponent.getBeskrivelse());
        lblLeft.setText("Varekode: " + komponent.getVarekode());
        if (komponent.getBilde() != null) {
            image.setImage(komponent.getBilde());
        } else {
            try {
                image.setImage(new Image(new FileInputStream("src/main/resources/Dataamatorene/Pictures/nia.png")));
            } catch (FileNotFoundException e) {
                System.out.println("Bildet ikke tilgjengelig");
                image.setImage(null);
            }
        }
    }

    ObservableList<Bestilling> bestillings;

    ObservableList<String> stringBestilling;

    ObservableList<String> strings = FXCollections.observableArrayList(new ArrayList<String>(Arrays.asList("Harddisk",
            "Hovedkort", "Lydkort", "Skjermkort", "Prosessor", "Minne", "Kabinett", "Skjerm",
            "Tastatur", "Mus")));

    ObservableList<? extends Datakomponent> datakomponents;


    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private JFXListView<String> listKomponent;

    @FXML
    private JFXListView<String> listBestilling;

    @FXML
    private Label lblInfromasjonBestilling;

    @FXML
    private Label lblUt;

    @FXML
    private ImageView image;

    @FXML
    private Label lblLeft;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    private Label lblRight;

}
