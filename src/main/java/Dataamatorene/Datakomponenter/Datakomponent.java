package Dataamatorene.Datakomponenter;

import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.BrukerRegister;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Datakomponent implements Serializable {

    // Datafelt
    protected int varekode;
    protected String navn;
    protected double pris;
    protected transient Image bilde;
    protected Bruker bruker;
    protected LocalDateTime tid;

    // Konstruktør
    public Datakomponent(String navn, double pris, int varekode, Image bilde){
        this.navn = navn;
        this.pris = pris;
        this.varekode = varekode;
        this.bilde = bilde;
        setBrukerTid();
    }

    // Gettere og settere
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

    public String getBeskrivelse() {
        return String.format("%s\n%skr, varekode: %s", navn, pris, getVarekode());
    }

    public void lagre() throws IOException {
        LagreKomponent.lagreAlle();
    }

    // toString
    @Override
    public String toString() {
        return String.format("%s, %s, %skr", varekode, navn, pris);
    }


    // Metoder for å serialisere javafx.Image
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        try {
            bilde = SwingFXUtils.toFXImage(ImageIO.read(s), null);
        } catch (Exception e) {
            //e.printStackTrace();
            bilde = null;
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        try {
            if (bilde != null) {
                ImageIO.write(SwingFXUtils.fromFXImage(bilde, null), "png", s);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
