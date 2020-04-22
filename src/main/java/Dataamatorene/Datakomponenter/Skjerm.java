package Dataamatorene.Datakomponenter;


import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Skjerm extends Datakomponent implements Serializable, Comparable<Skjerm> {

    protected String opplosning;
    protected double storrelse;

    public Skjerm(String navn, double pris, int varekode, Image bilde, String opplosning, double storrelse) {
        super(navn, pris, varekode, bilde);
        this.opplosning = opplosning;
        this.storrelse = storrelse;
        setBrukerTid();
    }

    public String getOpplosning() {
        return opplosning;
    }

    public void setOpplosning(String opplosning) {
        this.opplosning = opplosning;
        setBrukerTid();
    }

    public String getStorrelse() {
        return String.valueOf(storrelse);
    }

    public void setStorrelse(double storrelse) {
        this.storrelse = storrelse;
        setBrukerTid();
    }

    @Override
    public String toString() {
        return String.format("%s %s %s'', %skr, VNr: %s", navn, opplosning, storrelse, pris, getVarekode());
    }

    @Override
    public int compareTo(@NotNull Skjerm o) {
        return this.navn.compareTo(o.navn);
    }
}
