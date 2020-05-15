package Dataamatorene.Bestilling;

import Dataamatorene.Comparators.DatakomponentVarekodeComparator;
import Dataamatorene.Datakomponenter.KomponentRegister;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;
import Dataamatorene.Filbehandling.ThreadSaverJobj;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public class BestillingsRegister {

    // Statisk arraylist med bestillingsobjekter
    private static ArrayList<Bestilling> bestillinger = new ArrayList<>();

    // Statiske medtoder for endring og henting av datafeltet
    public static void addBestilling(Bestilling b) {
        bestillinger.add(b);
    }

    public static ArrayList<Bestilling> getBestillinger() {
        return bestillinger;
    }

    public static void setBestillinger(ArrayList<Bestilling> bestillinger) {
        BestillingsRegister.bestillinger = bestillinger;
    }

    // Statisk metode for fillagring(jobj) av bestillinger
    public static void lagreBestillinger(Pane pane) {
        ThreadSaverJobj saver;
        var ordererd = BestillingsRegister.getBestillinger();
        saver = new ThreadSaverJobj(ordererd, "src/main/resources/Dataamatorene/Files/Tastatur.jobj", pane);
        saver.save();
    }
}
