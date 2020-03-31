package Dataamatorene.Bestilling;

import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;

import java.io.IOException;
import java.util.ArrayList;

public class BestillingsRegister {

    private static ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public static void addBestilling(Bestilling b) {
        bestillinger.add(b);
    }

    public static ArrayList<Bestilling> getBestillinger() {
        return bestillinger;
    }

    public static void setBestillinger(ArrayList<Bestilling> bestillinger) {
        BestillingsRegister.bestillinger = bestillinger;
    }

    public static void lagreBestillinger() {
        try {
            FileSaver saver = new FileSaverJobj();
            saver.save(bestillinger, "src/main/java/Dataamatorene/Files/Bestillinger.jobj");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
