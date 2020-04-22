package Dataamatorene;

import Dataamatorene.Bestilling.BestillingsRegister;
import Dataamatorene.Comparators.DatakomponentVarekodeComparator;
import Dataamatorene.Datakomponenter.*;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerJobj;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;
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

        Harddisk h = new Harddisk("Hei", 10, 10001,1024);
        h.setBilde(new Image(new FileInputStream("src/main/java/Dataamatorene/Pictures/nia.jpg")));

        ArrayList<Harddisk> liste = new ArrayList<>();
        liste.add(h);

        FileSaver saver = new FileSaverJobj();
        saver.save(liste, "src/main/java/Dataamatorene/Pictures/niabia.jobj");


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
