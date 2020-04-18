package Dataamatorene;

import Dataamatorene.Bestilling.BestillingsRegister;
import Dataamatorene.Comparators.DatakomponentVarekodeComparator;
import Dataamatorene.Datakomponenter.Skjerm;
import Dataamatorene.Datakomponenter.Skjermkort;
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

class TestKlasse {
    private String string;

    public TestKlasse(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}

public class TEST {

    static TestKlasse testKlasse = new TestKlasse("Hei");

    static Double tall = 0.0;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<TestKlasse> liste = new ArrayList<>(Arrays.asList(testKlasse));
        liste.get(0).setString("på deg");
        System.out.println(testKlasse.getString());
    }
}
