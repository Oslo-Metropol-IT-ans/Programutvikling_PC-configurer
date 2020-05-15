package Dataamatorene.Datakomponenter;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Hovedkort extends Datakomponent implements Serializable, Comparable<Hovedkort> {

    // Nye datafelt til subklassen
    protected int antallPorter;

    // kontruktør
    public Hovedkort(String navn, double pris, int varekode, Image bilde, int antallPorter) {
        super(navn, pris, varekode, bilde);
        this.antallPorter = antallPorter;
    }

    // getter og setter
    public String getAntallPorter() {
        return String.valueOf(antallPorter);
    }

    public void setAntallPorter(int antallPorter) {
        this.antallPorter = antallPorter;
        setBrukerTid();
    }

    // overkjøring av arvede metoder
    @Override
    public String getBeskrivelse() {
        return String.format("%s\n %s porter\nPris: %skr, varekode: %s", navn, antallPorter, pris, getVarekode());
    }

    @Override
    public void lagre(ArrayList<? extends Datakomponent> liste, Pane pane) throws IOException {
        KomponentRegister.setHovedkortArrayList((ArrayList<Hovedkort>) liste);
        LagreKomponent.lagreHovedkort(pane);
    }

    @Override
    public String toString() {
        return String.format("%s %s porter, %skr, VNr: %s", navn, antallPorter, pris, getVarekode());
    }

    @Override
    public int compareTo(@NotNull Hovedkort o) {
        return this.navn.compareTo(o.getNavn());
    }
}
