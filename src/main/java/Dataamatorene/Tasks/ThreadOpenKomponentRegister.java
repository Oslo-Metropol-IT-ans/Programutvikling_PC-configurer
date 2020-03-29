package Dataamatorene.Tasks;

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
         try{
             Thread.sleep(3000);
         } catch (InterruptedException e){

         }


        return null;
    }
}
