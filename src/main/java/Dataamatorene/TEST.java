package Dataamatorene;

import Dataamatorene.Bestilling.BestillingsRegister;
import Dataamatorene.Comparators.SkjermkortVarekodeComparator;
import Dataamatorene.Datakomponenter.Skjerm;
import Dataamatorene.Datakomponenter.Skjermkort;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerJobj;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TEST {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOpener opener = new FileOpenerJobj();
        ArrayList<Skjermkort> liste = (ArrayList<Skjermkort>) opener.read("src/main/java/Dataamatorene/Files/Skjermkort.jobj");
        Collections.sort(liste);

        SkjermkortVarekodeComparator test = new SkjermkortVarekodeComparator();
        liste.sort(test);

        for (Skjermkort s:liste) {
            System.out.println(s.getVarekode() + " " + s.getNavn());
        }
    }
}
