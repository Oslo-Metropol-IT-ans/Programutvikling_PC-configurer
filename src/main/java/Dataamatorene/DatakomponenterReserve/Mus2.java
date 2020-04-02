package Dataamatorene.DatakomponenterReserve;

import Dataamatorene.Datakomponenter.Datakomponent;

import java.io.Serializable;

public class Mus2 extends Datakomponent implements Serializable {

    protected boolean tråd;
    protected int antallKnapper;

    public Mus2(String navn, double pris, int varekode, boolean tråd, int antallKnapper) {
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
            return String.format("%s trådløs %s knapper, %skr, VNr: %s", navn, antallKnapper, pris, varekode);
        else
            return String.format("%s med tråd %s knapper, %skr, VNr: %s", navn, antallKnapper, pris, varekode);
    }
}
