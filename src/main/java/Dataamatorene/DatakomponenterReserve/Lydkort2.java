package Dataamatorene.DatakomponenterReserve;

import Dataamatorene.Datakomponenter.Datakomponent;
import javafx.scene.image.Image;

import java.io.Serializable;

public class Lydkort2 extends Datakomponent2 implements Serializable {

    protected boolean integrert;
    protected double frekvens;

    public Lydkort2(String navn, double pris, int varekode, Image bilde, boolean integrert, double frekvens) {
        super(navn, pris, varekode, bilde);
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
            return String.format("%s %s integrert, %skr, VNr: %s", navn, frekvens, pris, varekode);
        } else return String.format("%s %s ikke integrert, %skr, VNr: %s", navn, frekvens, pris, varekode);

    }
}
