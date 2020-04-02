package Dataamatorene.Datakomponenter;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Skjermkort extends Datakomponent implements Serializable, Comparable<Skjermkort> {

    protected String oppløsning;

    public Skjermkort(String navn, double pris, int varekode, String oppløsning) {
        super(navn, pris, varekode);
        this.oppløsning = oppløsning;
    }

    public String getOppløsning() {
        return oppløsning;
    }

    public void setOppløsning(String oppløsning) {
        this.oppløsning = oppløsning;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %skr, VNr: %s", navn, oppløsning, pris, getVarekode());
    }

    @Override
    public int compareTo(@NotNull Skjermkort o) {
        return this.navn.compareTo(o.navn);
    }
}
