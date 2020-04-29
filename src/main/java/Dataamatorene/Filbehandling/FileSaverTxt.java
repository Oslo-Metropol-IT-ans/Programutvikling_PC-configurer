package Dataamatorene.Filbehandling;

import Dataamatorene.Bestilling.Bestilling;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileSaverTxt implements FileSaver { // lagrer filer av type txt
    public void save(ArrayList<? extends Serializable> liste, String path) throws IOException {

    }

    public void saveBestillingerBruker(ArrayList<Bestilling> liste, String path) throws IOException {
        String ut = "Harddisk" + "\t" + "Hovedkort" + "\t" + "Lydkort" + "\t" + "Skjermkort" + "\t" +
                "Prosessor" + "\t" + "Minne" + "\t" + "Kabinett" + "\t" + "Skjerm" + "\t" + "Tastatur" + "\t" +
                "Mus" + "\t" + "Bestillingsnummer" + "\t" + "Totalpris" + "\n";
        for (Bestilling b:liste) {
            ut += b.getHarddiskT() + "\t" + b.getHovedkortT() + "\t" + b.getLydkortT() + "\t" + b.getSkjermkortT() +
                    "\t" + b.getProsessorT() + "\t" + b.getMinneT() + "\t" + b.getKabinettT() + "\t" +
                    b.getSkjermT() + "\t" + b.getTastaturT() + "\t" + b.getMusT() + "\t" + b.getBestillingsnummerT() +
                    "\t" + b.getPrisT() + "\n";
        }
        Path paths = Paths.get(path);
        Files.write(paths, ut.getBytes());

    }

    public void saveBestilingerAdmin(ArrayList<Bestilling> liste, String path) throws IOException {
        String ut = "Bruker" + "\t" + "Harddisk" + "\t" + "Hovedkort" + "\t" + "Lydkort" + "\t" + "Skjermkort" + "\t" +
                "Prosessor" + "\t" + "Minne" + "\t" + "Kabinett" + "\t" + "Skjerm" + "\t" + "Tastatur" + "\t" +
                "Mus" + "\t" + "Bestillingsnummer" + "\t" + "Totalpris" + "\n";
        for (Bestilling b : liste) {
            ut += b.getBrukerT() + "\t" + b.getHarddiskT() + "\t" + b.getHovedkortT() + "\t" + b.getLydkortT() + "\t" + b.getSkjermkortT() +
                    "\t" + b.getProsessorT() + "\t" + b.getMinneT() + "\t" + b.getKabinettT() + "\t" +
                    b.getSkjermT() + "\t" + b.getTastaturT() + "\t" + b.getMusT() + "\t" + b.getBestillingsnummerT() +
                    "\t" + b.getPrisT() + "\n";
        }
        Path paths = Paths.get(path);
        Files.write(paths, ut.getBytes());
    }
}
