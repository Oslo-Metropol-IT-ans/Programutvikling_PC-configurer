package Dataamatorene;

import Dataamatorene.Bestilling.BestillingsRegister;
import Dataamatorene.Comparators.DatakomponentVarekodeComparator;
import Dataamatorene.Datakomponenter.*;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerJobj;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TEST {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Harddisk h = new Harddisk("Hei", 10, 10001, null,1024);
        h.setBilde(new Image(new FileInputStream("src/main/java/Dataamatorene/Pictures/i9.jpg")));
        Harddisk h2 = new Harddisk("På", 100, 10002, null, 1024);
        h2.setBilde(new Image(new FileInputStream("src/main/java/Dataamatorene/Pictures/nia.jpg")));
        Harddisk h3 = new Harddisk("Deg", 1000, 10003, null, 1024);

        ArrayList<Harddisk> liste = new ArrayList<>();
        liste.add(h);
        liste.add(h2);
        liste.add(h3);

        ObservableList<Harddisk> oListe = FXCollections.observableArrayList(liste);

    }

    /*
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        bilde = SwingFXUtils.toFXImage(ImageIO.read(s), null);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        ImageIO.write(SwingFXUtils.fromFXImage(bilde, null), "jpg", s);
    }

     */

}
