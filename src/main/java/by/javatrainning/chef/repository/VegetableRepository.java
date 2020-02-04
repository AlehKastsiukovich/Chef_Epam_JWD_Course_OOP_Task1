package by.javatrainning.chef.repository;

import by.javatrainning.chef.entity.Vegetable;
import java.util.Set;

public interface VegetableRepository {

    void addVegetable(Vegetable vegetable);
    void removeVegetable(Vegetable vegetable);
    Set<Vegetable> getCollection();
}
