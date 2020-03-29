package Dataamatorene.Datakomponenter;

import java.io.Serializable;

public class Kabinett extends Datakomponent implements Serializable {

    protected String størrelse;
    protected int antallVifter;

    public Kabinett(String navn, double pris, int varekode, String størrelse, int antallVifter) {
        super(navn, pris, varekode);
        this.størrelse = størrelse;
        this.antallVifter = antallVifter;
    }

    public String getStørrelse() {
        return størrelse;
    }

    public void setStørrelse(String størrelse) {
        this.størrelse = størrelse;
    }

    public String getAntallVifter() {
        return String.valueOf(antallVifter);
    }

    public void setAntallVifter(int antallVifter) {
        this.antallVifter = antallVifter;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s vifter, %skr, %s", navn, størrelse, antallVifter, pris, varekode);
    }
}
