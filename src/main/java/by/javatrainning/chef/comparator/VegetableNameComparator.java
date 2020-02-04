package by.javatrainning.chef.comparator;

import by.javatrainning.chef.entity.Vegetable;
import java.util.Comparator;

public class VegetableNameComparator implements Comparator<Vegetable> {

    @Override
    public int compare(Vegetable o1, Vegetable o2) {
        return o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
    }
}
