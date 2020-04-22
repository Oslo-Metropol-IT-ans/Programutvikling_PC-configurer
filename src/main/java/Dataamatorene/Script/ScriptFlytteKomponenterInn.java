package Dataamatorene.Script;

import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Datakomponenter.*;
import Dataamatorene.DatakomponenterReserve.*;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerJobj;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;

import java.io.IOException;
import java.util.ArrayList;

public class ScriptFlytteKomponenterInn {
    public static void main(String[] args) {
        FileOpener opener = new FileOpenerJobj();

        try {
            BrukerRegister.setAktivBruker((Bruker)opener.read("src/main/java/Dataamatorene/Files/Login.jobj").get(0));
            ArrayList<Harddisk2> harddisks = (ArrayList<Harddisk2>) opener.read("src/main/java/Dataamatorene/Files/Harddisk.jobj");
            ArrayList<Hovedkort2> hovedkorts = (ArrayList<Hovedkort2>) opener.read("src/main/java/Dataamatorene/Files/Hovedkort.jobj");
            ArrayList<Lydkort2> lydkorts = (ArrayList<Lydkort2>) opener.read("src/main/java/Dataamatorene/Files/Lydkort.jobj");
            ArrayList<Skjermkort2> skjermkorts = (ArrayList<Skjermkort2>) opener.read("src/main/java/Dataamatorene/Files/Skjermkort.jobj");
            ArrayList<Prosessor2> prosessors = (ArrayList<Prosessor2>) opener.read("src/main/java/Dataamatorene/Files/Prosessor.jobj");
            ArrayList<Minne2> minnes = (ArrayList<Minne2>) opener.read("src/main/java/Dataamatorene/Files/Minne.jobj");
            ArrayList<Kabinett2> kabinetts = (ArrayList<Kabinett2>) opener.read("src/main/java/Dataamatorene/Files/Kabinett.jobj");
            ArrayList<Skjerm2> skjerms = (ArrayList<Skjerm2>) opener.read("src/main/java/Dataamatorene/Files/Skjerm.jobj");
            ArrayList<Tastatur2> tastaturs = (ArrayList<Tastatur2>) opener.read("src/main/java/Dataamatorene/Files/Tastatur.jobj");
            ArrayList<Mus2> muses = (ArrayList<Mus2>) opener.read("src/main/java/Dataamatorene/Files/Mus.jobj");

            ArrayList<Harddisk> harddisk2s = new ArrayList<>();
            ArrayList<Hovedkort> hovedkort2s = new ArrayList<>();
            ArrayList<Lydkort> lydkort2s = new ArrayList<>();
            ArrayList<Skjermkort> skjermkort2s = new ArrayList<>();
            ArrayList<Prosessor> prosessor2s = new ArrayList<>();
            ArrayList<Minne> minne2s = new ArrayList<>();
            ArrayList<Kabinett> kabinett2s = new ArrayList<>();
            ArrayList<Skjerm> skjerm2s = new ArrayList<>();
            ArrayList<Tastatur> tastatur2s = new ArrayList<>();
            ArrayList<Mus> mus2s = new ArrayList<>();

            for (Harddisk2 h:harddisks) {
                harddisk2s.add(new Harddisk(h.getNavn(), h.getPris(), Integer.parseInt(h.getVarekode()), h.getBilde(), Integer.parseInt(h.getLagring())));
            }

            for (Hovedkort2 h:hovedkorts) {
                hovedkort2s.add(new Hovedkort(h.getNavn(), h.getPris(), Integer.parseInt(h.getVarekode()), h.getBilde(), Integer.parseInt(h.getAntallPorter())));
            }

            for (Lydkort2 l:lydkorts) {
                lydkort2s.add(new Lydkort(l.getNavn(), l.getPris(), Integer.parseInt(l.getVarekode()), l.getBilde(), Boolean.getBoolean(l.getIntegrert()), Double.parseDouble(l.getFrekvens())));
            }

            for (Skjermkort2 s:skjermkorts) {
                skjermkort2s.add(new Skjermkort(s.getNavn(), s.getPris(), Integer.parseInt(s.getVarekode()), s.getBilde(), s.getOppløsning()));
            }

            for (Prosessor2 p:prosessors) {
                prosessor2s.add(new Prosessor(p.getNavn(), p.getPris(), Integer.parseInt(p.getVarekode()), p.getBilde(), Integer.parseInt(p.getAntallKjerner()), Double.parseDouble(p.getFrekvens()), Integer.parseInt(p.getAntallTråder())));
            }

            for (Minne2 m:minnes) {
                minne2s.add(new Minne(m.getNavn(), m.getPris(), Integer.parseInt(m.getVarekode()), m.getBilde(), Integer.parseInt(m.getRam()), Double.parseDouble(m.getFrekvens())));
            }

            for (Kabinett2 k:kabinetts) {
                kabinett2s.add(new Kabinett(k.getNavn(), k.getPris(), Integer.parseInt(k.getVarekode()), k.getBilde(), k.getStørrelse(), Integer.parseInt(k.getAntallVifter())));
            }

            for (Skjerm2 s:skjerms) {
                skjerm2s.add(new Skjerm(s.getNavn(),s.getPris(), Integer.parseInt(s.getVarekode()), s.getBilde(), s.getOppløsning(), Double.parseDouble(s.getStørrelse())));
            }

            for (Tastatur2 t:tastaturs) {
                tastatur2s.add(new Tastatur(t.getNavn(), t.getPris(), Integer.parseInt(t.getVarekode()), t.getBilde(), t.getSpråk(), Boolean.getBoolean(t.isMekanisk()), Boolean.getBoolean(t.isRgb())));
            }

            for (Mus2 m:muses) {
                mus2s.add(new Mus(m.getNavn(), m.getPris(), Integer.parseInt(m.getVarekode()), m.getBilde(), Boolean.getBoolean(m.isTråd()), Integer.parseInt(m.getAntallKnapper())));
            }

            FileSaver saver = new FileSaverJobj();
            saver.save(harddisk2s, "src/main/java/Dataamatorene/Files/Harddisk.jobj");
            saver.save(hovedkort2s, "src/main/java/Dataamatorene/Files/Hovedkort.jobj");
            saver.save(lydkort2s, "src/main/java/Dataamatorene/Files/Lydkort.jobj");
            saver.save(skjermkort2s, "src/main/java/Dataamatorene/Files/Skjermkort.jobj");
            saver.save(prosessor2s, "src/main/java/Dataamatorene/Files/Prosessor.jobj");
            saver.save(minne2s, "src/main/java/Dataamatorene/Files/Minne.jobj");
            saver.save(kabinett2s, "src/main/java/Dataamatorene/Files/Kabinett.jobj");
            saver.save(skjerm2s, "src/main/java/Dataamatorene/Files/Skjerm.jobj");
            saver.save(tastatur2s, "src/main/java/Dataamatorene/Files/Tastatur.jobj");
            saver.save(mus2s, "src/main/java/Dataamatorene/Files/Mus.jobj");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
