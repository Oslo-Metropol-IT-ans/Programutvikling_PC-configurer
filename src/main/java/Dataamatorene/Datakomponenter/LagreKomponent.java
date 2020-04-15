package Dataamatorene.Datakomponenter;

import Dataamatorene.Comparators.DatakomponentVarekodeComparator;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;

import java.io.IOException;
import java.util.ArrayList;

public class LagreKomponent {

    public static void lagreHarddisk() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getHarddiskArrayList(), "src/main/java/Dataamatorene/Files/Harddisk.jobj" );
    }

    public static void lagreHovedkort() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getHovedkortArrayList(), "src/main/java/Dataamatorene/Files/Hovedkort.jobj" );
    }

    public static void lagreKabinett() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getKabinettArrayList(), "src/main/java/Dataamatorene/Files/Kabinett.jobj" );
    }

    public static void lagreLydkort() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getLydkortArrayList(), "src/main/java/Dataamatorene/Files/Lydkort.jobj" );
    }

    public static void lagreMinne() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getMinneArrayList(), "src/main/java/Dataamatorene/Files/Minne.jobj" );
    }

    public static void lagreMus() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getMusArrayList(), "src/main/java/Dataamatorene/Files/Mus.jobj" );
    }

    public static void lagreProsessor() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getProsessorArrayList(), "src/main/java/Dataamatorene/Files/Prosessor.jobj" );
    }

    public static void lagreSkjerm() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getSkjermArrayList(), "src/main/java/Dataamatorene/Files/Skjerm.jobj" );
    }

    public static void lagreSkjermkort() throws IOException {
        FileSaver saver = new FileSaverJobj();
        ArrayList<Skjermkort> midlertidig = KomponentRegister.getSkjermkortArrayList();
        midlertidig.sort(new DatakomponentVarekodeComparator());
        saver.save(midlertidig, "src/main/java/Dataamatorene/Files/Skjermkort.jobj" );
    }

    public static void lagreTastatur() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getTastaturArrayList(), "src/main/java/Dataamatorene/Files/Tastatur.jobj" );
    }

    public static void lagreAlle() throws IOException {
        lagreHarddisk();
        lagreHovedkort();
        lagreKabinett();
        lagreLydkort();
        lagreMinne();
        lagreMus();
        lagreProsessor();
        lagreSkjerm();
        lagreSkjermkort();
        lagreTastatur();
    }

}
