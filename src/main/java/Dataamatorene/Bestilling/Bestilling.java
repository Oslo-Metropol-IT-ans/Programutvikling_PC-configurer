package Dataamatorene.Bestilling;

import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Datakomponenter.*;

public class Bestilling {

    private Bruker bruker;
    private Harddisk harddisk;
    private Hovedkort hovedkort;
    private Lydkort lydkort;
    private Skjermkort skjermkort;
    private Prosessor prosessor;
    private Minne  minne;
    private Kabinett kabinett;
    private Skjerm skjerm;
    private Tastatur tastatur;
    private Mus mus;

    public Bestilling(Bruker bruker, Harddisk harddisk, Hovedkort hovedkort, Lydkort lydkort, Skjermkort skjermkort,
                      Prosessor prosessor, Minne minne, Kabinett kabinett, Skjerm skjerm, Tastatur tastatur, Mus mus) {
        this.bruker = bruker;
        this.harddisk = harddisk;
        this.hovedkort = hovedkort;
        this.lydkort = lydkort;
        this.skjermkort = skjermkort;
        this.prosessor = prosessor;
        this.minne = minne;
        this.kabinett = kabinett;
        this.skjerm = skjerm;
        this.tastatur = tastatur;
        this.mus = mus;
    }

    public Bruker getBruker() {
        return bruker;
    }

    public String getBrukerT() {
        return bruker.getBrukernavn();
    }

    public void setBruker(Bruker bruker) {
        this.bruker = bruker;
    }

    public Harddisk getHarddisk() {
        return harddisk;
    }

    public String getHarddiskT() {
        return harddisk.getVarekode();
    }

    public void setHarddisk(Harddisk harddisk) {
        this.harddisk = harddisk;
    }

    public Hovedkort getHovedkort() {
        return hovedkort;
    }

    public String getHovedkortT() {
        return hovedkort.getVarekode();
    }

    public void setHovedkort(Hovedkort hovedkort) {
        this.hovedkort = hovedkort;
    }

    public Lydkort getLydkort() {
        return lydkort;
    }

    public String getLydkortT() {
        return lydkort.getVarekode();
    }

    public void setLydkort(Lydkort lydkort) {
        this.lydkort = lydkort;
    }

    public Skjermkort getSkjermkort() {
        return skjermkort;
    }

    public String getSkjermKortT() {
        return skjermkort.getVarekode();
    }

    public void setSkjermkort(Skjermkort skjermkort) {
        this.skjermkort = skjermkort;
    }

    public Prosessor getProsessor() {
        return prosessor;
    }

    public String getProsessorT() {
        return prosessor.getVarekode();
    }

    public void setProsessor(Prosessor prosessor) {
        this.prosessor = prosessor;
    }

    public Minne getMinne() {
        return minne;
    }

    public String getMinneT() {
        return minne.getVarekode();
    }

    public void setMinne(Minne minne) {
        this.minne = minne;
    }

    public Kabinett getKabinett() {
        return kabinett;
    }

    public String getKabinettT() {
        return kabinett.getVarekode();
    }

    public void setKabinett(Kabinett kabinett) {
        this.kabinett = kabinett;
    }

    public Skjerm getSkjerm() {
        return skjerm;
    }

    public String getSkjermT() {
        return skjerm.getVarekode();
    }

    public void setSkjerm(Skjerm skjerm) {
        this.skjerm = skjerm;
    }

    public Tastatur getTastatur() {
        return tastatur;
    }

    public String getTastaturT() {
        return tastatur.getVarekode();
    }

    public void setTastatur(Tastatur tastatur) {
        this.tastatur = tastatur;
    }

    public Mus getMus() {
        return mus;
    }

    public String getMusT() {
        return mus.getVarekode();
    }

    public void setMus(Mus mus) {
        this.mus = mus;
    }
}
