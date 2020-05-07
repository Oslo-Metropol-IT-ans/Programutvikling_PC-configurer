package Dataamatorene.Datakomponenter;


import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Skjerm extends Datakomponent implements Serializable, Comparable<Skjerm> {

    // Nye datafelt til subklassen
    protected String opplosning;
    protected double storrelse;

    // Konstruktør
    public Skjerm(String navn, double pris, int varekode, Image bilde, String opplosning, double storrelse) {
        super(navn, pris, varekode, bilde);
        this.opplosning = opplosning;
        this.storrelse = storrelse;
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

    public String getStorrelse() {
        return String.valueOf(storrelse);
    }

    public void setStorrelse(double storrelse) {
        this.storrelse = storrelse;
        setBrukerTid();
    }

    // Overkjøring av arvede metoder
    @Override
    public String getBeskrivelse() {
        return String.format("%s\n%s'' skjerm med oppløsning %s\nPris: %skr, varekode: %s", navn, storrelse,
                opplosning, pris, getVarekode());
    }

    @Override
    public void lagre(ArrayList<? extends Datakomponent> liste) throws IOException {
        KomponentRegister.setSkjermArrayList((ArrayList<Skjerm>) liste);
        LagreKomponent.lagreSkjerm();
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
