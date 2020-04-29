package Dataamatorene.Filbehandling;

import Dataamatorene.Bestilling.Bestilling;
import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Datakomponenter.*;
import Dataamatorene.Exceptions.InvalidBrukerException;

import java.util.IllegalFormatException;
import java.util.InvalidPropertiesFormatException;

public class Converter {

    public static Bestilling parseBestilling(String bestilling) throws InvalidPropertiesFormatException {
        String[] spilt = bestilling.split("\t");
        if (spilt.length != 13) {
            throw new InvalidPropertiesFormatException("Ugyldig format");
        }
        try {
            Bruker b = finnBruker(spilt[0]);
            Harddisk h = finnHarddisk(spilt[1]);
            Hovedkort h1 = finnHovedkort(spilt[2]);
            Lydkort l = finnLydkort(spilt[3]);
            Skjermkort s = finnSkjermkort(spilt[4]);
            Prosessor p = finnProsessor(spilt[5]);
            Minne m = finnMinne(spilt[6]);
            Kabinett k = finnKabientt(spilt[7]);
            Skjerm s1 = finnSkjerm(spilt[8]);
            Tastatur t = finnTastatur(spilt[9]);
            Mus m1 = finnMus(spilt[10]);
            String bestillingsnummer = spilt[11];
            Bestilling b2 = new Bestilling(b, h, h1, l, s, p, m, k ,s1, t,m1);
            b2.setBestillingsnummer(Integer.parseInt(bestillingsnummer));
            return b2;

        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    private static Bruker finnBruker(String inn) {
        for (Bruker b : BrukerRegister.getBrukere()) {
            if (b.getBrukernavn().equalsIgnoreCase(inn)) {
                return b;
            }
        }
         throw new InvalidBrukerException("Brukeren finnes ikke");
    }

    private static Harddisk finnHarddisk(String inn) {
        for (Harddisk h: KomponentRegister.getHarddiskArrayList()) {
            if (h.getVarekode().equals("0" + inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Harddisken finnes ikke");
    }

    private static Hovedkort finnHovedkort(String inn) {
        for (Hovedkort h: KomponentRegister.getHovedkortArrayList()) {
            if (h.getVarekode().equals("0" +inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Hovedkortet finnes ikke");
    }

    private static Skjermkort finnSkjermkort(String inn) {
        for (Skjermkort h: KomponentRegister.getSkjermkortArrayList()) {
            if (h.getVarekode().equals("0" +inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Skjermkortet finnes ikke");
    }

    private static Lydkort finnLydkort(String inn) {
        for (Lydkort h: KomponentRegister.getLydkortArrayList()) {
            if (h.getVarekode().equals("0" +inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Lydkortet finnes ikke");
    }

    private static Prosessor finnProsessor(String inn) {
        for (Prosessor h: KomponentRegister.getProsessorArrayList()) {
            if (h.getVarekode().equals("0" +inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Prosessoren finnes ikke");
    }

    private static Minne finnMinne(String inn) {
        for (Minne h: KomponentRegister.getMinneArrayList()) {
            if (h.getVarekode().equals("0" +inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Minnet finnes ikke");
    }

    private static Kabinett finnKabientt(String inn) {
        for (Kabinett h: KomponentRegister.getKabinettArrayList()) {
            if (h.getVarekode().equals("0" +inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Kabinettet finnes ikke");
    }

    private static Skjerm finnSkjerm(String inn) {
        for (Skjerm h: KomponentRegister.getSkjermArrayList()) {
            if (h.getVarekode().equals("0" +inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Skjermen finnes ikke");
    }

    private static Tastatur finnTastatur(String inn) {
        for (Tastatur h: KomponentRegister.getTastaturArrayList()) {
            if (h.getVarekode().equals("0" +inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Tastaturet finnes ikke");
    }

    private static Mus finnMus(String inn) {
        for (Mus h: KomponentRegister.getMusArrayList()) {
            if (h.getVarekode().equals(inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Musen finnes ikke");
    }
}
