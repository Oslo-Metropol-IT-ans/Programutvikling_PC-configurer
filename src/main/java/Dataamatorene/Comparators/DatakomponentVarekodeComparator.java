package Dataamatorene.Comparators;

import Dataamatorene.Datakomponenter.Datakomponent;
import Dataamatorene.Datakomponenter.Skjermkort;

import java.util.Comparator;

public class DatakomponentVarekodeComparator implements Comparator<Datakomponent> {
    @Override
    public int compare(Datakomponent o1, Datakomponent o2) {
        return (Integer.parseInt(o1.getVarekode()) - Integer.parseInt(o2.getVarekode()));
    }

}
