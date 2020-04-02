package Dataamatorene.Datakomponenter;


import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Skjerm extends Datakomponent implements Serializable, Comparable<Skjerm> {

    protected String oppløsning;
    protected double størrelse;

    public Skjerm(String navn, double pris, int varekode, String oppløsning, double størrelse) {
        super(navn, pris, varekode);
        this.oppløsning = oppløsning;
        this.størrelse = størrelse;
    }

    public String getOppløsning() {
        return oppløsning;
    }

    public void setOppløsning(String oppløsning) {
        this.oppløsning = oppløsning;
    }

    public String getStørrelse() {
        return String.valueOf(størrelse);
    }

    public void setStørrelse(double størrelse) {
        this.størrelse = størrelse;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s'', %skr, VNr: %s", navn, oppløsning, størrelse, pris, getVarekode());
    }

    @Override
    public int compareTo(@NotNull Skjerm o) {
        return this.navn.compareTo(o.navn);
    }
}
