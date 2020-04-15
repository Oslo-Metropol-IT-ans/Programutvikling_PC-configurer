package Dataamatorene.Script;

import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.Bruker2;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerJobj;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;

import java.io.IOException;
import java.util.ArrayList;

public class ScriptFlytteBrukereInn {
    public static void main(String[] args) {
        FileOpener opener = new FileOpenerJobj();
        ArrayList<Bruker2> liste = new ArrayList<>();
        ArrayList<Bruker> listeUt = new ArrayList<>();
        try {
            liste = (ArrayList<Bruker2>) opener.read("src/main/java/Dataamatorene/Files/Login.jobj");
        } catch (IOException | ClassNotFoundException e) {

        }

        if (liste != null) {
            for (Bruker2 b:liste) {
                if(b.getRettigheter().equalsIgnoreCase("Admin")) {
                    listeUt.add(new Bruker(b.getBrukernavn(), b.getPassord(), true));
                } else {
                    listeUt.add(new Bruker(b.getBrukernavn(), b.getPassord(), false));
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
