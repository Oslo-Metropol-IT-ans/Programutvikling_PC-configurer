package Dataamatorene.Datakomponenter;

import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Prosessor extends Datakomponent implements Serializable, Comparable<Prosessor> {

    // Nye datafelt til subklassen
    protected int antallKjerner;
    protected double frekvens;
    protected int antallTrader;

    // Konstruktør
    public Prosessor(String navn, double pris, int varekode, Image bilde, int antallKjerner, double frekvens, int antallTrader) {
        super(navn, pris, varekode, bilde);
        this.antallKjerner = antallKjerner;
        this.frekvens = frekvens;
        this.antallTrader = antallTrader;
        setBrukerTid();
    }

    // Getter og settere
    public String getAntallKjerner() {
        return String.valueOf(antallKjerner);
    }

    public void setAntallKjerner(int antallKjerner) {
        this.antallKjerner = antallKjerner;
        setBrukerTid();
    }

    public String getFrekvens() {
        return String.valueOf(frekvens);
    }

    public void setFrekvens(double frekvens) {
        this.frekvens = frekvens;
        setBrukerTid();
    }

    public String getAntallTrader() {
        return String.valueOf(antallTrader);
    }

    public void setAntallTrader(int antallTrader) {
        this.antallTrader = antallTrader;
        setBrukerTid();
    }

    // Overkjøring av arvede metoder
    @Override
    public String getBeskrivelse() {
        return String.format("%s\n%s GHz, %s-core, %s-thread prosessor\nPris: %skr, varekode: %s", navn, frekvens,
                antallKjerner, antallTrader, pris, getVarekode());
    }

    @Override
    public void lagre(ArrayList<? extends Datakomponent> liste) throws IOException {
        KomponentRegister.setProsessorArrayList((ArrayList<Prosessor>) liste);
        LagreKomponent.lagreProsessor();
    }

    @Override
    public String toString() {
        return String.format("%s %sGHz %s kjerner %s tråder, %skr, VNr: %s", navn, frekvens, antallKjerner, antallTrader
                            , pris, getVarekode());
    }

    @Override
    public int compareTo(@NotNull Prosessor o) {
        return this.navn.compareTo(o.navn);
    }
}
