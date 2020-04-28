package Dataamatorene.Datakomponenter;

import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Kabinett extends Datakomponent implements Serializable, Comparable<Datakomponent> {

    // nye datafelt til subklassen
    protected String storrelse;
    protected int antallVifter;

    // konstruktør
    public Kabinett(String navn, double pris, int varekode, Image bilde, String storrelse, int antallVifter) {
        super(navn, pris, varekode, bilde);
        this.storrelse = storrelse;
        this.antallVifter = antallVifter;
        setBrukerTid();
    }

    // Gettere og settere
    public String getStorrelse() {
        return storrelse;
    }

    public void setStorrelse(String storrelse) {
        this.storrelse = storrelse;
        setBrukerTid();
    }

    public String getAntallVifter() {
        return String.valueOf(antallVifter);
    }

    public void setAntallVifter(int antallVifter) {
        this.antallVifter = antallVifter;
        setBrukerTid();
    }

    // overkjøring av arvede metoder
    @Override
    public String getBeskrivelse() {
        return String.format("%s\n%scm med %s vifter\nPris: %skr, varekode: %s", navn, storrelse, antallVifter,
                pris, getVarekode());
    }

    @Override
    public String toString() {
        return String.format("%s %s %s vifter, %skr, VNr: %s", navn, storrelse, antallVifter, pris, getVarekode());
    }

    @Override
    public int compareTo(@NotNull Datakomponent o) {
        return this.navn.compareTo(o.navn);
    }
}
