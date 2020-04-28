package Dataamatorene;

public class Komponent<E> {

    // Når en komponent endres skal vi ikke miste attributter

    private E komponent;

    public Komponent(E komponent) {
        this.komponent = komponent;
    }

    public E getKomponent() {
        return komponent;
    }

    public void setKomponent(E komponent) {
        this.komponent = komponent;
    }
}
