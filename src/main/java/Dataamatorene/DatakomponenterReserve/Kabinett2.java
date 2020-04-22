package Dataamatorene.DatakomponenterReserve;

import Dataamatorene.Datakomponenter.Datakomponent;
import javafx.scene.image.Image;

import java.io.Serializable;

public class Kabinett2 extends Datakomponent2 implements Serializable {

    protected String størrelse;
    protected int antallVifter;

    public Kabinett2(String navn, double pris, int varekode, Image bilde, String størrelse, int antallVifter) {
        super(navn, pris, varekode, bilde);
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
        return String.format("%s %s %s vifter, %skr, VNr: %s", navn, størrelse, antallVifter, pris, varekode);
    }
}
