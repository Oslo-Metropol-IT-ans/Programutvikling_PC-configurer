package Dataamatorene.Comparators;

import Dataamatorene.Datakomponenter.Datakomponent;

import java.util.Comparator;

public class DatakomponentNavnComparator implements Comparator<Datakomponent> {
    @Override
    public int compare(Datakomponent o1, Datakomponent o2) {
        return o1.getNavn().compareTo(o2.getNavn());
    }
}
