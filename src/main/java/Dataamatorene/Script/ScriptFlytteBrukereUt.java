package Dataamatorene.Script;

import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.Bruker2;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerJobj;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;

import java.io.IOException;
import java.util.ArrayList;

public class ScriptFlytteBrukereUt {
    public static void main(String[] args) {
        FileOpener opener = new FileOpenerJobj();
        ArrayList<Bruker> liste = new ArrayList<>();
        ArrayList<Bruker2> listeUt = new ArrayList<>();
        try {
            liste = (ArrayList<Bruker>) opener.read("src/main/java/Dataamatorene/Files/Login.jobj");
        } catch (IOException | ClassNotFoundException e) {

        }

        if (liste != null) {
            for (Bruker b:liste) {
                if(b.getRettigheter().equalsIgnoreCase("Admin")) {
                    listeUt.add(new Bruker2(b.getBrukernavn(), b.getPassord(),null, null, null, true));
                } else {
                    listeUt.add(new Bruker2(b.getBrukernavn(), b.getPassord(), null, null, null, false));
                }

            }

            FileSaver saver = new FileSaverJobj();
            try {
                saver.save(listeUt, "src/main/java/Dataamatorene/Files/Login.jobj");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
