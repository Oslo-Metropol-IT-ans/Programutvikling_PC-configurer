package Dataamatorene.Datakomponenter;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Minne extends Datakomponent implements Serializable, Comparable<Minne> {

    // Nye datafelt til subklassen
    protected int ram;
    protected double frekvens;

    // Konstruktør
    public Minne(String navn, double pris, int varekode, Image bilde, int ram, double frekvens) {
        super(navn, pris, varekode, bilde);
        this.ram = ram;
        this.frekvens = frekvens;
        setBrukerTid();
    }

    // Gettere og settere
    public String getRam() {
        return String.valueOf(ram);
    }

    public void setRam(int ram) {
        this.ram = ram;
        setBrukerTid();
    }

    public String getFrekvens() {
        return String.valueOf(frekvens);
    }

    public void setFrekvens(double frekvens) {
        this.frekvens = frekvens;
        setBrukerTid();
    }

    // Overkjøring av arvede metoder
    @Override
    public String getBeskrivelse() {
        return String.format("%s\n%s GB RAM, %s\nPris: %skr, varekode: %s", navn, ram, frekvens, pris, getVarekode());
    }

    @Override
    public void lagre(ArrayList<? extends Datakomponent> liste, Pane pane) throws IOException {
        KomponentRegister.setMinneArrayList((ArrayList<Minne>) liste);
        LagreKomponent.lagreMinne(pane);
    }

    @Override
    public String toString() {
        return String.format("%s %sGB RAM %sGHz, %skr, VNr: %s", navn, ram, frekvens, pris, getVarekode());
    }

    @Override
    public int compareTo(@NotNull Minne o) {
        return this.navn.compareTo(o.navn);
    }
}
