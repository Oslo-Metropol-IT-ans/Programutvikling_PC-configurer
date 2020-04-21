package Dataamatorene;

import Dataamatorene.Bestilling.BestillingsRegister;
import Dataamatorene.Comparators.DatakomponentVarekodeComparator;
import Dataamatorene.Datakomponenter.KomponentRegister;
import Dataamatorene.Datakomponenter.Skjerm;
import Dataamatorene.Datakomponenter.Skjermkort;
import Dataamatorene.Datakomponenter.Tastatur;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerJobj;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TEST {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOpener opener = new FileOpenerJobj();

        var liste = opener.read("src/main/java/Dataamatorene/Files/Tastatur.jobj");
        KomponentRegister.setTastaturArrayList((ArrayList<Tastatur>) liste);
        for (Tastatur t:KomponentRegister.getTastaturArrayList()) {
            System.out.println(t.getVarekode());
        }
    }

}
