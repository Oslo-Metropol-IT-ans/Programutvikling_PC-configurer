package Dataamatorene.Datakomponenter;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Minne extends Datakomponent implements Serializable, Comparable<Minne> {

    protected int ram;
    protected double frekvens;

    public Minne(String navn, double pris, int varekode, int ram, double frekvens) {
        super(navn, pris, varekode);
        this.ram = ram;
        this.frekvens = frekvens;
        setBrukerTid();
    }

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

    @Override
    public String toString() {
        return String.format("%s %sGB RAM %sGHz, %skr, VNr: %s", navn, ram, frekvens, pris, getVarekode());
    }

    @Override
    public int compareTo(@NotNull Minne o) {
        return this.navn.compareTo(o.navn);
    }
}
