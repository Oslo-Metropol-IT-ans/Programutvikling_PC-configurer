package Dataamatorene;

import Dataamatorene.Brukere.BrukerRegister;
import javafx.collections.FXCollections;

import java.util.stream.Collectors;

public class Streams {
    public static void streamBrukernavn(String s){
        BrukerRegister.setAktivList(BrukerRegister.getOliste().stream().filter(x -> x.getBrukernavn().toLowerCase().contains(s.toLowerCase()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList)));


    }
}
