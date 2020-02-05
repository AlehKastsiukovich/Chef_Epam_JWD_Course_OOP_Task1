package by.javatraining.chef.comparator;

import by.javatraining.chef.entity.Vegetable;
import java.util.Comparator;

public class VegetableWeightComparator implements Comparator<Vegetable> {

    @Override
    public int compare(Vegetable o1, Vegetable o2) {
        return Double.compare(o1.getWeight(), o2.getWeight());
    }
}
