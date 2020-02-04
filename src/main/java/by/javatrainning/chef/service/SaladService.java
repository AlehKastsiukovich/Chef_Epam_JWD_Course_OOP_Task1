package by.javatrainning.chef.service;

import by.javatrainning.chef.comparator.VegetableCaloriesComparator;
import by.javatrainning.chef.comparator.VegetableNameComparator;
import by.javatrainning.chef.comparator.VegetableWeightComparator;
import by.javatrainning.chef.entity.Salad;
import by.javatrainning.chef.entity.Vegetable;
import java.util.Set;
import java.util.TreeSet;

public class SaladService {

    public double calculateSaladCalories(Salad salad) {
        double caloriesSum = 0;

        for (Vegetable vegetable: salad.getListOfVegetables()) {
            caloriesSum += vegetable.getCalories();
        }

        return caloriesSum;
    }

    public Set<Vegetable> sortVegetablesByName(Salad salad) {
        Set<Vegetable> vegetableSet = new TreeSet<>(new VegetableNameComparator());

        vegetableSet.addAll(salad.getListOfVegetables());

        return vegetableSet;
    }

    public Set<Vegetable> sortVegetablesByCaloriesAndWeight(Salad salad) {
        Set<Vegetable> vegetableSet = new TreeSet<>(new VegetableCaloriesComparator()
                .thenComparing(new VegetableWeightComparator()));

        vegetableSet.addAll(salad.getListOfVegetables());

        return vegetableSet;
    }

    public Set<Vegetable> findSaladComponentsInCaloriesRange(Salad salad, double in, double out) {
        Set<Vegetable> vegetableSet = new TreeSet<>();

        for (Vegetable vegetable : salad.getListOfVegetables()) {
            if (isInRange(vegetable.getCalories(), in, out)) {
                vegetableSet.add(vegetable);
            }
        }

        return vegetableSet;
    }

    private boolean isInRange(double value, double in, double out) {
        return value >= in & value <= out;
    }
}
