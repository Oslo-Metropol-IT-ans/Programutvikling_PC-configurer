package Dataamatorene.Datakomponenter;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Mus extends Datakomponent implements Serializable, Comparable<Mus> {

    protected boolean trad;
    protected int antallKnapper;

    public Mus(String navn, double pris, int varekode, boolean trad, int antallKnapper) {
        super(navn, pris, varekode);
        this.trad = trad;
        this.antallKnapper = antallKnapper;
        setBrukerTid();
    }


    public String isTrad() {
        if(trad) return "true";
        else return "false";
    }

    public void setTrad(boolean trad) {
        this.trad = trad;
        setBrukerTid();
    }

    public String getAntallKnapper() {
        return String.valueOf(antallKnapper);
    }

    public void setAntallKnapper(int antallKnapper) {
        this.antallKnapper = antallKnapper;
        setBrukerTid();
    }

    @Override
    public String toString() {
        if(trad)
            return String.format("%s trådløs %s knapper, %skr, VNr: %s", navn, antallKnapper, pris, getVarekode());
        else
            return String.format("%s med tråd %s knapper, %skr, VNr: %s", navn, antallKnapper, pris, getVarekode());
    }

    @Override
    public int compareTo(@NotNull Mus o) {
        return this.navn.compareTo(o.navn);
    }
}
