package Dataamatorene.Comparators;

import Dataamatorene.Datakomponenter.Datakomponent;

import java.util.Comparator;

public class DatakomponentPrisHoyComparator implements Comparator<Datakomponent> {
    @Override
    public int compare(Datakomponent o1, Datakomponent o2) {
        return (int) (o2.getPris() - o1.getPris());
    }
}
