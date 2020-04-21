package Dataamatorene.DatakomponenterReserve;

import Dataamatorene.Datakomponenter.Datakomponent;

import java.io.Serializable;

public class Minne2 extends Datakomponent2 implements Serializable {

    protected int ram;
    protected double frekvens;

    public Minne2(String navn, double pris, int varekode, int ram, double frekvens) {
        super(navn, pris, varekode);
        this.ram = ram;
        this.frekvens = frekvens;
    }

    public String getRam() {
        return String.valueOf(ram);
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getFrekvens() {
        return String.valueOf(frekvens);
    }

    public void setFrekvens(double frekvens) {
        this.frekvens = frekvens;
    }

    @Override
    public String toString() {
        return String.format("%s %sGB RAM %sGHz, %skr, VNr: %s", navn, ram, frekvens, pris, varekode);
    }
}
