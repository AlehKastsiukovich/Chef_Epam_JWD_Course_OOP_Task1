package by.javatraining.chef.service;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.exception.ServiceException;
import by.javatraining.chef.exception.VegetableRepositoryException;
import by.javatraining.chef.repository.VegetableRepository;
import by.javatraining.chef.repository.VegetableRepositoryImpl;
import by.javatraining.chef.repository.specification.SaladSpecification;
import by.javatraining.chef.repository.specification.SaladSpecificationByCaloriesRange;
import java.util.Set;

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

    public Set<Vegetable> findSaladComponentsInCaloriesRange(double inRange, double outRange) throws ServiceException {
        SaladSpecification specification = new SaladSpecificationByCaloriesRange(inRange, outRange);

        try {
            return  repository.query(specification);
        } catch (VegetableRepositoryException e) {
            throw new ServiceException();
        }
    }
}
