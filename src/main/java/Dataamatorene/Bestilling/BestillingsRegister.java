package Dataamatorene.Bestilling;

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
}
