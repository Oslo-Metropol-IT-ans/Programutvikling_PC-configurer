package Dataamatorene.Comparators;

import Dataamatorene.Datakomponenter.Datakomponent;

import java.util.Comparator;

public class DatakomponentPrisLavComparator implements Comparator<Datakomponent> {
    @Override
    public int compare(Datakomponent o1, Datakomponent o2) {
        return (int) (o1.getPris() - o2.getPris());
    }
}
