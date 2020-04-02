package Dataamatorene.DatakomponenterReserve;

import Dataamatorene.Datakomponenter.Datakomponent;

import java.io.Serializable;

public class Tastatur2 extends Datakomponent implements Serializable {

    protected String språk;
    protected boolean mekanisk;
    protected boolean rgb;

    public Tastatur2(String navn, double pris, int varekode, String språk, boolean mekanisk, boolean rgb) {
        super(navn, pris, varekode);
        this.språk = språk;
        this.mekanisk = mekanisk;
        this.rgb = rgb;
    }

    public String getSpråk() {
        return språk;
    }

    public void setSpråk(String språk) {
        this.språk = språk;
    }

    public String isMekanisk() {
        return String.valueOf(mekanisk);
    }

    public void setMekanisk(boolean mekanisk) {
        this.mekanisk = mekanisk;
    }

    public String isRgb() {
        return String.valueOf(rgb);
    }

    public void setRgb(boolean rgb) {
        this.rgb = rgb;
    }

    @Override
    public String toString() {
        if(mekanisk && rgb)
            return String.format("%s er mekanisk og med lys, %s, %skr, VNr: %s", navn, språk
                                                , pris, varekode);
        else if(mekanisk && !rgb)
            return String.format("%s er mekanisk og uten lys, %s, %skr, VNr: %s", navn, språk
                    , pris, varekode);
        else if(!mekanisk && rgb)
            return String.format("%s er ikke mekanisk og med lys, %s, %skr, VNr: %s", navn, språk
                    , pris, varekode);
        else
            return String.format("%s er ikke mekanisk og uten lys, %s, %skr, VNr: %s", navn, språk
                    , pris, varekode);
    }
}
