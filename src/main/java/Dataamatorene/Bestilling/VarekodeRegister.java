package Dataamatorene.Bestilling;

import Dataamatorene.Datakomponenter.*;
import Dataamatorene.Exceptions.AlreadyTakenVarekodeException;
import Dataamatorene.Exceptions.InvalidVarekodeException;

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

    public static Harddisk chechVarekodeHarddisk(String varekode) {
        for (Harddisk h: KomponentRegister.getHarddiskArrayList()) {
            if (varekode.equals(h.getVarekode())) {
                return h;
            }
        }

        throw new InvalidVarekodeException("Denne varen finnes ikke");
    }

    public static Hovedkort chechVarekodeHovedkort(String varekode) {
        for (Hovedkort h: KomponentRegister.getHovedkortArrayList()) {
            if (varekode.equals(h.getVarekode())) {
                return h;
            }
        }

        throw new InvalidVarekodeException("Denne varen finnes ikke");
    }

    public static Lydkort chechVarekodeLydkort(String varekode) {
        for (Lydkort l: KomponentRegister.getLydkortArrayList()) {
            if (varekode.equals(l.getVarekode())) {
                return l;
            }
        }

        throw new InvalidVarekodeException("Denne varen finnes ikke");
    }

    public static Skjermkort chechVarekodeSkjermkort(String varekode) {
        for (Skjermkort s: KomponentRegister.getSkjermkortArrayList()) {
            if (varekode.equals(s.getVarekode())) {
                return s;
            }
        }

        throw new InvalidVarekodeException("Denne varen finnes ikke");
    }

    public static Prosessor chechVarekodeProsessor(String varekode) {
        for (Prosessor p: KomponentRegister.getProsessorArrayList()) {
            if (varekode.equals(p.getVarekode())) {
                return p;
            }
        }

        throw new InvalidVarekodeException("Denne varen finnes ikke");
    }

    public static Minne chechVarekodeMinne(String varekode) {
        for (Minne m: KomponentRegister.getMinneArrayList()) {
            if (varekode.equals(m.getVarekode())) {
                return m;
            }
        }

        throw new InvalidVarekodeException("Denne varen finnes ikke");
    }

    public static Kabinett chechVarekodeKabinett(String varekode) {
        for (Kabinett k: KomponentRegister.getKabinettArrayList()) {
            if (varekode.equals(k.getVarekode())) {
                return k;
            }
        }

        throw new InvalidVarekodeException("Denne varen finnes ikke");
    }

    public static Skjerm chechVarekodeSkjerm(String varekode) {
        for (Skjerm s: KomponentRegister.getSkjermArrayList()) {
            if (varekode.equals(s.getVarekode())) {
                return s;
            }
        }

        throw new InvalidVarekodeException("Denne varen finnes ikke");
    }

    public static Tastatur chechVarekodeTastatur(String varekode) {
        for (Tastatur t: KomponentRegister.getTastaturArrayList()) {
            if (varekode.equals(t.getVarekode())) {
                return t;
            }
        }

        throw new InvalidVarekodeException("Denne varen finnes ikke");
    }

    public static Mus chechVarekodeMus(String varekode) {
        for (Mus m: KomponentRegister.getMusArrayList()) {
            if (varekode.equals(m.getVarekode())) {
                return m;
            }
        }

        throw new InvalidVarekodeException("Denne varen finnes ikke");
    }



}
