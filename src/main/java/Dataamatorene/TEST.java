package Dataamatorene;

import Dataamatorene.Bestilling.Bestilling;
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
import java.util.*;

public class TEST {
    public static void main(String[] args) {
        BestillingsRegister.setBestillinger(new ArrayList<>());
        BestillingsRegister.lagreBestillinger();

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
