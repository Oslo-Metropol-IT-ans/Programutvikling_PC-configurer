package Dataamatorene.Datakomponenter;

import Dataamatorene.Comparators.DatakomponentVarekodeComparator;
import Dataamatorene.Filbehandling.*;
import Dataamatorene.Comparators.*;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public class LagreKomponent {

    static ThreadSaverJobj saver;

    // Metoder for å lagre(jobj) arraylistene til datakomponent
    public static void lagreHarddisk(Pane pane) throws IOException {
        var ordererd = KomponentRegister.getHarddiskArrayList();
        ordererd.sort(new DatakomponentVarekodeComparator());
        saver = new ThreadSaverJobj(ordererd, "src/main/resources/Dataamatorene/Files/Harddisk.jobj", pane);
        saver.save();
    }

    public static void lagreHovedkort(Pane pane) throws IOException {
        var ordererd = KomponentRegister.getHovedkortArrayList();
        ordererd.sort(new DatakomponentVarekodeComparator());
        saver = new ThreadSaverJobj(ordererd, "src/main/resources/Dataamatorene/Files/Hovedkort.jobj", pane);
        saver.save();
    }

    public static void lagreKabinett(Pane pane) throws IOException {
        var ordererd = KomponentRegister.getKabinettArrayList();
        ordererd.sort(new DatakomponentVarekodeComparator());
        saver = new ThreadSaverJobj(ordererd, "src/main/resources/Dataamatorene/Files/Kabinett.jobj", pane);
        saver.save();
    }

    public static void lagreLydkort(Pane pane) throws IOException {
        var ordererd = KomponentRegister.getLydkortArrayList();
        ordererd.sort(new DatakomponentVarekodeComparator());
        saver = new ThreadSaverJobj(ordererd, "src/main/resources/Dataamatorene/Files/Lydkort.jobj", pane);
        saver.save();
    }

    public static void lagreMinne(Pane pane) throws IOException {
        var ordererd = KomponentRegister.getMinneArrayList();
        ordererd.sort(new DatakomponentVarekodeComparator());
        saver = new ThreadSaverJobj(ordererd, "src/main/resources/Dataamatorene/Files/Minne.jobj", pane);
        saver.save();
    }

    public static void lagreMus(Pane pane) throws IOException {
        var ordererd = KomponentRegister.getMusArrayList();
        ordererd.sort(new DatakomponentVarekodeComparator());
        saver = new ThreadSaverJobj(ordererd, "src/main/resources/Dataamatorene/Files/Mus.jobj", pane);
        saver.save();
    }

    public static void lagreProsessor(Pane pane) throws IOException {
        var ordererd = KomponentRegister.getProsessorArrayList();
        ordererd.sort(new DatakomponentVarekodeComparator());
        saver = new ThreadSaverJobj(ordererd, "src/main/resources/Dataamatorene/Files/Prosessor.jobj", pane);
        saver.save();
    }

    public static void lagreSkjerm(Pane pane) throws IOException {
        var ordererd = KomponentRegister.getSkjermArrayList();
        ordererd.sort(new DatakomponentVarekodeComparator());
        saver = new ThreadSaverJobj(ordererd, "src/main/resources/Dataamatorene/Files/Skjerm.jobj", pane);
        saver.save();
    }

    public static void lagreSkjermkort(Pane pane) throws IOException {
        var ordererd = KomponentRegister.getSkjermkortArrayList();
        ordererd.sort(new DatakomponentVarekodeComparator());
        saver = new ThreadSaverJobj(ordererd, "src/main/resources/Dataamatorene/Files/Skjermkort.jobj", pane);
        saver.save();
    }

    public static void lagreTastatur(Pane pane) throws IOException {
        var ordererd = KomponentRegister.getTastaturArrayList();
        ordererd.sort(new DatakomponentVarekodeComparator());
        saver = new ThreadSaverJobj(ordererd, "src/main/resources/Dataamatorene/Files/Tastatur.jobj", pane);
        saver.save();
    }

    public static void lagreAlle(Pane pane) throws IOException {
        lagreHarddisk(pane);
        lagreHovedkort(pane);
        lagreKabinett(pane);
        lagreLydkort(pane);
        lagreMinne(pane);
        lagreMus(pane);
        lagreProsessor(pane);
        lagreSkjerm(pane);
        lagreSkjermkort(pane);
        lagreTastatur(pane);
    }

}
