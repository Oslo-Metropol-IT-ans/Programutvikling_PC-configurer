package Dataamatorene.Brukere;

import Dataamatorene.Exceptions.*;


public class BrukerValidering {

    public static String sjekkBrukernavn(String brukernavn) {

        boolean minst = brukernavn.length() >= 4;
        boolean maks = brukernavn.length() < 16;
        boolean mellomrom = brukernavn.contains(" ");

        if(minst && maks && !mellomrom){
            return brukernavn;
        }
        else throw new InvalidBrukerException("Ugyldig brukernavn");
    }

    public static String sjekkPassord(String passord) {
        boolean stor = false; boolean liten = false; boolean tall = false; boolean lengde = passord.length() >= 8;

        for(int i = 0; i < passord.length(); i++){
            String verdi = String.valueOf(passord.charAt(i));
            if (verdi.matches("[A-ZÆØÅ]")){
                stor = true;
            }
            if (verdi.matches("[a-zæøå]")){
                liten = true;
            }
            if (verdi.matches("[0-9]")){
                tall = true;
            }
        }

        if(liten && stor && tall && lengde){
            return passord;
        }
        else throw new InvalidPasswordException("Ugyldig passord");

    }

    public static String sjekkRettigheter(String rettigheter){
        if(rettigheter.equalsIgnoreCase("admin") || rettigheter.equalsIgnoreCase("bruker")){
            return rettigheter;
        }
        else throw new IllegalArgumentException("Ugyldig rettigheter");
    }

}
