package Dataamatorene.Datakomponenter;

import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.BrukerRegister;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Datakomponent implements Serializable {

    protected int varekode;
    protected String navn;
    protected double pris;
    protected Image bilde;
    protected Bruker bruker;
    protected LocalDateTime tid;

    public Datakomponent(String navn, double pris, int varekode){
        this.navn = navn;
        this.pris = pris;
        this.varekode = varekode;
        setBrukerTid();
    }

    public String getVarekode() {
        DecimalFormat df = new DecimalFormat("00000");
        return df.format(varekode);
    }

    public void setVarekode(int varekode) {
        this.varekode = varekode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
        setBrukerTid();
    }

    public double getPris() {
        return pris;
    }

    public String getPrisT() {
        DecimalFormat df = new DecimalFormat("###,###.00");
        return df.format(pris);
    }

    public void setPris(double pris) {
        this.pris = pris;
        setBrukerTid();
    }

    public Image getBilde() {
        return bilde;
    }

    public void setBilde(Image bilde) {
        this.bilde = bilde;
        setBrukerTid();
    }

    public String getBruker() {
        return bruker.getBrukernavn();
    }

    public String getTid() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        return tid.format(format);
    }

    protected void setBrukerTid() {
        this.bruker = BrukerRegister.getAktivBruker();
        this.tid = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %skr", varekode, navn, pris);
    }
}
