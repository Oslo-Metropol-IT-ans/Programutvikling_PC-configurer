package Dataamatorene.Datakomponenter;

import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Harddisk extends Datakomponent implements Serializable, Comparable<Harddisk> {

    // Spesielle datafelt for arvet klasse
    protected int lagring;

    // Konstruktør
    public Harddisk(String navn, double pris, int varekode, Image bilde, int lagring) {
        super(navn, pris, varekode, bilde);
        this.lagring = lagring;
    }

    // gettere og settere
    public String getLagring() {
        return String.valueOf(lagring);
    }

    public void setLagring(int lagring) {
        this.lagring = lagring;
        setBrukerTid();
    }

    // overkjører arvede metoder fra superklassen
    @Override
    public void lagre(ArrayList<? extends Datakomponent> liste) throws IOException {
        KomponentRegister.setHarddiskArrayList((ArrayList<Harddisk>)liste);
        LagreKomponent.lagreHarddisk();
    }

    @Override
    public String getBeskrivelse() {
        if (lagring < 1000) return String.format("%s\n %sGB lagring\nPris: %skr, varekode: %s", navn, lagring,
                pris, getVarekode());
        else return String.format("%s\n %sTB lagring\nPris: %skr, varekode: %s", navn,  (lagring/1000),
                pris, getVarekode());
    }

    @Override
    public String toString() {
        if(lagring < 1000) return String.format("%s %sGB, %skr, %s", navn, lagring, pris, getVarekode());
        else return String.format("%s %sTB, %skr, VNr: %s", navn, (lagring/1000), pris, getVarekode());

    }

    @Override
    public int compareTo(@NotNull Harddisk o) {
        return this.navn.compareTo(o.navn);
    }
}
