package Dataamatorene.DatakomponenterReserve;

import Dataamatorene.Datakomponenter.Datakomponent;

import java.io.Serializable;

public class Skjermkort2 extends Datakomponent implements Serializable {

    protected String oppløsning;

    public Skjermkort2(String navn, double pris, int varekode, String oppløsning) {
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
        return String.format("%s %s, %skr, VNr: %s", navn, oppløsning, pris, varekode);
    }
}
