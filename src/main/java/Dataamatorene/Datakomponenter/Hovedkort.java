package Dataamatorene.Datakomponenter;

import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Hovedkort extends Datakomponent implements Serializable, Comparable<Hovedkort> {

    protected int antallPorter;

    public Hovedkort(String navn, double pris, int varekode, Image bilde, int antallPorter) {
        super(navn, pris, varekode, bilde);
        this.antallPorter = antallPorter;
    }

    public String getAntallPorter() {
        return String.valueOf(antallPorter);
    }

    public void setAntallPorter(int antallPorter) {
        this.antallPorter = antallPorter;
        setBrukerTid();
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
