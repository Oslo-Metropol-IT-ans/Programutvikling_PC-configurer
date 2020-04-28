package Dataamatorene.Datakomponenter;


import java.util.ArrayList;

public class KomponentRegister {

    // Statiske datafelt for arraylist av hver type komponent
    private static ArrayList<Harddisk> harddiskArrayList = new ArrayList<>();
    private static ArrayList<Hovedkort> hovedkortArrayList = new ArrayList<>();
    private static ArrayList<Kabinett> kabinettArrayList = new ArrayList<>();
    private static ArrayList<Lydkort> lydkortArrayList = new ArrayList<>();
    private static ArrayList<Minne> minneArrayList = new ArrayList<>();
    private static ArrayList<Mus> musArrayList = new ArrayList<>();
    private static ArrayList<Prosessor> prosessorArrayList = new ArrayList<>();
    private static ArrayList<Skjerm> skjermArrayList = new ArrayList<>();
    private static ArrayList<Skjermkort> skjermkortArrayList = new ArrayList<>();
    private static ArrayList<Tastatur> tastaturArrayList = new ArrayList<>();

    // add get og set for hver arraylist

    // Harddisk
    public static void addHarddisk(Harddisk h){
        harddiskArrayList.add(h);
    }

    public static ArrayList<Harddisk> getHarddiskArrayList() {
        return harddiskArrayList;
    }

    public static void setHarddiskArrayList(ArrayList<Harddisk> harddiskArrayList1) {
        harddiskArrayList = harddiskArrayList1;
    }

    // Hovedkort
    public static void addHovedkort(Hovedkort h){
        hovedkortArrayList.add(h);
    }

    public  static ArrayList<Hovedkort> getHovedkortArrayList() {
        return hovedkortArrayList;
    }

    public static void setHovedkortArrayList(ArrayList<Hovedkort> hovedkortArrayList1) {
        hovedkortArrayList = hovedkortArrayList1;
    }

    // Kabinett
    public static void addKabinett(Kabinett h){
        kabinettArrayList.add(h);
    }

    public static ArrayList<Kabinett> getKabinettArrayList() {
        return kabinettArrayList;
    }

    public static void setKabinettArrayList(ArrayList<Kabinett> kabinettArrayList1) {
        kabinettArrayList = kabinettArrayList1;
    }

    // Lydkort
    public static void addLydkort(Lydkort h){
        lydkortArrayList.add(h);
    }

    public static ArrayList<Lydkort> getLydkortArrayList() {
        return lydkortArrayList;
    }

    public static void setLydkortArrayList(ArrayList<Lydkort> lydkortArrayList1) {
        lydkortArrayList = lydkortArrayList1;
    }

    // Minne
    public static void addMinne(Minne h){
        minneArrayList.add(h);
    }

    public static ArrayList<Minne> getMinneArrayList() {
        return minneArrayList;
    }

    public static void setMinneArrayList(ArrayList<Minne> minneArrayList1) {
        minneArrayList = minneArrayList1;
    }

    // Mus
    public static void addMus(Mus h){
        musArrayList.add(h);
    }

    public static ArrayList<Mus> getMusArrayList() {
        return musArrayList;
    }

    public static void setMusArrayList(ArrayList<Mus> musArrayList1) {
        musArrayList = musArrayList1;
    }

    // Prosessor
    public static void addProsessor(Prosessor h){
        prosessorArrayList.add(h);
    }

    public static ArrayList<Prosessor> getProsessorArrayList() {
        return prosessorArrayList;
    }

    public static void setProsessorArrayList(ArrayList<Prosessor> prosessorArrayList1) {
        prosessorArrayList = prosessorArrayList1;
    }

    // Skjerm
    public static void addSkjerm(Skjerm h){
        skjermArrayList.add(h);
    }

    public static ArrayList<Skjerm> getSkjermArrayList() {
        return skjermArrayList;
    }

    public static void setSkjermArrayList(ArrayList<Skjerm> skjermArrayList1) {
        skjermArrayList = skjermArrayList1;
    }

    // Skjermkort
    public static void addSkjermkort(Skjermkort h){
        skjermkortArrayList.add(h);
    }

    public static ArrayList<Skjermkort> getSkjermkortArrayList() {
        return skjermkortArrayList;
    }

    public static void setSkjermkortArrayList(ArrayList<Skjermkort> skjermkortArrayList1) {
        skjermkortArrayList = skjermkortArrayList1;
    }

    // Tastatur
    public static void addTastatur(Tastatur h){
        tastaturArrayList.add(h);
    }

    public static ArrayList<Tastatur> getTastaturArrayList() {
        return tastaturArrayList;
    }

    public static void setTastaturArrayList(ArrayList<Tastatur> tastaturArrayList1) {
        tastaturArrayList = tastaturArrayList1;
    }

    // datafelt og metoder for hvorvidt registerene er lastet fra fil
    private static boolean lasta = false;

    public static void setLasta(boolean b) {
        lasta = b;
    }

    public static boolean isLasta() {
        return lasta;
    }
}
