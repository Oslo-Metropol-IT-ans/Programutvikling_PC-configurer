package Dataamatorene.Brukere;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Bruker implements Serializable, Comparable<Bruker> {

    private String brukernavn;
    private String passord;
    private String navn;
    private String tlfNummer;
    private String email;
    private boolean superbruker;

    public Bruker(String brukernavn, String passord, String navn, String tlfNummer, String email, boolean superbruker){
        this.brukernavn = brukernavn;
        this.passord = passord;
        this.navn = navn;
        this.tlfNummer = tlfNummer;
        this.email = email;
        this.superbruker = superbruker;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public String getPassord() {
        return passord;
    }

    public String getNavn() {
        return navn;
    }

    public String getTlfNummer() {
        return tlfNummer;
    }

    public String getEmail() {
        return email;
    }

    public String getRettigheter() {
        if(superbruker) return "Admin";
        else return "Bruker";
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setTlfNummer(String tlfNummer) {
        this.tlfNummer = tlfNummer;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSuperbruker(String rettigheter){
        if(rettigheter.equalsIgnoreCase("admin")) superbruker = true;
        else superbruker = false;
    }

    public boolean isSuperbruker() {
        return superbruker;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", brukernavn, getRettigheter());
    }


    @Override
    public int compareTo(@NotNull Bruker o) {
        return this.brukernavn.compareTo(o.brukernavn);
    }
}
