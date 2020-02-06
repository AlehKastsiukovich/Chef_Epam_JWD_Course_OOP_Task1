package by.javatraining.chef.service;

import by.javatraining.chef.comparator.VegetableCaloriesComparator;
import by.javatraining.chef.comparator.VegetableNameComparator;
import by.javatraining.chef.comparator.VegetableWeightComparator;
import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.exception.ServiceException;
import by.javatraining.chef.exception.VegetableRepositoryException;
import by.javatraining.chef.repository.VegetableRepository;
import by.javatraining.chef.repository.VegetableRepositoryImpl;
import by.javatraining.chef.validator.ServiceValidator;
import java.util.Set;
import java.util.TreeSet;

public class SaladService {
    private static VegetableRepository repository = VegetableRepositoryImpl.getInstance();

    public static class SaladServiceHolder {
        public static final SaladService instance = new SaladService();
    }

    public static SaladService getInstance() {
        return SaladServiceHolder.instance;
    }

    public void addVegetable(Vegetable vegetable) throws ServiceException {
        if (vegetable == null) {
            throw new ServiceException();
        }

        try {
            repository.add(vegetable);
        } catch (VegetableRepositoryException e) {
            throw new ServiceException();
        }
    }

    public void removeVegetable(Vegetable vegetable) throws ServiceException {
        if (vegetable == null) {
            throw new ServiceException();
        }
        try {
            repository.remove(vegetable);
        } catch (VegetableRepositoryException e) {
            throw new ServiceException();
        }
    }

    public double calculateSaladCalories() {
        double caloriesSum = 0;

        for (Vegetable vegetable: repository.getAll()) {
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

    public Set<Vegetable> findSaladComponentsInCaloriesRange(double in, double out) throws ServiceException {
        Set<Vegetable> vegetableSet = new TreeSet<>();

        for (Vegetable vegetable : repository.getAll()) {
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
