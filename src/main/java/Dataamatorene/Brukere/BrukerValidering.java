package Dataamatorene.Brukere;

import Dataamatorene.Exceptions.*;


public class BrukerValidering {

    // Metorer for validering av brukerinputt

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

    public static String sjekkValidNavn(String data){
        String navn = data;
        String[] regex = {"[A-ZÆØÅ][a-zæøå]+",
                "[A-ZÆØÅ][a-zæøå]+ [A-ZÆØÅ][a-zæøå]+",
                "[A-ZÆØÅ][a-zæøå]+ [A-ZÆØÅ][a-zæøå]+ [A-ZÆØÅ][a-zæøå]+",
                "[A-ZÆØÅ][a-zæøå]+[-][A-ZÆØÅ][a-zæøå]+ [A-ZÆØÅ][a-zæøå]+",
                "[A-ZÆØÅ][a-zæøå]+ [A-ZÆØÅ][a-zæøå]+[-][A-ZÆØÅ][a-zæøå]+",
                "[A-ZÆØÅ][a-zæøå]+[-][A-ZÆØÅ][a-zæøå]+ [A-ZÆØÅ][a-zæøå]+[-][A-ZÆØÅ][a-zæøå]+",
                "[A-ZÆØÅ][a-zæøå]+ [A-ZÆØÅ][a-zæøå]+ [A-ZÆØÅ][a-zæøå]+ [A-ZÆØÅ][a-zæøå]+"};
        for(String str : regex){
            if(navn.matches(str)){
                return navn;
            }
        }
        throw new InvalidNameException("Navnet du skrev inn er ikke gyldig");
    }

    public static String sjekkValidTelefon(String data) throws InvalidTelefonException {
        String telefon = data;
        String[] regex = {"[0-9]{8}", "[0]{2} [4][7] [0-9]{8}", "[0]{2} [4][7] [0-9]{3} [0-9]{2} [0-9]{3}",
                "[+][4][7] [0-9]{8}", "[+][4][7][0-9]{8}", "[(][+][4][7][)][0-9]{8}", "[(][+][4][7][)] [0-9]{8}",
                "[(][+][4][7][)] [0-9]{2} [0-9]{2} [0-9]{2} [0-9]{2}", "[0][0-9]{4} [0-9]{6}",
                "[+][4]{2} [0-9]{4} [0-9]{6}", "[0-9]{3}-[0-9]{4}", "[(]541[)] [0-9]{3}-[0-9]{4}",
                "[+][1]-[0-9]{3}-[0-9]{3}-[0-9]{4}", "[1]-[0-9]{3}-[0-9]{3}-[0-9]{4}",
                "[0]{2}[1]-[0-9]{3}-[0-9]{3}-[0-9]{4}"};
        for(String Regex:regex){
            if(telefon.matches(Regex)){
                return telefon;
            }

        }
        throw new InvalidTelefonException("Ugyldig telefonnummer");
    }

    public static String sjekkValidEpost(String data) throws InvalidEpostException {
        String[] regex = {"[a-zæøåA-ZÆØÅ0-9.]+[@][a-z]+[.][a-z]+", "[a-zæøåA-ZÆØÅ0-9.]+[@][a-z]+[.][a-z]+[.][a-z]+"};
        for(String str : regex){
            if(data.matches(str)){
                return data;
            }
        }
        throw new InvalidEpostException("Skriv inn en gyldig epost");
    }

}
