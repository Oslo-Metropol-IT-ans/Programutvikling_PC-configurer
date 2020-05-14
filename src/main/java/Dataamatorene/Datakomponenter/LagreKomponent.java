package Dataamatorene.Datakomponenter;

import Dataamatorene.Comparators.DatakomponentVarekodeComparator;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerJobj;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;
import Dataamatorene.Comparators.*;

import java.io.IOException;
import java.util.ArrayList;

public class LagreKomponent {

    // Metoder for å lagre(jobj) arraylistene til datakomponent
    public static void lagreHarddisk() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getHarddiskArrayList(), "src/main/resources/Dataamatorene/Files/Harddisk.jobj");
    }

    public static void lagreHovedkort() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getHovedkortArrayList(), "src/main/resources/Dataamatorene/Files/Hovedkort.jobj" );
    }

    public static void lagreKabinett() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getKabinettArrayList(), "src/main/resources/Dataamatorene/Files/Kabinett.jobj" );
    }

    public static void lagreLydkort() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getLydkortArrayList(), "src/main/resources/Dataamatorene/Files/Lydkort.jobj" );
    }

    public static void lagreMinne() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getMinneArrayList(), "src/main/resources/Dataamatorene/Files/Minne.jobj" );
    }

    public static void lagreMus() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getMusArrayList(), "src/main/resources/Dataamatorene/Files/Mus.jobj" );
    }

    public static void lagreProsessor() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getProsessorArrayList(), "src/main/resources/Dataamatorene/Files/Prosessor.jobj" );
    }

    public static void lagreSkjerm() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getSkjermArrayList(), "src/main/resources/Dataamatorene/Files/Skjerm.jobj" );
    }

    public static void lagreSkjermkort() throws IOException {
        FileSaver saver = new FileSaverJobj();
        ArrayList<Skjermkort> midlertidig = KomponentRegister.getSkjermkortArrayList();
        midlertidig.sort(new DatakomponentVarekodeComparator());
        saver.save(midlertidig, "src/main/resources/Dataamatorene/Files/Skjermkort.jobj" );
    }

    public static void lagreTastatur() throws IOException {
        FileSaver saver = new FileSaverJobj();
        saver.save(KomponentRegister.getTastaturArrayList(), "src/main/resources/Dataamatorene/Files/Tastatur.jobj" );
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
