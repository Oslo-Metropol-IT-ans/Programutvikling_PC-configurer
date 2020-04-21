package Dataamatorene.Datakomponenter;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Prosessor extends Datakomponent implements Serializable, Comparable<Prosessor> {

    protected int antallKjerner;
    protected double frekvens;
    protected int antallTrader;

    public Prosessor(String navn, double pris, int varekode, int antallKjerner, double frekvens, int antallTrader) {
        super(navn, pris, varekode);
        this.antallKjerner = antallKjerner;
        this.frekvens = frekvens;
        this.antallTrader = antallTrader;
        setBrukerTid();
    }

    public String getAntallKjerner() {
        return String.valueOf(antallKjerner);
    }

    public void setAntallKjerner(int antallKjerner) {
        this.antallKjerner = antallKjerner;
        setBrukerTid();
    }

    public String getFrekvens() {
        return String.valueOf(frekvens);
    }

    public void setFrekvens(double frekvens) {
        this.frekvens = frekvens;
        setBrukerTid();
    }

    public String getAntallTrader() {
        return String.valueOf(antallTrader);
    }

    public void setAntallTrader(int antallTrader) {
        this.antallTrader = antallTrader;
        setBrukerTid();
    }

    @Override
    public String toString() {
        return String.format("%s %sGHz %s kjerner %s tråder, %skr, VNr: %s", navn, frekvens, antallKjerner, antallTrader
                            , pris, getVarekode());
    }

    @Override
    public int compareTo(@NotNull Prosessor o) {
        return this.navn.compareTo(o.navn);
    }
}
