package Dataamatorene.Tasks;

import Dataamatorene.Bestilling.Bestilling;
import Dataamatorene.Bestilling.BestillingsRegister;
import Dataamatorene.Bestilling.VarekodeRegister;
import Dataamatorene.Datakomponenter.*;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerJobj;
import javafx.concurrent.Task;

import java.util.ArrayList;

public class ThreadOpenKomponentRegister2 extends Task<Void> {

    @Override
    protected Void call() throws Exception {
        FileOpener opener = new FileOpenerJobj();

        updateMessage("Laster harddisker");
        KomponentRegister.setHarddiskArrayList(
                (ArrayList<Harddisk>) opener.read("src/main/java/Dataamatorene/Files/Harddisk.jobj"));
        updateProgress(1, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Laster hovedkort");
        KomponentRegister.setHovedkortArrayList(
                (ArrayList<Hovedkort>) opener.read("src/main/java/Dataamatorene/Files/Hovedkort.jobj"));
        updateProgress(2, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Laster kabinett");
        KomponentRegister.setKabinettArrayList(
                (ArrayList<Kabinett>) opener.read("src/main/java/Dataamatorene/Files/Kabinett.jobj"));
        updateProgress(3, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Laster lydkort");
        KomponentRegister.setLydkortArrayList(
                (ArrayList<Lydkort>) opener.read("src/main/java/Dataamatorene/Files/Lydkort.jobj"));
        updateProgress(4, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Later minne");
        KomponentRegister.setMinneArrayList(
                (ArrayList<Minne>) opener.read("src/main/java/Dataamatorene/Files/Minne.jobj"));
        updateProgress(5, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Laster muser");
        KomponentRegister.setMusArrayList(
                (ArrayList<Mus>) opener.read("src/main/java/Dataamatorene/Files/Mus.jobj"));
        updateProgress(6, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Laster prosessorer");
        KomponentRegister.setProsessorArrayList(
                (ArrayList<Prosessor>) opener.read("src/main/java/Dataamatorene/Files/Prosessor.jobj"));
        updateProgress(7, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Laster skjermer");
        KomponentRegister.setSkjermArrayList(
                (ArrayList<Skjerm>) opener.read("src/main/java/Dataamatorene/Files/Skjerm.jobj"));
        updateProgress(8, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Laster skjermkort");
        KomponentRegister.setSkjermkortArrayList(
                (ArrayList<Skjermkort>) opener.read("src/main/java/Dataamatorene/Files/Skjermkort.jobj"));
        updateProgress(9, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Laster tastaturer");
        KomponentRegister.setTastaturArrayList(
                (ArrayList<Tastatur>) opener.read("src/main/java/Dataamatorene/Files/Tastatur.jobj"));
        updateProgress(10, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Setter varekoder harddisk");
        for (Harddisk h: KomponentRegister.getHarddiskArrayList()) {
            VarekodeRegister.addVarekode(h.getVarekode());
        } updateProgress(11, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Setter varekoder hovedkort");
        for (Hovedkort h:KomponentRegister.getHovedkortArrayList()) {
            VarekodeRegister.addVarekode(h.getVarekode());
        } updateProgress(12, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Setter varekoder Lydkort");
        for (Lydkort l:KomponentRegister.getLydkortArrayList()) {
            VarekodeRegister.addVarekode(l.getVarekode());
        } updateProgress(13, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Setter varekoder Skjermkort");
        for (Skjermkort s:KomponentRegister.getSkjermkortArrayList()) {
            VarekodeRegister.addVarekode(s.getVarekode());
        } updateProgress(14, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Setter varekoder prosessor");
        for (Prosessor p:KomponentRegister.getProsessorArrayList()) {
            VarekodeRegister.addVarekode(p.getVarekode());
        } updateProgress(15, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Setter varekoder minne");
        for (Minne m:KomponentRegister.getMinneArrayList()) {
            VarekodeRegister.addVarekode(m.getVarekode());
        } updateProgress(16, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Setter varekoder kabinett");
        for (Kabinett k:KomponentRegister.getKabinettArrayList()) {
            VarekodeRegister.addVarekode(k.getVarekode());
        } updateProgress(17, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Setter varekoder skjermer");
        for (Skjerm s:KomponentRegister.getSkjermArrayList()) {
            VarekodeRegister.addVarekode(s.getVarekode());
        } updateProgress(18, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Setter varekoder tastatur");
        for (Tastatur t:KomponentRegister.getTastaturArrayList()) {
            VarekodeRegister.addVarekode(t.getVarekode());
        } updateProgress(19, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Setter varekoder mus");
        for (Mus m:KomponentRegister.getMusArrayList()) {
            VarekodeRegister.addVarekode(m.getVarekode());
        } updateProgress(20, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Laster bestillinger");
        BestillingsRegister.setBestillinger((ArrayList<Bestilling>) opener.read("src/main/java/Dataamatorene/Files/Bestillinger.jobj"));
        updateProgress(21, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }

        updateMessage("Setter bestillinger");
        if (!BestillingsRegister.getBestillinger().isEmpty()) {
            Bestilling.setTeller(BestillingsRegister.getBestillinger().get(BestillingsRegister.getBestillinger().size()
                    - 1).getBestillingsnummer() + 1);
        } updateProgress(22, 22);
        try{
            Thread.sleep(25);
        } catch (InterruptedException e){

        }
        updateMessage("Ferdig!");



        return null;
    }
}
