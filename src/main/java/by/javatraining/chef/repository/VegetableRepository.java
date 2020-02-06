package by.javatraining.chef.repository;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.exception.VegetableRepositoryException;

import java.util.Set;

public interface VegetableRepository {

    Set<Vegetable> getAll();
    Set<Vegetable> query(VegetableSpecification specification) throws VegetableRepositoryException;
    void add(Vegetable vegetable) throws VegetableRepositoryException;
    void remove(Vegetable vegetable) throws VegetableRepositoryException;
}
