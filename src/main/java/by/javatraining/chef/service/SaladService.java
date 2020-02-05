package by.javatraining.chef.service;

import by.javatraining.chef.comparator.VegetableCaloriesComparator;
import by.javatraining.chef.comparator.VegetableNameComparator;
import by.javatraining.chef.comparator.VegetableWeightComparator;
import by.javatraining.chef.entity.Salad;
import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.exception.ServiceException;
import by.javatraining.chef.validator.ServiceValidator;
import java.util.Set;
import java.util.TreeSet;

public class SaladService {

    public double calculateSaladCalories(Salad salad) throws ServiceException {
        if (!ServiceValidator.checkSalad(salad)) {
            throw new ServiceException();
        }

        double caloriesSum = 0;

        for (Vegetable vegetable: salad.getListOfVegetables()) {
            caloriesSum += vegetable.getCalories();
        }

        return caloriesSum;
    }

    public Set<Vegetable> sortVegetablesByName(Salad salad) throws ServiceException {
        if (!ServiceValidator.checkSalad(salad)) {
            throw new ServiceException();
        }

        Set<Vegetable> vegetableSet = new TreeSet<>(new VegetableNameComparator());
        vegetableSet.addAll(salad.getListOfVegetables());

        return vegetableSet;
    }

    public Set<Vegetable> sortVegetablesByCaloriesAndWeight(Salad salad) throws ServiceException {
        if (!ServiceValidator.checkSalad(salad)) {
            throw new ServiceException();
        }

        Set<Vegetable> vegetableSet = new TreeSet<>(new VegetableCaloriesComparator()
                .thenComparing(new VegetableWeightComparator()));
        vegetableSet.addAll(salad.getListOfVegetables());

        return vegetableSet;
    }

    public Set<Vegetable> findSaladComponentsInCaloriesRange(Salad salad, double in, double out) throws ServiceException {
        if (!ServiceValidator.checkSalad(salad)) {
            throw new ServiceException();
        }

        Set<Vegetable> vegetableSet = new TreeSet<>();

        for (Vegetable vegetable : salad.getListOfVegetables()) {
            if (isInRange(vegetable.getCalories(), in, out)) {
                vegetableSet.add(vegetable);
            }
        }

        return vegetableSet;
    }

    private boolean isInRange(double value, double in, double out) {
        return (in < out) && (value >= in && value <= out);
    }
}
