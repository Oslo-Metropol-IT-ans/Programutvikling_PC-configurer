package Dataamatorene.Bestilling;

import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;

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
    public static void lagreBestillinger() {
        try {
            FileSaver saver = new FileSaverJobj();
            saver.save(bestillinger, "src/main/resources/Dataamatorene/Files/Bestillinger.jobj");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
