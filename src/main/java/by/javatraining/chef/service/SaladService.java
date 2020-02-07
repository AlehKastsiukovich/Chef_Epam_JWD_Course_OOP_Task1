package by.javatraining.chef.service;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.exception.ServiceException;
import by.javatraining.chef.exception.VegetableRepositoryException;
import by.javatraining.chef.repository.VegetableRepository;
import by.javatraining.chef.repository.VegetableRepositoryImpl;
import by.javatraining.chef.repository.specification.*;
import org.apache.log4j.Logger;
import java.util.Set;

public class SaladService {
    private static final Logger logger = Logger.getLogger(SaladService.class);
    private static VegetableRepository repository = VegetableRepositoryImpl.getInstance();

    public static class SaladServiceHolder {
        public static final SaladService instance = new SaladService();
    }

    public static SaladService getInstance() {
        return SaladServiceHolder.instance;
    }

    public void addVegetable(Vegetable vegetable) throws ServiceException {
        if (vegetable == null) {
            logger.debug("Enter null object to addVegetable method!");
            throw new ServiceException();
        }

        try {
            repository.add(vegetable);
        } catch (VegetableRepositoryException e) {
            logger.error("Can't add data to repository!", e);
            throw new ServiceException();
        }
    }

    public void removeVegetable(Vegetable vegetable) throws ServiceException {
        if (vegetable == null) {
            logger.debug("Enter null object to addVegetable method!");
            throw new ServiceException();
        }

        try {
            repository.remove(vegetable);
        } catch (VegetableRepositoryException e) {
            logger.error("Can't remove data from repository!", e);
            throw new ServiceException();
        }
    }

    public double calculateSaladCalories() {
        double caloriesSum = 0;

        for (Vegetable vegetable: repository.getAll()) {
            caloriesSum += vegetable.getCalories();
        }
        logger.info("Sum of calories is : " + caloriesSum);
        return caloriesSum;
    }

    public Set<Vegetable> findSaladComponentsInCaloriesRange(double inRange, double outRange) throws ServiceException {
        SaladSpecification specification = new SaladSpecificationByCaloriesRange(inRange, outRange);

        try {
            return  repository.query(specification);
        } catch (VegetableRepositoryException e) {
            logger.error("Problems with query to repository!", e);
            throw new ServiceException();
        }
    }

    public Set<Vegetable> findSaladComponentsByIdRange(int inRange, int outRange) throws ServiceException {
        SaladSpecification specification = new SaladSpecificationFindRangeVegetableByIdRange(inRange, outRange);

        try {
            return repository.query(specification);
        } catch (VegetableRepositoryException e) {
            logger.error("Problems with query to repository!", e);
            throw new ServiceException();
        }
    }

    public Set<Vegetable> sortRepositorySetById() throws ServiceException {
        SaladSpecification specification = new SaladSpecificationSortById();

        try {
            return repository.query(specification);
        } catch (VegetableRepositoryException e) {
            logger.error("Problems with query to repository!", e);
            throw new ServiceException();
        }
    }

    public Set<Vegetable> sortRepositorySetByName() throws ServiceException {
        SaladSpecification specification = new SaladSpecificationSortByName();

        try {
            return repository.query(specification);
        } catch (VegetableRepositoryException e) {
            logger.error("Problems with query to repository!", e);
            throw new ServiceException();
        }
    }
}
