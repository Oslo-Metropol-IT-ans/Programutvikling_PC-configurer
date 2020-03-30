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


}
