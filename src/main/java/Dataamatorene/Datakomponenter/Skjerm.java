package Dataamatorene.Datakomponenter;


import java.io.Serializable;

public class Skjerm extends Datakomponent implements Serializable {

    protected String oppløsning;
    protected double størrelse;

    public Skjerm(String navn, double pris, int varekode, String oppløsning, double størrelse) {
        super(navn, pris, varekode);
        this.oppløsning = oppløsning;
        this.størrelse = størrelse;
    }

    public String getOppløsning() {
        return oppløsning;
    }

    public void setOppløsning(String oppløsning) {
        this.oppløsning = oppløsning;
    }

    public String getStørrelse() {
        return String.valueOf(størrelse) + '"';
    }

    public void setStørrelse(double størrelse) {
        this.størrelse = størrelse;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s'', %skr, %s", navn, oppløsning, størrelse, pris, varekode);
    }
}
