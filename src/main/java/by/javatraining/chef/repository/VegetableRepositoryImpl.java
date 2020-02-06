package by.javatraining.chef.repository;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.exception.VegetableRepositoryException;
import java.util.Set;
import java.util.TreeSet;

public class VegetableRepositoryImpl implements VegetableRepository {
    private Set<Vegetable> repository;

    public VegetableRepositoryImpl() {
        repository = new TreeSet<>();
    }

    public VegetableRepositoryImpl(Set<Vegetable> vegetableSet) throws VegetableRepositoryException {
        if (vegetableSet == null) {
            throw new VegetableRepositoryException();
        }
        repository = vegetableSet;
    }

    @Override
    public Set<Vegetable> getAll() {
        return repository;
    }

    @Override
    public Set<Vegetable> query(VegetableSpecification specification) throws VegetableRepositoryException {
        if (specification == null) {
            throw new VegetableRepositoryException();
        }

        return specification.query();
    }

    @Override
    public void add(Vegetable vegetable) throws VegetableRepositoryException {
        if (vegetable == null) {
           throw new VegetableRepositoryException();
        }

        repository.add(vegetable);
    }

    @Override
    public void remove(Vegetable vegetable) throws VegetableRepositoryException {
        if (vegetable == null) {
            throw new VegetableRepositoryException();
        }

        repository.remove(vegetable);

    }
}
