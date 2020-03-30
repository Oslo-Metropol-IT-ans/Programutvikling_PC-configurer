package Dataamatorene.Tasks;

import Dataamatorene.Bestilling.Bestilling;
import Dataamatorene.Bestilling.BestillingsRegister;
import Dataamatorene.Bestilling.VarekodeRegister;
import Dataamatorene.Datakomponenter.*;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerJobj;
import javafx.concurrent.Task;

import java.util.ArrayList;

public class ThreadOpenKomponentRegister extends Task<Void> {

    @Override
    protected Void call() throws Exception {
        FileOpener opener = new FileOpenerJobj();

        KomponentRegister.setHarddiskArrayList(
                (ArrayList<Harddisk>) opener.read("src/main/java/Dataamatorene/Files/Harddisk.jobj"));
        KomponentRegister.setHovedkortArrayList(
                (ArrayList<Hovedkort>) opener.read("src/main/java/Dataamatorene/Files/Hovedkort.jobj"));
        KomponentRegister.setKabinettArrayList(
                (ArrayList<Kabinett>) opener.read("src/main/java/Dataamatorene/Files/Kabinett.jobj"));
        KomponentRegister.setLydkortArrayList(
                (ArrayList<Lydkort>) opener.read("src/main/java/Dataamatorene/Files/Lydkort.jobj"));
        KomponentRegister.setMinneArrayList(
                (ArrayList<Minne>) opener.read("src/main/java/Dataamatorene/Files/Minne.jobj"));
        KomponentRegister.setMusArrayList(
                (ArrayList<Mus>) opener.read("src/main/java/Dataamatorene/Files/Mus.jobj"));
        KomponentRegister.setProsessorArrayList(
                (ArrayList<Prosessor>) opener.read("src/main/java/Dataamatorene/Files/Prosessor.jobj"));
        KomponentRegister.setSkjermArrayList(
                (ArrayList<Skjerm>) opener.read("src/main/java/Dataamatorene/Files/Skjerm.jobj"));
        KomponentRegister.setSkjermkortArrayList(
                (ArrayList<Skjermkort>) opener.read("src/main/java/Dataamatorene/Files/Skjermkort.jobj"));
        KomponentRegister.setTastaturArrayList(
                (ArrayList<Tastatur>) opener.read("src/main/java/Dataamatorene/Files/Tastatur.jobj"));

        for (Harddisk h: KomponentRegister.getHarddiskArrayList()) {
            VarekodeRegister.addVarekode(h.getVarekode());
        }

        for (Hovedkort h:KomponentRegister.getHovedkortArrayList()) {
            VarekodeRegister.addVarekode(h.getVarekode());
        }

        for (Lydkort l:KomponentRegister.getLydkortArrayList()) {
            VarekodeRegister.addVarekode(l.getVarekode());
        }

        for (Skjermkort s:KomponentRegister.getSkjermkortArrayList()) {
            VarekodeRegister.addVarekode(s.getVarekode());
        }

        for (Prosessor p:KomponentRegister.getProsessorArrayList()) {
            VarekodeRegister.addVarekode(p.getVarekode());
        }

        for (Minne m:KomponentRegister.getMinneArrayList()) {
            VarekodeRegister.addVarekode(m.getVarekode());
        }

        for (Kabinett k:KomponentRegister.getKabinettArrayList()) {
            VarekodeRegister.addVarekode(k.getVarekode());
        }

        for (Skjerm s:KomponentRegister.getSkjermArrayList()) {
            VarekodeRegister.addVarekode(s.getVarekode());
        }

        for (Tastatur t:KomponentRegister.getTastaturArrayList()) {
            VarekodeRegister.addVarekode(t.getVarekode());
        }

        for (Mus m:KomponentRegister.getMusArrayList()) {
            VarekodeRegister.addVarekode(m.getVarekode());
        }

        BestillingsRegister.setBestillinger((ArrayList<Bestilling>) opener.read("src/main/java/Dataamatorene/Files/Bestillinger.jobj"));

        if (!BestillingsRegister.getBestillinger().isEmpty()) {
            Bestilling.setTeller(BestillingsRegister.getBestillinger().get(BestillingsRegister.getBestillinger().size()
                    - 1).getBestillingsnummer() + 1);
        }

         try{
             Thread.sleep(3000);
         } catch (InterruptedException e){

         }


        return null;
    }
}
