package by.javatraining.chef.repository;

import by.javatraining.chef.entity.Vegetable;
import java.util.Set;

public interface VegetableRepository {

    void addVegetable(Vegetable vegetable);
    void removeVegetable(Vegetable vegetable);
    void updateVegetable(Vegetable vegetable);
    Set<Vegetable> getCollection();
}
