package Dataamatorene.Datakomponenter;

import java.io.Serializable;

public class Harddisk extends Datakomponent implements Serializable {

    protected int lagring;

    public Harddisk(String navn, double pris, int varekode, int lagring) {
        super(navn, pris, varekode);
        this.lagring = lagring;
    }

    public String getLagring() {
        return String.valueOf(lagring);
    }

    public void setLagring(int lagring) {
        this.lagring = lagring;
    }

    @Override
    public String toString() {
        if(lagring < 1000) return String.format("%s %sGB, %skr, %s", navn, lagring, pris, varekode);
        else return String.format("%s %sTB, %skr, %s", navn, (lagring/1000), pris, varekode);

    }
}
