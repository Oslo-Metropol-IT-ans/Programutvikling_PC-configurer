package Dataamatorene.Datakomponenter;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Harddisk extends Datakomponent implements Serializable, Comparable<Harddisk> {

    protected int lagring;

    public Harddisk(String navn, double pris, int varekode, int lagring) {
        super(navn, pris, varekode);
        this.lagring = lagring;
    }

    public String getLagring() {
        return String.valueOf(lagring);
    }

    public void setLagring(int lagring) {
        this.lagring = lagring;
        setBrukerTid();
    }

    @Override
    public String toString() {
        if(lagring < 1000) return String.format("%s %sGB, %skr, %s", navn, lagring, pris, getVarekode());
        else return String.format("%s %sTB, %skr, VNr: %s", navn, (lagring/1000), pris, getVarekode());

    }

    @Override
    public int compareTo(@NotNull Harddisk o) {
        return this.navn.compareTo(o.navn);
    }
}
