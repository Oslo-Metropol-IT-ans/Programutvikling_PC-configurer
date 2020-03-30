package Dataamatorene.Datakomponenter;

import Dataamatorene.Exceptions.InvalidComponentAttributeException;
import Dataamatorene.Exceptions.InvalidPrisException;
import Dataamatorene.Exceptions.InvalidVarekodeException;

public class KomponentValidering {

    public static String navnValidering (String s) {
        if (s.matches("[A-Z][a-zA-Z \\-0-9]+")) {
            return s;
        } else throw new InvalidComponentAttributeException("Ugyldig navn");
    }

    public static double prisValidering (String s) {
        if (s.matches("[0-9.]+")) {
            return Double.parseDouble(s);
        } else {
            throw new InvalidPrisException("Ugyldig pris");
        }
    }

    public static int varekodeValidering (String s) {
        if (s.matches("[0-9]{5}")) {
            return Integer.parseInt(s);
        } else throw new InvalidVarekodeException("Ugyldig varekode");
    }

    public static int lagringValidering (String s) {
        if (s.matches("[0-9]+")) {
            return Integer.parseInt(s);
        } else throw new InvalidComponentAttributeException("Ugyldig lagring");
    }

    public static int porterValidering (String s) {
        if (s.matches("[0-9]+")) {
            int porter = Integer.parseInt(s);
            if (porter > 0 && porter < 30) {
                return porter;
            } else throw new InvalidComponentAttributeException("Ugyldig antall porter");

        } else throw new InvalidComponentAttributeException("Ugyldig antall porter");
    }

    public static String størrelseValidering (String s) {
        String[] tall = s.split("[x]");
        if (tall.length == 3) {
            if (tall[0].matches("[0-9]+") && tall[1].matches("[0-9]+") && tall[2].matches("[0-9]+")) {
                return s;
            } else throw new InvalidComponentAttributeException("Ugyldig størrelse");
        } else throw new InvalidComponentAttributeException("Ugyldig størrelse");
    }

    public static int vifterValidering (String s) {
        if (s.matches("[0-9]+")) {
            int vifter = Integer.parseInt(s);
            if (vifter > 0 && vifter < 8) {
                return vifter;
            } else throw new InvalidComponentAttributeException("Ugyldig antall vifter");

        } else throw new InvalidComponentAttributeException("Ugyldig antall vifter");
    }

    public static double frekvensValidering (String s) {
        if (s.matches("[1-9]{1}[.][0-9]{1}")) {
            return Double.parseDouble(s);
        } else throw new InvalidComponentAttributeException("Ugyldig frekvens");
    }

    public static int ramValidering (String s) {
        if (s.matches("[0-9]+")) {
            int ram = Integer.parseInt(s);
            if (ram%4 == 0){
                return ram;
            } else throw new InvalidComponentAttributeException("Ugyldig ram");
        } else throw new InvalidComponentAttributeException("Ugyldig ram");
    }

    public static int knapperValidering (String s) {
        if (s.matches("[0-9]+")) {
            int knapper = Integer.parseInt(s);
            if (knapper > 0 && knapper < 20) {
                return knapper;
            } else throw new InvalidComponentAttributeException("Ugyldig antall knapper");

        } else throw new InvalidComponentAttributeException("Ugyldig antall knapper");
    }

    public static int kjernerValidering (String s) {
        if (s.matches("[0-9]+")) {
            int kjerner = Integer.parseInt(s);
            if (kjerner > 1 && kjerner < 65 && (kjerner%4 == 0 || kjerner == 2)) {
                return kjerner;
            } else throw new InvalidComponentAttributeException("Ugyldig antall kjerner");

        } else throw new InvalidComponentAttributeException("Ugyldig antall kjerner");
    }

    public static int tråderValidering (String s) {
        if (s.matches("[0-9]+")) {
            int tråder = Integer.parseInt(s);
            if (tråder > 3 && tråder < 129 && tråder%4 == 0) {
                return tråder;
            } else throw new InvalidComponentAttributeException("Ugyldig antall tråder");

        } else throw new InvalidComponentAttributeException("Ugyldig antall tråder");
    }

    public static String oppløsningValidering (String s) {
        String[] tall = s.split("[x]");
        if(tall.length == 2){
            if(tall[0].matches("[0-9]+") && tall[1].matches("[0-9]+")) {
                return s;
            } else throw new InvalidComponentAttributeException("Ugyldig oppløsning");
        } else throw new InvalidComponentAttributeException("Ugyldig oppløsning");
    }

    public static double skjermstørrelseValidering (String s) {
        if (s.matches("[0-9.]+")) {
            double størrelse = Double.parseDouble(s);
            if (størrelse > 12 && størrelse < 60) {
                return størrelse;
            } else throw new InvalidComponentAttributeException("Ugyldig skjermstørrelse");
        } else throw new InvalidComponentAttributeException("Ugyldig skjermstørrelse");
    }

    public static boolean booleanValidering (String s) {
        if(s.equalsIgnoreCase("true")) return true;
        else if(s.equalsIgnoreCase("false")) return false;
        else throw new InvalidComponentAttributeException("Ugyldig verdi");
    }



}
