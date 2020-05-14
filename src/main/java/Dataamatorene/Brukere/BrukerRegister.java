package Dataamatorene.Brukere;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BrukerRegister {

    // datafelt og manipulering av aktiv bruker
    private static Bruker aktivBruker;

    public static void setAktivBruker(Bruker b){
        aktivBruker = b;
    }

    public static Bruker getAktivBruker() {
        return aktivBruker;
    }

    // datafelt og manipulering av brukerregisteret
    private static ArrayList<Bruker> brukere = new ArrayList<>();

    private static ObservableList<Bruker> Oliste = FXCollections.observableArrayList(brukere);

    private static ObservableList<Bruker> aktivList = FXCollections.observableArrayList();

    public static void update() {
        Oliste.setAll(brukere);
    }

    // Setter tabelview på endreBrukerController
    public static void setTableView (TableView<Bruker> tv){
        //update();
        tv.setItems(Oliste);
    }

    public static void setAktivList (ObservableList<Bruker> ob) {
        aktivList = ob;
    }

    public static void setAktivTableView(TableView<Bruker> tv) {
        tv.setItems(aktivList);
    }

    // gettere og settere
    public static ArrayList<Bruker> getBrukere() {
        return brukere;
    }

    public static ObservableList<Bruker> getOliste() {
        return Oliste;
    }

    public static ObservableList<Bruker> getAktivList() {
        return aktivList;
    }

    public static void setBrukere(ArrayList<Bruker> brukere) {
        BrukerRegister.brukere = brukere;
        update();
    }

    public static void addBruker(Bruker b){
        brukere.add(b);
        update();
    }

    public static void streamBrukernavn(String s){
        BrukerRegister.setAktivList(BrukerRegister.getOliste().stream().filter(x -> x.getBrukernavn().toLowerCase().contains(s.toLowerCase()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList)));


    }
}
