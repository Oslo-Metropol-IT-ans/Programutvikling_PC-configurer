package Dataamatorene.DatakomponenterReserve;

import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.Bruker2;
import Dataamatorene.Brukere.BrukerRegister;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Datakomponent2 implements Serializable {
    protected int varekode;
    protected String navn;
    protected double pris;
    protected transient Image bilde;
    protected Bruker2 bruker;
    protected LocalDateTime tid;

    public Datakomponent2(String navn, double pris, int varekode, Image bilde){
        this.navn = navn;
        this.pris = pris;
        this.varekode = varekode;
        this.bilde = bilde;
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
        Bruker b = BrukerRegister.getAktivBruker();
        this.bruker = new Bruker2(b.getBrukernavn(), b.getPassord(), "Hei", "hei", "null", true);
        this.tid = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %skr", varekode, navn, pris);
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        try{
            bilde = SwingFXUtils.toFXImage(ImageIO.read(s), null);
        } catch (Exception e) {
            bilde = null;
        }

    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(bilde, null), "jpg", s);
        } catch (Exception e) {};

    }
}
