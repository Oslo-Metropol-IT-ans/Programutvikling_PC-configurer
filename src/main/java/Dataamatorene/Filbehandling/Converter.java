package Dataamatorene.Filbehandling;

import Dataamatorene.Bestilling.Bestilling;
import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Datakomponenter.*;
import Dataamatorene.Exceptions.InvalidBrukerException;
import org.jetbrains.annotations.NotNull;

import java.util.IllegalFormatException;
import java.util.InvalidPropertiesFormatException;

public class Converter {

    public static Bestilling parseBestilling(String bestilling) throws InvalidPropertiesFormatException {
        String[] spilt = bestilling.split("\t");

        if (spilt.length == 13) {
            try {
                Bruker b = finnBruker(spilt[0]);
                return getBestilling(spilt, b, 0);

            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        else if (spilt.length == 12) {
            try {
                Bruker b = BrukerRegister.getAktivBruker();
                return getBestilling(spilt, b, 1);

            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        else {
            throw new InvalidPropertiesFormatException("Ugyldig format");
        }


    }

    @NotNull
    private static Bestilling getBestilling(String[] spilt, Bruker b, int i) {
        Harddisk h = finnHarddisk(spilt[1 - i]);
        Hovedkort h1 = finnHovedkort(spilt[2 - i]);
        Lydkort l = finnLydkort(spilt[3 - i]);
        Skjermkort s = finnSkjermkort(spilt[4 - i]);
        Prosessor p = finnProsessor(spilt[5 - i]);
        Minne m = finnMinne(spilt[6 - i]);
        Kabinett k = finnKabientt(spilt[7 - i]);
        Skjerm s1 = finnSkjerm(spilt[8 - i]);
        Tastatur t = finnTastatur(spilt[9 - i]);
        Mus m1 = finnMus(spilt[10 - i]);
        String bestillingsnummer = spilt[11 - i];
        Bestilling b2 = new Bestilling(b, h, h1, l, s, p, m, k ,s1, t,m1);
        b2.setBestillingsnummer(Integer.parseInt(bestillingsnummer));
        return b2;
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
            if (h.getVarekode().equals(inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Harddisken finnes ikke");
    }

    private static Hovedkort finnHovedkort(String inn) {
        for (Hovedkort h: KomponentRegister.getHovedkortArrayList()) {
            if (h.getVarekode().equals(inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Hovedkortet finnes ikke");
    }

    private static Skjermkort finnSkjermkort(String inn) {
        for (Skjermkort h: KomponentRegister.getSkjermkortArrayList()) {
            if (h.getVarekode().equals(inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Skjermkortet finnes ikke");
    }

    private static Lydkort finnLydkort(String inn) {
        for (Lydkort h: KomponentRegister.getLydkortArrayList()) {
            if (h.getVarekode().equals(inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Lydkortet finnes ikke");
    }

    private static Prosessor finnProsessor(String inn) {
        for (Prosessor h: KomponentRegister.getProsessorArrayList()) {
            if (h.getVarekode().equals(inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Prosessoren finnes ikke");
    }

    private static Minne finnMinne(String inn) {
        for (Minne h: KomponentRegister.getMinneArrayList()) {
            if (h.getVarekode().equals(inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Minnet finnes ikke");
    }

    private static Kabinett finnKabientt(String inn) {
        for (Kabinett h: KomponentRegister.getKabinettArrayList()) {
            if (h.getVarekode().equals(inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Kabinettet finnes ikke");
    }

    private static Skjerm finnSkjerm(String inn) {
        for (Skjerm h: KomponentRegister.getSkjermArrayList()) {
            if (h.getVarekode().equals(inn)) {
                return h;
            }
        }
        throw new IllegalArgumentException("Skjermen finnes ikke");
    }

    private static Tastatur finnTastatur(String inn) {
        for (Tastatur h: KomponentRegister.getTastaturArrayList()) {
            if (h.getVarekode().equals(inn)) {
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
