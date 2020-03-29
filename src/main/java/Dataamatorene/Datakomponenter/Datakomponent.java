package Dataamatorene.Datakomponenter;

import java.io.Serializable;

public class Datakomponent implements Serializable {

    protected int varekode;
    protected String navn;
    protected double pris;

    public Datakomponent(String navn, double pris, int varekode){
        this.navn = navn;
        this.pris = pris;
        this.varekode = varekode;
    }

    public String getVarekode() {
        return String.valueOf(varekode);
    }

    public void setVarekode(int varekode) {
        this.varekode = varekode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getPris() {
        return pris;
    }

    public String getPrisT() {
        return String.valueOf(pris);
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        return String.format("%%s, %s, %skr", varekode, navn, pris);
    }
}
