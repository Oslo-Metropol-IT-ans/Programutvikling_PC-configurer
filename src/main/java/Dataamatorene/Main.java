package Dataamatorene;

import Dataamatorene.Datakomponenter.Harddisk;
import Dataamatorene.DatakomponenterReserve.Harddisk2;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerJobj;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOpener opener = new FileOpenerJobj();
        ArrayList<Harddisk> harddisks = (ArrayList<Harddisk>) opener.read("src/main/resources/Dataamatorene/Files/Harddisk.jobj");
        for (Harddisk h: harddisks) {
            System.out.println(h.getVarekode());
        }
    }
}
