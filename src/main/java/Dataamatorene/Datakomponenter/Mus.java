package Dataamatorene.Datakomponenter;

import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Mus extends Datakomponent implements Serializable, Comparable<Mus> {

    // Nye datafelt til subklassen
    protected boolean trad;
    protected int antallKnapper;

    // Konstruktør
    public Mus(String navn, double pris, int varekode, Image bilde, boolean trad, int antallKnapper) {
        super(navn, pris, varekode, bilde);
        this.trad = trad;
        this.antallKnapper = antallKnapper;
        setBrukerTid();
    }

    // Gettere og settere
    public String isTrad() {
        if(trad) return "true";
        else return "false";
    }

    public void setTrad(boolean trad) {
        this.trad = trad;
        setBrukerTid();
    }

    public String getAntallKnapper() {
        return String.valueOf(antallKnapper);
    }

    public void setAntallKnapper(int antallKnapper) {
        this.antallKnapper = antallKnapper;
        setBrukerTid();
    }

    // Overkjøring av arvede metoder
    @Override
    public String getBeskrivelse() {
        if(trad)
            return String.format("%s\nEn trådløs mus med %s knapper\nPris: %skr, varekode: %s", navn, antallKnapper,
                    pris, getVarekode());
        else
            return String.format("%s\nEn mus med tråd, med %s knapper\nPris: %skr, varekdoe: %s", navn, antallKnapper,
                    pris, getVarekode());
    }

    @Override
    public String toString() {
        if(trad)
            return String.format("%s trådløs %s knapper, %skr, VNr: %s", navn, antallKnapper, pris, getVarekode());
        else
            return String.format("%s med tråd %s knapper, %skr, VNr: %s", navn, antallKnapper, pris, getVarekode());
    }

    @Override
    public int compareTo(@NotNull Mus o) {
        return this.navn.compareTo(o.navn);
    }
}
