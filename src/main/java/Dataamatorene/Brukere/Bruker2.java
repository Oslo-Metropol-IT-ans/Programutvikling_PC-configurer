package Dataamatorene.Brukere;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Bruker2 implements Serializable, Comparable<Bruker2> {

    private String brukernavn;
    private String passord;
    private boolean superbruker;

    public Bruker2(String brukernavn, String passord, boolean superbruker){
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


    @Override
    public int compareTo(@NotNull Bruker2 o) {
        return this.brukernavn.compareTo(o.brukernavn);
    }
}
