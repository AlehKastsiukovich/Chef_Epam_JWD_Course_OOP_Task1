package by.javatraining.chef.repository.specification;

import by.javatraining.chef.entity.Vegetable;
import java.util.Set;

public interface SaladSpecification {

    Set<Vegetable> query();
}
