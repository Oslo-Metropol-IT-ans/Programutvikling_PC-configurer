package Dataamatorene.Brukere;

import java.io.Serializable;

public class Bruker implements Serializable {

    private String brukernavn;
    private String passord;
    private boolean superbruker;

    public Bruker(String brukernavn, String passord, boolean superbruker){
        this.brukernavn = brukernavn;
        this.passord = passord;
        this.superbruker = superbruker;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public String getPassord() {
        return passord;
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
}
