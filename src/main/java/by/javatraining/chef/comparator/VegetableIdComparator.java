package by.javatraining.chef.comparator;

import by.javatraining.chef.entity.Vegetable;
import java.util.Comparator;

public class VegetableIdComparator implements Comparator<Vegetable> {

    @Override
    public int compare(Vegetable o1, Vegetable o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
