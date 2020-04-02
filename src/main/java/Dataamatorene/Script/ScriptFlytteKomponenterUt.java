package Dataamatorene.Script;

import Dataamatorene.Datakomponenter.*;
import Dataamatorene.DatakomponenterReserve.*;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerJobj;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;

import java.io.IOException;
import java.util.ArrayList;

public class ScriptFlytteKomponenterUt {
    public static void main(String[] args) {
        FileOpener opener = new FileOpenerJobj();

        try {
            ArrayList<Harddisk> harddisks = (ArrayList<Harddisk>) opener.read("src/main/java/Dataamatorene/Files/Harddisk.jobj");
            ArrayList<Hovedkort> hovedkorts = (ArrayList<Hovedkort>) opener.read("src/main/java/Dataamatorene/Files/Hovedkort.jobj");
            ArrayList<Lydkort> lydkorts = (ArrayList<Lydkort>) opener.read("src/main/java/Dataamatorene/Files/Lydkort.jobj");
            ArrayList<Skjermkort> skjermkorts = (ArrayList<Skjermkort>) opener.read("src/main/java/Dataamatorene/Files/Skjermkort.jobj");
            ArrayList<Prosessor> prosessors = (ArrayList<Prosessor>) opener.read("src/main/java/Dataamatorene/Files/Prosessor.jobj");
            ArrayList<Minne> minnes = (ArrayList<Minne>) opener.read("src/main/java/Dataamatorene/Files/Minne.jobj");
            ArrayList<Kabinett> kabinetts = (ArrayList<Kabinett>) opener.read("src/main/java/Dataamatorene/Files/Kabinett.jobj");
            ArrayList<Skjerm> skjerms = (ArrayList<Skjerm>) opener.read("src/main/java/Dataamatorene/Files/Skjerm.jobj");
            ArrayList<Tastatur> tastaturs = (ArrayList<Tastatur>) opener.read("src/main/java/Dataamatorene/Files/Tastatur.jobj");
            ArrayList<Mus> muses = (ArrayList<Mus>) opener.read("src/main/java/Dataamatorene/Files/Mus.jobj");

            ArrayList<Harddisk2> harddisk2s = new ArrayList<>();
            ArrayList<Hovedkort2> hovedkort2s = new ArrayList<>();
            ArrayList<Lydkort2> lydkort2s = new ArrayList<>();
            ArrayList<Skjermkort2> skjermkort2s = new ArrayList<>();
            ArrayList<Prosessor2> prosessor2s = new ArrayList<>();
            ArrayList<Minne2> minne2s = new ArrayList<>();
            ArrayList<Kabinett2> kabinett2s = new ArrayList<>();
            ArrayList<Skjerm2> skjerm2s = new ArrayList<>();
            ArrayList<Tastatur2> tastatur2s = new ArrayList<>();
            ArrayList<Mus2> mus2s = new ArrayList<>();

            for (Harddisk h:harddisks) {
                harddisk2s.add(new Harddisk2(h.getNavn(), h.getPris(), Integer.parseInt(h.getVarekode()), Integer.parseInt(h.getLagring())));
            }

            for (Hovedkort h:hovedkorts) {
                hovedkort2s.add(new Hovedkort2(h.getNavn(), h.getPris(), Integer.parseInt(h.getVarekode()), Integer.parseInt(h.getAntallPorter())));
            }

            for (Lydkort l:lydkorts) {
                lydkort2s.add(new Lydkort2(l.getNavn(), l.getPris(), Integer.parseInt(l.getVarekode()), Boolean.getBoolean(l.getIntegrert()), Double.parseDouble(l.getFrekvens())));
            }

            for (Skjermkort s:skjermkorts) {
                skjermkort2s.add(new Skjermkort2(s.getNavn(), s.getPris(), Integer.parseInt(s.getVarekode()), s.getOppløsning()));
            }

            for (Prosessor p:prosessors) {
                prosessor2s.add(new Prosessor2(p.getNavn(), p.getPris(), Integer.parseInt(p.getVarekode()), Integer.parseInt(p.getAntallKjerner()), Double.parseDouble(p.getFrekvens()), Integer.parseInt(p.getAntallTråder())));
            }

            for (Minne m:minnes) {
                minne2s.add(new Minne2(m.getNavn(), m.getPris(), Integer.parseInt(m.getVarekode()), Integer.parseInt(m.getRam()), Double.parseDouble(m.getFrekvens())));
            }

            for (Kabinett k:kabinetts) {
                kabinett2s.add(new Kabinett2(k.getNavn(), k.getPris(), Integer.parseInt(k.getVarekode()), k.getStørrelse(), Integer.parseInt(k.getAntallVifter())));
            }

            for (Skjerm s:skjerms) {
                skjerm2s.add(new Skjerm2(s.getNavn(),s.getPris(), Integer.parseInt(s.getVarekode()), s.getOppløsning(), Double.parseDouble(s.getStørrelse())));
            }

            for (Tastatur t:tastaturs) {
                tastatur2s.add(new Tastatur2(t.getNavn(), t.getPris(), Integer.parseInt(t.getVarekode()), t.getSpråk(), Boolean.getBoolean(t.isMekanisk()), Boolean.getBoolean(t.isRgb())));
            }

            for (Mus m:muses) {
                mus2s.add(new Mus2(m.getNavn(), m.getPris(), Integer.parseInt(m.getVarekode()), Boolean.getBoolean(m.isTråd()), Integer.parseInt(m.getAntallKnapper())));
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
