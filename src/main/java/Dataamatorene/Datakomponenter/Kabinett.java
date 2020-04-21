package Dataamatorene.Datakomponenter;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Kabinett extends Datakomponent implements Serializable, Comparable<Datakomponent> {

    protected String storrelse;
    protected int antallVifter;

    public Kabinett(String navn, double pris, int varekode, String storrelse, int antallVifter) {
        super(navn, pris, varekode);
        this.storrelse = storrelse;
        this.antallVifter = antallVifter;
        setBrukerTid();
    }

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

    @Override
    public String toString() {
        return String.format("%s %s %s vifter, %skr, VNr: %s", navn, storrelse, antallVifter, pris, getVarekode());
    }

    @Override
    public int compareTo(@NotNull Datakomponent o) {
        return this.navn.compareTo(o.navn);
    }
}
