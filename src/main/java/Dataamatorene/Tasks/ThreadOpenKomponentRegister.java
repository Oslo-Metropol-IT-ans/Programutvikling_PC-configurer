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
        updateProgress(1, 22);

        KomponentRegister.setHovedkortArrayList(
                (ArrayList<Hovedkort>) opener.read("src/main/java/Dataamatorene/Files/Hovedkort.jobj"));
        updateProgress(2, 22);

        KomponentRegister.setKabinettArrayList(
                (ArrayList<Kabinett>) opener.read("src/main/java/Dataamatorene/Files/Kabinett.jobj"));
        updateProgress(3, 22);

        KomponentRegister.setLydkortArrayList(
                (ArrayList<Lydkort>) opener.read("src/main/java/Dataamatorene/Files/Lydkort.jobj"));
        updateProgress(4, 22);

        KomponentRegister.setMinneArrayList(
                (ArrayList<Minne>) opener.read("src/main/java/Dataamatorene/Files/Minne.jobj"));
        updateProgress(5, 22);

        KomponentRegister.setMusArrayList(
                (ArrayList<Mus>) opener.read("src/main/java/Dataamatorene/Files/Mus.jobj"));
        updateProgress(6, 22);

        KomponentRegister.setProsessorArrayList(
                (ArrayList<Prosessor>) opener.read("src/main/java/Dataamatorene/Files/Prosessor.jobj"));
        updateProgress(7, 22);

        KomponentRegister.setSkjermArrayList(
                (ArrayList<Skjerm>) opener.read("src/main/java/Dataamatorene/Files/Skjerm.jobj"));
        updateProgress(8, 22);

        KomponentRegister.setSkjermkortArrayList(
                (ArrayList<Skjermkort>) opener.read("src/main/java/Dataamatorene/Files/Skjermkort.jobj"));
        updateProgress(9, 22);

        KomponentRegister.setTastaturArrayList(
                (ArrayList<Tastatur>) opener.read("src/main/java/Dataamatorene/Files/Tastatur.jobj"));
        updateProgress(10, 22);

        for (Harddisk h: KomponentRegister.getHarddiskArrayList()) {
            VarekodeRegister.addVarekode(h.getVarekode());
        } updateProgress(11, 22);

        for (Hovedkort h:KomponentRegister.getHovedkortArrayList()) {
            VarekodeRegister.addVarekode(h.getVarekode());
        } updateProgress(12, 22);

        for (Lydkort l:KomponentRegister.getLydkortArrayList()) {
            VarekodeRegister.addVarekode(l.getVarekode());
        } updateProgress(13, 22);

        for (Skjermkort s:KomponentRegister.getSkjermkortArrayList()) {
            VarekodeRegister.addVarekode(s.getVarekode());
        } updateProgress(14, 22);

        for (Prosessor p:KomponentRegister.getProsessorArrayList()) {
            VarekodeRegister.addVarekode(p.getVarekode());
        } updateProgress(15, 22);

        for (Minne m:KomponentRegister.getMinneArrayList()) {
            VarekodeRegister.addVarekode(m.getVarekode());
        } updateProgress(16, 22);

        for (Kabinett k:KomponentRegister.getKabinettArrayList()) {
            VarekodeRegister.addVarekode(k.getVarekode());
        } updateProgress(17, 22);

        for (Skjerm s:KomponentRegister.getSkjermArrayList()) {
            VarekodeRegister.addVarekode(s.getVarekode());
        } updateProgress(18, 22);

        for (Tastatur t:KomponentRegister.getTastaturArrayList()) {
            VarekodeRegister.addVarekode(t.getVarekode());
        } updateProgress(19, 22);

        for (Mus m:KomponentRegister.getMusArrayList()) {
            VarekodeRegister.addVarekode(m.getVarekode());
        } updateProgress(20, 22);

        BestillingsRegister.setBestillinger((ArrayList<Bestilling>) opener.read("src/main/java/Dataamatorene/Files/Bestillinger.jobj"));
        updateProgress(21, 22);

        if (!BestillingsRegister.getBestillinger().isEmpty()) {
            Bestilling.setTeller(BestillingsRegister.getBestillinger().get(BestillingsRegister.getBestillinger().size()
                    - 1).getBestillingsnummer() + 1);
        } updateProgress(22, 22);

         try{
             Thread.sleep(3000);
         } catch (InterruptedException e){

         }


        return null;
    }
}
