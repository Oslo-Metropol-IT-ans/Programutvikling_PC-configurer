package Dataamatorene.Datakomponenter;

import java.io.Serializable;

public class Prosessor extends Datakomponent implements Serializable {

    protected int antallKjerner;
    protected double frekvens;
    protected int antallTråder;

    public Prosessor(String navn, double pris, int varekode, int antallKjerner, double frekvens, int antallTråder) {
        super(navn, pris, varekode);
        this.antallKjerner = antallKjerner;
        this.frekvens = frekvens;
        this.antallTråder = antallTråder;
    }

    public String getAntallKjerner() {
        return String.valueOf(antallKjerner);
    }

    public void setAntallKjerner(int antallKjerner) {
        this.antallKjerner = antallKjerner;
    }

    public String getFrekvens() {
        return String.valueOf(frekvens);
    }

    public void setFrekvens(double frekvens) {
        this.frekvens = frekvens;
    }

    public String getAntallTråder() {
        return String.valueOf(antallTråder);
    }

    public void setAntallTråder(int antallTråder) {
        this.antallTråder = antallTråder;
    }

    @Override
    public String toString() {
        return String.format("%s %sGHz %s kjerner %s tråder, %skr, %s", navn, frekvens, antallKjerner, antallTråder
                            , pris, varekode);
    }
}
