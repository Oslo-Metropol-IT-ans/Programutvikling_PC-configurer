package Dataamatorene.Datakomponenter;

import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Tastatur extends Datakomponent implements Serializable, Comparable<Tastatur> {

    // Nye datefelt til subklassen
    protected String sprak;
    protected boolean mekanisk;
    protected boolean rgb;

    // Konstruktør
    public Tastatur(String navn, double pris, int varekode, Image bilde, String sprak, boolean mekanisk, boolean rgb) {
        super(navn, pris, varekode, bilde);
        this.sprak = sprak;
        this.mekanisk = mekanisk;
        this.rgb = rgb;
        setBrukerTid();
    }

    // Gettere og settere
    public String getSprak() {
        return sprak;
    }

    public void setSprak(String sprak) {
        this.sprak = sprak;
        setBrukerTid();
    }

    public String isMekanisk() {
        return String.valueOf(mekanisk);
    }

    public void setMekanisk(boolean mekanisk) {
        this.mekanisk = mekanisk;
        setBrukerTid();
    }

    public String isRgb() {
        return String.valueOf(rgb);
    }

    public void setRgb(boolean rgb) {
        this.rgb = rgb;
        setBrukerTid();
    }

    // Overkjøring av arvede metoder
    @Override
    public String getBeskrivelse() {
        if(mekanisk && rgb)
            return String.format("%s\nEt mekanisk tastatur med lys, %s\nPris: %skr, varekode: %s", navn, sprak
                    , pris, getVarekode());
        else if(mekanisk && !rgb)
            return String.format("%s\nEt mekanisk tastatur uten lys, %s\nPris: %skr, varekode: %s", navn, sprak
                    , pris, getVarekode());
        else if(!mekanisk && rgb)
            return String.format("%s\nEt ikke-mekanisk tastatur med lys, %s\nPris; %skr, varekode: %s", navn, sprak
                    , pris, getVarekode());
        else
            return String.format("%s\nEt ikke-mekanisk tastatur uten lys, %s\nPris: %skr, varekode: %s", navn, sprak
                    , pris, getVarekode());
    }

    @Override
    public void lagre(ArrayList<? extends Datakomponent> liste) throws IOException {
        KomponentRegister.setTastaturArrayList((ArrayList<Tastatur>) liste);
        LagreKomponent.lagreTastatur();
    }

    @Override
    public String toString() {
        if(mekanisk && rgb)
            return String.format("%s er mekanisk og med lys, %s, %skr, VNr: %s", navn, sprak
                                                , pris, getVarekode());
        else if(mekanisk && !rgb)
            return String.format("%s er mekanisk og uten lys, %s, %skr, VNr: %s", navn, sprak
                    , pris, getVarekode());
        else if(!mekanisk && rgb)
            return String.format("%s er ikke mekanisk og med lys, %s, %skr, VNr: %s", navn, sprak
                    , pris, getVarekode());
        else
            return String.format("%s er ikke mekanisk og uten lys, %s, %skr, VNr: %s", navn, sprak
                    , pris, getVarekode());
    }

    @Override
    public int compareTo(@NotNull Tastatur o) {
        return this.navn.compareTo(o.navn);
    }
}
