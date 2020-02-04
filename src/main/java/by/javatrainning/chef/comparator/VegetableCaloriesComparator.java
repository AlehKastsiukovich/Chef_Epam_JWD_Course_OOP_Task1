package by.javatrainning.chef.comparator;

import by.javatrainning.chef.entity.Vegetable;
import java.util.Comparator;

public class VegetableCaloriesComparator implements Comparator<Vegetable> {

    @Override
    public int compare(Vegetable o1, Vegetable o2) {
        return Double.compare(o1.getCalories(), o2.getCalories());
    }
}
