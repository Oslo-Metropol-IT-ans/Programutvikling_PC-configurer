package Dataamatorene.Datakomponenter;

import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Skjermkort extends Datakomponent implements Serializable, Comparable<Skjermkort> {

    protected String opplosning;

    public Skjermkort(String navn, double pris, int varekode, Image bilde, String opplosning) {
        super(navn, pris, varekode, bilde);
        this.opplosning = opplosning;
        setBrukerTid();
    }

    public String getOpplosning() {
        return opplosning;
    }

    public void setOpplosning(String opplosning) {
        this.opplosning = opplosning;
        setBrukerTid();
    }

    @Override
    public String getBeskrivelse() {
        return String.format("%s\n%s oppløsning\nPris: %skr, varekode: %s", navn, opplosning, pris, getVarekode());
    }

    @Override
    public String toString() {
        return String.format("%s %s, %skr, VNr: %s", navn, opplosning, pris, getVarekode());
    }

    @Override
    public int compareTo(@NotNull Skjermkort o) {
        return this.navn.compareTo(o.navn);
    }
}
