package by.javatraining.chef.repository;

import by.javatraining.chef.entity.Vegetable;
import java.util.Set;

public interface VegetableSpecification {

    Set<Vegetable> query();
}
