package by.javatraining.chef.repository;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.exception.VegetableRepositoryException;
import by.javatraining.chef.repository.specification.SaladSpecification;
import org.apache.log4j.Logger;
import java.util.Set;
import java.util.TreeSet;

public class VegetableRepositoryImpl implements VegetableRepository {
    private static final Logger logger = Logger.getLogger(VegetableRepository.class);
    private Set<Vegetable> repository;

    private VegetableRepositoryImpl() {
        repository = new TreeSet<>();
        logger.info("VegetableRepositoryImpl was created!");
    }

    public static class VegetableRepositoryImplHolder {
        public static final VegetableRepositoryImpl instance = new VegetableRepositoryImpl();
    }

    public static VegetableRepositoryImpl getInstance() {
        return VegetableRepositoryImplHolder.instance;
    }

    @Override
    public Set<Vegetable> getAll() {
        return repository;
    }

    @Override
    public Set<Vegetable> query(SaladSpecification specification) throws VegetableRepositoryException {
        if (specification == null) {
            logger.debug("Enter null specification object to method query");
            throw new VegetableRepositoryException();
        }

        return specification.query();
    }

    @Override
    public void add(Vegetable vegetable) throws VegetableRepositoryException {
        if (vegetable == null) {
            logger.debug("Enter null Vegetable object to method add!");
            throw new VegetableRepositoryException();
        }

        repository.add(vegetable);
    }

    @Override
    public void remove(Vegetable vegetable) throws VegetableRepositoryException {
        if (vegetable == null) {
            logger.debug("Enter null Vegetable object to method remove!");
            throw new VegetableRepositoryException();
        }

        repository.remove(vegetable);
    }
}
