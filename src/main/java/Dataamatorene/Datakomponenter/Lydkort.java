package Dataamatorene.Datakomponenter;

import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Lydkort extends Datakomponent implements Serializable, Comparable<Lydkort> {

    protected boolean integrert;
    protected double frekvens;

    public Lydkort(String navn, double pris, int varekode, Image bilde, boolean integrert, double frekvens) {
        super(navn, pris, varekode, bilde);
        this.integrert = integrert;
        this.frekvens = frekvens;
        setBrukerTid();
    }

    public String getIntegrert() {
        if (integrert) return "true";
        else return "false";
    }

    public void setIntegrert(boolean integrert) {
        this.integrert = integrert;
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
        if(integrert){
            return String.format("%s %s integrert, %skr, VNr: %s", navn, frekvens, pris, getVarekode());
        } else return String.format("%s %s ikke integrert, %skr, VNr: %s", navn, frekvens, pris, getVarekode());

    }

    @Override
    public int compareTo(@NotNull Lydkort o) {
        return this.navn.compareTo(o.navn);
    }
}
