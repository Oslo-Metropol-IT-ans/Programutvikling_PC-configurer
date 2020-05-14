package Dataamatorene.Controllers;

import Dataamatorene.Bestilling.Bestilling;
import Dataamatorene.Datakomponenter.Datakomponent;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class VisBestillingController {

    private static Bestilling aktivBestilling;
    private static String melding;

    private static boolean test = false;

    public static void setAktivBestilling(Bestilling bestilling) {
        aktivBestilling = bestilling;
        melding = "";
        test = true;
    }

    public static void setAktivBestilling(Bestilling bestilling, String meldingInn) {
        aktivBestilling = bestilling;
        melding = meldingInn;
    }

    protected Bestilling b;

    public void initialize() {
        test = false;
        lblRight.setText("Totalpris: " + aktivBestilling.getPrisT());
        lblLeft.setText("");
        lblUt.setText(melding);

        datakomponents = FXCollections.observableArrayList(new ArrayList<>(Arrays.asList(aktivBestilling.getHarddisk(),
                aktivBestilling.getHovedkort(), aktivBestilling.getLydkort(), aktivBestilling.getSkjermkort(),
                aktivBestilling.getProsessor(), aktivBestilling.getMinne(), aktivBestilling.getKabinett(),
                aktivBestilling.getSkjerm(), aktivBestilling.getTastatur(), aktivBestilling.getMus())));

        list.setItems(strings);

        list.setOnMouseClicked(mouseEvent -> {
            VisBestillingerController.visKomponentInner(list, datakomponents, lblInfromasjonBestilling, lblLeft, image);
        });

        for (Node n: testVbox.getChildren()) {
            n.setOnMouseMoved(mouseEvent -> {
                if (test) {
                    initialize();
                    if (list.getSelectionModel().getSelectedItem() != null) {
                        VisBestillingerController
                                .visKomponentInner(list, datakomponents, lblInfromasjonBestilling, lblLeft, image);
                    }

                    test = false;
                }
            });
        }

    }



    ObservableList<String> strings = FXCollections.observableArrayList(new ArrayList<>(Arrays.asList("Harddisk",
            "Hovedkort", "Lydkort", "Skjermkort", "Prosessor", "Minne", "Kabinett", "Skjerm",
            "Tastatur", "Mus")));

    ObservableList<? extends Datakomponent> datakomponents;

    @FXML
    private VBox testVbox;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private JFXListView<String> list;

    @FXML
    private Label lblInfromasjonBestilling;

    @FXML
    private ImageView image;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    private Label lblRight;

    @FXML
    private Label lblLeft;

    @FXML
    private Label lblUt;

}
