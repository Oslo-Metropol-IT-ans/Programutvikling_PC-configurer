package Dataamatorene.Datakomponenter;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Lydkort extends Datakomponent implements Serializable, Comparable<Lydkort> {

    // Nye datafelt til subklassen
    protected boolean integrert;
    protected double frekvens;

    // Konstruktør
    public Lydkort(String navn, double pris, int varekode, Image bilde, boolean integrert, double frekvens) {
        super(navn, pris, varekode, bilde);
        this.integrert = integrert;
        this.frekvens = frekvens;
        setBrukerTid();
    }

    // Gettere og settere
    public String getIntegrert() {
        if (integrert) return "true";
        else return "false";
    }

    public void setIntegrert(boolean integrert) {
        this.integrert = integrert;
        setBrukerTid();
    }

    public String getFrekvens() {
        return String.valueOf(frekvens);
    }

    public void setFrekvens(double frekvens) {
        this.frekvens = frekvens;
        setBrukerTid();
    }

    // Overkjøring av arvede metoder
    @Override
    public String getBeskrivelse() {
        if(integrert){
            return String.format("%s\n %s kHz, er integrert\nPris; %skr, varekode: %s", navn, frekvens, pris, getVarekode());
        } else return String.format("%s\n %s kHz, er ikke integrert\nPris: %skr, varekode: %s", navn, frekvens, pris, getVarekode());
    }

    @Override
    public void lagre(ArrayList<? extends Datakomponent> liste, Pane pane) throws IOException {
        KomponentRegister.setLydkortArrayList((ArrayList<Lydkort>) liste);
        LagreKomponent.lagreLydkort(pane);
    }

    @Override
    public String toString() {
        if(integrert){
            return String.format("%s %s integrert, %skr, VNr: %s", navn, frekvens, pris, getVarekode());
        } else return String.format("%s %s ikke integrert, %skr, VNr: %s", navn, frekvens, pris, getVarekode());

    }

    @Override
    public int compareTo(@NotNull Lydkort o) {
        return this.navn.compareTo(o.navn);
    }
}
