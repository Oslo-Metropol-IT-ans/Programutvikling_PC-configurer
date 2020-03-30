package Dataamatorene.Bestilling;

import Dataamatorene.Exceptions.AlreadyTakenVarekodeException;

import java.util.ArrayList;

public class VarekodeRegister {

    private static ArrayList<String> varekoder = new ArrayList<>();

    public static void addVarekode(String v){
        varekoder.add(v);
    }

    public static ArrayList<String> getVarekoder() {
        return varekoder;
    }

    public static void setVarekoder(ArrayList<String> varekoder1) {
        varekoder = varekoder1;
    }

    public static void checkVarekode (int varekode) throws AlreadyTakenVarekodeException {
        boolean finnes = false;
        for(String v:varekoder) {
            if(v.equals(String.valueOf(varekode))) {
                finnes = true;
            }
        }

        if (!finnes) return;
        else throw new AlreadyTakenVarekodeException("Denne varekoden finnes allerede");
    }
}
