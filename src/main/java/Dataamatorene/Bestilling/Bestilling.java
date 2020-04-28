package Dataamatorene.Bestilling;

import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Datakomponenter.*;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class Bestilling implements Serializable {

    // Varekode startverdi
    private static int teller = 10001;

    // Setter ny verdi etter siste innlastet bestilling
    public static void setTeller(int teller1) {
        teller = teller1;
    }

    public static int getTeller() {
        return teller;
    }

    // Datafelt
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
    private double pris;
    private int bestillingsnummer;
    private final LocalDate date;

    // Konstruktør
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
        this.bestillingsnummer = teller++;
        this.date = LocalDate.now();
        setPris();
    }

    // Gettere og settere, gettere med T er varekode for tableview
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
        setPris();
    }

    public Hovedkort getHovedkort() {
        return hovedkort;
    }

    public String getHovedkortT() {
        return hovedkort.getVarekode();
    }

    public void setHovedkort(Hovedkort hovedkort) {
        this.hovedkort = hovedkort;
        setPris();
    }

    public Lydkort getLydkort() {
        return lydkort;
    }

    public String getLydkortT() {
        return lydkort.getVarekode();
    }

    public void setLydkort(Lydkort lydkort) {
        this.lydkort = lydkort;
        setPris();
    }

    public Skjermkort getSkjermkort() {
        return skjermkort;
    }

    public String getSkjermkortT() {
        return skjermkort.getVarekode();
    }

    public void setSkjermkort(Skjermkort skjermkort) {
        this.skjermkort = skjermkort;
        setPris();
    }

    public Prosessor getProsessor() {
        return prosessor;
    }

    public String getProsessorT() {
        return prosessor.getVarekode();
    }

    public void setProsessor(Prosessor prosessor) {
        this.prosessor = prosessor;
        setPris();
    }

    public Minne getMinne() {
        return minne;
    }

    public String getMinneT() {
        return minne.getVarekode();
    }

    public void setMinne(Minne minne) {
        this.minne = minne;
        setPris();
    }

    public Kabinett getKabinett() {
        return kabinett;
    }

    public String getKabinettT() {
        return kabinett.getVarekode();
    }

    public void setKabinett(Kabinett kabinett) {
        this.kabinett = kabinett;
        setPris();
    }

    public Skjerm getSkjerm() {
        return skjerm;
    }

    public String getSkjermT() {
        return skjerm.getVarekode();
    }

    public void setSkjerm(Skjerm skjerm) {
        this.skjerm = skjerm;
        setPris();
    }

    public Tastatur getTastatur() {
        return tastatur;
    }

    public String getTastaturT() {
        return tastatur.getVarekode();
    }

    public void setTastatur(Tastatur tastatur) {
        this.tastatur = tastatur;
        setPris();
    }

    public Mus getMus() {
        return mus;
    }

    public String getMusT() {
        return mus.getVarekode();
    }

    public void setMus(Mus mus) {
        this.mus = mus;
        setPris();
    }

    public int getBestillingsnummer() {
        return bestillingsnummer;
    }

    public String getBestillingsnummerT() {
        return String.valueOf(bestillingsnummer);
    }

    public void setBestillingsnummer(int bestillingsnummer) {
        this.bestillingsnummer = bestillingsnummer;
    }

    public String getDatoT() {
        return String.valueOf(date);
    }

    private void setPris() {
        this.pris = this.harddisk.getPris() + this.hovedkort.getPris() + this.lydkort.getPris() + this.skjermkort.getPris() +
                this.prosessor.getPris() + this.minne.getPris() + this.kabinett.getPris() + this.skjerm.getPris() +
                this.tastatur.getPris() + this.mus.getPris();
    }

    public double getPris() {
        return pris;
    }

    public String getPrisT() {
        DecimalFormat df = new DecimalFormat("###,###.00");
        return df.format(pris);
    }

    // toString
    @Override
    public String toString() {
        return String.format("Din bestilling %s med\nHarddisk: %s, Hovedkort: %s\nLydkort: %s, Skjermkort %s" +
                        "\nProsessor: %s, Minne: %s\nKabinett: %s, Skjerm: %s\nTastatur: %s, Mus: %s\nTotalpris: %skr " +
                        "ble registrert %s",
                bestillingsnummer, harddisk.getNavn(), hovedkort.getNavn(), lydkort.getNavn(), skjermkort.getNavn(),
                prosessor.getNavn(), minne.getNavn(), kabinett.getNavn(), skjerm.getNavn(), tastatur.getNavn(), mus.getNavn(),
                getPrisT(), getDatoT());
    }
}
