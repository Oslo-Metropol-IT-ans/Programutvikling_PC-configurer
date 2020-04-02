package Dataamatorene.Datakomponenter;

import java.io.Serializable;
import java.text.DecimalFormat;

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
        DecimalFormat df = new DecimalFormat("00000");
        return df.format(varekode);
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
        DecimalFormat df = new DecimalFormat("###,###.00");
        return df.format(pris);
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        return String.format("%%s, %s, %skr", varekode, navn, pris);
    }
}
