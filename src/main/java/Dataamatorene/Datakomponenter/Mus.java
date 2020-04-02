package Dataamatorene.Datakomponenter;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Mus extends Datakomponent implements Serializable, Comparable<Mus> {

    protected boolean tråd;
    protected int antallKnapper;

    public Mus(String navn, double pris, int varekode, boolean tråd, int antallKnapper) {
        super(navn, pris, varekode);
        this.tråd = tråd;
        this.antallKnapper = antallKnapper;
    }


    public String isTråd() {
        if(tråd) return "true";
        else return "false";
    }

    public void setTråd(boolean tråd) {
        this.tråd = tråd;
    }

    public String getAntallKnapper() {
        return String.valueOf(antallKnapper);
    }

    public void setAntallKnapper(int antallKnapper) {
        this.antallKnapper = antallKnapper;
    }

    @Override
    public String toString() {
        if(tråd)
            return String.format("%s trådløs %s knapper, %skr, VNr: %s", navn, antallKnapper, pris, getVarekode());
        else
            return String.format("%s med tråd %s knapper, %skr, VNr: %s", navn, antallKnapper, pris, getVarekode());
    }

    @Override
    public int compareTo(@NotNull Mus o) {
        return this.navn.compareTo(o.navn);
    }
}
