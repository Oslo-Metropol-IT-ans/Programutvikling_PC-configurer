package Dataamatorene.Datakomponenter;

import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Skjermkort extends Datakomponent implements Serializable, Comparable<Skjermkort> {

    // Nye datafelt til subklassen
    protected String opplosning;

    // Konstruktør
    public Skjermkort(String navn, double pris, int varekode, Image bilde, String opplosning) {
        super(navn, pris, varekode, bilde);
        this.opplosning = opplosning;
        setBrukerTid();
    }

    // Gettere og settere
    public String getOpplosning() {
        return opplosning;
    }

    public void setOpplosning(String opplosning) {
        this.opplosning = opplosning;
        setBrukerTid();
    }

    // Overkjøring av arvede metoder
    @Override
    public String getBeskrivelse() {
        return String.format("%s\n%s oppløsning\nPris: %skr, varekode: %s", navn, opplosning, pris, getVarekode());
    }

    @Override
    public void lagre(ArrayList<? extends Datakomponent> liste) throws IOException {
        KomponentRegister.setSkjermkortArrayList((ArrayList<Skjermkort>) liste);
        LagreKomponent.lagreSkjermkort();
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
