package Dataamatorene.Datakomponenter;

import java.io.Serializable;

public class Lydkort extends Datakomponent implements Serializable {

    protected boolean integrert;
    protected double frekvens;

    public Lydkort(String navn, double pris, int varekode, boolean integrert, double frekvens) {
        super(navn, pris, varekode);
        this.integrert = integrert;
        this.frekvens = frekvens;
    }

    public String getIntegrert() {
        if (integrert) return "true";
        else return "false";
    }

    public void setIntegrert(boolean integrert) {
        this.integrert = integrert;
    }

    public String getFrekvens() {
        return String.valueOf(frekvens);
    }

    public void setFrekvens(double frekvens) {
        this.frekvens = frekvens;
    }

    @Override
    public String toString() {
        if(integrert){
            return String.format("%s %s integrert, %skr, %s", navn, frekvens, pris, varekode);
        } else return String.format("%s %s ikke integrert, %skr, %s", navn, frekvens, pris, varekode);

    }
}
